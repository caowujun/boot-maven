-- robin.customconfig definition

CREATE TABLE `customconfig` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `configkey` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `configvalue` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `createat` datetime DEFAULT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='自定义配置';


-- robin.enumtypes definition

CREATE TABLE `enumtypes` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `parentid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `enumname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `enumvalue` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `enumtype` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `createat` datetime DEFAULT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='枚举配置';


-- robin.fire definition

CREATE TABLE `fire` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `recorddate` date NOT NULL,
  `weight` double DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `createat` datetime DEFAULT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='运动记录';


-- robin.gasoline definition

CREATE TABLE `gasoline` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `spendmoney` double NOT NULL,
  `volume` double NOT NULL,
  `unitprice` double NOT NULL,
  `kilometer` double NOT NULL,
  `recorddate` datetime NOT NULL,
  `createat` datetime DEFAULT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='加油统计';


-- robin.menu definition

CREATE TABLE `menu` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `parentid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `actionurl` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` tinyint(4) NOT NULL,
  `sortindex` tinyint(4) NOT NULL,
  `icon` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `createat` datetime DEFAULT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='菜单';


-- robin.money definition

CREATE TABLE `money` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `spendnum` double NOT NULL,
  `moneytype` tinyint(4) NOT NULL,
  `note` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `recorddate` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `consumptiontype` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createat` datetime DEFAULT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='消费';


-- robin.noticeboard definition

CREATE TABLE `noticeboard` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `noticetitle` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `noticecontent` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `noticetype` tinyint(4) NOT NULL,
  `createat` datetime DEFAULT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统公告';


-- robin.`role` definition

CREATE TABLE `role` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `parentid` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `title` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `sortindex` tinyint(4) NOT NULL,
  `createat` datetime DEFAULT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色';


-- robin.rolemenu definition

CREATE TABLE `rolemenu` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `roleid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `menuid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `createat` datetime DEFAULT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色-菜单对应表';


-- robin.roleuser definition

CREATE TABLE `roleuser` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `roleid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `userid` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `createat` datetime DEFAULT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='角色-用户对应表';


-- robin.runninglog definition

CREATE TABLE `runninglog` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `logcontent` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `actiontype` tinyint(4) NOT NULL,
  `createat` datetime DEFAULT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='执行日志';


-- robin.sysuser definition

CREATE TABLE `sysuser` (
  `id` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `username` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `userpsd` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `cnname` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `phonenum` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '1',
  `createat` datetime NOT NULL,
  `createby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `updateat` datetime DEFAULT NULL,
  `updateby` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci COMMENT='系统用户';