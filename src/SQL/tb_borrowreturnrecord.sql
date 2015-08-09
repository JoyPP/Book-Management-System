/*
Navicat MySQL Data Transfer

Source Server         : ruirui
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2014-12-28 19:07:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_borrowreturnrecord
-- ----------------------------
DROP TABLE IF EXISTS `tb_borrowreturnrecord`;
CREATE TABLE `tb_borrowreturnrecord` (
  `bookid` varchar(5) NOT NULL,
  `bookname` varchar(100) DEFAULT NULL,
  `readerid` varchar(5) DEFAULT NULL,
  `borrowdate` datetime DEFAULT NULL,
  `returndate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_borrowreturnrecord
-- ----------------------------
INSERT INTO `tb_borrowreturnrecord` VALUES ('B0002', 'Java语言程序设计', 'R0001', '2014-12-24 00:00:00', '2014-12-27 02:23:16');
INSERT INTO `tb_borrowreturnrecord` VALUES ('B0001', '数据库课程设计', 'R0001', '2014-12-01 00:00:00', '2014-12-22 10:05:59');
INSERT INTO `tb_borrowreturnrecord` VALUES ('B0004', '界面化学', 'R0002', '2014-12-27 10:18:20', '2014-12-27 12:45:43');
INSERT INTO `tb_borrowreturnrecord` VALUES ('B0001', '数据库课程设计', 'R0001', '2014-12-27 02:13:16', null);
INSERT INTO `tb_borrowreturnrecord` VALUES ('B0004', '界面化学', 'R0001', '2014-12-27 02:18:09', '2014-12-27 02:24:11');
INSERT INTO `tb_borrowreturnrecord` VALUES ('B0004', '界面化学', 'R0003', '2014-12-27 02:42:30', '2014-12-27 02:42:41');
INSERT INTO `tb_borrowreturnrecord` VALUES ('B0002', 'Java语言程序设计', 'R0007', '2014-12-27 05:27:18', '2014-12-28 02:58:48');
INSERT INTO `tb_borrowreturnrecord` VALUES ('B0010', '数据库系统概论', 'R0001', '2014-12-28 02:54:48', '2014-12-28 02:57:17');
