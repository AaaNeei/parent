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

 Date: 04/03/2019 14:21:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yxw_town
-- ----------------------------
DROP TABLE IF EXISTS `yxw_town`;
CREATE TABLE `yxw_town`  (
  `town_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '城镇(县级及其以下单位)',
  `town_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `town_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `town_enum` int(11) DEFAULT NULL COMMENT '当前城镇对应的枚举值',
  `city_id` int(11) DEFAULT NULL COMMENT '所属市id',
  PRIMARY KEY (`town_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
