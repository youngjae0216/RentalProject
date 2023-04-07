INSERT INTO venue VALUES('EZEN-A01','이젠빌딩지하주차장');
INSERT INTO venue VALUES('EZEN-A02','이젠빌딩지하주차장');
INSERT INTO venue VALUES('EZEN-B01','이젠빌딩지하주차장');
INSERT INTO venue VALUES('EZEN-B02','이젠빌딩지하주차장');
INSERT INTO venue VALUES('SNH-A10','신논현역유료주차장');
INSERT INTO venue VALUES('SNH-A11','신논현역유료주차장');
INSERT INTO venue VALUES('GN-C03','강남역유료주차장');
INSERT INTO venue VALUES('GN-C04','강남역유료주차장');
INSERT INTO venue VALUES('APRO-E03','에이프로스퀘어지하주차장');
INSERT INTO venue VALUES('APRO-F07','에이프로스퀘어지하주차장');

INSERT INTO client VALUES('apple123','1234','꿀사과','2023-04-04');
INSERT INTO client VALUES('cherry55','1111','강체리','2023-03-28');
INSERT INTO client VALUES('banana02','2222','이바나','2023-04-01');
INSERT INTO client VALUES('dongdong','6666','문동은','2023-04-02');
INSERT INTO client VALUES('yeonjin','4444','박연진','2023-03-29');

INSERT INTO vehicle VALUES('05허0512','현대아반떼','EZEN-A01','2019-01-01'); //
INSERT INTO vehicle VALUES('03하0243','기아K5','EZEN-A02','2020-02-02');  //
INSERT INTO vehicle VALUES('04허0546','현대아이오닉5','EZEN-B01','2021-03-03'); //
INSERT INTO vehicle VALUES('02허0586','기아셀토스','EZEN-B02','2022-04-04');//
INSERT INTO vehicle VALUES('01하0786','쌍용토레스','APRO-F07','2023-01-01');
INSERT INTO vehicle VALUES('07하0077','현대투싼','APRO-E03','2023-02-16');
INSERT INTO vehicle VALUES('08허0798','기아카니발(9인승)','GN-C03','2023-02-04'); //
INSERT INTO vehicle VALUES('04호0513','기아카니발(11인승)','GN-C04','2023-04-01');

INSERT INTO booking VALUES('05허0512','yeonjin','EZEN-A01','2023-04-20','40','500000','2023-04-04','GEJIS72242');
INSERT INTO booking VALUES('08허0798','yeonjin','GN-C03','2023-05-14','80','900000','2023-04-05','WQFKJ12985');
INSERT INTO booking VALUES('03하0243','dongdong','EZEN-A02','2023-04-10','24','550000','2023-04-06','FASJN51255');
INSERT INTO booking VALUES('04허0546','banana02','EZEN-B01','2023-04-15','18','390000','2023-04-06','WGEJK59287');
INSERT INTO booking VALUES('02허0586','apple123','EZEN-B02','2023-04-24','100','1090000','2023-04-06','GWEJN72377');

INSERT INTO board VALUES('00001','yeonjin','렌터카예약후기1','내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용','2023-04-04','2023-04-05');
INSERT INTO board VALUES('00002','dongdong','렌터카예약후기2','내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용','2023-04-06','2023-04-08');
INSERT INTO board VALUES('00003','banana02','렌터카예약후기3','내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용','2023-04-06','2023-04-10');
INSERT INTO board VALUES('00004','apple123','렌터카예약후기4','내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용내용','2023-04-06','2023-04-12');
