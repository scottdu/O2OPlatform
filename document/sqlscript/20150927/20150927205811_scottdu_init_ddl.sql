
DROP DATABASE IF EXISTS `o2o_platform`;

CREATE DATABASE `o2o_platform`;

USE `o2o_platform`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
  `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `father_id` INT NOT NULL DEFAULT '0', -- 父节点ID
  `username` VARCHAR(60) NOT NULL DEFAULT '', -- 用户姓名
  `password` VARCHAR(100) NOT NULL DEFAULT '', -- 密码
  `user_role` VARCHAR(60) NOT NULL DEFAULT 'CUSTOMER', -- 用户角色ADMIN,CUSTOMER,PROVIDER
  `user_type` VARCHAR(60) NOT NULL DEFAULT '', -- 用户类型ORGANIZATION/PERSONAL
  `gender` VARCHAR(30) NOT NULL DEFAULT '', -- 性别
  `email` VARCHAR(60) NOT NULL DEFAULT '', -- 电子邮件
  `mobile` VARCHAR(60) NOT NULL DEFAULT '', -- 手机号
  `created_ts` DATETIME, -- 创建数据时间戳
  `updated_ts` DATETIME  -- 更新数据时间戳
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`(
  `id` int not null primary key auto_increment,
  `user_id` int not null,
  `fix_phone` VARCHAR(60) DEFAULT '', -- 固定电话
  `country` VARCHAR(60) DEFAULT '', -- 国家
  `province` VARCHAR(60) DEFAULT '', -- 省份
  `city` VARCHAR(60) DEFAULT '', -- 城市
  `street` VARCHAR(60) DEFAULT '', -- 街道
  `work_address` VARCHAR(100) DEFAULT '', -- 工作地点
  `account_icon` VARCHAR(200) DEFAULT '', -- 头像
  `nationality` VARCHAR(200) DEFAULT '',
  `id_type` VARCHAR(50) DEFAULT '', -- 证件类型 身份证/军官证/护照
  `id_no` VARCHAR(50) DEFAULT '', -- 证件号码
  `id_photo` VARCHAR(50) DEFAULT '', -- 证件照片
  `biz_permit_photo` VARCHAR(100) DEFAULT '', -- 许可证照片
  `biz_desc` VARCHAR(200) DEFAULT '',  -- 从事业务描述
  `change_unit` VARCHAR(100), -- 单位时间收费
  `currency` VARCHAR(50), -- 币种 RMB,USD,JPY,EUR,GBP... 
  `created_ts` DATETIME, -- 创建数据时间戳
  `updated_ts` DATETIME  -- 更新数据时间戳
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


