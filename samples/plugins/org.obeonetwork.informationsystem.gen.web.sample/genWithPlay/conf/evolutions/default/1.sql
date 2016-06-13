# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table choco (
  id                        bigint not null,
  short_description         varchar(255),
  description               varchar(255),
  user_id                   bigint,
  constraint pk_choco primary key (id))
;

create table office (
  id                        bigint not null,
  short_description         varchar(255),
  description               varchar(255),
  constraint pk_office primary key (id))
;

create table user (
  id                        bigint not null,
  nickname                  varchar(255),
  short_nickname            varchar(255),
  first_name                varchar(255),
  last_name                 varchar(255),
  office_id                 bigint,
  email                     varchar(255),
  level                     integer,
  xp                        integer,
  constraint pk_user primary key (id))
;

create sequence choco_seq;

create sequence office_seq;

create sequence user_seq;

alter table choco add constraint fk_choco_user_1 foreign key (user_id) references user (id) on delete restrict on update restrict;
create index ix_choco_user_1 on choco (user_id);
alter table user add constraint fk_user_office_2 foreign key (office_id) references office (id) on delete restrict on update restrict;
create index ix_user_office_2 on user (office_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists choco;

drop table if exists office;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists choco_seq;

drop sequence if exists office_seq;

drop sequence if exists user_seq;

