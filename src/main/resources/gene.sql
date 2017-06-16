/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50024
Source Host           : localhost:3306
Source Database       : gene

Target Server Type    : MYSQL
Target Server Version : 50024
File Encoding         : 65001

Date: 2017-06-06 14:52:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dict
-- ----------------------------
DROP TABLE IF EXISTS `dict`;
CREATE TABLE `dict` (
  `id` int(11) NOT NULL auto_increment,
  `value` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `type` varchar(255) default NULL,
  `subType` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dict
-- ----------------------------
INSERT INTO `dict` VALUES ('1', 'gene', 'systemName', 'systemName', 'name1');
INSERT INTO `dict` VALUES ('2', '101', '经济责任审计', '审计类型', null);
INSERT INTO `dict` VALUES ('3', '102', '财务收支审计', '审计类型', null);
INSERT INTO `dict` VALUES ('4', '103', '建设项目审计', '审计类型', null);
INSERT INTO `dict` VALUES ('5', '104', '投资立项审计', '审计类型', null);
INSERT INTO `dict` VALUES ('6', '105', '设计管理审计', '审计类型', null);
INSERT INTO `dict` VALUES ('7', '106', '招投标审计', '审计类型', null);
INSERT INTO `dict` VALUES ('8', '107', '合同管理审计', '审计类型', null);
INSERT INTO `dict` VALUES ('9', '108', '物资采购审计', '审计类型', null);
INSERT INTO `dict` VALUES ('10', '109', '工程管理审计', '审计类型', null);
INSERT INTO `dict` VALUES ('11', '110', '工程造价审计', '审计类型', null);
INSERT INTO `dict` VALUES ('12', '111', '竣工验收审计', '审计类型', null);
INSERT INTO `dict` VALUES ('13', '112', '财务管理审计', '审计类型', null);
INSERT INTO `dict` VALUES ('14', '113', '后评价审计', '审计类型', null);
INSERT INTO `dict` VALUES ('15', '114', '收费和涉案财物审计', '审计类型', null);
INSERT INTO `dict` VALUES ('16', '115', '经济效益审计', '审计类型', null);
INSERT INTO `dict` VALUES ('17', '116', '经济责任审计', '审计类型', null);
INSERT INTO `dict` VALUES ('18', '117', '内部控制审计', '审计类型', null);
INSERT INTO `dict` VALUES ('19', '118', '风险管理审计', '审计类型', null);
INSERT INTO `dict` VALUES ('20', '119', '财经法纪审计', '审计类型', null);
INSERT INTO `dict` VALUES ('21', '120', '专项审计', '审计类型', null);
INSERT INTO `dict` VALUES ('22', '121', '其他审计', '审计类型', null);
INSERT INTO `dict` VALUES ('23', '122', '审计调查', '审计类型', null);
INSERT INTO `dict` VALUES ('24', '123', '审计咨询', '审计类型', null);
INSERT INTO `dict` VALUES ('25', '124', '审计咨询1', '审计类型', null);
INSERT INTO `dict` VALUES ('26', '125', '审计咨询2', '审计类型', null);
INSERT INTO `dict` VALUES ('27', '126', '审计咨询3', '审计类型', null);
INSERT INTO `dict` VALUES ('28', '127', '审计咨询4', '审计类型', null);
INSERT INTO `dict` VALUES ('29', '128', '审计咨询5', '审计类型', null);
INSERT INTO `dict` VALUES ('30', '129', '审计咨询6', '审计类型', null);
INSERT INTO `dict` VALUES ('31', '130', '审计咨询7', '审计类型', null);
INSERT INTO `dict` VALUES ('32', '131', '审计咨询8', '审计类型', null);
INSERT INTO `dict` VALUES ('33', '132', '审计咨询9', '审计类型', null);
INSERT INTO `dict` VALUES ('34', '133', '审计咨询10', '审计类型', null);
INSERT INTO `dict` VALUES ('35', '134', '审计咨询11', '审计类型', null);
INSERT INTO `dict` VALUES ('36', '135', '审计咨询12', '审计类型', null);
INSERT INTO `dict` VALUES ('37', '136', '审计咨询13', '审计类型', null);

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL auto_increment COMMENT '菜单ID',
  `name` varchar(500) default NULL COMMENT '菜单描述',
  `pid` int(11) default NULL COMMENT '上级菜单ID',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '功能1', '0');
