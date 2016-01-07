Select id, ordernumber, itemid, supplierid, qty, rate, orderdate, deliverydate, totalamt, notes from usersdb.purchaseorder
USE usersdb;

insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (1,'NEWDT11',0,0,0,0,'2016-01-05 00:00:00',null,0,'Updated order');
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (2,'DT11',0,0,0,0,'2016-01-06 00:00:00',null,2,null);
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (3,'DT11',0,0,0,0,'2016-01-06 00:00:00',null,3,null);
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (4,'POSTMDT11',0,0,0,0,'2016-01-06 00:00:00',null,5,null);
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (5,'TOSTMDT11',0,0,0,0,'2016-01-06 00:00:00',null,6,null);
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (6,'STMDT11',11,1,10,2.4,'2016-01-06 00:00:00','2016-02-05 00:00:00',7,null);
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (7,'TMDT11',11,1,10,2.4,'2016-01-06 00:00:00','2016-02-05 00:00:00',8,null);
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (8,'DT11',0,0,0,0,'2016-01-06 00:00:00',null,3,null);
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (9,'DT11',0,0,0,0,'2016-01-06 00:00:00',null,6,null);
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (10,'NEWDT11',1,10,10,2.3,'2016-01-05 00:00:00','2016-03-05 00:00:00',0,'New Updated order');
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (11,'NEWDT11',1,10,10,5.3,'2016-01-05 00:00:00','2016-03-05 00:00:00',0,'New Updated order');
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (12,'IT_NEWREAL',0,0,0,0,'2016-01-06 00:00:00',null,23888.45,'Notes');
insert into `purchaseorder`(`id`,`ordernumber`,`itemid`,`supplierid`,`qty`,`rate`,`orderdate`,`deliverydate`,`totalamt`,`notes`) values (13,'NOTEPOS',11,1,10,2.4,'2016-01-06 00:00:00','2016-02-05 00:00:00',0,'new Notes');
