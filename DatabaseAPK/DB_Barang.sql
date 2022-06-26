-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.18-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for db_barang
CREATE DATABASE IF NOT EXISTS `db_barang` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `db_barang`;

-- Dumping structure for table db_barang.tb_barang
CREATE TABLE IF NOT EXISTS `tb_barang` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kd_barang` varchar(50) DEFAULT '0',
  `nm_barang` varchar(50) DEFAULT '0',
  `keterangan` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table db_barang.tb_barang: ~2 rows (approximately)
/*!40000 ALTER TABLE `tb_barang` DISABLE KEYS */;
INSERT INTO `tb_barang` (`id`, `kd_barang`, `nm_barang`, `keterangan`) VALUES
	(5, 'BAJU', 'barang bekas\n', '0001'),
	(6, 'SEPATU', 'Barang Baru', '0002');
/*!40000 ALTER TABLE `tb_barang` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
