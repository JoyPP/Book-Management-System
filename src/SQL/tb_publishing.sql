/*
Navicat MySQL Data Transfer

Source Server         : ruirui
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2014-12-28 19:08:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_publishing
-- ----------------------------
DROP TABLE IF EXISTS `tb_publishing`;
CREATE TABLE `tb_publishing` (
  `ISBN` varchar(10) NOT NULL,
  `pubname` varchar(100) DEFAULT NULL,
  `pubcount` int(5) DEFAULT NULL,
  PRIMARY KEY (`ISBN`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_publishing
-- ----------------------------
INSERT INTO `tb_publishing` VALUES ('I0001', '清华出版社', '0');
INSERT INTO `tb_publishing` VALUES ('I0002', '北航出版社', '3');
INSERT INTO `tb_publishing` VALUES ('I0003', '哈哈出版社', '1');
INSERT INTO `tb_publishing` VALUES ('I0005', '化学工业出版社', '1');
INSERT INTO `tb_publishing` VALUES ('I0007', '清华大学出版社', '1');
INSERT INTO `tb_publishing` VALUES ('I0008', '高等教育出版社', '1');
