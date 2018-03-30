CREATE TABLE `ANIME_USER` (
  `ID` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `MOBILE` varchar(100) DEFAULT NULL COMMENT '手机',
  `PORTRAIT_URL` varchar(300) DEFAULT NULL COMMENT '头像地址',
  `LOGINNAME` varchar(100) DEFAULT NULL COMMENT '登录名称',
  `NICKNAME` varchar(100) DEFAULT NULL COMMENT '昵称',
  `PASSWD` varchar(100) DEFAULT NULL COMMENT '密码',
  `SALT` varchar(40) DEFAULT NULL COMMENT 'shiro加密盐',
  `GENDER` smallint(6) DEFAULT NULL COMMENT '性别:-1保密,0女，1男',
  `STATUS` smallint(6) DEFAULT NULL COMMENT '状态:1开通,-1冻结',
  `CREATE_TIMESTAMP` bigint(20) DEFAULT NULL COMMENT '创建时间戳',
  `EMAIL` varchar(200) DEFAULT NULL COMMENT '邮箱',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
insert into `ANIME_USER` value ('1','18300197590',NULL,'admin','椎名真白',NULL,'0','1',NULL,'1101939669@qq.com')

CREATE TABLE `ANIME_MANAGER` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(100) DEFAULT NULL COMMENT '姓名',
  `EMAIL` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `STATUS` smallint(6) DEFAULT NULL COMMENT '状态: -1冻结, 1正常',
  `ROLE_ID` int(20) DEFAULT NULL COMMENT '角色ID',
  `LOGIN_ID` varchar(20) DEFAULT NULL COMMENT '登录名',
  `USER_PASSWD` varchar(100) DEFAULT NULL COMMENT '登录密码',
  `CUSTOMER_ID` int(20) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LOGIN_ID` (`LOGIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `ANIME_ROLE` (
  `ID` int(20) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) DEFAULT NULL COMMENT '角色名称',
  `POPEDOM_JSON` longtext COMMENT '权限json,格式为{"模块代号":""操作代号","模块代号":""操作代号,操作代号"},如,{"001":"001,002","002":"003"}',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

