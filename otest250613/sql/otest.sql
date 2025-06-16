create table member ( -- 멤버 테이블 생성
mno number(7) not null ,
id varchar2(20) not null,
pw varchar2(30) not null,
name varchar2 (20) not null ,
email varchar2 (30) not null,
mname varchar2 (20) not null primary key,
pno number (11) not null,
mdate date default sysdate not null
)

drop table member -- 테이블 삭제 처리용
drop sequence member_seq -- 시퀀스 삭제 처리용

create sequence member_seq increment by 1 start with 1 nocycle nocache -- 시퀀스 생성


-- 더미데이더 입력
insert into member (mno, id, pw, name, email, mname, pno, mdate) 
values (member_seq.nextval, 'master', '1234', '관리자', 'master@master.com', '관리자', 01099999999, sysdate)

insert into member (mno, id, pw, name, email, mname, pno, mdate)
values (member_seq.nextval,'kcs','1111','김춘식','kcs@csword.com','김춘식팬클럽',01012345678,sysdate)

insert into member (mno, id, pw, name, email, mname, pno, mdate)
values (member_seq.nextval,'hkd','2222','홍길동','hkd@star.com','동서남북스타',01097919791,sysdate)

insert into member (mno, id, pw, name, email, mname, pno, mdate)
values (member_seq.nextval,'cgs','3333','최고심','cgs@lucky.com','내가최고얌',01092569256,sysdate)

insert into member (mno, id, pw, name, email, mname, pno, mdate)
values (member_seq.nextval,'bkcat','4444','김블랙','black@catworld.com','낭만고양이',01012319595,sysdate)

select *from member -- 멤버 테이블 조회

------------------------------------------------------------------------------------------------------
alter table member add constraint member_board_fk foreign key (mname) references board (bname)
alter table member drop constraint member_board_fk


create table board (
bno number (5) not null,
btitle varchar2 (50) not null,
bcontent varchar2 (1000) not null,
bname varchar2 (20) not null primary key,
bdate date default sysdate not null
)

insert into board (bno, btitle, bcontent, bname, bdate) values (member_seq.nextval,'[공지사항]아무말이나 쓰지마세요','제곧내','관리자',sysdate)
insert into board (bno, btitle, bcontent, bname, bdate) values (member_seq.nextval,'글도 맘대로 못쓰게하냐','내마음이다용','김춘식팬클럽',sysdate)
insert into board (bno, btitle, bcontent, bname, bdate) values (member_seq.nextval,'동에번쩍 서에번쩍 바쁘다','바빠죽겠네','동서남북스타',sysdate)
insert into board (bno, btitle, bcontent, bname, bdate) values (member_seq.nextval,'7월부터는 진짜 제대로 산다','6월까진 엉망임','내가최고얌',sysdate)
insert into board (bno, btitle, bcontent, bname, bdate) values (member_seq.nextval,'낭만고양이 노래 아는 사람','검은고양이 네로네로','낭만고양이',sysdate)

select *from board
select m.*,b.bname from member m inner join board b on m.mname = b.bname where id = 'master'





