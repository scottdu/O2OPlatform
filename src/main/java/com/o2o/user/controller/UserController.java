package com.o2o.user.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.o2o.domain.User;
import com.o2o.domain.UserInfo;
import com.o2o.user.constant.UserConstant;
import com.o2o.user.service.UserService;
import com.o2o.util.MD5;

@Controller
public class UserController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/regist",method=RequestMethod.GET)
	public String regist() {
		LOGGER.debug("HTTP GET user/regist.jsp");
		return "user/regist";
	}
	
	@RequestMapping(value="/user/regist",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> regist(@RequestBody String strRequest) {
		LOGGER.debug("HTTP POST user/regist");
		LOGGER.debug("strRequest=>{}",strRequest);
		Map<String, String> resultMap = new HashMap<String,String>();
		try {
			JSONObject jsonObj = new JSONObject(strRequest);
			
			String username = jsonObj.getString("username");
			String password = jsonObj.getString("password");
			String repassword = jsonObj.getString("re_password");
			String gender = jsonObj.getString("gender");
			String email = jsonObj.getString("email");
			String mobile = jsonObj.getString("mobile");
			String userType = jsonObj.getString("user_type");
			String fixPhoneNo = jsonObj.getString("fix_phone_no");
			String country = jsonObj.getString("country");
			String province = jsonObj.getString("province");
			String city = jsonObj.getString("city");
			String street = jsonObj.getString("street");
			String workAddress = jsonObj.getString("work_address");
			
			String userRole = UserConstant.UserRole.CUSTOMER.name();
			if(jsonObj.has("user_role")) {
				userRole = jsonObj.getString("user_role");
			}
			
			
			if(!password.equals(repassword)) {
				throw new RuntimeException("两次输入的密码不一致");
			}
			//验证邮箱。。。
			
			User user = new User();
			user.setUsername(username);
			user.setPassword(MD5.Str2MD5(password));
			user.setGender(gender);
			user.setEmail(email);
			user.setMobile(mobile);
			user.setUserType(userType);
			user.setUserRole(userRole);
			
			UserInfo userInfo = new UserInfo();
			userInfo.setFixPhone(fixPhoneNo);
			userInfo.setCountry(country);
			userInfo.setProvince(province);
			userInfo.setCity(city);
			userInfo.setStreet(street);
			userInfo.setWorkAddress(workAddress);
			
			userService.regist(user, userInfo);
			
			resultMap.put("resultCode", "0");
			resultMap.put("resultDesc", "注册成功");
			
		} catch (ParseException e) {
			LOGGER.error("error",e);
			resultMap.put("resultCode", "1");
			resultMap.put("resultDesc", "json 数据解析失败");
		} catch (Exception e) {
			LOGGER.error("error",e);
			resultMap.put("resultCode", "2");
			resultMap.put("resultDesc", e.getMessage());			
		}
		return resultMap;
	}
	
	
	@RequestMapping(value="/user/login",method=RequestMethod.GET)
	public String preLogin() {
		LOGGER.debug("HTTP GET user/login.jsp");
		
		return "user/login";
	}
	
	@RequestMapping(value="/user/login",method=RequestMethod.POST)
	public @ResponseBody Map<String,String> login(@RequestBody String strRequest, HttpSession session) {
		LOGGER.debug("HTTP POST user/login");
		LOGGER.debug("strRequest=>{}",strRequest);
		
		Map<String,String> resultMap = new HashMap<String,String>();
		
		try {
			JSONObject jsonObj = new JSONObject(strRequest);
			
			String email = jsonObj.getString("email");
			String mobile = jsonObj.getString("mobile");
			String password = jsonObj.getString("password");
			
			User user = new User();
			user.setPassword(password);
			user.setEmail(email);
			user.setMobile(mobile);
			
			Map<String,Object> sessionAttributes = userService.login(user);
			
			session.setAttribute("USER", sessionAttributes.get("USER"));
			session.setAttribute("USER_INFO", sessionAttributes.get("USER_INFO"));
			
			resultMap.put("resultCode", "0");
			resultMap.put("resultDesc", "登陆成功");
			
		} catch (ParseException e) {
			LOGGER.error("error",e);
			resultMap.put("resultCode", "1");
			resultMap.put("resultDesc", "json 数据解析失败");
		} catch (Exception e) {
			LOGGER.error("error",e);
			resultMap.put("resultCode", "2");
			resultMap.put("resultDesc", e.getMessage());			
		}
		
		return resultMap;
	}
	
	@RequestMapping(value="/user/main",method=RequestMethod.GET)
	public String main(HttpSession session) {
		LOGGER.debug("HTTP GET main.jsp");
		
		User user = (User) session.getAttribute("USER");
		
		if(user == null) {
			return "redirect:/user/login";
		}
		
		return "main";
	}
}
