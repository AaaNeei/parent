/*
 Navicat Premium Data Transfer

 Source Server         : 130
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : 192.168.162.130:3306
 Source Schema         : yxw-member

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 03/05/2019 22:49:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for yxw_open_login
-- ----------------------------
DROP TABLE IF EXISTS `yxw_open_login`;
CREATE TABLE `yxw_open_login`  (
  `id` int(11) NOT NULL COMMENT '表id',
  `wx_openId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关联登陆微信openId',
  `stu_id` int(11) NOT NULL COMMENT '关联登录用户id',
  `qq_openId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关联登录QQopenId',
  `zfb_openId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '关联登录支付宝openId',
  `create_time` datetime(0) NOT NULL COMMENT '创建时间',
  `update_time` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `comment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
