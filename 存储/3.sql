-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.17 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  8.0.0.4458
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 test 的数据库结构
CREATE DATABASE IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test`;


-- 导出  表 test.dep 结构
CREATE TABLE IF NOT EXISTS `dep` (
  `deptno` int(11) NOT NULL AUTO_INCREMENT,
  `deptname` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- 正在导出表  test.dep 的数据：~22 rows (大约)
/*!40000 ALTER TABLE `dep` DISABLE KEYS */;
INSERT INTO `dep` (`deptno`, `deptname`) VALUES
	(1, '哈尔滨'),
	(2, '哈尔滨'),
	(33, '哈尔滨'),
	(34, '哈尔滨'),
	(35, '哈尔滨'),
	(36, '哈尔滨'),
	(37, '哈尔滨'),
	(38, '哈尔滨'),
	(39, '哈尔滨'),
	(41, '技术部'),
	(42, '媒体部'),
	(43, '媒体部'),
	(44, '媒体部'),
	(45, '媒体部'),
	(46, '保洁部'),
	(47, '媒体部'),
	(48, '云开发部'),
	(49, '云开发部1'),
	(50, '云开发部2'),
	(51, '云开发部3'),
	(52, '云开发部5'),
	(53, '云开发部8'),
	(54, '媒体部'),
	(55, '媒体部'),
	(56, '财务部'),
	(57, '习近平同学'),
	(58, '周永康同学');
/*!40000 ALTER TABLE `dep` ENABLE KEYS */;


-- 导出  表 test.employee 结构
CREATE TABLE IF NOT EXISTS `employee` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `deptno` int(11) DEFAULT NULL,
  `sex` enum('female','male') DEFAULT 'male',
  PRIMARY KEY (`Id`),
  KEY `testfk` (`deptno`),
  CONSTRAINT `testfk` FOREIGN KEY (`deptno`) REFERENCES `dep` (`deptno`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- 正在导出表  test.employee 的数据：~16 rows (大约)
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` (`Id`, `name`, `deptno`, `sex`) VALUES
	(2, '刘', 42, 'male'),
	(4, '张', 42, 'male'),
	(5, '张', 44, 'male'),
	(6, '张', 45, 'male'),
	(7, '姚', 46, 'male'),
	(8, '张', 47, 'male'),
	(9, '张', 48, 'male'),
	(10, '张1', 49, 'male'),
	(11, '张2', 50, 'male'),
	(12, '张3', 51, 'male'),
	(13, '张3', 52, 'male'),
	(14, '张7', 53, 'male'),
	(15, '张', 54, 'male'),
	(16, '董', 55, 'male'),
	(17, '董', 56, 'male');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;


-- 导出  过程 test.query_userbyid 结构
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `query_userbyid`(IN `in_id` int

)
BEGIN
			select *
			from user
			where id=in_id;
		
			
	     
END//
DELIMITER ;


-- 导出  过程 test.query_userbyresult 结构
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `query_userbyresult`(IN `in_id` INT, OUT `out_result` VARCHAR(50))
BEGIN
			select *
			from user
			where id=in_id;
			
		
		set out_result='ok';
	     
END//
DELIMITER ;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
