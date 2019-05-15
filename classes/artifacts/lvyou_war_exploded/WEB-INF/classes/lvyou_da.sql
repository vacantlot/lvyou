-- phpMyAdmin SQL Dump
-- version 3.0.1.1
-- http://www.phpmyadmin.net
--
-- 服务器版本: 5.1.29
-- PHP 版本: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- --------------------------------------------------------

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `username` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `admin` VALUES ('陈奕迅', '123456');

CREATE TABLE `t_userinfo` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user_id',
  `password` varchar(20) NOT NULL COMMENT '登录密码',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `telephone` varchar(20) DEFAULT NULL COMMENT '手机号码',
  `sex` varchar(4) DEFAULT NULL COMMENT '性别',
  `user_photo` varchar(60) DEFAULT NULL COMMENT '用户照片',
  `birthday` varchar(20) DEFAULT NULL COMMENT '出生日期',
  `address` varchar(50) DEFAULT NULL COMMENT '家庭地址',
  `role` varchar(20) DEFAULT NULL COMMENT '角色',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8

CREATE TABLE `role` (
  `id` int(11) NOT NULL COMMENT 'id',
  `role` varchar(255) DEFAULT NULL COMMENT '角色',
  `user_id` varchar(255) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

-- INSERT INTO `role` VALUES ('1', 'user');
-- INSERT INTO `role` VALUES ('2', 'admin');


CREATE TABLE IF NOT EXISTS `t_scenicType` (
  `scenic_type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `type_name` varchar(20)  NOT NULL COMMENT '类别名称',
  PRIMARY KEY (`scenic_type_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_city` (
  `city_id` varchar(20)  NOT NULL COMMENT 'cityNo',
  `cityName` varchar(20)  NOT NULL COMMENT '城市名称',
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `t_scenic` (
  `scenic_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '景点id',
  `city_id` varchar(20)  NOT NULL COMMENT '所在城市',
  `scenic_type_id` int(11) NOT NULL COMMENT '景点类型',
  `scenic_level` varchar(20)  DEFAULT NULL COMMENT '景点等级',
  `scenic_name` varchar(30)  NOT NULL COMMENT '景点名称',
  `scenic_photo` varchar(60)  DEFAULT NULL COMMENT '景区图片',
  `scenic_desc` varchar(2000)  DEFAULT NULL COMMENT '景点介绍',
  `price` varchar(20) DEFAULT NULL COMMENT '门票价格',
  `open_time` varchar(30)  DEFAULT NULL COMMENT '开放时间',
  `address` varchar(60)  DEFAULT NULL COMMENT '景点地址',
  PRIMARY KEY (`scenic_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `scenic_id` int(11) NOT NULL COMMENT '被评景点',
  `commentContent` varchar(30)  NOT NULL COMMENT '评论内容',
  `user_id` varchar(20)  NOT NULL COMMENT '评论人',
  `comment_time` varchar(20)  NULL COMMENT '评论时间',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_orderInfo` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `scenic_id` int(11) NOT NULL COMMENT '预定景点',
  `order_date` varchar(20)  NULL COMMENT '预定日期',
  `price` varchar(20) NOT NULL COMMENT '预定价格',
  `user_id` varchar(20)  NOT NULL COMMENT '预定用户',
  `order_time` varchar(20)  NULL COMMENT '下单时间',
  `audit_State` varchar(20)  NOT NULL COMMENT '审核状态',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `t_leaveWord` (
  `leave_word_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '留言id',
  `title` varchar(40)  NOT NULL COMMENT '标题',
  `leave_content` varchar(2000)  NOT NULL COMMENT '留言内容',
  `add_time` varchar(20)  NULL COMMENT '留言时间',
  `user_id` varchar(20)  NOT NULL COMMENT '留言人',
  `reply_content` varchar(2000)  NULL COMMENT '回复内容',
  `reply_time` varchar(20)  NULL COMMENT '回复时间',
  PRIMARY KEY (`leave_word_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

