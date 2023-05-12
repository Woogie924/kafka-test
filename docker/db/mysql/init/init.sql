CREATE TABLE member (
    id bigint auto_increment,
    name varchar(100) not null comment '이름'
) comment '테스트용 유저 테이블';

INSERT INTO member(name) values ('name1');
INSERT INTO member(name) values ('name2');
INSERT INTO member(name) values ('name3');
INSERT INTO member(name) values ('name4');
INSERT INTO member(name) values ('name5');