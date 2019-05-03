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

 Date: 04/03/2019 14:20:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yxw_school
-- ----------------------------
DROP TABLE IF EXISTS `yxw_school`;
CREATE TABLE `yxw_school`  (
  `school_id` int(11) NOT NULL COMMENT '高校(学校)id',
  `school_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校名称',
  `school_grade` int(255) NOT NULL COMMENT '高校排名(统一阶段)',
  `school_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学校地址',
  `school_intro` blob COMMENT '简介',
  `create_time` datetime(0) DEFAULT NULL COMMENT '数据插入时间',
  PRIMARY KEY (`school_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '高校信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
