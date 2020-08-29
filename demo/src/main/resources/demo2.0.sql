/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2020-08-29 22:55:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dataset
-- ----------------------------
DROP TABLE IF EXISTS `dataset`;
CREATE TABLE `dataset` (
  `dataset_id` varchar(64) NOT NULL,
  `create_time` date DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `dataset_name` varchar(255) DEFAULT NULL,
  `file_count` int(10) DEFAULT NULL,
  PRIMARY KEY (`dataset_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of dataset
-- ----------------------------
INSERT INTO `dataset` VALUES ('dataset2020082900011', '2020-08-29', 'user2020082300002', 'dataset2020082900011', '11');
INSERT INTO `dataset` VALUES ('dataset2020082900012', '2020-08-29', 'user2020082300002', 'dataset2020082900012', '11');
INSERT INTO `dataset` VALUES ('dataset2020082900013', '2020-08-29', 'user2020082300002', 'dataset2020082900013', '1');
INSERT INTO `dataset` VALUES ('dataset2020082900014', '2020-08-29', 'user2020082300002', 'dataset2020082900014', '1');

-- ----------------------------
-- Table structure for file_info
-- ----------------------------
DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info` (
  `file_id` varchar(64) NOT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_size` double DEFAULT NULL,
  `dataset_id` varchar(255) NOT NULL,
  `create_time` date DEFAULT NULL,
  PRIMARY KEY (`dataset_id`,`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of file_info
-- ----------------------------
INSERT INTO `file_info` VALUES ('file2020082900078', '截止2020-08-28日牛客Java京东面经合集.docx', 'E:\\files\\dataset2020082900012\\java面经\\截止2020-08-28日牛客Java京东面经合集.docx', '490059', 'dataset2020082900012', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900079', '截止2020-08-28日牛客Java实习面经合集.docx', 'E:\\files\\dataset2020082900012\\java面经\\截止2020-08-28日牛客Java实习面经合集.docx', '104246', 'dataset2020082900012', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900080', '截止2020-08-28日牛客Java快手面经合集.docx', 'E:\\files\\dataset2020082900012\\java面经\\截止2020-08-28日牛客Java快手面经合集.docx', '238550', 'dataset2020082900012', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900081', '截止2020-08-28日牛客Java校招面经合集.docx', 'E:\\files\\dataset2020082900012\\java面经\\截止2020-08-28日牛客Java校招面经合集.docx', '80386', 'dataset2020082900012', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900082', '截止2020-08-28日牛客Java滴滴面经合集.docx', 'E:\\files\\dataset2020082900012\\java面经\\截止2020-08-28日牛客Java滴滴面经合集.docx', '206655', 'dataset2020082900012', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900083', '截止2020-08-28日牛客Java百度面经合集.docx', 'E:\\files\\dataset2020082900012\\java面经\\截止2020-08-28日牛客Java百度面经合集.docx', '358755', 'dataset2020082900012', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900084', '截止2020-08-28日牛客Java社招面经合集.docx', 'E:\\files\\dataset2020082900012\\java面经\\截止2020-08-28日牛客Java社招面经合集.docx', '588119', 'dataset2020082900012', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900085', '截止2020-08-28日牛客Java美团面经合集.docx', 'E:\\files\\dataset2020082900012\\java面经\\截止2020-08-28日牛客Java美团面经合集.docx', '666787', 'dataset2020082900012', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900086', '截止2020-08-28日牛客Java阿里巴巴社招面经合集.docx', 'E:\\files\\dataset2020082900012\\java面经\\截止2020-08-28日牛客Java阿里巴巴社招面经合集.docx', '80797', 'dataset2020082900012', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900087', '截止2020-08-28日牛客Java阿里巴巴面经合集.docx', 'E:\\files\\dataset2020082900012\\java面经\\截止2020-08-28日牛客Java阿里巴巴面经合集.docx', '907554', 'dataset2020082900012', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900088', '截止2020-08-28日牛客Java面经合集.docx', 'E:\\files\\dataset2020082900012\\java面经\\截止2020-08-28日牛客Java面经合集.docx', '264470', 'dataset2020082900012', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900089', '1092', 'E:\\files\\dataset2020082900013\\file\\1092', '113827', 'dataset2020082900013', '2020-08-29');
INSERT INTO `file_info` VALUES ('file2020082900090', 'IMG_202008241_122659900.jpg', 'E:\\files\\dataset2020082900014\\IMG_202008241_122659900.jpg', '52384', 'dataset2020082900014', '2020-08-29');

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
INSERT INTO `generate_id` VALUES ('file', '91', '2020-08-29');
INSERT INTO `generate_id` VALUES ('user', '4', '2020-08-23');
INSERT INTO `generate_id` VALUES ('dataset', '15', '2020-08-29');

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
INSERT INTO `role` VALUES ('3', '查看文件', '/viewlist');

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
