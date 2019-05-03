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

 Date: 04/03/2019 14:20:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yxw_province
-- ----------------------------
DROP TABLE IF EXISTS `yxw_province`;
CREATE TABLE `yxw_province`  (
  `province_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '省份id自动增长',
  `province_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `province_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注信息',
  `province_enum` int(11) DEFAULT NULL COMMENT '当前省份名称对应的枚举值',
  `country_id` int(11) DEFAULT NULL COMMENT '所属国家id',
  PRIMARY KEY (`province_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
