/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : bbs

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 15/04/2019 15:25:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for apply_plate
-- ----------------------------
DROP TABLE IF EXISTS `apply_plate`;
CREATE TABLE `apply_plate`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '申请的用户id',
  `info` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT '' COMMENT '申请的理由',
  `plate_id` int(11) NOT NULL DEFAULT 0 COMMENT '申请的板块',
  `state` tinyint(3) DEFAULT 1 COMMENT '1 有效 0无效',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '版主申请表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of apply_plate
-- ----------------------------
INSERT INTO `apply_plate` VALUES (1, 3, '我上边有人', 15, 0, '2019-03-14 10:34:50', '2019-04-09 18:47:14');
INSERT INTO `apply_plate` VALUES (2, 4, '1111', 18, 1, '2019-03-14 11:44:01', '2019-03-14 11:44:01');
INSERT INTO `apply_plate` VALUES (3, 4, '222', 19, 1, '2019-03-14 11:49:29', '2019-03-14 11:49:29');
INSERT INTO `apply_plate` VALUES (5, 1, '我腰椎很好，申请当版主', 26, 1, '2019-03-24 11:50:20', '2019-03-24 11:50:20');
INSERT INTO `apply_plate` VALUES (6, 12, '赶紧的，我操', 29, 0, '2019-03-31 22:53:24', '2019-03-31 22:53:24');
INSERT INTO `apply_plate` VALUES (7, 13, '老用户了，给我吧', 15, 1, '2019-04-09 18:42:06', '2019-04-09 18:42:06');

-- ----------------------------
-- Table structure for askhelp
-- ----------------------------
DROP TABLE IF EXISTS `askhelp`;
CREATE TABLE `askhelp`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `post_id` int(11) NOT NULL COMMENT '帖子id',
  `rev_question_user_id` int(11) NOT NULL COMMENT '被求问用户id',
  `send_question_user_id` int(11) NOT NULL COMMENT '发问用户id',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL COMMENT '求问信息',
  `gmt_create` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `state` tinyint(3) NOT NULL DEFAULT 1 COMMENT '状态：1 有效 2无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '求问表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of askhelp
-- ----------------------------
INSERT INTO `askhelp` VALUES (1, 34, 1, 1, '测试1530', '2019-03-18 15:31:58', 1);
INSERT INTO `askhelp` VALUES (2, 34, 3, 1, '测试1530', '2019-03-18 15:31:58', 1);
INSERT INTO `askhelp` VALUES (3, 34, 4, 1, '测试1530', '2019-03-18 15:31:58', 1);
INSERT INTO `askhelp` VALUES (4, 34, 5, 1, '测试1530', '2019-03-18 15:31:58', 1);
INSERT INTO `askhelp` VALUES (5, 35, 3, 1, '测试181548', '2019-03-18 15:48:24', 1);
INSERT INTO `askhelp` VALUES (6, 35, 4, 1, '测试181548', '2019-03-18 15:48:24', 1);
INSERT INTO `askhelp` VALUES (7, 35, 5, 1, '测试181548', '2019-03-18 15:48:24', 1);
INSERT INTO `askhelp` VALUES (8, 35, 6, 1, '测试181548', '2019-03-18 15:48:24', 1);
INSERT INTO `askhelp` VALUES (9, 36, 1, 27, 'testGO', '2019-03-24 10:11:14', 1);
INSERT INTO `askhelp` VALUES (10, 36, 3, 27, 'testGO', '2019-03-24 10:11:14', 1);
INSERT INTO `askhelp` VALUES (11, 36, 4, 27, 'testGO', '2019-03-24 10:11:14', 1);
INSERT INTO `askhelp` VALUES (12, 36, 5, 27, 'testGO', '2019-03-24 10:11:14', 1);
INSERT INTO `askhelp` VALUES (13, 37, 1, 1, 'testGO', '2019-03-24 10:21:56', 1);
INSERT INTO `askhelp` VALUES (14, 37, 3, 1, 'testGO', '2019-03-24 10:21:56', 1);
INSERT INTO `askhelp` VALUES (15, 37, 4, 1, 'testGO', '2019-03-24 10:21:56', 1);
INSERT INTO `askhelp` VALUES (16, 37, 5, 1, 'testGO', '2019-03-24 10:21:56', 1);
INSERT INTO `askhelp` VALUES (17, 38, 1, 12, '对97000的回复', '2019-03-31 22:40:02', 1);
INSERT INTO `askhelp` VALUES (18, 38, 3, 12, '对97000的回复', '2019-03-31 22:40:02', 1);
INSERT INTO `askhelp` VALUES (19, 38, 4, 12, '对97000的回复', '2019-03-31 22:40:02', 1);
INSERT INTO `askhelp` VALUES (20, 38, 5, 12, '对97000的回复', '2019-03-31 22:40:02', 1);

