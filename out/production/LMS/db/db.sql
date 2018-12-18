
drop table student_book;
drop table student;
drop table book;
drop table login;



create table login(
    username varchar(30) primary key,
    password varchar(30)
);

insert into login values ('shikhar','abc123');


create table book(
    isbn varchar(30) primary key,
    name text,
    author text,
    price numeric(7,2)
);

insert into book values('b1','Around the World in 80 Days','Jules Verne',112);
insert into book values('b2','The Time Machine','H.G. Wells',85);
insert into book values('b3','The Picture of Dorian Gray','Oscar Wilde',139);

create table student(
    rno varchar(30) primary key,
    name text,
    class text,
    email text,
    contact text
);

insert into student values('101','Rohan','8-A','rohan@gmail.com','9478348751');
insert into student values('102','Shubham','9-C','shubham@gmail.com','9827563017');
insert into student values('103','Sangram','10-B','sangram@gmail.com','9064836529');


create table student_book(
    rno varchar(30) references student(rno),
    isbn varchar(30) references book(isbn),
    returnByDate date
);