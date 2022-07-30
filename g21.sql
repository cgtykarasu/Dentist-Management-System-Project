-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2021 at 09:26 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `g21`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointment`
--

CREATE TABLE `appointment` (
  `AID` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Time` time NOT NULL,
  `PID` int(11) NOT NULL,
  `DID` int(11) NOT NULL,
  `APID` int(11) DEFAULT NULL,
  `TPID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointment`
--

INSERT INTO `appointment` (`AID`, `Date`, `Time`, `PID`, `DID`, `APID`, `TPID`) VALUES
(1, '2021-05-17', '09:30:00', 1, 1, 1, 2),
(2, '2021-05-17', '10:00:00', 2, 2, 2, 2),
(3, '2021-05-17', '10:00:00', 3, 3, 3, 1),
(4, '2021-05-17', '11:00:00', 4, 4, 4, 2),
(5, '2021-05-17', '11:15:00', 5, 5, 5, 3),
(6, '2021-05-17', '11:30:00', 6, 6, 6, 2),
(7, '2021-05-17', '15:00:00', 7, 7, 7, 1),
(8, '2021-05-17', '15:15:00', 8, 8, 8, 2),
(9, '2021-05-17', '16:00:00', 9, 9, 9, 3),
(10, '2021-05-17', '14:45:00', 10, 10, 10, 2),
(11, '2021-05-18', '10:00:00', 1, 1, 11, 2),
(12, '2021-05-18', '10:00:00', 2, 2, 12, 1),
(13, '2021-05-18', '10:30:00', 3, 3, 13, 4),
(14, '2021-05-18', '11:10:00', 4, 4, 14, 2),
(15, '2021-05-18', '11:00:00', 5, 5, 15, 1),
(16, '2021-05-18', '10:15:00', 6, 6, 16, 2),
(17, '2021-05-18', '14:20:00', 7, 7, 17, 2),
(18, '2021-05-18', '14:30:00', 8, 8, 18, 1),
(19, '2021-05-18', '14:00:00', 9, 9, 19, 3),
(20, '2021-05-18', '10:00:00', 10, 10, 20, 2),
(21, '2021-05-19', '09:00:00', 1, 1, 21, 2),
(22, '2021-05-19', '09:30:00', 2, 2, 22, 1),
(23, '2021-05-19', '09:45:00', 3, 3, 23, 4),
(24, '2021-05-19', '10:00:00', 4, 4, 24, 3),
(25, '2021-05-19', '10:15:00', 5, 5, 25, 4),
(26, '2021-05-19', '10:30:00', 6, 6, 26, 2),
(27, '2021-05-19', '10:30:00', 7, 7, 27, 3),
(28, '2021-05-19', '11:00:00', 8, 8, 28, 1),
(29, '2021-05-19', '14:30:00', 9, 9, 29, 2),
(30, '2021-05-19', '15:00:00', 10, 10, 30, 2),
(32, '2021-06-06', '10:00:00', 10, 2, 38, 2),
(33, '2021-06-15', '11:00:00', 4, 24, 42, 4),
(41, '2021-06-13', '20:00:00', 15, 10, 50, 2),
(42, '2021-06-14', '14:45:00', 1, 3, 51, 2);

-- --------------------------------------------------------

--
-- Table structure for table `appointmentprocedure`
--

