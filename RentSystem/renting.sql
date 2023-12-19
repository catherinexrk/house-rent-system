/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : renting

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-01-10 14:33:30
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` varchar(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'z', '123');
INSERT INTO `admin` VALUES ('123', '123', '123');
INSERT INTO `admin` VALUES ('1232', '1', '123');

-- ----------------------------
-- Table structure for `history`
-- ----------------------------
DROP TABLE IF EXISTS `history`;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `room` varchar(255) DEFAULT NULL,
  `registertime` datetime DEFAULT NULL,
  `exittime` datetime DEFAULT NULL,
  `money` float(20,0) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1216 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of history
-- ----------------------------
INSERT INTO `history` VALUES ('1', 'liu', '102', '2019-12-11 15:57:25', '2019-12-28 15:57:29', '2100', null);
INSERT INTO `history` VALUES ('2', '李三', '103', '2019-12-02 19:50:21', '2019-12-26 19:50:26', '3000', null);
INSERT INTO `history` VALUES ('3', '阿萨德', '202', '2019-11-19 19:50:56', '2019-12-18 19:51:02', '6000', null);
INSERT INTO `history` VALUES ('4', '史蒂芬森', '101', '2019-12-10 19:51:42', '2019-12-18 19:51:46', '3200', null);
INSERT INTO `history` VALUES ('5', '爱心超人', '202', '2019-12-02 19:52:45', '2019-12-26 19:52:49', '2600', null);
INSERT INTO `history` VALUES ('6', '巩华', '302', '2019-12-18 19:53:23', '2019-12-10 19:53:26', '3020', null);
INSERT INTO `history` VALUES ('7', '胡静', '302', '2019-10-08 19:53:53', '2019-11-27 19:53:58', '3600', null);
INSERT INTO `history` VALUES ('8', '关东', '201', '2019-12-25 19:55:17', '2019-12-30 19:55:22', '200', null);

-- ----------------------------
-- Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `fromid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `toid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `room` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('12', '1', '201');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(10) NOT NULL,
  `grade` varchar(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `state` int(20) DEFAULT NULL,
  `remarks` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('101', '三室一厅', '3000', '1', null);
INSERT INTO `room` VALUES ('102', '二室一厅', '1800', '1', null);
INSERT INTO `room` VALUES ('103', '二室一厅', '1800', '0', null);
INSERT INTO `room` VALUES ('104', '三室一厅', '3000', '0', null);
INSERT INTO `room` VALUES ('105', '一室一厅', '1000', '0', null);
INSERT INTO `room` VALUES ('106', '二室一厅', '1500', '0', null);
INSERT INTO `room` VALUES ('201', '三室一厅', '2300', '1', null);
INSERT INTO `room` VALUES ('202', '一室一厅', '1200', '1', null);
INSERT INTO `room` VALUES ('203', '三室一厅', '2200', '0', null);
INSERT INTO `room` VALUES ('204', '一室一厅', '2000', '0', null);
INSERT INTO `room` VALUES ('205', '三室一厅', '3500', '0', null);
INSERT INTO `room` VALUES ('206', '一室一厅', '1800', '0', null);
INSERT INTO `room` VALUES ('303', '三室一厅', '1800', '0', null);
INSERT INTO `room` VALUES ('505', '三室一厅', '2500', '0', null);
INSERT INTO `room` VALUES ('606', '三室一厅', '1200', '0', null);

-- ----------------------------
-- Table structure for `tenant`
-- ----------------------------
DROP TABLE IF EXISTS `tenant`;
CREATE TABLE `tenant` (
  `id` char(20) NOT NULL,
  `password` char(20) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `card` char(18) DEFAULT NULL,
  `sett` int(11) DEFAULT NULL,
  `room` int(18) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `sex` char(255) DEFAULT NULL,
  `hometown` char(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`password`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of tenant
-- ----------------------------
INSERT INTO `tenant` VALUES ('111', '000', '穆念慈', '36542', '0', '301', '2019-11-19', '女', '河南');
INSERT INTO `tenant` VALUES ('12', '12', '李强', '12356', '0', '201', '2019-11-12', '男', '北京');
INSERT INTO `tenant` VALUES ('123', '123', 'zhang', '20301', '0', null, null, null, null);
INSERT INTO `tenant` VALUES ('123456', '11111', 'wang', '411524', '1', '101', '2019-12-18', '男', '上海');
INSERT INTO `tenant` VALUES ('231', '11', '李健康', '32152', '0', null, null, '男', '南京');
