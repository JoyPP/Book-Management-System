/*
Navicat MySQL Data Transfer

Source Server         : ruirui
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2014-12-28 19:07:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_booktype
-- ----------------------------
DROP TABLE IF EXISTS `tb_booktype`;
CREATE TABLE `tb_booktype` (
  `typeID` varchar(10) NOT NULL,
  `typename` varchar(50) DEFAULT NULL,
  `typecount` int(5) DEFAULT NULL,
  PRIMARY KEY (`typeID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_booktype
-- ----------------------------
INSERT INTO `tb_booktype` VALUES ('T0001', '计算机类', '3');
INSERT INTO `tb_booktype` VALUES ('T0002', '小说类', '2');
INSERT INTO `tb_booktype` VALUES ('T0003', '文学类', '0');
INSERT INTO `tb_booktype` VALUES ('T0004', '化学类', '1');
INSERT INTO `tb_booktype` VALUES ('T0005', '文艺类', '0');
INSERT INTO `tb_booktype` VALUES ('T0006', '玄幻类', '1');
