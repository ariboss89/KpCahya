# Host: localhost  (Version: 5.5.5-10.4.17-MariaDB)
# Date: 2021-07-30 21:58:39
# Generator: MySQL-Front 5.3  (Build 4.81)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "dt_barangkeluar"
#

DROP TABLE IF EXISTS `dt_barangkeluar`;
CREATE TABLE `dt_barangkeluar` (
  `id_detail` int(11) NOT NULL AUTO_INCREMENT,
  `id_keluar` varchar(11) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `jumlah` varchar(255) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  PRIMARY KEY (`id_detail`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

#
# Data for table "dt_barangkeluar"
#

/*!40000 ALTER TABLE `dt_barangkeluar` DISABLE KEYS */;
INSERT INTO `dt_barangkeluar` VALUES (15,'K0001','Kabel Jaringan','10','2021-07-30'),(16,'K0002','Kabel Jaringan','5','2021-07-29');
/*!40000 ALTER TABLE `dt_barangkeluar` ENABLE KEYS */;

#
# Structure for table "tb_barang"
#

DROP TABLE IF EXISTS `tb_barang`;
CREATE TABLE `tb_barang` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nama_barang` varchar(255) DEFAULT NULL,
  `kategori` varchar(255) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_barang"
#

/*!40000 ALTER TABLE `tb_barang` DISABLE KEYS */;
INSERT INTO `tb_barang` VALUES (1,'Kabel Jaringan DXC','KABEL',35);
/*!40000 ALTER TABLE `tb_barang` ENABLE KEYS */;

#
# Structure for table "tb_barangkeluar"
#

DROP TABLE IF EXISTS `tb_barangkeluar`;
CREATE TABLE `tb_barangkeluar` (
  `Id` varchar(11) NOT NULL DEFAULT '',
  `tanggal` date DEFAULT NULL,
  `total` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_barangkeluar"
#

INSERT INTO `tb_barangkeluar` VALUES ('K0001','2021-07-30','10'),('K0002','2021-07-29','5');

#
# Structure for table "tb_barangmasuk"
#

DROP TABLE IF EXISTS `tb_barangmasuk`;
CREATE TABLE `tb_barangmasuk` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nama` varchar(255) DEFAULT NULL,
  `kategori` varchar(255) DEFAULT NULL,
  `jumlah` varchar(255) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_barangmasuk"
#

/*!40000 ALTER TABLE `tb_barangmasuk` DISABLE KEYS */;
INSERT INTO `tb_barangmasuk` VALUES (1,'KABEL','Kabel Jaringan','20','2021-07-30'),(3,'KABEL','Kabel Jaringan','30','2021-07-30');
/*!40000 ALTER TABLE `tb_barangmasuk` ENABLE KEYS */;

#
# Structure for table "tb_pengguna"
#

DROP TABLE IF EXISTS `tb_pengguna`;
CREATE TABLE `tb_pengguna` (
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "tb_pengguna"
#

INSERT INTO `tb_pengguna` VALUES ('admin','123456','admin');
