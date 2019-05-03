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

 Date: 04/03/2019 14:20:39
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yxw_grade
-- ----------------------------
DROP TABLE IF EXISTS `yxw_grade`;
CREATE TABLE `yxw_grade`  (
  `grade_id` int(11) NOT NULL COMMENT '等级id',
  `grade_type` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '等级类型(1:世界名校100,2:国内名校100,3:985,4:211,5:一本,6:二本,7:三本,8:大专,)',
  `grade_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '(1:世界名校100,2:国内名校100,3:985,4:211,5:一本,6:二本,7:三本,8:大专,)'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '高校等级表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of yxw_grade
-- ----------------------------
INSERT INTO `yxw_grade` VALUES (1, '1', '世界名校(前100)');
INSERT INTO `yxw_grade` VALUES (2, '2', '国内名校(前100)');
INSERT INTO `yxw_grade` VALUES (3, '3', '国内985');
INSERT INTO `yxw_grade` VALUES (4, '4', '国内211');
INSERT INTO `yxw_grade` VALUES (5, '5', '一类本科');
INSERT INTO `yxw_grade` VALUES (6, '6', '二类本科');
INSERT INTO `yxw_grade` VALUES (7, '7', '三类本科');
INSERT INTO `yxw_grade` VALUES (8, '8', '大专');

SET FOREIGN_KEY_CHECKS = 1;
