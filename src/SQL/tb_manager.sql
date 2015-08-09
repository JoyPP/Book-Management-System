/*
Navicat MySQL Data Transfer

Source Server         : ruirui
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2014-12-28 19:07:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager` (
  `sid` varchar(10) NOT NULL,
  `sname` varchar(30) DEFAULT NULL,
  `spwd` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_manager
-- ----------------------------
INSERT INTO `tb_manager` VALUES ('M001', 'admin', '123');
INSERT INTO `tb_manager` VALUES ('M002', '刘丽萍', '123');
