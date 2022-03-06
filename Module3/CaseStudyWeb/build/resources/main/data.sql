INSERT INTO education_degree
VALUES	(1, 'Intermediate'),
		(2, 'Colleges'),
		(3, 'University'),
        (4, 'Master');
        
INSERT INTO `position`
VALUES	(1, 'Receptionist'),
		(2, 'Service Staff'),
        (3, 'Expert'),
        (4, 'Supervisor'),
        (5, 'Manager'),
        (6, 'Director');
        
INSERT INTO division
VALUES	(1, 'Sale Marketing Department'),
		(2, 'Aministration Department'),
        (3, 'Service Department'),
        (4, 'Management Department');
        
INSERT INTO `role`
VALUES	(1, 'Director or Manager'),
		(2, 'Employee'),
        (3, 'Customer');
        
insert into `user` (username, password) values ('ryair0', 'nZNPoGy');
insert into `user` (username, password) values ('athurstance1', 'pdeljl');
insert into `user` (username, password) values ('oingliby2', '24pOPq');
insert into `user` (username, password) values ('lcreyke3', 'fQASB0k9YL');
insert into `user` (username, password) values ('stegler4', 'V1eDTLD7mN');
insert into `user` (username, password) values ('nvesco5', '5rZzoRX31Wc');
insert into `user` (username, password) values ('ewillcocks6', 'G1LAhMOuP3Ge');
insert into `user` (username, password) values ('ecantopher7', 'n2MSTwAPy');
insert into `user` (username, password) values ('gthorneloe8', 'v0qYpCJp');
insert into `user` (username, password) values ('nfreestone9', 'EMSd2c');
insert into `user` (username, password) values ('admin', 'admin');
insert into `user` (username, password) values ('employee', 'employee');
insert into `user` (username, password) values ('customer', 'customer');

insert into user_role (role_id, username)
values	(2, 'ryair0'),
		(3, 'athurstance1'),
        (1, 'oingliby2'),
        (2, 'lcreyke3'),
        (3, 'stegler4'),
        (3, 'nvesco5'),
        (3, 'ewillcocks6'),
        (2, 'ecantopher7'),
        (3, 'gthorneloe8'),
        (2, 'nfreestone9'),
        (1, 'admin'),
        (2, 'employee'),
        (3, 'customer');


insert into employee 
values 	 (1, 'Jdavie', '2018-02-17', '5048375565897187', 2177.53, '986-179-6002', 'jgeekie0@usa.gov', '1 Prentice Circle', 1, 2, 2, 'ryair0'),
		 (2, 'Stafani', '2018-10-23', '5108752674085630', 4244.7, '661-840-8422', 'smorgon1@seesaa.net', '05033 Green Ridge Plaza', 5, 1, 4, 'oingliby2'),
		 (3, 'Olenka', '2020-11-05', '5002358543671936', 4732.78, '504-895-4402', 'obenmore2@wired.com', '84454 Hermina Drive', 1, 4, 1, 'ecantopher7'),
		 (4, 'Garnet', '2018-08-23', '4041370829425990', 3940.22, '818-971-2140', 'gmealing3@bigcartel.com', '19403 Hoard Alley', 3, 2, 1, 'nfreestone9'),
		 (5, 'Sandi', '2021-03-29', '4017952783914232', 3785.36, '599-388-6323', 'sbrok4@newsvine.com', '014 Weeping Birch Road', 6, 3, 3, 'admin'),
		 (6, 'Mathilde', '2019-02-18', '4017959100289743', 2467.24, '378-492-4162', 'mborchardt5@zdnet.com', '81 Everett Avenue', 5, 1, 4, 'employee'),
		 (7, 'Salem', '2018-05-01', '5108758744762512', 1898.88, '859-599-4655', 'snutting6@uol.com.br', '1051 Ridgeway Alley', 6, 2, 1, 'admin'),
		 (8, 'Bartholemy', '2020-07-17', '4017958819161', 3734.5, '309-380-9255', 'bbertholin7@scribd.com', '982 Melvin Way', 2, 3, 1, 'employee'),
		 (9, 'Valina', '2019-09-28', '5048373508365289', 1355.57, '544-784-5313', 'vghost8@furl.net', '07 Dapin Drive', 5, 1, 3, 'oingliby2'),
		 (10, 'Hercule', '2020-07-19', '4017956925232551', 1371.58, '160-167-9804', 'hcurner9@examiner.com', '389 Mallory Junction', 6, 2, 2, 'ryair0');


 