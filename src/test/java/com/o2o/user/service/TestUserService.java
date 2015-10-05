package com.o2o.user.service;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.o2o.constant.Constant;
import com.o2o.domain.User;
import com.o2o.domain.UserInfo;
import com.o2o.user.constant.UserConstant;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:app-context.xml")
public class TestUserService {
	
	private static Logger LOGGER;
	
	@Autowired
	private UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Constant.getInitParameters();
		LOGGER = LoggerFactory.getLogger(TestUserService.class);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_001_regist() {
		LOGGER.debug("............test user insert........");
		User user = new User();
		user.setUsername("杜峥兴");
		user.setPassword("123456");
		user.setEmail("duzhengxing625@163.com");
		user.setMobile("13917886815");
		Date now = new Date();
		user.setFatherId(0);
		user.setUserRole(UserConstant.UserRole.ADMIN.name());
		user.setUserType(UserConstant.UserType.PERSONAL.name());
		user.setGender(UserConstant.Gender.MALE.name());
		user.setCreatedTs(now);
		user.setUpdatedTs(now);
		
		UserInfo userInfo = new UserInfo();
		userInfo.setCity("SHANGHAI");
		
		userService.regist(user, userInfo);
		
		
	}
	
	
	
}
