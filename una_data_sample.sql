
-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES (8);

-- ----------------------------
-- Records of master_jenis_asuransi
-- ----------------------------
INSERT INTO `master_jenis_asuransi` VALUES ('PA', 'Asuransi Kecelakaan Diri', 'SYSTEM', '2023-10-29 23:30:58', 'NAILUR', '2023-10-31 12:01:01', NULL);

-- ----------------------------
-- Records of master_jenis_kelamin
-- ----------------------------
INSERT INTO `master_jenis_kelamin` VALUES ('L', 'Laki-laki', 'SYSTEM', '2023-10-29 23:05:19', 'NAILUR', '2023-10-31 14:52:51');
INSERT INTO `master_jenis_kelamin` VALUES ('P', 'Perempuan', 'SYSTEM', '2023-10-29 23:06:01', NULL, NULL);

-- ----------------------------
-- Records of master_manfaat_asuransi
-- ----------------------------
INSERT INTO `master_manfaat_asuransi` VALUES (1, 1, 'Santunan Meninggal Dunia Akibat Kecelakaan', 25000000.00, 'SYSTEM', '2023-10-29 23:17:16', NULL, NULL);
INSERT INTO `master_manfaat_asuransi` VALUES (2, 1, 'Santunan Perawatan Rumah Sakit Akibat Kecelakaan', 2500000.00, 'SYSTEM', '2023-10-29 23:18:00', NULL, NULL);
INSERT INTO `master_manfaat_asuransi` VALUES (3, 2, 'Santunan Meninggal Dunia Akibat Kecelakaan', 50000000.00, 'NAILUR', '2023-10-31 17:51:01', NULL, NULL);
INSERT INTO `master_manfaat_asuransi` VALUES (4, 2, 'Santunan Perawatan Rumah Sakit Akibat Kecelakaan', 5000000.00, 'NAILUR', '2023-10-31 17:51:26', NULL, NULL);

-- ----------------------------
-- Records of master_plan_asuransi
-- ----------------------------
INSERT INTO `master_plan_asuransi` VALUES (1, 'PA', 'Plan 25', 279174.00, 'SYSTEM', '2023-10-29 23:15:11', NULL, NULL);
INSERT INTO `master_plan_asuransi` VALUES (2, 'PA', 'Plan 50', 324414.00, 'NAILUR', '2023-10-31 16:00:09', 'NAILUR', '2023-10-31 16:01:41');

-- ----------------------------
-- Records of master_polis
-- ----------------------------
INSERT INTO `master_polis` VALUES (7, 'PA-0001-2023-11', 6, '2023-11-01', '2024-11-01', 1, 'NAILUR', '2023-11-01 00:39:03', NULL, NULL);

-- ----------------------------
-- Records of master_tertanggung
-- ----------------------------
INSERT INTO `master_tertanggung` VALUES (6, 'Muh Nailur Rohman Faiq', 'L', '1999-04-09', 'NAILUR', '2023-10-31 23:53:35', NULL, NULL);
