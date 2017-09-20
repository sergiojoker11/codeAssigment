create table DISCOUNTTOAPPLY (
    id bigint generated by default as identity (start with 1),
    PRODUCTID bigint,
    primary key (id));

create table DISCOUNTAPPLIED (
    id bigint generated by default as identity (start with 1),
    PRODUCTID bigint,
    primary key (id));

create table DISCOUNT (
    id bigint generated by default as identity (start with 1),
    DISCOUNTTOAPPLYID bigint,
    DISCOUNTAPPLIEDID bigint,
    primary key (id));