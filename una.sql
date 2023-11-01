/*
 Navicat Premium Data Transfer

 Source Server         : LOCAL_MYSQL
 Source Server Type    : MySQL
 Source Server Version : 100428
 Source Host           : localhost:3306
 Source Schema         : una

 Target Server Type    : MySQL
 Target Server Version : 100428
 File Encoding         : 65001

 Date: 01/11/2023 11:00:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence`  (
  `next_val` bigint NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (8);

-- ----------------------------
-- Table structure for master_jenis_asuransi
-- ----------------------------
DROP TABLE IF EXISTS `master_jenis_asuransi`;
CREATE TABLE `master_jenis_asuransi`  (
  `kode` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `deskripsi` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'SYSTEM',
  `create_at` timestamp NOT NULL DEFAULT current_timestamp,
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_at` timestamp NULL DEFAULT NULL,
  `jenis_kelamin` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`kode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of master_jenis_asuransi
-- ----------------------------
INSERT INTO `master_jenis_asuransi` VALUES ('PA', 'Asuransi Kecelakaan Diri', 'SYSTEM', '2023-10-29 23:30:58', 'NAILUR', '2023-10-31 12:01:01', NULL);

-- ----------------------------
-- Table structure for master_jenis_kelamin
-- ----------------------------
DROP TABLE IF EXISTS `master_jenis_kelamin`;
CREATE TABLE `master_jenis_kelamin`  (
  `kode` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `jenis_kelamin` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'SYSTEM',
  `create_at` timestamp NOT NULL DEFAULT current_timestamp,
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`kode`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of master_jenis_kelamin
-- ----------------------------
INSERT INTO `master_jenis_kelamin` VALUES ('L', 'Laki-laki', 'SYSTEM', '2023-10-29 23:05:19', 'NAILUR', '2023-10-31 14:52:51');
INSERT INTO `master_jenis_kelamin` VALUES ('P', 'Perempuan', 'SYSTEM', '2023-10-29 23:06:01', NULL, NULL);

-- ----------------------------
-- Table structure for master_manfaat_asuransi
-- ----------------------------
DROP TABLE IF EXISTS `master_manfaat_asuransi`;
CREATE TABLE `master_manfaat_asuransi`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `plan_asuransi_id` int NOT NULL,
  `manfaat` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nominal` double(11, 2) NOT NULL,
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'SYSTEM',
  `create_at` timestamp NOT NULL DEFAULT current_timestamp,
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_plan_asuransi`(`plan_asuransi_id`) USING BTREE,
  CONSTRAINT `fk_plan_asuransi` FOREIGN KEY (`plan_asuransi_id`) REFERENCES `master_plan_asuransi` (`id`) ON DELETE RESTRICT ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of master_manfaat_asuransi
-- ----------------------------
INSERT INTO `master_manfaat_asuransi` VALUES (1, 1, 'Santunan Meninggal Dunia Akibat Kecelakaan', 25000000.00, 'SYSTEM', '2023-10-29 23:17:16', NULL, NULL);
INSERT INTO `master_manfaat_asuransi` VALUES (2, 1, 'Santunan Perawatan Rumah Sakit Akibat Kecelakaan', 2500000.00, 'SYSTEM', '2023-10-29 23:18:00', NULL, NULL);
INSERT INTO `master_manfaat_asuransi` VALUES (3, 2, 'Santunan Meninggal Dunia Akibat Kecelakaan', 50000000.00, 'NAILUR', '2023-10-31 17:51:01', NULL, NULL);
INSERT INTO `master_manfaat_asuransi` VALUES (4, 2, 'Santunan Perawatan Rumah Sakit Akibat Kecelakaan', 5000000.00, 'NAILUR', '2023-10-31 17:51:26', NULL, NULL);

-- ----------------------------
-- Table structure for master_plan_asuransi
-- ----------------------------
DROP TABLE IF EXISTS `master_plan_asuransi`;
CREATE TABLE `master_plan_asuransi`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `jenis_asuransi_kode` varchar(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `plan_asuransi` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `premi` double(11, 2) NOT NULL,
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'SYSTEM',
  `create_at` timestamp NOT NULL DEFAULT current_timestamp,
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pk_jenis_asuransi`(`jenis_asuransi_kode`) USING BTREE,
  CONSTRAINT `pk_jenis_asuransi` FOREIGN KEY (`jenis_asuransi_kode`) REFERENCES `master_jenis_asuransi` (`kode`) ON DELETE RESTRICT ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of master_plan_asuransi
-- ----------------------------
INSERT INTO `master_plan_asuransi` VALUES (1, 'PA', 'Plan 25', 279174.00, 'SYSTEM', '2023-10-29 23:15:11', NULL, NULL);
INSERT INTO `master_plan_asuransi` VALUES (2, 'PA', 'Plan 50', 324414.00, 'NAILUR', '2023-10-31 16:00:09', 'NAILUR', '2023-10-31 16:01:41');

-- ----------------------------
-- Table structure for master_polis
-- ----------------------------
DROP TABLE IF EXISTS `master_polis`;
CREATE TABLE `master_polis`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `nomor_polis` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `tertanggung_id` int NOT NULL,
  `awal_periode_asuransi` date NOT NULL,
  `akhir_periode_asuransi` date NOT NULL,
  `plan_asuransi_id` int NOT NULL,
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'SYSTEM',
  `create_at` timestamp NOT NULL DEFAULT current_timestamp,
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_tertanggung`(`tertanggung_id`) USING BTREE,
  INDEX `FK5a0ab3irwielu0tkhnbyi8d36`(`plan_asuransi_id`) USING BTREE,
  CONSTRAINT `FK5a0ab3irwielu0tkhnbyi8d36` FOREIGN KEY (`plan_asuransi_id`) REFERENCES `master_plan_asuransi` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_tertanggung` FOREIGN KEY (`tertanggung_id`) REFERENCES `master_tertanggung` (`id`) ON DELETE RESTRICT ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of master_polis
-- ----------------------------
INSERT INTO `master_polis` VALUES (7, 'PA-0001-2023-11', 6, '2023-11-01', '2024-11-01', 1, 'NAILUR', '2023-11-01 00:39:03', NULL, NULL);

-- ----------------------------
-- Table structure for master_tertanggung
-- ----------------------------
DROP TABLE IF EXISTS `master_tertanggung`;
CREATE TABLE `master_tertanggung`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `nama_lengkap` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `kode_jenis_kelamin` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tanggal_lahir` date NOT NULL,
  `create_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'SYSTEM',
  `create_at` timestamp NOT NULL DEFAULT current_timestamp,
  `update_by` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK7gj55ev1bovejdusf1gqr9o3p`(`kode_jenis_kelamin`) USING BTREE,
  CONSTRAINT `fk_jenis_kelamin` FOREIGN KEY (`kode_jenis_kelamin`) REFERENCES `master_jenis_kelamin` (`kode`) ON DELETE RESTRICT ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of master_tertanggung
-- ----------------------------
INSERT INTO `master_tertanggung` VALUES (6, 'Muh Nailur Rohman Faiq', 'L', '1999-04-09', 'NAILUR', '2023-10-31 23:53:35', NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
