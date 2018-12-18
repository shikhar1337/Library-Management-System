
drop table datex;


create table datex(
    code int primary key,
    date_of_return date
);

insert into datex values(101,current_date+7);