-- ----------------------------
-- Table structure for chat_record
-- ----------------------------
DROP TABLE IF EXISTS `chat_record`;
CREATE TABLE `chat_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '聊天内容',
  `team_id` int(11) NOT NULL COMMENT '讨论组小组id',
  `gmt_create` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `user_create` int(11) DEFAULT NULL COMMENT '创建者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '讨论组聊天记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of chat_record
-- ----------------------------
INSERT INTO `chat_record` VALUES (1, '124124', 5, '2019-04-15 11:12:02', 12);
INSERT INTO `chat_record` VALUES (2, '有人吗', 5, '2019-04-15 11:12:22', 1);
INSERT INTO `chat_record` VALUES (3, '123', 5, '2019-04-15 11:27:30', 12);
INSERT INTO `chat_record` VALUES (4, '444', 5, '2019-04-15 11:27:31', 12);
INSERT INTO `chat_record` VALUES (5, '124', 5, '2019-04-15 11:27:36', 1);
INSERT INTO `chat_record` VALUES (6, '哈哈哈', 5, '2019-04-15 14:28:59', 12);
INSERT INTO `chat_record` VALUES (7, '???', 5, '2019-04-15 14:31:09', 1);
INSERT INTO `chat_record` VALUES (8, 'test111', 5, '2019-04-15 14:33:07', 1);
INSERT INTO `chat_record` VALUES (9, 'test222', 5, '2019-04-15 14:33:19', 12);
INSERT INTO `chat_record` VALUES (10, '11', 5, '2019-04-15 15:15:32', 1);

-- ----------------------------
-- Table structure for favorites_article
-- ----------------------------
DROP TABLE IF EXISTS `favorites_article`;
CREATE TABLE `favorites_article`  (
  `user_id` int(10) NOT NULL COMMENT '用户id',
  `post_id` int(10) NOT NULL COMMENT '帖子id',
  `state` tinyint(3) NOT NULL DEFAULT 1 COMMENT '状态： 1 有效 2 无效',
  `gmt_create` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `user_create` int(11) DEFAULT NULL COMMENT '创建者id',
  `user_modify` int(11) DEFAULT NULL COMMENT '修改着id',
  PRIMARY KEY (`user_id`, `post_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '喜欢的文章表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of favorites_article
-- ----------------------------
INSERT INTO `favorites_article` VALUES (1, 37, 0, '2019-03-24 10:53:45', '2019-03-24 11:17:37', 1, 1);

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow`  (
  `fan_id` int(10) NOT NULL COMMENT '粉丝id',
  `star_id` int(10) NOT NULL COMMENT '被关注者id',
  `gmt_create` datetime(0) DEFAULT NULL COMMENT '创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '关注人表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of follow
-- ----------------------------
INSERT INTO `follow` VALUES (7, 1, '2019-04-05 15:30:56');
INSERT INTO `follow` VALUES (1, 5, '2019-04-05 15:30:56');
INSERT INTO `follow` VALUES (12, 3, '2019-04-05 15:39:13');
INSERT INTO `follow` VALUES (1, 10, '2019-04-05 15:53:43');
INSERT INTO `follow` VALUES (3, 1, '2019-04-05 16:35:06');
INSERT INTO `follow` VALUES (4, 1, '2019-04-05 16:35:06');
INSERT INTO `follow` VALUES (5, 1, '2019-04-05 16:35:06');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(10) DEFAULT NULL,
  `permission` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, 1, 'post:add');
INSERT INTO `permission` VALUES (2, 1, 'reply:add');
INSERT INTO `permission` VALUES (3, 2, 'post:delete');
INSERT INTO `permission` VALUES (4, 2, 'reply:delete');
INSERT INTO `permission` VALUES (5, 2, 'post:add');
INSERT INTO `permission` VALUES (6, 2, 'reply:add');
INSERT INTO `permission` VALUES (7, 2, 'user:ban');
INSERT INTO `permission` VALUES (8, 3, 'post:add');
INSERT INTO `permission` VALUES (9, 3, 'reply:add');
INSERT INTO `permission` VALUES (10, 3, 'post:delete');
INSERT INTO `permission` VALUES (11, 3, 'reply:delete');
INSERT INTO `permission` VALUES (12, 3, 'user:ban');
INSERT INTO `permission` VALUES (13, 3, 'moderator:ban');
INSERT INTO `permission` VALUES (14, 3, 'moderator:agree');
INSERT INTO `permission` VALUES (15, 2, 'post:good');
INSERT INTO `permission` VALUES (16, 3, 'post:good');
INSERT INTO `permission` VALUES (17, 2, 'post:un_good');
INSERT INTO `permission` VALUES (18, 3, 'post:un_good');

-- ----------------------------
-- Table structure for plater
-- ----------------------------
DROP TABLE IF EXISTS `plater`;
CREATE TABLE `plater`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `plate_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '板块名称',
  `owner_id` int(11) DEFAULT NULL COMMENT '版主id',
  `state` tinyint(1) DEFAULT 1 COMMENT '状态： 1 有效，2 无效',
  `gmt_create` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `user_create` int(11) DEFAULT NULL COMMENT '创建者id',
  `user_modify` int(11) DEFAULT NULL COMMENT '修改着id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '板块表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plater
