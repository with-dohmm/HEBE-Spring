-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        8.0.25 - MySQL Community Server - GPL
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- hebe 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `hebe` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hebe`;

-- 테이블 hebe.diarydb 구조 내보내기
CREATE TABLE IF NOT EXISTS `diarydb` (
  `iboard` int NOT NULL AUTO_INCREMENT,
  `title` varchar(30) COLLATE utf8mb4_general_ci NOT NULL,
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `iuser` int NOT NULL,
  `regdt` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `thumbnail` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`iboard`),
  KEY `iuser` (`iuser`),
  CONSTRAINT `diarydb_ibfk_1` FOREIGN KEY (`iuser`) REFERENCES `userdb` (`iuser`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 hebe.diarydb:~53 rows (대략적) 내보내기
/*!40000 ALTER TABLE `diarydb` DISABLE KEYS */;
INSERT INTO `diarydb` (`iboard`, `title`, `content`, `iuser`, `regdt`, `thumbnail`) VALUES
	(1, '오늘 점심은 무엇을 먹으면 좋을까요?', '배는 무척이나 고픈데 먹고 싶은 음식은 딱히 없다...', 1, '2021-06-21 12:09:21', '/cat1.jpg'),
	(2, '또방은 영원하다.', '어림도 없지~', 2, '2021-06-22 12:31:21', '/ddobang.jpg'),
	(3, '너무 졸린다... ㅠ', '3시간만 더 자고 싶다..ㅎ', 1, '2021-06-23 09:45:22', NULL),
	(4, '맨날 밥 고민하는 것도 귀찮', '그래서 뭐먹지;;', 1, '2021-06-23 09:45:58', NULL),
	(5, '마라탕 먹고 싶다', '어제도 먹었지만 또 먹고 싶다', 4, '2021-06-23 09:46:16', NULL),
	(6, '반장~ 애들 다 있나', '반장 똑바로 일 안하네', 2, '2021-06-23 09:47:23', NULL),
	(7, '안녕하신가영', '반가워영', 5, '2021-06-23 09:48:03', NULL),
	(8, '데이터 채우기용,,,', 'ㅠㅠㅠㅠㅠㅠ넘나귀찮', 3, '2021-06-23 09:48:19', NULL),
	(9, '집 갈 때 안 됐나?', '너무 가고 싶고', 3, '2021-06-23 09:49:00', NULL),
	(10, '하품 찍찍 해버리기~', '하아아아아아암~~', 3, '2021-06-23 09:49:50', NULL),
	(11, '꾹꾹이 꾹꾹', '본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 본문 내용 ', 1, '2021-06-23 10:25:24', NULL),
	(12, '하나씩 뜯어보자', 'mock.json 파일 객체가 많지 않아서 아이템을 10개씩 불러오기로 했다. slice 메소드로 인덱스 0 부터 10 까지의 아이템을 json 파일에서 받아오고, 이를 result 변수에 넣어주었다. productList 에 불러온 객체들이 하나씩 들어가게 된다.', 2, '2021-06-23 10:27:41', NULL),
	(13, '스크롤이 끝에 다다르면 component', 'infiniteScroll = () => {infiniteScroll = () => {infiniteScroll = () => {infiniteScroll = () => {infiniteScroll = () => {', 5, '2021-06-23 10:28:37', NULL),
	(14, 'offsetTop', '왼쪽 끝 맨 위를 기준으로 한 위치값. container에 위치값을 따로 부여하지 않으면 0으로 고정되어 있다.', 4, '2021-06-23 10:29:14', NULL),
	(15, 'scrollHeight ', ' 화면에 보이지 않는 곳까지의 총 길이를 의미한다. 스크롤로 지나온 곳, 현재의 보고 있는 곳, 앞으로 내려갈 곳을 모두 합친 사이트의 총 길이.', 3, '2021-06-23 10:29:38', NULL),
	(16, '(추가) 2차 수정', '데이터를 불러오는 것과 관련된 로직을 따로 함수로 분리하고, this.componentDidMount 전체를 직접 호출하는 지금의 구조를 바꾸라는 피드백을 받았다. 분리하면 아래와 같이 된다.', 1, '2021-06-23 10:29:59', NULL),
	(17, '무너진 건물, 거기에 감리자는 없었다', '건축공사 감리 규정과 달리 해체공사 감리는 2019년 서울 잠원동 철거 현장 사망사고 이후에야 관련 규정이 신설됐다. 하지만 이번 광주 사고 현장에 감리자는 없었다.', 1, '2021-06-23 10:30:56', NULL),
	(18, '상주 감리 비용 5배 더 높아', '서울시와 대전시 서구, 대구시 등 일부 지자체는 고위험 해체공사 현장에 감리자 상주를 의무화하는 조례와 내부 지침 등을 마련하기도 했다. 그러나 한계가 분명한 조치다. 근거가 될 상위법이 없기 때문에 위반 현장을 적발해도 행정지도 등 실질적인 제재를 할 수 없다. 서울시 지역건축안전센터 안종욱 센터장은 “법체계가 완전히 갖추어져야 안정적으로 상주 감리를 운영할 수 있다”라고 말했다.', 5, '2021-06-23 10:31:17', NULL),
	(19, '한 치매 환자가 또 다른 ‘치매 환자들’', '히구치 나오미 씨는 우리가 ‘치매’라 일컫는 ‘레비소체 인지저하증’을 앓고 있다. 〈오작동하는 뇌〉 출간을 앞두고 그와 서면으로 인터뷰했다. 그는 이 인터뷰 답변의 내용도 일부 잊을지 모른다.', 1, '2021-06-23 10:32:23', NULL),
	(20, '알츠하이머나 파킨슨병과는 어떤 차이가 있나요?', '미국 배우 로빈 윌리엄스는 생전에 파킨슨병 진단을 받았는데, 사후 부검에서 실은 레비소체 인지저하증이었다는 사실이 밝혀졌습니다. 레비소체 인지저하증은 알츠하이머와 달리 초기에 기억장애가 두드러지지 않습니다. 사람마다 다양한 증상이 나타납니다. 그 때문에 레비소체 인지저하증은 다른 병으로 오진되기 십상입니다. 또한 알츠하이머 진단을 받은 사람 중에 적지 않은 경우가 레비소체 인지저하증을 함께 겪었다는 사실이 연구(해부)를 통해 알려졌습니다.', 4, '2021-06-23 10:32:49', NULL),
	(21, '[끌올IN]타투이스트들이 노조 만든 이유', '문신은 한때 조직폭력배의 상징으로 쓰였다. 지금은 그렇지 않다. 어깨에 고양이, 쇄골에 복숭아, 발등에 펭귄, 골반에 범고래…. 상상할 수 없이 작고 귀엽고 감각적인 ‘타투’가 인기다. 한국에서 타투를 시술받은 인구는 100만명으로 추산된다. 하지만 ‘문신은 의료인이 하지 않으면 보건위생상 위해가 생길 수 있는 의료 행위’라는 1992년 대법원 판결 이후 비의료인 타투는 법의 사각지대에 있다. 1만~2만명에 이르는 타투이스트(문신사)들은 종종 시술 뒤 ‘신고하겠다’며 금액 협상을 시도하는 고객의 협박에 시달린다. 단속 때문에 고민하다 목숨을 끊은 이들도 있다.', 3, '2021-06-23 10:33:19', NULL),
	(22, '저작권자 © 시사IN 무단전재 및 재배포 금지', '타투유니온은 현재 의료계와 협업해 자체적인 위생 및 감염관리 지침을 만들고 있다. “아파서 일을 못하면 끝”인 조합원들을 위해 건강검진을 추진한다. 법률 보호를 지원하며, 자율적인 노동시간 가이드라인도 만들 예정이다. “노동의 개념도 이전의 제조업 중심을 넘어서 확장되어야 한다. 우리가 잘해서 성공하면 ‘첫 모델’이 될 수 있지 않을까.”', 2, '2021-06-23 10:33:45', NULL),
	(23, '벼농사 유전자 넘어선 산업별 노조의 역사', '아니, 이게 뭔 말? 지난 3월 〈시사IN〉 제703호에 실린 이철승 서강대 교수의 인터뷰다(‘50대 노조원의 밥그릇, 스마트하게 건드리자’). 지금에야 글을 쓰지만 이 구절은 두고두고 마음에 걸렸다. 산별주의자를 자처하며 쏟아부은 내 삶의 노력은 낮달처럼 무용했을까. 지금도 산별 체제를 구축하려고 애쓰는 현장 노동자들에게 “그건 안 돼, 도로(徒勞)야”, 한 바가지 찬물을 끼얹는 건 아닐까.', 1, '2021-06-23 10:34:15', NULL),
	(24, 'test1', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(25, 'test2', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(26, 'test3', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(27, 'test4', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(28, 'test5', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(29, 'test6', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(30, 'test7', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(31, 'test8', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(32, 'test9', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(33, 'test10', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(34, 'test11', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(35, 'test12', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(36, 'test13', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(37, 'test14', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(38, 'test15', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(39, 'test16', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(40, 'test17', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(41, 'test18', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(42, 'test19', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(43, 'test20', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(44, 'test21', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(45, 'test22', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(46, 'test23', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(47, 'test24', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(48, 'test25', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(49, 'test26', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(50, 'test27', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(51, 'test28', 'test1', 1, '2021-06-23 10:37:47', NULL),
	(53, 'ㄱㄴㄷㄹ', '<p><strong>ㅇㅇㅇㅇㅇ</strong></p>\n<p><strong>ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ<br></strong><span style="color: rgb(0,0,0);background-color: rgb(255,255,255);font-size: medium;font-family: Malgun Gothic;"><strong>ㅇㅇㅇㅇㅇ</strong></span><span style="color: rgb(41,105,176);background-color: rgb(255,255,255);font-size: medium;font-family: Malgun Gothic;"><strong>ㅇㅇㅇㅇㅇ</strong></span><span style="color: rgb(41,105,176);"><strong> <br></strong></span><span style="color: rgb(41,105,176);background-color: rgb(255,255,255);font-size: medium;font-family: Malgun Gothic;"><strong>ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</strong></span><span style="color: rgb(41,105,176);"><strong> <br></strong></span><span style="color: rgb(41,105,176);background-color: rgb(255,255,255);font-size: medium;font-family: Malgun Gothic;"><strong>ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</strong></span><span style="color: rgb(41,105,176);"><strong> <br></strong></span><span style="color: rgb(41,105,176);background-color: rgb(255,255,255);font-size: medium;font-family: Malgun Gothic;"><strong>ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</strong></span><span style="color: rgb(41,105,176);"> </span><br><span style="color: rgb(0,0,0);background-color: rgb(255,255,255);font-size: medium;font-family: Malgun Gothic;">ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ</span>&nbsp;</p>\n<p></p>\n', 1, '2021-07-03 19:57:54', NULL),
	(54, '11111', '<p></p>\n<img src="https://ssl.pstatic.net/tveta/libs/1345/1345081/1fc3708b30cfac70eff7_20210701160602280.jpg" alt="undefined" style="height: auto;width: auto"/>\n<p></p>\n', 1, '2021-07-04 16:48:26', NULL),
	(55, 'dsafasfsafd', '<p><strong>dfsad</strong></p>\n<p><strong>df</strong></p>\n<p><strong>df</strong></p>\n<p><span style="color: rgb(147,101,184);">afffff</span></p>\n<p></p>\n<p style="text-align:right;">fdsafafdafaf</p>\n', 1, '2021-07-05 09:16:46', NULL);
/*!40000 ALTER TABLE `diarydb` ENABLE KEYS */;

-- 테이블 hebe.favdb 구조 내보내기
CREATE TABLE IF NOT EXISTS `favdb` (
  `iuser` int NOT NULL,
  `iboard` int NOT NULL,
  PRIMARY KEY (`iuser`,`iboard`),
  KEY `iboard` (`iboard`),
  CONSTRAINT `favdb_ibfk_1` FOREIGN KEY (`iuser`) REFERENCES `userdb` (`iuser`),
  CONSTRAINT `favdb_ibfk_2` FOREIGN KEY (`iboard`) REFERENCES `diarydb` (`iboard`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 hebe.favdb:~2 rows (대략적) 내보내기
/*!40000 ALTER TABLE `favdb` DISABLE KEYS */;
INSERT INTO `favdb` (`iuser`, `iboard`) VALUES
	(1, 1),
	(2, 1);
/*!40000 ALTER TABLE `favdb` ENABLE KEYS */;

-- 테이블 hebe.userdb 구조 내보내기
CREATE TABLE IF NOT EXISTS `userdb` (
  `iuser` int NOT NULL AUTO_INCREMENT,
  `uid` varchar(16) COLLATE utf8mb4_general_ci NOT NULL,
  `upw` varchar(16) COLLATE utf8mb4_general_ci NOT NULL,
  `unm` varchar(16) COLLATE utf8mb4_general_ci NOT NULL,
  `profileImg` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `introduction` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`iuser`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 hebe.userdb:~4 rows (대략적) 내보내기
/*!40000 ALTER TABLE `userdb` DISABLE KEYS */;
INSERT INTO `userdb` (`iuser`, `uid`, `upw`, `unm`, `profileImg`, `introduction`) VALUES
	(1, 'jun17183', 'jun17183', '블블디', '/cat.jpg', NULL),
	(2, 'dohmm', 'dohmm', '도흠', NULL, NULL),
	(3, 'hongjun', 'hongjun', '홍준', NULL, NULL),
	(4, 'SUE', 'SUE', '지수', NULL, NULL),
	(5, 'heon', 'heon', '성헌', NULL, NULL);
/*!40000 ALTER TABLE `userdb` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
