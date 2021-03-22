------------------------------------
---User inserts
------------------------------------
INSERT INTO user(id,name,create_ts,last_ts) VALUES (1,'Eddy Ramos','2021-03-17 00:00:00','2021-03-17 00:00:00');
INSERT INTO user(id,name,create_ts,last_ts) VALUES (2,'John Wick','2021-03-17 00:00:00','2021-03-17 00:00:00');
INSERT INTO user(id,name,create_ts,last_ts) VALUES (3,'Machete Kills','2021-03-17 00:00:00','2021-03-17 00:00:00');


------------------------------------
---Transaction inserts
------------------------------------
INSERT INTO transaction(id,amount,id_user,card_data,disbursed,create_ts,last_ts) VALUES (1,3.1416,1,'20004152895621457448',false,'2021-03-17 00:00:00','2021-03-17 00:00:00');
INSERT INTO transaction(id,amount,id_user,card_data,disbursed,create_ts,last_ts) VALUES (2,1000.25,1,'20004152895621457448',false,'2021-03-17 00:00:00','2021-03-17 00:00:00');
INSERT INTO transaction(id,amount,id_user,card_data,disbursed,create_ts,last_ts) VALUES (3,100,2,'111122223334444',false,'2021-03-17 00:00:00','2021-03-17 00:00:00');

------------------------------------
---Disbursement inserts
------------------------------------
INSERT INTO disbursement(id,amount,id_user,create_ts,last_ts) VALUES (1,25000,1,'2021-01-01 00:00:00','2021-01-01 00:00:00');
INSERT INTO disbursement(id,amount,id_user,create_ts,last_ts) VALUES (2,25000,1,'2021-02-01 00:00:00','2021-02-01 00:00:00');
