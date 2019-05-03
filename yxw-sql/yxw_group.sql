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

 Date: 04/03/2019 14:20:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yxw_group
-- ----------------------------
DROP TABLE IF EXISTS `yxw_group`;
CREATE TABLE `yxw_group`  (
  `group_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '组队信息id',
  `group_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '团队名称',
  `group_start_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预计出发起点',
  `group_end_line` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '预计结束终点',
  `creat_time` datetime(0) DEFAULT NULL COMMENT '数据插入时间',
  `modify_time` datetime(0) DEFAULT NULL COMMENT '插入数据被修改时间',
  `group_up_strat_time` datetime(0) NOT NULL COMMENT '组队信息开始在网站公布时间,其他用户可以看到此组队信息',
  `group_up_end_time` datetime(0) NOT NULL COMMENT '组队信息停止其他用户参与组队结束时间,说明已经超时或者组队已经完成',
  `group_travel_start_time` datetime(0) NOT NULL COMMENT '该组队预计出发时间',
  `group_travel_end_time` datetime(0) NOT NULL COMMENT '该组队预计返回时间',
  `group_information` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '团队标语,介绍等',
  `group_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
