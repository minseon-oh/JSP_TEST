create table t_users(
    id varchar2(50) not null,
    pw varchar2(50) not null,
    name varchar2(50) not null,
    phone1 varchar2(50),
    phone2 varchar2(50),
    phone3 varchar2(50),
    email1 varchar2(50),
    email2 varchar2(50),
    addr_basic varchar2(200),
    addr_detail varchar2(200)
);

alter table t_users add CONSTRAINT t_users_pk PRIMARY KEY (id);

create table t_board(
    bno number(10),
    title varchar2(100),
    writer varchar2(50),
    content varchar2(1000),
    regdate date default sysdate
);

create SEQUENCE t_board_seq;
alter table t_board add CONSTRAINT t_bno_pk PRIMARY KEY (bno);
