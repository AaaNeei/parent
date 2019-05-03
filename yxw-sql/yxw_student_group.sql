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

 Date: 04/03/2019 14:21:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yxw_student_group
-- ----------------------------
DROP TABLE IF EXISTS `yxw_student_group`;
CREATE TABLE `yxw_student_group`  (
  `s_g_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '多对多中间表_学生_组队信息',
  `student_id` int(11) NOT NULL COMMENT '学生用户id',
  `group_id` int(11) NOT NULL COMMENT '组队id',
  `s_g_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  `creat_time` datetime(0) DEFAULT NULL COMMENT '数据创建时间',
  PRIMARY KEY (`s_g_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
