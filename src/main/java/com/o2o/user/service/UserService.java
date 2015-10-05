package com.o2o.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.o2o.domain.User;
import com.o2o.domain.UserInfo;
import com.o2o.util.MD5;
import com.o2o.util.StringUtil;

@Service
public class UserService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@PersistenceContext(unitName = "READ_UNIT")
	private EntityManager rem;
	
	@PersistenceContext(unitName = "WRITE_UNIT")
	private EntityManager wem;
	
	public Map<String,Object> login(User user) {
		
		if((user.getEmail() == null || "".equals(user.getEmail())) && 
		   (user.getMobile() == null || "".equals(user.getMobile()))) {
			LOGGER.debug("email/mobile as username is blank");
			throw new RuntimeException("请输入手机号或者Email作为用户名");
		}
		
		Map<String,Object> sessionMap = new HashMap<String,Object>();
		TypedQuery<User> typedQuery = rem.createQuery("SELECT u FROM User u WHERE (u.email=:email OR u.mobile=:mobile) AND u.password=:password", User.class);
		typedQuery.setParameter("email", user.getEmail());
		typedQuery.setParameter("mobile", user.getMobile());
		typedQuery.setParameter("password", MD5.Str2MD5(user.getPassword()));
		
		List<User> userList = typedQuery.getResultList();
		
		if(userList == null || userList.isEmpty()) {
			LOGGER.debug("userList is empty");
			throw new RuntimeException("用户名或密码错误");
		}
		
		User dbUser = userList.get(0);
		
		if(dbUser == null) {
			LOGGER.debug("dbUser is null");
			throw new RuntimeException("用户名或密码错误");
		}
		
		sessionMap.put("USER", dbUser);
		
		int userId = dbUser.getId();
		
		List<UserInfo> userInfoList = rem.createQuery("SELECT ui FROM UserInfo ui WHERE ui.userId=:userId", UserInfo.class).setParameter("userId", userId).getResultList();
		
		if(userInfoList != null && !userInfoList.isEmpty()) {
			UserInfo userInfo = userInfoList.get(0);
			sessionMap.put("USER_INFO", userInfo);
		}
		
		return sessionMap;
	}
	
	@Transactional
	public void regist(User user, UserInfo userInfo) {
		//验证email和手机的重复性
		
		TypedQuery<User> typedQuery = wem.createQuery("SELECT u FROM User u WHERE u.email=:email OR u.mobile=:mobile", User.class);
		typedQuery.setParameter("email", user.getEmail());
		typedQuery.setParameter("mobile", user.getMobile());
		List<User> userList = typedQuery.getResultList();
		
		if(StringUtil.isBlank(user.getEmail())) {
			LOGGER.debug("email={}",user.getEmail());
			throw new RuntimeException("请输入Email");
		}
		
		if(StringUtil.isBlank(user.getMobile())) {
			LOGGER.debug("mobile={}",user.getMobile());
			throw new RuntimeException("请输入手机号");
		}
		
		if(!StringUtil.isEmail(user.getEmail())) {
			LOGGER.debug("email=>{} is not a valid email",user.getEmail());
			throw new RuntimeException("请输入合法的Email");
		}
		
		if(!StringUtil.isMobile(user.getMobile())) {
			LOGGER.debug("mobile={} is not a valid mobile",user.getMobile());
			throw new RuntimeException("请输入合法的手机号");
		}
		
		if(userList != null && !userList.isEmpty()) {
			LOGGER.debug("email => {} or mobile => {} existed",new Object[] {user.getEmail(),user.getMobile()});
			throw new RuntimeException("邮箱或手机号已注册");
		}
		
		Date now = new Date();
		user.setCreatedTs(now);
		user.setUpdatedTs(now);
		wem.persist(user);
		userInfo.setUserId(user.getId());
		userInfo.setCreatedTs(now);
		userInfo.setUpdatedTs(now);
		wem.persist(userInfo);
		
	}
	
}
