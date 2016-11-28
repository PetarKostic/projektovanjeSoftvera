-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 08, 2016 at 01:52 PM
-- Server version: 5.7.9
-- PHP Version: 7.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `vezbanje`
--

-- --------------------------------------------------------

--
-- Table structure for table `dobavljac`
--

DROP TABLE IF EXISTS `dobavljac`;
CREATE TABLE IF NOT EXISTS `dobavljac` (
  `dobavljacID` int(11) NOT NULL,
  `d_naziv` varchar(25) NOT NULL,
  `pib` int(11) NOT NULL,
  PRIMARY KEY (`dobavljacID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dobavljac`
--

INSERT INTO `dobavljac` (`dobavljacID`, `d_naziv`, `pib`) VALUES
(1, 'digiMax', 12345),
(2, 'digiMax', 2425);

-- --------------------------------------------------------

--
-- Table structure for table `proizvod`
--

DROP TABLE IF EXISTS `proizvod`;
CREATE TABLE IF NOT EXISTS `proizvod` (
  `proizvodID` int(11) NOT NULL,
  `cena` double NOT NULL,
  `naziv` varchar(25) NOT NULL,
  `kolicina` int(11) NOT NULL,
  `opis` text NOT NULL,
  `dobavljacID` int(11) NOT NULL,
  PRIMARY KEY (`proizvodID`),
  KEY `dobavljacID` (`dobavljacID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proizvod`
--

INSERT INTO `proizvod` (`proizvodID`, `cena`, `naziv`, `kolicina`, `opis`, `dobavljacID`) VALUES
(2, 345, 'Canon fix7', 5, 'Canon aparat', 2);

-- --------------------------------------------------------

--
-- Table structure for table `racun`
--

DROP TABLE IF EXISTS `racun`;
CREATE TABLE IF NOT EXISTS `racun` (
  `racunID` int(11) NOT NULL,
  `datum` date NOT NULL,
  `iznos` double NOT NULL,
  `radnikID` int(11) NOT NULL,
  `storniran` tinyint(1) NOT NULL,
  PRIMARY KEY (`racunID`),
  KEY `radnikID` (`radnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `racun`
--

INSERT INTO `racun` (`racunID`, `datum`, `iznos`, `radnikID`, `storniran`) VALUES
(1, '2016-09-05', 235, 1, 1),
(2, '2012-05-21', 690, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `radnik`
--

DROP TABLE IF EXISTS `radnik`;
CREATE TABLE IF NOT EXISTS `radnik` (
  `radnikID` int(11) NOT NULL,
  `korisnickoIme` varchar(25) NOT NULL,
  `ime` varchar(25) NOT NULL,
  `sifra` varchar(25) NOT NULL,
  `jmbg` int(11) NOT NULL,
  PRIMARY KEY (`radnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `radnik`
--

INSERT INTO `radnik` (`radnikID`, `korisnickoIme`, `ime`, `sifra`, `jmbg`) VALUES
(1, 'pera', 'Petar', '123', 1041989);

-- --------------------------------------------------------

--
-- Table structure for table `stavkaracuna`
--

DROP TABLE IF EXISTS `stavkaracuna`;
CREATE TABLE IF NOT EXISTS `stavkaracuna` (
  `racunID` int(11) NOT NULL,
  `rbStavke` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL,
  `proizvodID` int(11) NOT NULL,
  PRIMARY KEY (`racunID`,`rbStavke`),
  KEY `proizvodID` (`proizvodID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stavkaracuna`
--

INSERT INTO `stavkaracuna` (`racunID`, `rbStavke`, `kolicina`, `proizvodID`) VALUES
(2, 1, 2, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `proizvod`
--
ALTER TABLE `proizvod`
  ADD CONSTRAINT `proizvod_ibfk_1` FOREIGN KEY (`dobavljacID`) REFERENCES `dobavljac` (`dobavljacID`) ON UPDATE CASCADE;

--
-- Constraints for table `racun`
--
ALTER TABLE `racun`
  ADD CONSTRAINT `racun_ibfk_1` FOREIGN KEY (`radnikID`) REFERENCES `radnik` (`radnikID`) ON DELETE NO ACTION;

--
-- Constraints for table `stavkaracuna`
--
ALTER TABLE `stavkaracuna`
  ADD CONSTRAINT `stavkaracuna_ibfk_1` FOREIGN KEY (`racunID`) REFERENCES `racun` (`racunID`) ON DELETE NO ACTION,
  ADD CONSTRAINT `stavkaracuna_ibfk_2` FOREIGN KEY (`proizvodID`) REFERENCES `proizvod` (`proizvodID`) ON DELETE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
