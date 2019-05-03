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

 Date: 04/03/2019 14:21:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yxw_student
-- ----------------------------
DROP TABLE IF EXISTS `yxw_student`;
CREATE TABLE `yxw_student`  (
  `stu_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '学生表ID,注解,非空',
  `stu_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `stu_sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `stu_age` int(3) DEFAULT NULL,
  `stu_addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `stu_hobbies` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '爱好',
  `create_time` datetime(0) DEFAULT NULL COMMENT '数据插入时间',
  `stu_username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册用户名,如果为空填入学生姓名',
  `stu_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '注册密码',
  `stu_comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注信息',
  `school_id` int(11) DEFAULT NULL COMMENT '当前用户对应的学校id',
  PRIMARY KEY (`stu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '高校学生信息表,用户表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
