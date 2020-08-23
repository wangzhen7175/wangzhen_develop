/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : damo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-08-23 22:52:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for generate_id
-- ----------------------------
DROP TABLE IF EXISTS `generate_id`;
CREATE TABLE `generate_id` (
  `id_type` varchar(255) DEFAULT NULL,
  `max_code` int(10) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of generate_id
-- ----------------------------
INSERT INTO `generate_id` VALUES ('iu', '17', '2020-06-21');
INSERT INTO `generate_id` VALUES ('ir', '35', '2020-06-21');
INSERT INTO `generate_id` VALUES ('file', '3', '2020-08-23');
INSERT INTO `generate_id` VALUES ('user', '4', '2020-08-23');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` varchar(50) NOT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '上传文件', '/upload');
INSERT INTO `role` VALUES ('2', '修改用户信息', '/update');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` varchar(30) NOT NULL COMMENT '用户ID\r\n',
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `role_Ids` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('123456', '王振', 'wangzhen123', '1', '\'1\',\'2\'');
INSERT INTO `user` VALUES ('user2020082300000', 'wang1', '2132', '1', '\'1\',\'2\'');
INSERT INTO `user` VALUES ('user2020082300001', '21321', '3213', '1', '\'1\',\'2\'');
INSERT INTO `user` VALUES ('user2020082300002', '1', '1', '1', '\'1\',\'2\'');
INSERT INTO `user` VALUES ('user2020082300003', '231', '213', '1', '\'1\',\'2\'');
