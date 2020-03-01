-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 01, 2020 at 07:39 PM
-- Server version: 10.3.20-MariaDB-0ubuntu0.19.04.1
-- PHP Version: 7.3.14-1+ubuntu19.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `prakrin`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_daftar`
--

CREATE TABLE `tb_daftar` (
  `nis` int(4) NOT NULL,
  `nama` varchar(100) DEFAULT NULL,
  `jkl` enum('Laki-Laki','Perempuan') DEFAULT NULL,
  `jurusan` enum('RPL','AKL','BDP') DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_daftar`
--

INSERT INTO `tb_daftar` (`nis`, `nama`, `jkl`, `jurusan`, `alamat`, `email`, `password`, `username`) VALUES
(1234, 'gs', 'Laki-Laki', 'AKL', 'gs', 'gs', 'gsgs', 'gsg'),
(3558, 'evsvs', 'Perempuan', 'AKL', 'gsgs', 'gsgs', 'gssg', 'gsgsg'),
(4242, 'Eri Setiawan', 'Laki-Laki', 'RPL', 'ts', 'te', 'te', 'esf'),
(9940, ' eri', 'Laki-Laki', 'RPL', 'Baluk', 'er@gmail.om', 'tes', 'eri04'),
(9955, 'ika ari', 'Perempuan', 'RPL', 'baluk', 'errea', 'tes', 'ika02'),
(9959, 'Genji', 'Perempuan', 'AKL', 'Pengragoa', 'eri@gmail.com', 'tes', 'genji11');

-- --------------------------------------------------------

--
-- Table structure for table `tb_penerimaan`
--

CREATE TABLE `tb_penerimaan` (
  `nama` varchar(100) NOT NULL,
  `nis` int(4) NOT NULL,
  `jurusan` enum('RPL','AKL','BDP') NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `tempat` varchar(100) NOT NULL,
  `alamat_pkl` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_penerimaan`
--

INSERT INTO `tb_penerimaan` (`nama`, `nis`, `jurusan`, `alamat`, `tempat`, `alamat_pkl`) VALUES
('ika ari', 9955, 'RPL', 'baluk', 'Kantor Kementrian Agama Kab. Jembrana', 'Jalan Hasanudin No.1, Jembrana'),
('Genji', 9959, 'RPL', 'Pengragoa', 'Kantor Kementrian Agama Kab. Jembrana', 'Jalan Hasanudin No.1, Jembrana');

-- --------------------------------------------------------

--
-- Table structure for table `tb_tempat`
--

CREATE TABLE `tb_tempat` (
  `kode_tempat` varchar(4) NOT NULL,
  `nama_tempat` varchar(100) DEFAULT NULL,
  `alamat` varchar(100) DEFAULT NULL,
  `jurusan` enum('RPL','AKL','BDP') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_tempat`
--

INSERT INTO `tb_tempat` (`kode_tempat`, `nama_tempat`, `alamat`, `jurusan`) VALUES
('P001', 'Kantor Pengadilan Negeri Negara', 'Jalan Mayor Sugianyar, Jembrana', 'RPL'),
('P002', 'Kantor Badan Pertanahan Nasional Kab. Jembrana', 'Jalan Mayor Sugianyar, Jembrana', 'RPL'),
('P003', 'Kantor Kementrian Agama Kab. Jembrana', 'Jalan Hasanudin No.1, Jembrana', 'RPL'),
('P004', 'Kantor Pengadilan Agama', 'Jalan Ngurah Rai, Jembrana', 'RPL'),
('P005', 'Badan Statistik Kabupaten Jembrana', 'Jalan Mayor Sugianyar, Jembrana', 'RPL'),
('P006', 'Adi Computer', 'Jalan Pulau Singkep LC Dauhwaru, Jembrana', 'RPL'),
('P007', 'Mitra Mandiri Computer', 'Jalan Danau Buyan, Lelateng, Negara', 'RPL'),
('P008', 'Prima Computer', 'Jalan Ratna, BB Agung, Negara', 'RPL');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_daftar`
--
ALTER TABLE `tb_daftar`
  ADD PRIMARY KEY (`nis`);

--
-- Indexes for table `tb_penerimaan`
--
ALTER TABLE `tb_penerimaan`
  ADD PRIMARY KEY (`nis`);

--
-- Indexes for table `tb_tempat`
--
ALTER TABLE `tb_tempat`
  ADD PRIMARY KEY (`kode_tempat`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
