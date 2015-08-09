/*
Navicat MySQL Data Transfer

Source Server         : ruirui
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2014-12-28 19:08:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_reader
-- ----------------------------
DROP TABLE IF EXISTS `tb_reader`;
CREATE TABLE `tb_reader` (
  `rid` varchar(10) NOT NULL,
  `rname` varchar(30) DEFAULT NULL,
  `rpwd` varchar(10) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `tel` varchar(11) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reader
-- ----------------------------
INSERT INTO `tb_reader` VALUES ('R0001', '张三', '123', '男', '12345678910', '12345678900@163.com');
INSERT INTO `tb_reader` VALUES ('R0002', '李四', '123', '男', '11111111111', '111111111111@qq.com');
INSERT INTO `tb_reader` VALUES ('R0003', '王五', '123', '女', '12345676543', '123456765433@126.com');
INSERT INTO `tb_reader` VALUES ('R0008', '郝倩', '123', '女', '12312312312', '1111111111');
INSERT INTO `tb_reader` VALUES ('R0009', '孙丹菲', '000000', '女', '11111111111', '');
INSERT INTO `tb_reader` VALUES ('R0010', 'fff', '123', '男', '00000000000', '123');
INSERT INTO `tb_reader` VALUES ('R0011', 'sdf', '111', '男', '00000000000', '1');
INSERT INTO `tb_reader` VALUES ('R0012', '111', '111', '男', '00000000000', '1');
INSERT INTO `tb_reader` VALUES ('R0013', 'sdf', '111', '男', '00000000000', '1');
INSERT INTO `tb_reader` VALUES ('R0014', '11', '11', '男', '00000000000', '1');
DROP TRIGGER IF EXISTS `insert_reader`;
DELIMITER ;;
CREATE TRIGGER `insert_reader` BEFORE INSERT ON `tb_reader` FOR EACH ROW BEGIN
		IF (LENGTH(new.tel)!=11) THEN
			SET new.tel = "00000000000";
		END IF;
	END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `update_reader`;
DELIMITER ;;
CREATE TRIGGER `update_reader` BEFORE UPDATE ON `tb_reader` FOR EACH ROW BEGIN
		IF (LENGTH(new.tel)!=11) THEN
			SET new.tel = "00000000000";
		END IF;
	END
;;
DELIMITER ;
