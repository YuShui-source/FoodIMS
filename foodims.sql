/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80017
 Source Host           : localhost:3306
 Source Schema         : foodims

 Target Server Type    : MySQL
 Target Server Version : 80017
 File Encoding         : 65001

 Date: 19/12/2024 23:33:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bank
-- ----------------------------
DROP TABLE IF EXISTS `bank`;
CREATE TABLE `bank`  (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `balance` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`u_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bank
-- ----------------------------
INSERT INTO `bank` VALUES (10, 25000.00);

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  `expiration` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES (5, '土豆', 1000, '2024-12-30');
INSERT INTO `food` VALUES (6, '玉米', 1000, '2025-01-30');
INSERT INTO `food` VALUES (7, '大豆', 1000, '2025-01-30');
INSERT INTO `food` VALUES (8, '小米', 1000, '2025-01-30');
INSERT INTO `food` VALUES (9, '白菜', 1000, '2025-01-30');
INSERT INTO `food` VALUES (10, '娃娃菜', 1000, '2025-01-30');
INSERT INTO `food` VALUES (11, '蕨菜', 1000, '2025-01-30');
INSERT INTO `food` VALUES (12, '黄豆', 1000, '2025-01-19');
INSERT INTO `food` VALUES (13, '芹菜', 1000, '2025-01-19');
INSERT INTO `food` VALUES (14, '香菜', 1000, '2025-01-19');
INSERT INTO `food` VALUES (15, '胡萝卜', 1000, '2025-01-19');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `o_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `f_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (1, '乙方', '土豆', 1000, 20.00);
INSERT INTO `order` VALUES (3, '乙方', '黄豆', 500, 20.00);
INSERT INTO `order` VALUES (4, '丙方', '玉米', 500, 10.00);
INSERT INTO `order` VALUES (5, '广州店', '香菜', 1000, 20.00);
INSERT INTO `order` VALUES (6, '广州店', '土豆', 1000, 20.00);
INSERT INTO `order` VALUES (7, '华南店', '菠菜', 1000, 20.00);
INSERT INTO `order` VALUES (8, '广东金融学院', '猪肉', 1000, 50.00);
INSERT INTO `order` VALUES (9, '广东金融学院', '牛肉', 1000, 100.00);
INSERT INTO `order` VALUES (10, '广东金融学院', '面粉', 2000, 10.00);
INSERT INTO `order` VALUES (11, '北苑饭堂', '大米', 1000, 10.00);
INSERT INTO `order` VALUES (12, '南苑饭堂', '鸡肉', 1000, 10.00);

-- ----------------------------
-- Table structure for purchase
-- ----------------------------
DROP TABLE IF EXISTS `purchase`;
CREATE TABLE `purchase`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `s_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `f_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `number` int(11) NULL DEFAULT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of purchase
-- ----------------------------
INSERT INTO `purchase` VALUES (1, '甲方', '土豆', 1000, 10.00);
INSERT INTO `purchase` VALUES (4, '甲方', '玉米', 1000, 20.00);
INSERT INTO `purchase` VALUES (5, '川蜀供应商', '辣椒', 500, 20.00);
INSERT INTO `purchase` VALUES (6, '湖南供应商', '胡椒', 500, 10.00);
INSERT INTO `purchase` VALUES (7, '供应商', '大米', 1000, 10.00);
INSERT INTO `purchase` VALUES (8, '东北供应商', '小米', 1000, 10.00);
INSERT INTO `purchase` VALUES (9, '神秘供应商', '芹菜', 1000, 10.00);
INSERT INTO `purchase` VALUES (10, '神秘供应商', '香菜', 1000, 10.00);
INSERT INTO `purchase` VALUES (11, '广东店', '娃娃菜', 1000, 20.00);
INSERT INTO `purchase` VALUES (12, '华南店', '菠菜', 1000, 20.00);
INSERT INTO `purchase` VALUES (13, '光明店', '胡萝卜', 1000, 10.00);

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `supplier` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (3, '土豆', '山东', '甲方');
INSERT INTO `supplier` VALUES (4, '玉米', '陕西', '甲方');
INSERT INTO `supplier` VALUES (5, '黄豆', '山西', '甲方');
INSERT INTO `supplier` VALUES (6, '胡萝卜', '河北', '甲方');
INSERT INTO `supplier` VALUES (7, '香菜', '天津', '甲方');
INSERT INTO `supplier` VALUES (8, '芹菜', '辽宁', '经销商');
INSERT INTO `supplier` VALUES (9, '大米', '黑龙江', '经销商');
INSERT INTO `supplier` VALUES (10, '小米', '吉林', '经销商');
INSERT INTO `supplier` VALUES (11, '娃娃菜', '广东', '经销商');
INSERT INTO `supplier` VALUES (12, '辣椒', '四川', '川蜀经销商');
INSERT INTO `supplier` VALUES (13, '胡椒', '湖南', '湖南经销商');

-- ----------------------------
-- Table structure for u_f
-- ----------------------------
DROP TABLE IF EXISTS `u_f`;
CREATE TABLE `u_f`  (
  `u_id` int(11) NOT NULL,
  `f_id` int(11) NOT NULL,
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_f
-- ----------------------------
INSERT INTO `u_f` VALUES (10, 5);
INSERT INTO `u_f` VALUES (10, 6);
INSERT INTO `u_f` VALUES (10, 7);
INSERT INTO `u_f` VALUES (10, 8);
INSERT INTO `u_f` VALUES (10, 9);
INSERT INTO `u_f` VALUES (10, 10);
INSERT INTO `u_f` VALUES (10, 11);
INSERT INTO `u_f` VALUES (10, 12);
INSERT INTO `u_f` VALUES (10, 13);
INSERT INTO `u_f` VALUES (10, 14);
INSERT INTO `u_f` VALUES (10, 15);

-- ----------------------------
-- Table structure for u_o
-- ----------------------------
DROP TABLE IF EXISTS `u_o`;
CREATE TABLE `u_o`  (
  `u_id` int(11) NOT NULL,
  `o_id` int(11) NOT NULL,
  PRIMARY KEY (`o_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_o
-- ----------------------------
INSERT INTO `u_o` VALUES (10, 1);
INSERT INTO `u_o` VALUES (10, 3);
INSERT INTO `u_o` VALUES (10, 4);
INSERT INTO `u_o` VALUES (10, 5);
INSERT INTO `u_o` VALUES (10, 6);
INSERT INTO `u_o` VALUES (10, 7);
INSERT INTO `u_o` VALUES (10, 8);
INSERT INTO `u_o` VALUES (10, 9);
INSERT INTO `u_o` VALUES (10, 10);
INSERT INTO `u_o` VALUES (10, 11);
INSERT INTO `u_o` VALUES (10, 12);

-- ----------------------------
-- Table structure for u_p
-- ----------------------------
DROP TABLE IF EXISTS `u_p`;
CREATE TABLE `u_p`  (
  `u_id` int(11) NOT NULL,
  `p_id` int(11) NOT NULL,
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_p
-- ----------------------------
INSERT INTO `u_p` VALUES (10, 1);
INSERT INTO `u_p` VALUES (10, 4);
INSERT INTO `u_p` VALUES (10, 5);
INSERT INTO `u_p` VALUES (10, 6);
INSERT INTO `u_p` VALUES (10, 7);
INSERT INTO `u_p` VALUES (10, 8);
INSERT INTO `u_p` VALUES (10, 9);
INSERT INTO `u_p` VALUES (10, 10);
INSERT INTO `u_p` VALUES (10, 11);
INSERT INTO `u_p` VALUES (10, 12);
INSERT INTO `u_p` VALUES (10, 13);

-- ----------------------------
-- Table structure for u_s
-- ----------------------------
DROP TABLE IF EXISTS `u_s`;
CREATE TABLE `u_s`  (
  `u_id` int(11) NOT NULL,
  `s_id` int(11) NOT NULL,
  PRIMARY KEY (`s_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_s
-- ----------------------------
INSERT INTO `u_s` VALUES (10, 3);
INSERT INTO `u_s` VALUES (10, 4);
INSERT INTO `u_s` VALUES (10, 5);
INSERT INTO `u_s` VALUES (10, 6);
INSERT INTO `u_s` VALUES (10, 7);
INSERT INTO `u_s` VALUES (10, 8);
INSERT INTO `u_s` VALUES (10, 9);
INSERT INTO `u_s` VALUES (10, 10);
INSERT INTO `u_s` VALUES (10, 11);
INSERT INTO `u_s` VALUES (10, 12);
INSERT INTO `u_s` VALUES (10, 13);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (9, 'ys', '456456');
INSERT INTO `user` VALUES (10, 'ad', '123123');

SET FOREIGN_KEY_CHECKS = 1;
