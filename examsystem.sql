/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50723
Source Host           : localhost:3306
Source Database       : examsystem

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-12-27 09:56:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for administratorlist
-- ----------------------------
DROP TABLE IF EXISTS `administratorlist`;
CREATE TABLE `administratorlist` (
  `Aid` int(11) NOT NULL,
  `Apw` varchar(30) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Aid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of administratorlist
-- ----------------------------
INSERT INTO `administratorlist` VALUES ('110', '123123', '管理员1');

-- ----------------------------
-- Table structure for classlist
-- ----------------------------
DROP TABLE IF EXISTS `classlist`;
CREATE TABLE `classlist` (
  `class` varchar(30) NOT NULL,
  `Sname` varchar(30) NOT NULL,
  PRIMARY KEY (`class`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of classlist
-- ----------------------------
INSERT INTO `classlist` VALUES ('17软件7班', '小明');

-- ----------------------------
-- Table structure for completionlist
-- ----------------------------
DROP TABLE IF EXISTS `completionlist`;
CREATE TABLE `completionlist` (
  `id` int(11) NOT NULL,
  `paper_id` int(11) NOT NULL DEFAULT '0',
  `title` varchar(100) DEFAULT NULL,
  `rightoption` varchar(30) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`paper_id`),
  KEY `completion_1` (`paper_id`),
  CONSTRAINT `completionlist_ibfk_1` FOREIGN KEY (`paper_id`) REFERENCES `exampaperlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of completionlist
-- ----------------------------

-- ----------------------------
-- Table structure for courselist
-- ----------------------------
DROP TABLE IF EXISTS `courselist`;
CREATE TABLE `courselist` (
  `subject` varchar(30) NOT NULL,
  PRIMARY KEY (`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of courselist
-- ----------------------------
INSERT INTO `courselist` VALUES ('java程序设计');

-- ----------------------------
-- Table structure for exampaperlist
-- ----------------------------
DROP TABLE IF EXISTS `exampaperlist`;
CREATE TABLE `exampaperlist` (
  `id` int(11) NOT NULL,
  `subject` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `exampaperlist_1` (`subject`),
  CONSTRAINT `exampaperlist_ibfk_1` FOREIGN KEY (`subject`) REFERENCES `courselist` (`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of exampaperlist
-- ----------------------------

-- ----------------------------
-- Table structure for getscore
-- ----------------------------
DROP TABLE IF EXISTS `getscore`;
CREATE TABLE `getscore` (
  `sid` int(11) NOT NULL,
  `paper_id` int(11) NOT NULL,
  `singlescore` int(10) NOT NULL,
  `mutiscore` int(10) NOT NULL,
  `completionscore` int(10) NOT NULL,
  `judementscore` int(10) NOT NULL,
  PRIMARY KEY (`sid`,`paper_id`),
  KEY `getscore_2` (`paper_id`),
  CONSTRAINT `getscore_ibfk_1` FOREIGN KEY (`sid`) REFERENCES `studentlist` (`sid`),
  CONSTRAINT `getscore_ibfk_2` FOREIGN KEY (`paper_id`) REFERENCES `exampaperlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of getscore
-- ----------------------------

-- ----------------------------
-- Table structure for javadanxuan
-- ----------------------------
DROP TABLE IF EXISTS `javadanxuan`;
CREATE TABLE `javadanxuan` (
  `tihao` varchar(100) DEFAULT NULL,
  `timu` varchar(100) DEFAULT NULL,
  `A` varchar(100) DEFAULT NULL,
  `B` varchar(100) DEFAULT NULL,
  `C` varchar(100) DEFAULT NULL,
  `D` varchar(100) DEFAULT NULL,
  `answer` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of javadanxuan
-- ----------------------------
INSERT INTO `javadanxuan` VALUES ('1', '下列哪个单词不是Java的关键字？', 'A:private', ' B:long', ' C:<T>sizeof', ' D:double', '1');
INSERT INTO `javadanxuan` VALUES ('2', '下列关于String说法错误的是()', 'A字符串的长度用length（）;', ' B字符串可以用charAt（）方法得到单个字符', ' C<T>String字符串的大小是可以用Size（）得到。', ' D所有的其他类型的类都可以覆盖toString（）方法实现输出;', '2');

-- ----------------------------
-- Table structure for javaduoxuan
-- ----------------------------
DROP TABLE IF EXISTS `javaduoxuan`;
CREATE TABLE `javaduoxuan` (
  `tihao` varchar(255) DEFAULT NULL,
  `timu` varchar(255) DEFAULT NULL,
  `A` varchar(255) DEFAULT NULL,
  `B` varchar(255) DEFAULT NULL,
  `C` varchar(255) DEFAULT NULL,
  `D` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of javaduoxuan
-- ----------------------------
INSERT INTO `javaduoxuan` VALUES ('1', '下列哪个单词不是Java的关键字？', 'A:private', 'B:long', 'C:<T>sizeof', 'D:double', '23');

-- ----------------------------
-- Table structure for javapanduan
-- ----------------------------
DROP TABLE IF EXISTS `javapanduan`;
CREATE TABLE `javapanduan` (
  `tihao` varchar(255) DEFAULT NULL,
  `timu` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of javapanduan
-- ----------------------------
INSERT INTO `javapanduan` VALUES ('1', '1+1=2', '1');

-- ----------------------------
-- Table structure for javascore
-- ----------------------------
DROP TABLE IF EXISTS `javascore`;
CREATE TABLE `javascore` (
  `name` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of javascore
-- ----------------------------
INSERT INTO `javascore` VALUES ('kil', '4');
INSERT INTO `javascore` VALUES ('tu', '3');
INSERT INTO `javascore` VALUES ('mike', '0');

-- ----------------------------
-- Table structure for javatiankong
-- ----------------------------
DROP TABLE IF EXISTS `javatiankong`;
CREATE TABLE `javatiankong` (
  `tihao` varchar(255) DEFAULT NULL,
  `timu` varchar(255) DEFAULT NULL,
  `answer` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of javatiankong
-- ----------------------------
INSERT INTO `javatiankong` VALUES ('1', '1+1=?', '2');

-- ----------------------------
-- Table structure for judgmentlist
-- ----------------------------
DROP TABLE IF EXISTS `judgmentlist`;
CREATE TABLE `judgmentlist` (
  `id` int(11) NOT NULL,
  `paper_id` int(11) NOT NULL DEFAULT '0',
  `title` varchar(100) DEFAULT NULL,
  `rightoption` varchar(30) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`paper_id`),
  KEY `judgment_1` (`paper_id`),
  CONSTRAINT `judgmentlist_ibfk_1` FOREIGN KEY (`paper_id`) REFERENCES `exampaperlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of judgmentlist
-- ----------------------------

-- ----------------------------
-- Table structure for marry
-- ----------------------------
DROP TABLE IF EXISTS `marry`;
CREATE TABLE `marry` (
  `classname` varchar(30) DEFAULT NULL,
  `classnumber` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of marry
-- ----------------------------
INSERT INTO `marry` VALUES ('1', '1');
INSERT INTO `marry` VALUES ('3', '2');
INSERT INTO `marry` VALUES ('4', '5');
INSERT INTO `marry` VALUES ('7', '7');
INSERT INTO `marry` VALUES ('6', '8');
INSERT INTO `marry` VALUES ('9', '9');
INSERT INTO `marry` VALUES ('null', 'null');
INSERT INTO `marry` VALUES ('null', 'null');
INSERT INTO `marry` VALUES ('null', 'null');
INSERT INTO `marry` VALUES ('null', 'null');

-- ----------------------------
-- Table structure for marrydepaper
-- ----------------------------
DROP TABLE IF EXISTS `marrydepaper`;
CREATE TABLE `marrydepaper` (
  `papername` varchar(30) DEFAULT NULL,
  `papershuliang` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of marrydepaper
-- ----------------------------
INSERT INTO `marrydepaper` VALUES ('java', null);
INSERT INTO `marrydepaper` VALUES ('c', null);

-- ----------------------------
-- Table structure for multilist
-- ----------------------------
DROP TABLE IF EXISTS `multilist`;
CREATE TABLE `multilist` (
  `id` int(11) NOT NULL,
  `paper_id` int(11) NOT NULL DEFAULT '0',
  `title` varchar(100) DEFAULT NULL,
  `optionA` varchar(30) DEFAULT NULL,
  `optionB` varchar(30) DEFAULT NULL,
  `optionC` varchar(30) DEFAULT NULL,
  `optionD` varchar(30) DEFAULT NULL,
  `rightoption` varchar(30) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`paper_id`),
  KEY `multi_1` (`paper_id`),
  CONSTRAINT `multilist_ibfk_1` FOREIGN KEY (`paper_id`) REFERENCES `exampaperlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of multilist
-- ----------------------------

-- ----------------------------
-- Table structure for singlelist
-- ----------------------------
DROP TABLE IF EXISTS `singlelist`;
CREATE TABLE `singlelist` (
  `id` int(11) NOT NULL,
  `paper_id` int(11) NOT NULL DEFAULT '0',
  `title` varchar(100) DEFAULT NULL,
  `optionA` varchar(30) DEFAULT NULL,
  `optionB` varchar(30) DEFAULT NULL,
  `optionC` varchar(30) DEFAULT NULL,
  `optionD` varchar(30) DEFAULT NULL,
  `rightoption` varchar(30) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`paper_id`),
  KEY `single_1` (`paper_id`),
  CONSTRAINT `singlelist_ibfk_1` FOREIGN KEY (`paper_id`) REFERENCES `exampaperlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of singlelist
-- ----------------------------

-- ----------------------------
-- Table structure for studentlist
-- ----------------------------
DROP TABLE IF EXISTS `studentlist`;
CREATE TABLE `studentlist` (
  `sid` int(11) NOT NULL,
  `Sname` varchar(30) NOT NULL,
  `spw` varchar(30) NOT NULL,
  `class` varchar(30) NOT NULL,
  `subject` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `studentlist_1` (`class`),
  KEY `teacherlist_1` (`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of studentlist
-- ----------------------------
INSERT INTO `studentlist` VALUES ('11', 'mike', '123456', '17软件7班', 'java程序设计');
INSERT INTO `studentlist` VALUES ('123', '林加浩', '123', '1班', null);

-- ----------------------------
-- Table structure for studentscore
-- ----------------------------
DROP TABLE IF EXISTS `studentscore`;
CREATE TABLE `studentscore` (
  `papername` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  `sname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of studentscore
-- ----------------------------
INSERT INTO `studentscore` VALUES ('java', '10', 'mike');

-- ----------------------------
-- Table structure for teacherlist
-- ----------------------------
DROP TABLE IF EXISTS `teacherlist`;
CREATE TABLE `teacherlist` (
  `tid` int(11) NOT NULL,
  `tname` varchar(30) NOT NULL,
  `tpw` varchar(30) NOT NULL,
  `subject` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `teacherlist_1` (`subject`),
  CONSTRAINT `teacherlist_ibfk_1` FOREIGN KEY (`subject`) REFERENCES `courselist` (`subject`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of teacherlist
-- ----------------------------
INSERT INTO `teacherlist` VALUES ('110', 'marry', '123456', 'java程序设计');

-- ----------------------------
-- Table structure for totalscorelist
-- ----------------------------
DROP TABLE IF EXISTS `totalscorelist`;
CREATE TABLE `totalscorelist` (
  `totalscore` double NOT NULL,
  `class` varchar(30) NOT NULL,
  `Sname` varchar(30) DEFAULT NULL,
  `gradepoint` int(11) DEFAULT NULL,
  `paper_id` int(11) NOT NULL,
  PRIMARY KEY (`totalscore`),
  KEY `total_1` (`paper_id`),
  CONSTRAINT `totalscorelist_ibfk_1` FOREIGN KEY (`paper_id`) REFERENCES `exampaperlist` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

-- ----------------------------
-- Records of totalscorelist
-- ----------------------------
