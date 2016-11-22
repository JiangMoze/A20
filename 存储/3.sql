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
