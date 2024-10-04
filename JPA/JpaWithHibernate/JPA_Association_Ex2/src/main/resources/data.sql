insert into course(id , name, last_Update_Date, create_Date) 
values (10001, 'Jpa in 50 steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
insert into course(id , name, last_Update_Date, create_Date) 
values (10002, 'Jpa in 3000 steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into course(id , name, last_Update_Date, create_Date) 
values (10003, 'Jpa in 4000 steps', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into course(id , name, last_Update_Date, create_Date) 
values (10004, 'Dummy1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
insert into course(id , name, last_Update_Date, create_Date) 
values (10005, 'Dummy2', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into course(id , name, last_Update_Date, create_Date) 
values (10006, 'Dummy3', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into course(id , name, last_Update_Date, create_Date) 
values (10007, 'Dummy4', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP );
insert into course(id , name, last_Update_Date, create_Date) 
values (10008, 'Dummy5', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into course(id , name, last_Update_Date, create_Date) 
values (10009, 'Dummy6', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into passport(id, number) values(40001, 'E12344');
insert into passport(id, number) values(40002, 'N12345');
insert into passport(id, number) values(40003, 'P12363');

insert into student(id, name, passport_id) values(20001, 'Sumit', 40001);
insert into student(id, name, passport_id) values(20002, 'Sourabh', 40002);
insert into student(id, name, passport_id) values(20003, 'Yogi', 40003);

insert into review(id, rating, description, course_id) values(50001, '4', 'good', 10001);
insert into review(id, rating, description, course_id) values(50002, '3', 'Not so good', 10001);
insert into review(id, rating, description, course_id) values(50003, '5', 'very good', 10003);

insert into student_course(student_id, course_id) values(20001,10001 );
insert into student_course(student_id, course_id) values(20001,10002 );
insert into student_course(student_id, course_id) values(20002,10001 );
insert into student_course(student_id, course_id) values(20003,10001 );