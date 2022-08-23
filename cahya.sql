-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.24-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for cahya
CREATE DATABASE IF NOT EXISTS `cahya` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `cahya`;

-- Dumping structure for table cahya.dt_barangkeluar
CREATE TABLE IF NOT EXISTS `dt_barangkeluar` (
  `id_detail` int(11) NOT NULL AUTO_INCREMENT,
  `id_keluar` varchar(11) DEFAULT NULL,
  `id_kabel` varchar(11) DEFAULT NULL,
  `nama_kabel` varchar(255) DEFAULT NULL,
  `type_kabel` varchar(255) DEFAULT NULL,
  `jumlah_core` varchar(255) DEFAULT NULL,
  `nomor_rak` varchar(255) DEFAULT NULL,
  `sisa_kabel` varchar(255) DEFAULT NULL,
  `jumlah` int(20) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `tahun` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_detail`)
) ENGINE=MyISAM AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table cahya.dt_barangkeluar: 3 rows
/*!40000 ALTER TABLE `dt_barangkeluar` DISABLE KEYS */;
REPLACE INTO `dt_barangkeluar` (`id_detail`, `id_keluar`, `id_kabel`, `nama_kabel`, `type_kabel`, `jumlah_core`, `nomor_rak`, `sisa_kabel`, `jumlah`, `tanggal`, `tahun`) VALUES
	(17, 'K0001', '1', 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 A', '4700', 100, '2022-08-30', '2007'),
	(18, 'K0001', '1', 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 A', '3700', 1000, '2022-08-30', '2010'),
	(19, 'K0002', '1', 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 A', '100', 2000, '2022-08-22', '2010'),
	(20, 'K0003', '1', 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 A', '2000', 100, '2022-08-23', '2022'),
	(21, 'K0003', '3', 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 B', '1900', 100, '2022-08-23', '2022'),
	(22, 'K0003', '6', 'Kabel Jaringan D', 'G-655', '48 Core', '2 A', '19990', 10, '2022-08-23', '2022');
/*!40000 ALTER TABLE `dt_barangkeluar` ENABLE KEYS */;

-- Dumping structure for table cahya.tb_barang
CREATE TABLE IF NOT EXISTS `tb_barang` (
  `id_kabel` int(11) NOT NULL AUTO_INCREMENT,
  `nama_kabel` varchar(255) DEFAULT NULL,
  `type_kabel` varchar(255) DEFAULT NULL,
  `jumlah_core` varchar(255) DEFAULT NULL,
  `nomor_rak` varchar(255) DEFAULT NULL,
  `jumlah` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_kabel`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table cahya.tb_barang: 8 rows
/*!40000 ALTER TABLE `tb_barang` DISABLE KEYS */;
REPLACE INTO `tb_barang` (`id_kabel`, `nama_kabel`, `type_kabel`, `jumlah_core`, `nomor_rak`, `jumlah`) VALUES
	(1, 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 A', 4000),
	(3, 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 B', 1900),
	(4, 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 C', 3100),
	(5, 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 D', 0),
	(6, 'Kabel Jaringan D', 'G-655', '48 Core', '2 A', 19990),
	(7, 'Kabel Jaringan D', 'G-655', '48 Core', '2 B', 20000),
	(8, 'Kabel Jaringan D', 'G-655', '48 Core', '2 C', 20000),
	(9, 'Kabel Jaringan D', 'G-655', '48 Core', '2 D', 20000);
/*!40000 ALTER TABLE `tb_barang` ENABLE KEYS */;

-- Dumping structure for table cahya.tb_barangkeluar
CREATE TABLE IF NOT EXISTS `tb_barangkeluar` (
  `Id` varchar(11) NOT NULL DEFAULT '',
  `tanggal` date DEFAULT NULL,
  `total` varchar(11) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `username` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table cahya.tb_barangkeluar: ~2 rows (approximately)
/*!40000 ALTER TABLE `tb_barangkeluar` DISABLE KEYS */;
REPLACE INTO `tb_barangkeluar` (`Id`, `tanggal`, `total`, `status`, `username`) VALUES
	('K0001', '2022-08-30', '1100', 'Selesai', 'cahya123'),
	('K0002', '2022-08-22', '2000', 'Batal', 'cahya123'),
	('K0003', '2022-08-23', '210', 'Selesai', 'cahya123');
/*!40000 ALTER TABLE `tb_barangkeluar` ENABLE KEYS */;

-- Dumping structure for table cahya.tb_barangmasuk
CREATE TABLE IF NOT EXISTS `tb_barangmasuk` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `id_kabel` int(11) NOT NULL DEFAULT 0,
  `nama_kabel` varchar(255) DEFAULT NULL,
  `type_kabel` varchar(255) DEFAULT NULL,
  `jumlah_core` varchar(255) DEFAULT NULL,
  `nomor_rak` varchar(255) DEFAULT NULL,
  `jumlah` int(20) DEFAULT NULL,
  `tanggal` date DEFAULT NULL,
  `tahun` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table cahya.tb_barangmasuk: 4 rows
/*!40000 ALTER TABLE `tb_barangmasuk` DISABLE KEYS */;
REPLACE INTO `tb_barangmasuk` (`Id`, `id_kabel`, `nama_kabel`, `type_kabel`, `jumlah_core`, `nomor_rak`, `jumlah`, `tanggal`, `tahun`) VALUES
	(5, 3, 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 B', 1000, '2022-08-20', '2022'),
	(6, 1, 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 A', 2000, '2022-08-20', '2022'),
	(7, 1, 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 A', 3000, '2022-08-20', '2022'),
	(8, 6, 'Kabel Jaringan D', 'G-655', '48 Core', '2 A', 20000, '2022-08-21', '2022'),
	(9, 4, 'Kabel Jaringan DXC', 'G-652', '24 Core', '1 C', 100, '2022-08-23', '2022');
/*!40000 ALTER TABLE `tb_barangmasuk` ENABLE KEYS */;

-- Dumping structure for table cahya.tb_pengguna
CREATE TABLE IF NOT EXISTS `tb_pengguna` (
  `username` varchar(50) NOT NULL DEFAULT '',
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `nama` varchar(150) DEFAULT NULL,
  `kontak` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table cahya.tb_pengguna: ~2 rows (approximately)
/*!40000 ALTER TABLE `tb_pengguna` DISABLE KEYS */;
REPLACE INTO `tb_pengguna` (`username`, `password`, `role`, `nama`, `kontak`) VALUES
	('admin', '123456', 'Superadmin', 'admin kantor', '111111'),
	('cahya123', '123456', 'Admin', 'Cahya Krida Pratama', '0819201011');
/*!40000 ALTER TABLE `tb_pengguna` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
