drop table member;
create table member(
id varchar2(20) primary key,
password varchar2(20) not null
);

select * from board;


학사정보의 내용을 객체 단위로 입력받아 서버프로그램에 전송 만들기



create table classinfo{
id varchar2(6) primary key,
name varchar2(20) not null,
kor number(3) not null,
eng number(3) not null,
math number(3) not null
) 

select * from classinfo;
