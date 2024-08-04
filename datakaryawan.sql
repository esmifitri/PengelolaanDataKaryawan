-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 04, 2024 at 01:17 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `datakaryawan`
--

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id` varchar(50) NOT NULL,
  `nama` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `pendidikanTerakhir` varchar(20) NOT NULL,
  `createdBy` varchar(50) NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id`, `nama`, `username`, `alamat`, `pendidikanTerakhir`, `createdBy`, `createdAt`) VALUES
('1', 'Nuri', 'esmi', 'Kebumen', 'S1', 'SYSTEM', '2024-08-03 14:38:43'),
('2', 'Sani', 'staff', 'Jakarta', 'S2', 'SYSTEM', '2024-08-03 14:39:53'),
('4a362f07-f10c-467b-bd8a-bd49498ea7cb', 'Mita', 'koko', 'Bandung', 'SMA', 'SYSTEM', '2024-08-04 01:14:23'),
('be4f7c4d-6348-44df-8e6c-b2405489d14b', 'sarah', 'sarahahana', 'Jakarta', 'S1', 'SYSTEM', '2024-08-04 08:14:25');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(50) NOT NULL,
  `createdAt` timestamp NOT NULL DEFAULT current_timestamp(),
  `createdBy` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `email`, `createdAt`, `createdBy`) VALUES
('10', 'esmi', 'f0ee41a2eae99e1b0b982200139b64cb', 'null', '0000-00-00 00:00:00', ''),
('2', 'staff', '5f4dcc3b5aa765d61d8327deb882cf99', 'staff@g.com', '2024-08-02 07:28:26', 'SYSTEM'),
('b2b728e0-a679-4221-b596-d15a7fa6d479', 'john_doe', '5f4dcc3b5aa765d61d8327deb882cf99', 'john.doe@example.com', '2024-08-03 01:54:50', 'SYSTEM');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
