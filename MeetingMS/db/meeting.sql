-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: meeting
-- ------------------------------------------------------
-- Server version	5.7.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `counter`
--

DROP TABLE IF EXISTS `counter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counter` (
  `visitcount` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counter`
--

LOCK TABLES `counter` WRITE;
/*!40000 ALTER TABLE `counter` DISABLE KEYS */;
/*!40000 ALTER TABLE `counter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `departmentid` int(11) NOT NULL AUTO_INCREMENT,
  `departmentname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`departmentid`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (13,'技术部'),(14,'财务部'),(15,'市场部'),(16,'商务部'),(17,'销售部'),(20,'生产部');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `employeeid` int(11) NOT NULL AUTO_INCREMENT,
  `employeename` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `departmentid` int(11) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`employeeid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'张兆轩','zzx','131','123','1',13,'zzx','1'),(8,'王晓华','wangxh','13671075406','wang@qq.com','1',13,'1','1'),(9,'林耀坤','linyk','13671075406','yang@qq.com','1',13,'1','2'),(10,'熊杰文','xiongjw','134555555','xiong@qq.com','1',13,'1','2'),(11,'王敏','wangmin','1324554321','wangm@qq.com','1',15,'1','2'),(15,'黄美玲','huangml','huangml@qq.com','13567898765','1',15,'1','2'),(20,'王敏','wangmin002','13454332334','wang@qq.com','1',15,'1','2'),(21,'陈敏','chenm','13559994444','www@aa.com','1',15,'1','2'),(23,'陈晨','wangm','22·2','11','2',14,'1','2'),(25,'王晓华','wangxh222','111','1','1',14,'1','2'),(27,'张三','zhangsan','122','22','2',16,'1','2'),(28,'李四','lisi','1','1','1',16,'1','2'),(29,'王五','wangwu','1','1','1',17,'1','2'),(30,'赵六','zhaoliu','1','1','2',13,'1','2'),(32,'冯七','fengqi','1','1','2',13,'1','2'),(33,'马八','maba','1','1','2',13,'1','2'),(34,'钱十','qianshi','1','1','1',13,'1','2'),(35,'周十一','zhoushiyi','1','1','2',13,'1','2'),(36,'wushier','wushier','1','1','1',13,'1','2'),(37,'张三','zzxzzx','2','565785929@qq.com','1',13,'1','2'),(38,'fds','dsfasd','13171706376','565785929@qq.com','1',15,'123456','2'),(39,'123','123123','13171706376','123123@qq.com','2',13,'123','2'),(40,'郝杰','hj9654','18894961897','1424029008@qq.com','1',13,'1996317','2'),(41,'cjr','ccccc','13171996953','1421045388@qq.com','2',13,'123456','2'),(42,'张三','asdasd','13171706376','565785929@qq.com','0',13,'asdasd','2'),(43,'yang','yang','15028361656','1591983325@qq.com','1',13,'123456','2'),(44,'hgh','gggg','13171706376','565785929@qq.com','0',13,'qqqqqq','2'),(45,'asdas','asdasda','13171706376','565785929@qq.com','0',13,'asdasd','2'),(46,'asdas','asdasdf','13171706376','565785929@qq.com','0',13,'asdasd','2'),(47,'yang','yutu','11111111111','159974693@qq.com','2',13,'123456','2'),(48,'yang','ukmjnh','15028361656','1591983325@qq.com','2',13,'123456','2'),(49,'1','1234','11111111411','122131er3@126.com','0',13,'123456','2'),(50,'zzz','aaaa','11111111111','1q2@qq.com','2',13,'!!!!!!','2');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meeting`
--

DROP TABLE IF EXISTS `meeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meeting` (
  `meetingid` int(11) NOT NULL AUTO_INCREMENT,
  `meetingname` varchar(255) DEFAULT NULL,
  `roomid` int(11) DEFAULT NULL,
  `reservationistid` int(11) DEFAULT NULL,
  `numberofparticipants` int(11) DEFAULT NULL,
  `starttime` datetime DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `reservationtime` datetime DEFAULT NULL,
  `canceledtime` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`meetingid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meeting`
--

LOCK TABLES `meeting` WRITE;
/*!40000 ALTER TABLE `meeting` DISABLE KEYS */;
INSERT INTO `meeting` VALUES (1,'123',7,1,123,'2017-12-19 11:15:08','2017-12-29 11:15:12','2017-12-19 11:15:25','2017-12-23 20:14:26','werdaesd','1'),(2,'12',15,1,12,'2017-12-20 19:25:54','2017-12-21 19:24:37','2017-12-20 19:28:05','2017-12-21 21:02:32','123','1'),(3,'12',5,1,12,'2017-12-19 21:11:53','2017-12-20 21:11:55','2017-12-20 20:52:43','2017-12-23 20:14:19','123','1'),(4,'12',9,1,12,'2017-12-20 19:25:54','2017-12-20 21:11:55','2017-12-20 21:02:44','2017-12-23 20:14:17','21312','1'),(5,'gh',15,43,62,'2017-12-22 15:08:19','2017-12-22 15:08:21','2017-12-22 15:09:01','2017-12-22 15:14:27','','1'),(6,'12',10,1,12,'2017-12-23 16:07:41','2017-12-29 16:07:43','2017-12-23 16:08:14',NULL,'21312','0'),(7,'asdf',6,1,1,'2017-12-23 16:54:05','2017-12-23 16:54:12','2017-12-23 16:55:57','2017-12-23 20:13:27','fasdfasd','1');
/*!40000 ALTER TABLE `meeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetingparticipants`
--

DROP TABLE IF EXISTS `meetingparticipants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meetingparticipants` (
  `meetingid` int(11) NOT NULL,
  `employeeid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetingparticipants`
--

LOCK TABLES `meetingparticipants` WRITE;
/*!40000 ALTER TABLE `meetingparticipants` DISABLE KEYS */;
INSERT INTO `meetingparticipants` VALUES (1,8),(2,11),(3,23),(4,15),(4,20),(4,21),(4,38),(5,9),(5,10),(5,32),(6,1),(6,10),(6,30),(6,33),(6,32),(6,9),(6,34),(6,36),(6,35),(6,40),(6,41),(6,39),(6,37),(6,42),(6,44),(6,46),(6,8),(6,47),(6,48),(6,49),(7,35),(7,10),(7,30),(7,15),(7,21),(7,38),(7,9),(7,11),(7,20);
/*!40000 ALTER TABLE `meetingparticipants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meetingroom`
--

DROP TABLE IF EXISTS `meetingroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `meetingroom` (
  `roomid` int(11) NOT NULL AUTO_INCREMENT,
  `roomnum` int(11) DEFAULT NULL,
  `roomname` varchar(255) DEFAULT NULL,
  `capacity` int(11) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roomid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meetingroom`
--

LOCK TABLES `meetingroom` WRITE;
/*!40000 ALTER TABLE `meetingroom` DISABLE KEYS */;
INSERT INTO `meetingroom` VALUES (5,101,'第一会议室',4,'0','技术部门会议室'),(6,102,'第二会议室',5,'0','管理部门会议室'),(7,103,'第三会议室',12,'1','市场部专用会议室'),(8,401,'第四会议室',15,'1','公共会议室'),(9,201,'第五会议室',15,'0','最大会议室'),(10,601,'第六会议室',12,'0','需要提前三天预定'),(15,999,'第999会议室',99,'0','第999会议室，哈哈哈哈哈'),(17,888,'地狱之门',888,'1','啦啦啦'),(18,777,'地狱之火',888,'1','123'),(23,666,'牛牛会议室',80,'0','');
/*!40000 ALTER TABLE `meetingroom` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-24 11:20:48
