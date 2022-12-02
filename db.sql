create table boards2 (
    bno number primary key, 
    btitle varchar2(200) not null,
    bcontent clob not null,
    bwriter varchar2(20) not null,
    bdate date not null,
    bhit_count number not null,
    bfile_name varchar2(200) null,
    bsaved_name varchar2(100) null,
    bfile_type varchar2(100) null

);

create sequence seq_boards2_bno;