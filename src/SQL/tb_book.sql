/*
Navicat MySQL Data Transfer

Source Server         : ruirui
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2014-12-28 19:07:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_book
-- ----------------------------
DROP TABLE IF EXISTS `tb_book`;
CREATE TABLE `tb_book` (
  `bid` varchar(9) NOT NULL,
  `bookname` varchar(100) DEFAULT NULL,
  `typeID` varchar(10) DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `ISBN` varchar(10) DEFAULT NULL,
  `bookcase` varchar(50) DEFAULT NULL,
  `storage` int(1) DEFAULT NULL,
  PRIMARY KEY (`bid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_book
-- ----------------------------
INSERT INTO `tb_book` VALUES ('B0001', '数据库课程设计', '计算机类', '郎波', '北航出版社', '中文科技', '0');
INSERT INTO `tb_book` VALUES ('B0002', 'Java语言程序设计', '计算机类', '郎波', '清华大学出版社', '中文科技', '1');
INSERT INTO `tb_book` VALUES ('B0003', '匆匆那年', '小说类', '九夜茴', '东方出版社', '社科书库', '1');
INSERT INTO `tb_book` VALUES ('B0004', '界面化学', '化学类', '颜肖慈', '化学工业出版社', '中文科技', '1');
INSERT INTO `tb_book` VALUES ('B0005', '数据库系统概论', '计算机类', '王珊', '高等教育出版社', '中文阅览室', '1');
