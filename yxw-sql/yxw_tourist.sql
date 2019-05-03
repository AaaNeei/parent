/*
 Navicat Premium Data Transfer

 Source Server         : mysql-东哥
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : 118.31.9.5:3306
 Source Schema         : yxw_master01

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 04/03/2019 14:21:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yxw_tourist
-- ----------------------------
DROP TABLE IF EXISTS `yxw_tourist`;
CREATE TABLE `yxw_tourist`  (
  `tourist_id` bigint(20) NOT NULL COMMENT '景点id',
  `tourist_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景点名称',
  `tourist_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `tourist_type` int(11) DEFAULT NULL COMMENT '景点等级(几星级,景点等级表枚举维护)',
  `tourist_province` int(11) NOT NULL COMMENT '景点省份(省份表枚举维护)',
  PRIMARY KEY (`tourist_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '景点信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