-- ----------------------------
INSERT INTO `plater` VALUES (1, 'JavaSE', 1, NULL, '2019-03-14 13:54:15', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (2, 'Python', 1, NULL, '2019-03-14 13:54:15', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (3, 'Javascript', 1, NULL, '2019-03-14 13:54:15', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (4, 'PHP', 1, NULL, '2019-03-14 13:54:15', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (5, 'C++', 1, NULL, '2019-03-14 13:54:15', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (6, 'JavaEE', 1, NULL, '2019-03-14 13:54:15', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (7, 'SQL', 1, NULL, '2019-03-14 13:54:15', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (8, '移动开发', 1, NULL, '2019-03-14 13:54:15', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (9, '云计算', 1, NULL, '2019-03-14 13:54:15', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (10, '区块链', 3, NULL, '2019-03-14 13:54:15', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (13, 'Go', 3, NULL, '2019-03-14 13:54:15', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (15, 'C', 3, NULL, '2019-03-14 14:11:25', '2019-04-09 18:47:18', NULL, NULL);
INSERT INTO `plater` VALUES (18, 'PHP', NULL, NULL, '2019-03-14 14:11:27', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (19, 'C#', NULL, NULL, '2019-03-14 14:11:29', NULL, NULL, NULL);
INSERT INTO `plater` VALUES (21, 'R', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `plater` VALUES (23, 'Ruby', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `plater` VALUES (25, '.NET', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `plater` VALUES (26, '腰椎间盘的护理', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `plater` VALUES (27, '高血压预防', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `plater` VALUES (28, '如何不掉发', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `plater` VALUES (29, '精神病学', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `plater` VALUES (30, '其他', NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `plater` VALUES (31, 'Android', NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '帖子标题',
  `info` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '帖子内容',
  `poster_id` int(10) NOT NULL DEFAULT 0 COMMENT '作者id',
  `if_good` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否被推荐，1被推荐 0 未被推荐',
  `plate_id` int(10) NOT NULL DEFAULT 0 COMMENT '板块id',
  `reply_count` int(10) NOT NULL DEFAULT 0 COMMENT '回复数',
  `thumbup_count` int(3) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `gmt_create` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `create_user` int(11) DEFAULT NULL COMMENT '创建用户',
  `modify_user` int(11) DEFAULT NULL COMMENT '修改用户',
  `state` tinyint(1) DEFAULT 1 COMMENT '状态 1 未删除 0 已删除',
  `read_count` int(11) NOT NULL DEFAULT 0 COMMENT '阅读数',
  `article_from` tinyint(1) NOT NULL DEFAULT 1 COMMENT '文章的来源：1 原创 2 转载',
  `article_type` tinyint(3) NOT NULL DEFAULT 1 COMMENT '文章的类型：1讨论帖 ，2资源贴，3求问贴',
  `ban_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '被封禁理由',
  `give_money` int(11) NOT NULL DEFAULT 0 COMMENT '悬赏积分（用于求问贴）',
  `need_money` int(11) NOT NULL DEFAULT 0 COMMENT '需要积分（用户下载）',
  `resource_id` int(11) DEFAULT NULL COMMENT '资源表id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '讨论帖子表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- ----------------------------
INSERT INTO `post` VALUES (1, '帖子1', '帖子内容', 1, 0, 1, 7, 0, '2019-03-04 15:45:29', '2019-03-31 22:18:38', 1, 1, 0, 15, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (2, '帖子2', '啊啊啊啊啊啊', 1, 0, 2, 7, 0, '2019-03-11 15:26:37', '2019-03-19 16:40:23', 1, 1, 1, 10, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (3, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:32', '2019-03-19 16:40:23', 1, 1, 1, 2, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (4, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (5, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (6, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (7, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (8, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (9, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (10, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (11, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (12, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (13, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (14, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (15, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (16, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (17, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (18, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (19, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 0, 1, 1, 1, '小测试', 0, 0, NULL);
INSERT INTO `post` VALUES (20, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 1, 0, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (21, 'test141556', 'test141556', 1, 0, 1, 0, 0, '2019-03-14 15:59:35', '2019-03-19 16:40:23', 1, 1, 0, 0, 1, 1, '测试', 0, 0, NULL);
INSERT INTO `post` VALUES (34, '测试1530', '11', 1, 0, 2, 0, 0, '2019-03-18 15:31:58', '2019-03-19 16:44:51', 1, 1, 1, 0, 1, 2, NULL, 0, 33, NULL);
INSERT INTO `post` VALUES (35, '测试181548', '测试181548', 1, 1, 2, 4, 0, '2019-03-18 15:48:24', '2019-04-10 13:04:21', 1, 1, 1, 59, 1, 2, NULL, 0, 22, NULL);
INSERT INTO `post` VALUES (36, 'testGO', 'test', 27, 0, 25, 0, 0, '2019-03-24 10:11:14', '2019-03-24 10:11:14', 27, 27, 1, 0, 1, 2, NULL, 0, 21, NULL);
INSERT INTO `post` VALUES (37, 'testGO', 'testGO', 1, 0, 13, 1, 0, '2019-03-24 10:21:56', '2019-03-24 14:49:57', 1, 1, 1, 44, 1, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (38, '对97000的回复', '来沈阳别让我看到你嗷', 12, 1, 23, 2, 0, '2019-03-31 22:40:02', '2019-04-10 12:57:42', 12, 1, 1, 14, 2, 2, NULL, 0, 22, NULL);
INSERT INTO `post` VALUES (40, '资源1', '资源1', 1, 0, 1, 0, 0, '2019-04-06 00:14:55', '2019-04-06 00:14:55', 1, 1, 1, 3, 2, 2, NULL, 0, 111, 4);
INSERT INTO `post` VALUES (41, '资源2', '资源2', 1, 1, 1, 0, 0, '2019-04-06 11:32:19', '2019-04-06 16:01:36', 1, 1, 1, 155, 1, 2, NULL, 0, 111, 5);
INSERT INTO `post` VALUES (42, '你好', '11', 1, 0, 6, 0, 0, '2019-04-10 14:01:00', '2019-04-10 14:01:00', 1, 1, 1, 2, 2, 1, NULL, 0, 0, NULL);
INSERT INTO `post` VALUES (43, '1528', '1528', 13, 0, 3, 0, 0, '2019-04-10 15:28:33', '2019-04-10 15:28:33', 13, 13, 1, 1, 1, 2, NULL, 0, 22, 6);

-- ----------------------------
-- Table structure for private_letter
-- ----------------------------
DROP TABLE IF EXISTS `private_letter`;
CREATE TABLE `private_letter`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_send_send` int(11) NOT NULL COMMENT '发送者id（用于创建者）',
  `user_send_rev` int(11) NOT NULL COMMENT '接收者id',
  `content` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '内容',
  `if_read` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否已读: 1已读 0 未读',
  `state` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态： 1有效 0无效',
  `user_modify` int(11) DEFAULT NULL COMMENT '修改着id',
  `gmt_create` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `letter_type` tinyint(1) DEFAULT NULL COMMENT '私信类型： 1 用户私信 2 系统私信',
  `user_rev_send` int(11) NOT NULL COMMENT '发送者id（用于接收者）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '私信表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of private_letter
-- ----------------------------
INSERT INTO `private_letter` VALUES (1, 4, 1, '啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊', b'0', 1, 1, '2019-03-24 16:05:34', '2019-03-31 22:16:39', 1, 0);
INSERT INTO `private_letter` VALUES (2, 1, 12, '你就是个篮子', b'1', 0, 12, '2019-03-31 22:38:21', '2019-03-31 22:38:57', 1, 1);
INSERT INTO `private_letter` VALUES (3, 1, 12, '来成都看我干不干你就完事了', b'1', 0, 12, '2019-03-31 22:38:43', '2019-03-31 22:39:00', 1, 1);
INSERT INTO `private_letter` VALUES (4, 12, 1, '日嫩娘', b'1', 0, 1, '2019-03-31 22:39:18', '2019-03-31 22:56:51', 1, 0);
INSERT INTO `private_letter` VALUES (5, 1, 12, '你好', b'0', 1, 1, '2019-04-10 13:05:47', '2019-04-10 13:05:47', 1, 1);

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `reply_info` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '回复信息',
  `post_id` int(10) DEFAULT NULL COMMENT '帖子id',
  `thumbup_count` int(3) NOT NULL DEFAULT 0 COMMENT '点赞数',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `user_create` int(11) NOT NULL COMMENT '创建者id',
  `user_modify` int(11) DEFAULT NULL COMMENT '修改者id',
  `state` tinyint(3) NOT NULL DEFAULT 1 COMMENT '1 有效, 0 无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 36 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '回复表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES (1, '哈哈太逗了', 4, 0, '2019-03-11 11:11:08', '2019-03-11 11:11:08', 1, 1, 1);
INSERT INTO `reply` VALUES (2, '没毛病嗷', 2, 0, '2019-03-11 11:11:08', '2019-03-11 11:11:08', 1, 1, 1);
INSERT INTO `reply` VALUES (3, '嚯嚯嚯', 1, 0, '2019-03-11 11:11:08', '2019-03-11 11:11:08', 1, 1, 1);
INSERT INTO `reply` VALUES (4, '那是真的牛批', 1, 0, '2019-03-11 11:11:05', '2019-03-11 11:11:32', 1, 1, 1);
INSERT INTO `reply` VALUES (5, '指定给你吃好果子嗷', 1, 0, '2019-03-11 11:11:08', '2019-03-31 22:10:46', 1, 1, 0);
INSERT INTO `reply` VALUES (6, '指定给你吃好果子嗷', 1, 0, '2019-03-11 11:11:08', '2019-03-11 11:11:08', 1, 1, 1);
INSERT INTO `reply` VALUES (7, '大家好我是陈冠希，一giao窝里giao giao giao', 1, 0, '2019-03-11 11:11:08', '2019-03-11 11:11:08', 1, 1, 1);
INSERT INTO `reply` VALUES (8, '阿giao给你留个言', 1, 0, '2019-03-11 11:11:08', '2019-03-11 11:11:08', 1, 1, 1);
INSERT INTO `reply` VALUES (9, '不睡最好', 16, 0, '2019-03-11 11:11:08', '2019-03-11 11:11:08', 1, 1, 1);
INSERT INTO `reply` VALUES (11, 'giao哥up up', 1, 0, '2019-03-11 11:11:08', '2019-03-11 11:11:08', 1, 1, 1);
INSERT INTO `reply` VALUES (12, '你好', 2, 0, '2019-03-11 17:08:19', '2019-03-11 17:08:19', 1, 1, 1);
INSERT INTO `reply` VALUES (13, '你好', 2, 0, '2019-03-11 17:08:19', '2019-03-11 17:08:19', 1, 1, 1);
INSERT INTO `reply` VALUES (14, '我透', 2, 0, '2019-03-11 17:10:08', '2019-03-11 17:10:08', 1, 1, 0);
INSERT INTO `reply` VALUES (15, '我透', 2, 0, '2019-03-11 17:10:08', '2019-03-11 17:10:08', 1, 1, 0);
INSERT INTO `reply` VALUES (16, '我透', 2, 0, '2019-03-11 17:10:16', '2019-03-11 17:10:16', 1, 1, 0);
INSERT INTO `reply` VALUES (17, '我透', 2, 0, '2019-03-11 17:10:16', '2019-03-11 17:10:16', 1, 1, 0);
INSERT INTO `reply` VALUES (18, '我透', 2, 0, '2019-03-11 17:10:17', '2019-03-11 17:10:17', 1, 1, 0);
INSERT INTO `reply` VALUES (19, '我透', 2, 0, '2019-03-11 17:10:17', '2019-03-11 17:10:17', 1, 1, 0);
INSERT INTO `reply` VALUES (20, '我透', 2, 0, '2019-03-11 17:10:17', '2019-03-11 17:10:17', 1, 1, 0);
INSERT INTO `reply` VALUES (21, '我透', 2, 0, '2019-03-11 17:10:17', '2019-03-11 17:10:17', 1, 1, 0);
INSERT INTO `reply` VALUES (22, '啊啊啊', 2, 0, '2019-03-12 10:08:53', '2019-03-12 10:08:53', 1, 1, 1);
INSERT INTO `reply` VALUES (23, '11111', 2, 0, '2019-03-12 10:10:07', '2019-03-12 10:10:07', 1, 1, 1);
INSERT INTO `reply` VALUES (24, '222', 2, 0, '2019-03-12 10:10:34', '2019-03-12 10:10:34', 1, 1, 1);
INSERT INTO `reply` VALUES (25, '333', 2, 0, '2019-03-12 10:11:18', '2019-03-12 10:11:18', 1, 1, 1);
INSERT INTO `reply` VALUES (26, '444', 2, 0, '2019-03-12 10:11:48', '2019-03-12 10:11:48', 1, 1, 1);
INSERT INTO `reply` VALUES (27, '555', 2, 0, '2019-03-12 10:12:17', '2019-03-12 10:12:17', 1, 1, 1);
INSERT INTO `reply` VALUES (28, 'LOOK AT U UGLY FAT', 1, 0, '2019-03-12 11:11:14', '2019-03-12 11:11:14', 3, 3, 1);
INSERT INTO `reply` VALUES (29, '写的不错', 37, 0, '2019-03-24 14:49:57', '2019-03-24 14:49:57', 1, 1, 1);
INSERT INTO `reply` VALUES (30, '嚯嚯嚯，那是真的牛批', 35, 0, '2019-03-31 22:37:53', '2019-03-31 22:37:53', 12, 12, 1);
INSERT INTO `reply` VALUES (31, '鸭儿哟', 35, 0, '2019-03-31 22:38:04', '2019-03-31 22:38:04', 12, 12, 1);
INSERT INTO `reply` VALUES (32, '11', 35, 0, '2019-04-02 19:55:06', '2019-04-02 19:55:06', 1, 1, 1);
INSERT INTO `reply` VALUES (33, '??', 35, 0, '2019-04-05 15:53:21', '2019-04-05 15:53:21', 1, 1, 1);
INSERT INTO `reply` VALUES (34, '111', 38, 0, '2019-04-10 12:57:39', '2019-04-10 12:57:39', 1, 1, 1);
INSERT INTO `reply` VALUES (35, '222222', 38, 0, '2019-04-10 12:57:42', '2019-04-10 12:57:42', 1, 1, 1);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `file_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '资源url',
  `file_size` int(11) NOT NULL COMMENT '资源大小',
  `file_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL COMMENT '资源名称',
  `gmt_create` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `user_create` int(11) DEFAULT NULL COMMENT '创建者id',
  `user_modify` int(11) DEFAULT NULL COMMENT '修改者id',
  `state` tinyint(3) DEFAULT 1 COMMENT '状态：1有效 0 无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci COMMENT = '上传的资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (4, 'D:\\user_file\\bbs-plus.rar', 3787, 'bbs-plus.rar', '2019-04-06 00:14:55', '2019-04-06 00:14:55', 1, 1, 1);
INSERT INTO `resource` VALUES (5, 'D:\\user_file\\1bbs-plus.rar', 3787, '1bbs-plus.rar', '2019-04-06 11:32:19', '2019-04-06 11:32:19', 1, 1, 1);
INSERT INTO `resource` VALUES (6, 'D:\\user_file\\13test.html1554881312901', 87, 'test.html', '2019-04-10 15:28:33', '2019-04-10 15:28:33', 13, 13, 1);

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `team_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小组名称',
  `member_count` int(11) NOT NULL COMMENT '成员个数',
  `plate_id` int(11) NOT NULL COMMENT '板块id',
  `leader_id` int(11) NOT NULL COMMENT '组长id',
  `state` tinyint(3) NOT NULL DEFAULT 1 COMMENT '状态：1 有效 2无效',
  `gmt_create` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `user_modify` int(11) DEFAULT NULL COMMENT '修改者id',
  `memo` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小组说明',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '讨论组表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (5, '12312', 3, 19, 1, 1, '2019-04-07 15:49:58', '2019-04-07 15:49:58', 1, '4124');
INSERT INTO `team` VALUES (6, 'test1', 1, 15, 1, 1, '2019-04-07 16:36:37', '2019-04-07 16:36:37', 1, 'test1');
INSERT INTO `team` VALUES (7, 'test2', 1, 13, 1, 1, '2019-04-07 16:37:12', '2019-04-07 16:37:12', 1, 'test2');
INSERT INTO `team` VALUES (8, 'test3', 1, 28, 1, 1, '2019-04-07 16:37:24', '2019-04-07 16:37:24', 1, 'test3');
INSERT INTO `team` VALUES (9, 'test4', 1, 26, 1, 1, '2019-04-07 16:37:39', '2019-04-07 16:37:39', 1, 'test4');

-- ----------------------------
-- Table structure for team_invite
-- ----------------------------
DROP TABLE IF EXISTS `team_invite`;
CREATE TABLE `team_invite`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) NOT NULL DEFAULT 0 COMMENT '小组id',
  `user_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户id',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) NOT NULL COMMENT '修改时间',
  `user_create` int(11) NOT NULL DEFAULT 0 COMMENT '创建人id',
  `user_modify` int(11) NOT NULL DEFAULT 0 COMMENT '修改人id',
  `state` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态：1 有效，0 无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of team_invite
-- ----------------------------
INSERT INTO `team_invite` VALUES (9, 5, 12, '2019-04-07 21:29:47', '2019-04-08 12:19:34', 1, 1, 0);
INSERT INTO `team_invite` VALUES (10, 5, 6, '2019-04-08 14:02:38', '2019-04-08 14:03:10', 0, 0, 0);
INSERT INTO `team_invite` VALUES (11, 5, 6, '2019-04-08 14:02:45', '2019-04-08 14:09:46', 0, 0, 0);
INSERT INTO `team_invite` VALUES (12, 5, 13, '2019-04-09 16:02:14', '2019-04-09 16:52:45', 12, 12, 0);

-- ----------------------------
-- Table structure for tlevel
-- ----------------------------
DROP TABLE IF EXISTS `tlevel`;
CREATE TABLE `tlevel`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tlevel
-- ----------------------------
INSERT INTO `tlevel` VALUES (1, 'ordinary');
INSERT INTO `tlevel` VALUES (2, 'moderator');
INSERT INTO `tlevel` VALUES (3, 'manager');

-- ----------------------------
-- Table structure for total_station_information
-- ----------------------------
DROP TABLE IF EXISTS `total_station_information`;
CREATE TABLE `total_station_information`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通知内容',
  `time` datetime(0) NOT NULL COMMENT '通知时间',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发出消息者名称',
  `gmt_create` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `user_create` int(11) DEFAULT NULL COMMENT '创建用户id',
  `user_modify` int(11) DEFAULT NULL COMMENT '修改用户id',
  `state` tinyint(1) DEFAULT 1 COMMENT '状态，1 有效 2 无效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '全站信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `nickname` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '昵称',
  `psw` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `money` int(10) DEFAULT 0 COMMENT '积分',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '邮箱',
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `level` int(11) NOT NULL DEFAULT 1 COMMENT '用户权限',
  `signa_ture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '个性签名',
  `sex` bit(1) DEFAULT NULL COMMENT '性别： 1 男 0 女',
  `age` tinyint(2) DEFAULT NULL COMMENT '年龄',
  `state` tinyint(3) NOT NULL DEFAULT 1 COMMENT '状态，1 有效，2无效',
  `gmt_create` datetime(0) NOT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `user_modify` int(11) DEFAULT NULL COMMENT '修改者id',
  `ban_reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '封禁理由',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '970009721@qq.com', '123', 1000, '970009721@qq.com', '970009721@qq.com1554450109233.jpg', 3, '11', b'1', 22, 1, '2019-03-04 13:05:45', '2019-04-05 15:41:49', 1, NULL);
INSERT INTO `user` VALUES (3, '308045454@qq.com', 'bde525986a233c8210fcf9223df865a5', 0, '308045454@qq.com', '308045454@qq.com1554450170779.jpg', 2, '冲冲冲冲冲', b'1', 22, 1, '2019-03-12 11:10:27', '2019-04-05 15:42:51', 3, NULL);
INSERT INTO `user` VALUES (4, '123', '123', 0, '123', 'default.jpg', 2, '冲冲冲冲冲', b'1', 2, 1, '2019-03-14 11:27:33', '2019-04-10 13:54:36', 1, '长得好丑');
INSERT INTO `user` VALUES (5, '970009721@qq.co', '9e3480e2ec2c0cfaba01bda6aac6a386', 0, '970009721@qq.co', 'default.jpg', 1, '冲冲冲冲冲', b'1', 2, 1, '2019-03-14 16:22:34', '2019-03-14 16:22:36', NULL, NULL);
INSERT INTO `user` VALUES (6, '小刘', '123', 0, 'test1@qq.com', 'default.jpg', 1, '冲冲冲冲冲', b'1', 2, 1, '2019-03-15 13:18:08', '2019-03-15 13:18:11', NULL, NULL);
INSERT INTO `user` VALUES (7, '小张', '123', 0, 'test2qq.com', 'default.jpg', 1, '冲冲冲冲冲', b'1', 2, 1, '2019-03-15 13:18:31', '2019-03-15 13:18:34', NULL, NULL);
INSERT INTO `user` VALUES (8, '老王', '123', 0, 'test3qq.com', 'default.jpg', 1, '冲冲冲冲冲', b'1', 2, 1, '2019-03-15 13:18:50', '2019-03-15 13:18:53', NULL, NULL);
INSERT INTO `user` VALUES (9, '小李', '123', 0, 'test3qq.com', 'default.jpg', 1, '冲冲冲冲冲', b'1', 2, 1, '2019-03-15 13:19:08', '2019-03-15 13:19:10', NULL, NULL);
INSERT INTO `user` VALUES (10, '小陈', '123', 0, 'test5qq.com', 'default.jpg', 1, '冲冲冲冲冲', b'1', 2, 1, '2019-03-15 13:58:49', '2019-03-15 13:58:49', NULL, NULL);
INSERT INTO `user` VALUES (11, '小杨', '123', 0, 'qqqq.com', 'default.jpg', 1, '冲冲冲冲冲', b'1', 2, 1, '2019-03-15 13:59:15', '2019-03-15 13:59:18', NULL, NULL);
INSERT INTO `user` VALUES (12, '小猪尼若', '123', 0, 'niruo', 'default.jpg', 1, '冲冲冲冲冲', b'1', 2, 1, '2019-03-15 13:59:33', '2019-03-15 13:59:33', NULL, NULL);
INSERT INTO `user` VALUES (13, '小猪佩奇', '123', 200, 'peiqi', 'default.jpg', 1, '冲冲冲冲冲', b'1', 2, 1, '2019-03-15 13:59:48', '2019-03-15 13:59:50', NULL, NULL);
INSERT INTO `user` VALUES (14, '小黄', '123', 0, 'oiqwhe1', 'default.jpg', 1, NULL, b'1', 2, 1, '2019-03-15 14:00:02', '2019-03-15 14:00:03', NULL, NULL);

-- ----------------------------
-- Table structure for user_ban
-- ----------------------------
DROP TABLE IF EXISTS `user_ban`;
CREATE TABLE `user_ban`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ban_user_id` int(11) NOT NULL COMMENT '被封禁用户id',
  `hand_user_id` int(11) NOT NULL COMMENT '操作人id',
  `end_time` datetime(0) NOT NULL COMMENT '结束时间',
  `gmt_create` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `gmt_modify` datetime(0) DEFAULT NULL COMMENT '修改时间',
  `user_modify` int(11) DEFAULT NULL COMMENT '修改者id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户封禁表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_team_rel
-- ----------------------------
DROP TABLE IF EXISTS `user_team_rel`;
CREATE TABLE `user_team_rel`  (
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `team_id` int(11) NOT NULL COMMENT '讨论组id',
  `state` tinyint(1) NOT NULL DEFAULT 1,
  `gmt_create` datetime(0) NOT NULL,
  `gmt_modify` datetime(0) NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户小组关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_team_rel
-- ----------------------------
INSERT INTO `user_team_rel` VALUES (1, 5, 1, '2019-04-07 15:49:58', '2019-04-07 15:49:58');
INSERT INTO `user_team_rel` VALUES (1, 6, 1, '2019-04-07 16:36:37', '2019-04-07 16:36:37');
INSERT INTO `user_team_rel` VALUES (1, 7, 1, '2019-04-07 16:37:12', '2019-04-07 16:37:12');
INSERT INTO `user_team_rel` VALUES (1, 8, 1, '2019-04-07 16:37:24', '2019-04-07 16:37:24');
INSERT INTO `user_team_rel` VALUES (1, 9, 1, '2019-04-07 16:37:39', '2019-04-07 16:37:39');
INSERT INTO `user_team_rel` VALUES (12, 5, 1, '2019-04-08 12:19:35', '2019-04-08 12:19:35');
INSERT INTO `user_team_rel` VALUES (6, 5, 1, '2019-04-08 14:03:10', '2019-04-08 14:03:10');

-- ----------------------------
-- Procedure structure for getinfo
-- ----------------------------
DROP PROCEDURE IF EXISTS `getinfo`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getinfo`(
	OUT minlevel DECIMAL(8,2),
	OUT avglevel DECIMAL(8,2),
	OUT maxlevel DECIMAL(8,2)
)
BEGIN	
	SELECT MIN(`level`) INTO minlevel FROM `user`;
	SELECT MAX(`level`) INTO maxlevel FROM `user`;
	SELECT AVG(`level`) INTO avglevel FROM `user`;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for getinfo2
-- ----------------------------
DROP PROCEDURE IF EXISTS `getinfo2`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getinfo2`()
BEGIN	
	SELECT MIN(`level`),MAX(`level`),AVG(`level`) FROM `user`;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for getuserbyid
-- ----------------------------
DROP PROCEDURE IF EXISTS `getuserbyid`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `getuserbyid`(
	IN userid INT, 
	OUT retuser DECIMAL(8,2)
)
BEGIN 
	SELECT `level` FROM `user` WHERE `user`.id = userid INTO retuser;
END
;;
delimiter ;

-- ----------------------------
-- Procedure structure for productpricing
-- ----------------------------
DROP PROCEDURE IF EXISTS `productpricing`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `productpricing`()
BEGIN
	SELECT AVG(`level`) from `user`;
END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