CREATE TABLE `appointmentprocedure` (
  `APID` int(11) NOT NULL,
  `AID` int(11) DEFAULT NULL,
  `PID` int(11) NOT NULL,
  `TPID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointmentprocedure`
--

INSERT INTO `appointmentprocedure` (`APID`, `AID`, `PID`, `TPID`) VALUES
(1, 1, 1, 2),
(2, 2, 2, 2),
(3, 3, 3, 1),
(4, 4, 4, 2),
(5, 5, 5, 3),
(6, 6, 6, 2),
(7, 7, 7, 1),
(8, 8, 8, 2),
(9, 9, 9, 3),
(10, 10, 10, 2),
(11, 11, 1, 2),
(12, 12, 2, 1),
(13, 13, 3, 4),
(14, 14, 4, 2),
(15, 15, 5, 1),
(16, 16, 6, 2),
(17, 17, 7, 2),
(18, 18, 8, 1),
(19, 19, 9, 3),
(20, 20, 10, 2),
(21, 21, 1, 2),
(22, 22, 2, 1),
(23, 23, 3, 4),
(24, 24, 4, 3),
(25, 25, 5, 4),
(26, 26, 6, 2),
(27, 27, 7, 3),
(28, 28, 8, 1),
(29, 29, 9, 2),
(30, 30, 10, 2),
(31, NULL, 10, 1),
(32, NULL, 10, 1),
(33, NULL, 10, 1),
(34, NULL, 10, 4),
(35, NULL, 10, 3),
(36, NULL, 9, 4),
(37, NULL, 8, 2),
(38, NULL, 10, 4),
(39, NULL, 10, 3),
(40, NULL, 10, 4),
(41, NULL, 5, 1),
(42, NULL, 4, 4),
(43, NULL, 4, 4),
(44, NULL, 7, 3),
(45, NULL, 5, 4),
(46, NULL, 8, 3),
(47, NULL, 5, 1),
(48, NULL, 10, 4),
(49, NULL, 10, 1),
(50, 41, 15, 2),
(51, 42, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `dentist`
--

CREATE TABLE `dentist` (
  `DID` int(11) NOT NULL,
  `DFirstName` varchar(50) NOT NULL,
  `DLastName` varchar(50) NOT NULL,
  `YearOfService` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `dentist`
--

INSERT INTO `dentist` (`DID`, `DFirstName`, `DLastName`, `YearOfService`) VALUES
(1, 'Ahmet', 'SARI', 10),
(2, 'Mehmet', 'KAYNAK', 7),
(3, 'Ayşe', 'TEK', 3),
(4, 'Hasan', 'ÇELEBİ', 1),
(5, 'Hüseyin', 'ARAT', 9),
(6, 'Emel', 'KARATAŞ', 4),
(7, 'Fatma', 'TERZİ', 2),
(8, 'Ali', 'ÇALIŞKAN', 1),
(9, 'Burak', 'ÖZTÜRK', 6),
(10, 'Merve', 'SANCAK', 4),
(22, 'Çağla', 'YEŞİL', 2),
(24, 'Yunus', 'EMRE', 5),
(30, 'Çağatay', 'KARASU', 2);

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `PID` int(11) NOT NULL,
  `PFirstName` varchar(50) NOT NULL,
  `PLastName` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `ContactNumber` varchar(12) NOT NULL,
  `EmailAddress` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`PID`, `PFirstName`, `PLastName`, `Address`, `ContactNumber`, `EmailAddress`) VALUES
(1, 'Hasta01', 'HASTA01', 'XXX', '05301231212', 'xxx@xxx.com'),
(2, 'Hasta02', 'HASTA02', 'YYY', '05311231212', 'yyy@yyy.com'),
(3, 'Hasta03', 'HASTA03', 'ZZZ', '05321231212', 'zzz@zzz.com'),
(4, 'Hasta04', 'HASTA04', 'TTT', '05331231212', 'ttt@ttt.com'),
(5, 'Hasta05', 'HASTA05', 'QQQ', '05341231212', 'qqq@qqq.com'),
(6, 'Hasta06', 'HASTA06', 'ZYZ', '05351231212', 'zyz@zyz.com'),
(7, 'Hasta07', 'HASTA07', 'YYT', '05361231212', 'yyt@yyt.com'),
(8, 'Hasta08', 'HASTA08', 'ABC', '05371231212', 'abc@abc.com'),
(9, 'Hasta09', 'HASTA09', 'DDD', '05381231212', 'ddd@ddd.com'),
(10, 'Hasta10', 'HASTA10', 'XYZ', '05391231212', 'xyz@xyz.com'),
(15, 'Test02', 'Hasta02', 'TestAdres02', '05552223344', 'test2@hasta.com');

-- --------------------------------------------------------

--
-- Table structure for table `treatmentprocedure`
--

CREATE TABLE `treatmentprocedure` (
  `TPID` int(11) NOT NULL,
  `Description` varchar(100) NOT NULL,
  `Cost` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `treatmentprocedure`
--

INSERT INTO `treatmentprocedure` (`TPID`, `Description`, `Cost`) VALUES
(1, 'Diş çekimi', 65),
(2, 'Kanal tedavisi', 120.5),
(3, 'Diş kaplama', 550),
(4, 'Implant', 2250.75),
(12, 'Diş Temizliği', 60);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`AID`),
  ADD KEY `APID` (`APID`),
  ADD KEY `DID` (`DID`),
  ADD KEY `PID` (`PID`),
  ADD KEY `TPID` (`TPID`);

--
-- Indexes for table `appointmentprocedure`
--
ALTER TABLE `appointmentprocedure`
  ADD PRIMARY KEY (`APID`),
  ADD KEY `AID` (`AID`),
  ADD KEY `PID` (`PID`),
  ADD KEY `TPID` (`TPID`);

--
-- Indexes for table `dentist`
--
ALTER TABLE `dentist`
  ADD PRIMARY KEY (`DID`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`PID`);

--
-- Indexes for table `treatmentprocedure`
--
ALTER TABLE `treatmentprocedure`
  ADD PRIMARY KEY (`TPID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `appointment`
--
ALTER TABLE `appointment`
  MODIFY `AID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;

--
-- AUTO_INCREMENT for table `appointmentprocedure`
--
ALTER TABLE `appointmentprocedure`
  MODIFY `APID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;

--
-- AUTO_INCREMENT for table `dentist`
--
ALTER TABLE `dentist`
  MODIFY `DID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `PID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `treatmentprocedure`
--
ALTER TABLE `treatmentprocedure`
  MODIFY `TPID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `appointment`
--
ALTER TABLE `appointment`
  ADD CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`APID`) REFERENCES `appointmentprocedure` (`APID`),
  ADD CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`DID`) REFERENCES `dentist` (`DID`),
  ADD CONSTRAINT `appointment_ibfk_3` FOREIGN KEY (`PID`) REFERENCES `patient` (`PID`),
  ADD CONSTRAINT `appointment_ibfk_4` FOREIGN KEY (`TPID`) REFERENCES `treatmentprocedure` (`TPID`);

--
-- Constraints for table `appointmentprocedure`
--
ALTER TABLE `appointmentprocedure`
  ADD CONSTRAINT `appointmentprocedure_ibfk_1` FOREIGN KEY (`AID`) REFERENCES `appointment` (`AID`),
  ADD CONSTRAINT `appointmentprocedure_ibfk_2` FOREIGN KEY (`PID`) REFERENCES `patient` (`PID`),
  ADD CONSTRAINT `appointmentprocedure_ibfk_3` FOREIGN KEY (`TPID`) REFERENCES `treatmentprocedure` (`TPID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
