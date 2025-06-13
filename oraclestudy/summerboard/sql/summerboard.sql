
drop table member -- 멤버 테이블 삭제용

create table member ( -- 멤버 테이블 생성
mno number(5) not null,
mname nvarchar2(10) primary key ,
id nvarchar2(10) not null, -- board 테이블의 bwriter과 fk 관계설정하려고함 (타입 일치해야됨)
pw nvarchar2(10) not null,
regidate date default sysdate not null
)

-- 시퀀스 객체는 이미 1개가 있으니 board_seq를 같이 사용
-- 부모 더미데이터 입력
delete from member
insert into member (mno, mname, id, pw) values (board_seq.nextval, '춘식이팬클럽','csfan','0001')
insert into member (mno, mname, id, pw) values (board_seq.nextval, '김춘식안티','csnotfan','0002')
insert into member (mno, mname, id, pw) values (board_seq.nextval, '대한민국','korea','0003')
insert into member (mno, mname, id, pw) values (board_seq.nextval, '삼다수사장','samdasu','0004')
insert into member (mno, mname, id, pw) values (board_seq.nextval, '김냠냠','knn','0005')
insert into member (mno, mname, id, pw) values (board_seq.nextval, '홍뇸뇸','hnn','0006')

select *from member





----------------------------------------------------------------------------

drop table board -- 기존에 board 테이블 삭제
drop sequence board_seq -- 자동번호 생성 제거

create table board(
bno number(5) not null,
btitle nvarchar2(30) not null,
bcontent nvarchar2(1000) not null,
bwriter nvarchar2(10) primary key not null,
bdate date not null
)



create sequence board_seq increment by 1 start with 1 nocycle nocache
alter table board add constraint board_member_fk foreign key (bwriter) references member(mname)


delete from board -- 조건없이 delete 를 실행하면 모든 데이터가 삭제 됨 - > 외래키를 다시 지정

insert into board (bno, btitle, bcontent, bwriter, bdate) values (board_seq.nextval, '☆공지☆ 썸머페스티벌 라인업','참가자 : 김춘식','춘식이팬클럽',sysdate)
insert into board (bno, btitle, bcontent, bwriter, bdate) values (board_seq.nextval, '썸페 라인업 구리다','김춘식이뭐냐 노잼','김춘식안티',sysdate)
insert into board (bno, btitle, bcontent, bwriter, bdate) values (board_seq.nextval, '스카이블루해수욕장OPEN','더워죽겠는데 빨리 놀러오세요','대한민국',sysdate)
insert into board (bno, btitle, bcontent, bwriter, bdate) values (board_seq.nextval, '삼다수','물은 역시 삼다수지','삼다수사장',sysdate)
insert into board (bno, btitle, bcontent, bwriter, bdate) values (board_seq.nextval, '[냠냠커피] 스카이블루해수욕장점 오픈','1000원 행사해요','김냠냠',sysdate)
insert into board (bno, btitle, bcontent, bwriter, bdate) values (board_seq.nextval, '냠냠커피 커피 맛없다','냠냠커피보다 건너편 뇸뇸커피가 더 맛있음','홍뇸뇸',sysdate)

select*from board;
---------------------------------------------------------------

-- 조인 : 테이블 2개를 연결하여 값을 가져온다

select b.*,m.mname from member m inner join board b on m.mname = b.bwriter where mname = '춘식이팬클럽'
-- b에 있는 모든 필드와 m에 있는 mname 필드를 조회 가능


