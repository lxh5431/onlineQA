/*
author:lxh
MySQL - 5.0.51a-community-nt : Database - vote
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`onlineqa` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `onlineqa`;

/*Table structure for table `admins` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `username` varchar(20) default NULL,
  `password` varchar(30) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admins` */

LOCK TABLES `admin` WRITE;

insert  into `admin`(`username`,`password`) values ('admin','232F297A57A5A743894A0E4A801FC3');

UNLOCK TABLES;

/*Table structure for table `answer` */

DROP TABLE IF EXISTS `answer`;

CREATE TABLE `answer` (
  `answerId` int(11) NOT NULL auto_increment COMMENT '答案Id',
  `replayId` int(11) NOT NULL COMMENT '回答者Id',
  `oid` int(11) NOT NULL COMMENT '回复主题Id',
  `qSeq` int(11) default NULL COMMENT '问题序号',
  `seSeq` int(11) default NULL COMMENT '选项序号',
  `seValue` varchar(1000) default NULL COMMENT '选项内容',
  `remark` varchar(200) default NULL COMMENT '备注',
  PRIMARY KEY  (`answerId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `answer` */

LOCK TABLES `answer` WRITE;

insert  into `answer`(`answerId`,`replayId`,`oid`,`qSeq`,`seSeq`,`seValue`,`remark`) values (16,6,21,1,1,'1',NULL),(17,6,21,2,2,'2',NULL),(18,6,21,3,1,'建议1',NULL),(19,7,21,1,2,'2',NULL),(20,7,21,2,3,'3',NULL),(21,7,21,3,1,'建议2',NULL);

UNLOCK TABLES;

/*Table structure for table `object` */

DROP TABLE IF EXISTS `object`;

CREATE TABLE `object` (
  `oid` int(11) NOT NULL auto_increment,
  `title` varchar(1000) default NULL,
  `discribe` varchar(1000) default NULL,
  `createtime` timestamp NULL default NULL,
  `state` int(11) default NULL,
  `remark` varchar(200) default NULL,
  `anonymousFlag` char(1) default NULL COMMENT '是否匿名投递',
  PRIMARY KEY  (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `object` */

LOCK TABLES `object` WRITE;

insert  into `object`(`oid`,`title`,`discribe`,`createtime`,`state`,`remark`,`anonymousFlag`) values (21,'员工思想动态调查问卷','说明：\r\n1. 本调查问卷主要了解您对一些问题的看法，请认真作答。\r\n2. 问卷为不记名方式，您的个人信息和观点将受到严格保密。\r\n3. 问卷主要为单项选择题，少部分可多选，请按照要求作出选择。\r\n4. 每题必答，请注意不要漏答。','2011-10-26 17:28:55',1,NULL,'1');

UNLOCK TABLES;

/*Table structure for table `question` */
DROP TABLE IF EXISTS `question`;

CREATE TABLE `question` (
  `oid` int(11) default NULL,
  `content` varchar(1000) default NULL,
  `qtype` int(11) default NULL,
  `seq` int(11) default NULL,
  `remark` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `question` */

LOCK TABLES `question` WRITE;

insert  into `question`(`oid`,`content`,`qtype`,`seq`,`remark`) values (21,'您的姓别',0,1,NULL),(21,'您的年龄',0,2,NULL),(21,'建议意见',3,3,NULL);

UNLOCK TABLES;

/*Table structure for table `replay` */

DROP TABLE IF EXISTS `replay`;

CREATE TABLE `replay` (
  `replayId` int(11) NOT NULL auto_increment COMMENT '回复ID',
  `replayCode` varchar(100) NOT NULL COMMENT '回复者代码',
  `replayIp` varchar(100) NOT NULL COMMENT '回复者IP',
  `oid` int(11) NOT NULL COMMENT '主题Id',
  `replayTime` timestamp NULL default NULL COMMENT '回复时间',
  `remark` varchar(200) default NULL COMMENT '备注',
  PRIMARY KEY  (`replayId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='回复内容表';

/*Data for the table `replay` */

LOCK TABLES `replay` WRITE;

insert  into `replay`(`replayId`,`replayCode`,`replayIp`,`oid`,`replayTime`,`remark`) values (6,'anonymous','192.168.0.1',21,'2011-12-05 10:23:24',''),(7,'anonymous','127.0.0.1',21,'2011-12-05 10:23:58','');

UNLOCK TABLES;

/*Table structure for table `selecter` */

DROP TABLE IF EXISTS `selecter`;

CREATE TABLE `selecter` (
  `oid` int(11) default NULL,
  `qseq` int(11) default NULL,
  `content` varchar(1000) default NULL,
  `selseq` int(11) default NULL,
  `remark` varchar(20) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `selecter` */

LOCK TABLES `selecter` WRITE;

insert  into `selecter`(`oid`,`qseq`,`content`,`selseq`,`remark`) values (21,1,'A 男',1,NULL),(21,1,'B 女',2,NULL),(21,2,'A 25岁以下',1,NULL),(21,2,'B 25~30岁',2,NULL),(21,2,'C 30岁以上',3,NULL),(21,3,'写出您的建议，意见',0,NULL);

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