INSERT INTO `menu` VALUES ('2', '功能2', '0');
INSERT INTO `menu` VALUES ('3', '功能3', '0');
INSERT INTO `menu` VALUES ('4', '功能1的子功能1', '1');
INSERT INTO `menu` VALUES ('5', '功能1的子功能2', '1');
INSERT INTO `menu` VALUES ('6', '功能2的子功能1', '2');
INSERT INTO `menu` VALUES ('7', '功能2的子功能2', '2');
INSERT INTO `menu` VALUES ('8', '功能3的子功能1', '3');
INSERT INTO `menu` VALUES ('9', '子功能1的功能1', '4');

-- ----------------------------
-- Table structure for org
-- ----------------------------
DROP TABLE IF EXISTS `org`;
CREATE TABLE `org` (
  `id` int(11) NOT NULL auto_increment COMMENT '单位ID',
  `name` varchar(500) default NULL COMMENT '单位名称',
  `info` varchar(500) default NULL COMMENT '单位描述',
  `pid` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of org
-- ----------------------------
INSERT INTO `org` VALUES ('1', '上海市卫计委', null, '0');
INSERT INTO `org` VALUES ('2', '江苏省卫计委', null, '0');
INSERT INTO `org` VALUES ('5', '嘉定区卫计委', null, '1');
INSERT INTO `org` VALUES ('3', '普陀区卫计委', null, '1');
INSERT INTO `org` VALUES ('4', '长宁区卫计委', null, '1');
INSERT INTO `org` VALUES ('6', '苏州市卫计委', null, '2');
INSERT INTO `org` VALUES ('7', '昆山市卫计委', null, '6');
INSERT INTO `org` VALUES ('8', '花桥镇卫生服务站', null, '7');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL auto_increment COMMENT '角色ID',
  `name` varchar(100) NOT NULL COMMENT '角色名称',
  `info` varchar(500) default NULL COMMENT '角色描述',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------

-- ----------------------------
-- Table structure for rolewithmenu
-- ----------------------------
DROP TABLE IF EXISTS `rolewithmenu`;
CREATE TABLE `rolewithmenu` (
  `rid` int(11) NOT NULL default '0' COMMENT '角色ID',
  `mid` int(11) NOT NULL default '0' COMMENT '菜单ID'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rolewithmenu
-- ----------------------------

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(11) NOT NULL auto_increment,
  `state` int(1) NOT NULL default '0' COMMENT '状态：0=停止，1=启动',
  `name` varchar(255) NOT NULL COMMENT '名称',
  `exp` varchar(50) NOT NULL COMMENT '表达式',
  `class` varchar(255) NOT NULL COMMENT '实现类',
  `info` varchar(255) default NULL COMMENT '说明',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('1', '0', '每分', '0 0/1 * * * ?', 'com.oss.job.EveryMinJob', '每分钟来一发');
INSERT INTO `task` VALUES ('2', '0', '每时', '0 0 0/1 * * ?', 'com.oss.job.EveryHourJob', '每小时统计一次');
INSERT INTO `task` VALUES ('12', '0', '每天', '59 59 23 * * ?', 'com.oss.job.EveryDayJob', '每天23点59分59秒跑一下');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL auto_increment COMMENT '用户ID',
  `loginID` varchar(200) default NULL COMMENT '登陆ID',
  `loginName` varchar(500) default NULL COMMENT '登录名',
  `password` varchar(500) default NULL COMMENT '密码',
  `orgid` int(11) default NULL COMMENT '单位ID',
  `roleid` int(11) default NULL COMMENT ' 角色ID',
  `stat` int(11) default '1' COMMENT '1.待启用2.启用3.停用',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'zhanfei', '詹飞', '111111', '1', '1', '1');
INSERT INTO `users` VALUES ('4', 'zhanfei123456', '', '123456', '4', '1', '1');
INSERT INTO `users` VALUES ('5', 'zhanfei123', '', '123', '5', '1', '1');
INSERT INTO `users` VALUES ('6', 'zfd1', '', '111111', '5', '1', '1');
INSERT INTO `users` VALUES ('7', 'zhanfei123456789', '', '111111', '3', '1', '1');
