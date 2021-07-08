/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 80017
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 80017
File Encoding         : 65001

Date: 2021-07-08 22:58:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `account` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '_admin1234', '12345678', '管理员一');
INSERT INTO `admin` VALUES ('2', '_admin12345', '87654321', '管理员二');

-- ----------------------------
-- Table structure for mcollection
-- ----------------------------
DROP TABLE IF EXISTS `mcollection`;
CREATE TABLE `mcollection` (
  `uid` int(32) DEFAULT NULL,
  `sid` int(32) DEFAULT NULL,
  `cname` varchar(64) DEFAULT NULL,
  `cposition` varchar(64) DEFAULT NULL,
  `cpicture` varchar(64) DEFAULT NULL,
  KEY `uid` (`uid`),
  KEY `sid` (`sid`),
  CONSTRAINT `mcollection_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`),
  CONSTRAINT `mcollection_ibfk_2` FOREIGN KEY (`sid`) REFERENCES `spot` (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of mcollection
-- ----------------------------
INSERT INTO `mcollection` VALUES ('1', '11', '布达拉宫', '西藏拉萨', '../img/pimg/20210529034830.png');
INSERT INTO `mcollection` VALUES ('1', '7', '普达措国家公园', '云南省香格里拉', '../img/pimg/20210524182120.png');
INSERT INTO `mcollection` VALUES ('1', '1', '张家界国家森林公园', '湖南省张家界', '../img/pimg/20210511235855.png');

-- ----------------------------
-- Table structure for province
-- ----------------------------
DROP TABLE IF EXISTS `province`;
CREATE TABLE `province` (
  `pid` int(32) NOT NULL AUTO_INCREMENT,
  `pname` varchar(32) NOT NULL,
  `pcounts` int(32) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of province
-- ----------------------------
INSERT INTO `province` VALUES ('1', '湖南省', '123');
INSERT INTO `province` VALUES ('2', '河北省', '757');
INSERT INTO `province` VALUES ('3', '山西省', '421');
INSERT INTO `province` VALUES ('4', '辽宁省', '658');
INSERT INTO `province` VALUES ('5', '吉林省', '283');
INSERT INTO `province` VALUES ('6', '黑龙江省', '123');
INSERT INTO `province` VALUES ('7', '江苏省', '467');
INSERT INTO `province` VALUES ('8', '浙江省', '879');
INSERT INTO `province` VALUES ('9', '安徽省', '458');
INSERT INTO `province` VALUES ('10', '福建省', '865');
INSERT INTO `province` VALUES ('11', '江西省', '879');
INSERT INTO `province` VALUES ('12', '山东省', '391');
INSERT INTO `province` VALUES ('13', '河南省', '931');
INSERT INTO `province` VALUES ('14', '湖北省', '732');
INSERT INTO `province` VALUES ('15', '广东省', '932');
INSERT INTO `province` VALUES ('16', '海南省', '639');
INSERT INTO `province` VALUES ('17', '四川省', '128');
INSERT INTO `province` VALUES ('18', '贵州省', '121');
INSERT INTO `province` VALUES ('19', '云南省', '552');
INSERT INTO `province` VALUES ('20', '陕西省', '842');
INSERT INTO `province` VALUES ('21', '甘肃省', '398');
INSERT INTO `province` VALUES ('22', '青海省', '537');
INSERT INTO `province` VALUES ('23', '台湾省', '988');
INSERT INTO `province` VALUES ('24', '内蒙古自治区', '211');
INSERT INTO `province` VALUES ('25', '广西壮族自治区', '122');
INSERT INTO `province` VALUES ('26', '西藏自治区', '325');
INSERT INTO `province` VALUES ('28', '新疆维吾尔自治区', '454');
INSERT INTO `province` VALUES ('29', '北京市', '323');
INSERT INTO `province` VALUES ('30', '天津市', '213');
INSERT INTO `province` VALUES ('31', '上海市', '187');
INSERT INTO `province` VALUES ('32', '重庆市', '169');

-- ----------------------------
-- Table structure for spot
-- ----------------------------
DROP TABLE IF EXISTS `spot`;
CREATE TABLE `spot` (
  `sid` int(32) NOT NULL AUTO_INCREMENT,
  `sname` varchar(64) NOT NULL,
  `position` varchar(64) DEFAULT NULL,
  `lid` int(32) DEFAULT NULL,
  `pid` int(32) DEFAULT NULL,
  `collect_counts` int(64) DEFAULT NULL,
  `level` varchar(32) DEFAULT NULL,
  `sdescription` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `spicture` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`sid`),
  KEY `lid` (`lid`),
  KEY `pid` (`pid`),
  CONSTRAINT `spot_ibfk_1` FOREIGN KEY (`lid`) REFERENCES `type` (`lid`),
  CONSTRAINT `spot_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `province` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of spot
-- ----------------------------
INSERT INTO `spot` VALUES ('1', '张家界国家森林公园', '湖南省张家界', '1', '1', '9711', '5A级', '张家界国家森林公园自然风光以峰称奇、以谷显幽、以林见秀。乘百龙天梯，观世遗美景。奇峰三千，秀水八百，是非常适合深度畅玩的复合型景区。', '../img/pimg/20210511235855.png');
INSERT INTO `spot` VALUES ('2', '岳阳楼洞庭湖风景名胜区', '湖南省岳阳市', '3', '1', '3184', '5A级', '岳阳楼洞庭湖风景名胜区，位于湖南省岳阳市区西北部，为国家级风景名胜区。', '../img/pimg/20210524181759.png');
INSERT INTO `spot` VALUES ('3', '橘子洲', '湖南省长沙市', '2', '1', '3184', '5A级', '橘子洲，位于湖南省长沙市岳麓区的湘江中心，是湘江下游众多冲积沙洲中面积最大的沙洲，被誉为“中国第一洲”。', '../img/pimg/20210529025012.png');
INSERT INTO `spot` VALUES ('4', '株洲方特欢乐世界', '湖南省株洲市', '4', '1', '5184', '5A级', '方特欢乐世界以科幻体验为特色，采用当今国际知名理念和技术精心打造，可与当前西方优秀主题乐园相媲美，被誉为“东方梦幻乐园”。', '../img/pimg/20210529025626.png');
INSERT INTO `spot` VALUES ('5', '阳明山国家级自然保护区', '湖南省永州市', '1', '1', '5184', '4A级', '阳明山为国家AAAA级旅游景区、国家级森林公园、国家水利风景区、国家级自然保护区、爱国主义教育基地。', '../img/pimg/20210524181819.png');
INSERT INTO `spot` VALUES ('6', '义帝陵', '湖南省郴州市', '2', '1', '6612', '4A级', '义帝陵是秦末义帝之陵墓，距今已有2200余年历史。它是郴州历史的最早见证，经历了郴州历史演变的风风雨雨。', '../img/pimg/20210529031658.png');
INSERT INTO `spot` VALUES ('7', '普达措国家公园', '云南省香格里拉', '1', '19', '3619', '5A级', '普达措国家公园位于香格里拉风景区的中心,是世界自然遗产“三江并流”的重要组成部分。', '../img/pimg/20210524182120.png');
INSERT INTO `spot` VALUES ('8', '独克宗古城', '云南省藏族自治州香格里拉县东南隅', '3', '19', '8818', '4A级', '独克宗古城位于迪庆藏族自治州香格里拉县东南隅，为唐代吐蕃王朝所建。古城依山而建，路面就地势铺筑石板，自然起伏。', '../img/pimg/20210529033601.png');
INSERT INTO `spot` VALUES ('9', '昆明世博园', '云南省昆明东北郊', '2', '19', '918', '5A级', '园区整体规划依山就势，集全国各地方风格的园林园艺品，庭院建筑和科技成就于一园，体现了“人与自然，和谐发展”的时代主题。', '../img/pimg/20210529033958.png');
INSERT INTO `spot` VALUES ('10', '西双版纳热带动物园', '云南省西双版纳傣族自治州勐腊县勐仑镇213国道', '1', '19', '918', '5A级', '西双版纳热带动物园于2005年建园，总占地面积四十亩，共有一百多种动物，其中热带野生动物30种，深受当地小朋友的喜爱。', '../img/pimg/20210529034517.png');
INSERT INTO `spot` VALUES ('11', '布达拉宫', '西藏拉萨', '2', '26', '3718', '5A级', '布达拉宫不仅是西藏的象征，更是朝圣者心中的圣地。如歌里唱到的一样“回到拉萨，回到了布达拉”。', '../img/pimg/20210529034830.png');
INSERT INTO `spot` VALUES ('12', '大昭寺', '西藏拉萨', '2', '26', '1621', '5A级', '在藏民心中大昭寺在拉萨的中心地位，不仅是地理位置上的，也包括社会生活。', '../img/pimg/20210529035251.png');
INSERT INTO `spot` VALUES ('13', '珠穆朗玛峰', '西藏日客则', '1', '26', '2168', '5A级', '珠穆朗玛峰是世界第一高峰。峰顶常年积雪，冰川随处可见。天气理想之时，晨光照射在峰顶，光彩夺目，它是藏民心中神圣不可替代的神山。', '../img/pimg/20210529035516.png');
INSERT INTO `spot` VALUES ('14', '雅鲁藏布大峡谷', '西藏林芝', '1', '26', '751', '4A级', '雅鲁藏布大峡谷位于西藏林芝地区米林县，平均深度5000米，最深处达6000米以上，长达504.9米，是世界上最大的大峡谷。', '../img/pimg/20210529035712.png');
INSERT INTO `spot` VALUES ('15', '冈仁波齐', '西藏阿里', '1', '26', '923', '5A级', '冈仁波齐位于普兰县玛旁雍错以北，是藏传佛教、印度教和信徒心中的“世界中心”。', '../img/pimg/20210529035858.png');
INSERT INTO `spot` VALUES ('22', '韶山毛泽东故乡', '湖南省湘潭市韶山', '3', '1', '9999', '5A级', '韶山是湖南省最出名的旅游景点之一，这里是新中国一代伟人毛泽东的故乡。单单是这一点，就足以吸引许多游客前来观光。加上当地政府对景区的改建，景点就更多了。', '../img/pimg/20210529010047.png');
INSERT INTO `spot` VALUES ('23', '岳麓山', '湖南省长沙市岳麓区', '1', '1', '2629', '5A级', '岳麓山共有植物种类977种，古树名木较多，如晋朝罗汉松、唐代银杏、宋元香樟、明清枫栗。岳麓山省级以上重点保护文物有15处，有多位烈士、名人墓葬。', '../img/pimg/20210529012750.png');
INSERT INTO `spot` VALUES ('24', '长沙世界之窗', '湖南省长沙市开福区', '4', '1', '3306', '4A级', '长沙世界之窗位于湖南省长沙市东北郊区浏阳河畔，是由湖南电广传媒股份有限公司、深圳华侨城控股股份有限公司和香港中旅集团共同投资兴建的文化主题公园。', '../img/pimg/20210529013634.png');
INSERT INTO `spot` VALUES ('25', '长沙海底世界', '湖南省长沙市开福区', '4', '1', '1873', '4A级', '长沙海底世界坐落于湖南省长沙市浏阳河畔金鹰影视文化城内，占地面积近100亩，投资金额4.2亿元人民币，由极地海洋馆、科教馆、水上乐园、儿童乐园等7大功能区组成，集观赏、休闲、娱乐、科普于一体。', '../img/pimg/20210529014816.png');
INSERT INTO `spot` VALUES ('26', '云南丽江古城景区', '云南省丽江市古城区', '3', '19', '4771', '5A级', '丽江古城位于云南省丽江市古城区，丽江古城体现了中国古代城市建设的成就，是中国民居中具有鲜明特色和风格的类型之一。，又名大研镇，坐落在丽江坝中部，始建于宋末元初', '../img/pimg/20210529015713.png');
INSERT INTO `spot` VALUES ('27', '昆明滇池国家旅游度假区', '云南省昆明市', '1', '19', '2854', '5A级', '昆明滇池国家旅游度假区是国家级。环境优美、空气清新、交通畅达、适宜人居，成为海内外游客到云南的必达之地和首选之地。旅游度假区中唯一位于内陆省的旅游度假区。', '../img/pimg/20210529020244.png');
INSERT INTO `spot` VALUES ('28', '曹溪寺', '云南省昆明市安宁市', '3', '19', '873', '4A级', '曹溪寺，全国重点文物保护单位，位于昆明市安宁市温泉镇龙溪路。该寺始建于宋代（大理国时期），建筑总体布局为常见四合院式，主殿宝华阁为全国罕见木质殿宇。', '../img/pimg/20210529020808.png');
INSERT INTO `spot` VALUES ('29', '玉龙雪山', '云南省丽江市', '1', '19', '4147', '5A级', '玉龙雪山在纳西语中被称为“欧鲁”，意为“天山”。其十三座雪峰连绵不绝，宛若一条“巨龙”腾越飞舞，故称为“玉龙”。又因其岩性主要为石灰岩与玄武岩，黑白分明，所以又称为“黑白雪山”。是纳西人的神山，传说纳西族保护神“三朵”的化身。', '../img/pimg/20210529021331.png');
INSERT INTO `spot` VALUES ('30', '纳木措', '西藏自治区拉萨市当雄县', '1', '26', '3059', '5A级', '“纳木措”为藏语，蒙古语名称为“腾格里海”，都是“天湖”之意。纳木措是西藏的“三大圣湖”之一。 纳木措是古象雄佛法雍仲本教的第一神湖，为著名的佛教圣地之一。', '../img/pimg/20210529023148.png');
INSERT INTO `spot` VALUES ('31', '唐古拉山脉', '西藏自治区东北部', '1', '26', '1631', '5A级', '位于中国西藏自治区东北部与青海省边境处（青藏高原），东段为西藏与青海的界山，东南部延伸接横断山脉的云岭和怒山。藏语意为“高原上的山”，又称“当拉山”，在蒙语中意为“雄鹰飞不过去的高山”，是青藏高原中部的一条近东西走向的山脉。', '../img/pimg/20210529023405.png');
INSERT INTO `spot` VALUES ('32', '噶丹寺', '西藏拉萨市达孜区', '3', '26', '482', '4A级', '位于拉萨市达孜区境内拉萨河南岸海拔3800米的旺波日山上。旺波日山犹如一头卧伏的巨象，驮载着布满山坳、规模庞大的建筑群，充分体现出传统藏传佛教寺院建筑因地制宜，寺庙傍山而立，群楼重叠，巍峨壮观。', '../img/pimg/20210529023855.png');

-- ----------------------------
-- Table structure for strategy
-- ----------------------------
DROP TABLE IF EXISTS `strategy`;
CREATE TABLE `strategy` (
  `uid` int(32) DEFAULT NULL,
  `sid` int(32) DEFAULT NULL,
  `tid` int(32) DEFAULT NULL,
  `tname` varchar(64) DEFAULT NULL,
  `tcost` int(32) DEFAULT NULL,
  `tdescription` varchar(1000) DEFAULT NULL,
  `phonenumber` varchar(64) DEFAULT NULL,
  `mymap` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of strategy
-- ----------------------------
INSERT INTO `strategy` VALUES ('1', null, '4', '个人攻略', '500', '自助游线路三晚四日游，自驾车线路二晚二日游。纯玩散客线路张家界、天子山、黄龙洞、猛洞河漂流三晚四日游。第1天游览张家界森林公园、黄石寨、金鞭溪。第2天天子山、电影《阿凡达》“乾坤柱”、袁家界、十里画廊...', '无', '../img/map.png');
INSERT INTO `strategy` VALUES ('1', null, '2', '风火旅游团', '2800', '旅游路线:...旅游景点....活动住宿安排....', '0085363241393', '../img/map.png');
INSERT INTO `strategy` VALUES ('1', null, '1', '山水旅游团', '1500', '旅游路线:...........', '0731-2856', '../img/map.png');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team` (
  `tid` int(32) NOT NULL AUTO_INCREMENT,
  `tname` varchar(32) NOT NULL,
  `phonenumber` varchar(32) NOT NULL,
  `tdescription` varchar(1000) DEFAULT NULL,
  `tcost` int(32) DEFAULT NULL,
  `sid` int(32) NOT NULL,
  `map` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES ('1', '山水旅游团', '0731-2856', '旅游路线:...........', '1500', '1', '../img/map.png');
INSERT INTO `team` VALUES ('2', '风火旅游团', '0085363241393', '旅游路线:...旅游景点....活动住宿安排....', '2800', '2', '../img/map.png');
INSERT INTO `team` VALUES ('3', '流云旅游团', '17705167291', '旅游路线:...旅游景点....活动住宿安排....', '1200', '3', '../img/map.png');
INSERT INTO `team` VALUES ('4', '个人攻略', '无', '自助游线路三晚四日游，自驾车线路二晚二日游。纯玩散客线路张家界、天子山、黄龙洞、猛洞河漂流三晚四日游。第1天游览张家界森林公园、黄石寨、金鞭溪。第2天天子山、电影《阿凡达》“乾坤柱”、袁家界、十里画廊...', '500', '1', '../img/map.png');
INSERT INTO `team` VALUES ('5', '个人攻略', '无', '旅游线路规划', '200', '2', '../img/map.png');
INSERT INTO `team` VALUES ('6', '个人管理', '无', '旅游线路规划', '0', '3', '../img/map.png');
INSERT INTO `team` VALUES ('7', '云南旅游团', '1008611', '线路', '1200', '10', '../img/map.png');
INSERT INTO `team` VALUES ('8', '个人攻略', '无', '线路', '800', '10', '../img/map.png');
INSERT INTO `team` VALUES ('9', '西藏旅游团', '1008611', '线路', '1400', '11', '../img/map.png');
INSERT INTO `team` VALUES ('10', '个人攻略', '无', '线路', '900', '11', '../img/map.png');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `lid` int(11) NOT NULL AUTO_INCREMENT,
  `lname` varchar(32) NOT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '自然景区');
INSERT INTO `type` VALUES ('2', '文化景区');
INSERT INTO `type` VALUES ('3', '历史景区');
INSERT INTO `type` VALUES ('4', '娱乐景区');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(32) NOT NULL AUTO_INCREMENT,
  `uname` varchar(32) NOT NULL,
  `upassword` varchar(32) NOT NULL,
  `uwhere` varchar(64) DEFAULT NULL,
  `ulike` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Billy', '12345678', '湖南省', '自然景区');
INSERT INTO `user` VALUES ('2', 'li123', '123456', '湖南省', '自然景区,历史景区,娱乐景区,文化景区');
INSERT INTO `user` VALUES ('3', 'BB123', '123456', '山西省', '自然景区,娱乐景区,历史景区');
INSERT INTO `user` VALUES ('4', 'CC123', '123321', '广西壮族自治区', '文化景区,自然景区');
INSERT INTO `user` VALUES ('5', 'dd321', '110018', '新疆维吾尔自治区', '自然景区,历史景区,娱乐景区,文化景区');
INSERT INTO `user` VALUES ('6', 'EE456', '123123', '上海市', '自然景区,娱乐景区');
INSERT INTO `user` VALUES ('14', '_admin1234', '12345678', '湖南省', '自然景区,娱乐景区');
INSERT INTO `user` VALUES ('21', 'qwe123', '12345678', '安徽省', '自然景区,历史景区');
INSERT INTO `user` VALUES ('22', 'asd123', '123456', '河南省', '自然景区,历史景区');

-- ----------------------------
-- Procedure structure for pre
-- ----------------------------
DROP PROCEDURE IF EXISTS `pre`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pre`( )
BEGIN
	DECLARE
		i INT;
	SET i = 1;
	WHILE
			i < 32 DO
			SELECT sname from spot where pid=i ORDER BY collect_counts DESC LIMIT 1;
		SET i = i + 1;
		
	END WHILE;
END
;;
DELIMITER ;
