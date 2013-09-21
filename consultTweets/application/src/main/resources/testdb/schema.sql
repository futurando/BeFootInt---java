drop table T_TWITTER if exists;
drop table T_LISTS if exists;
create table T_TWITTER(ID varchar(20) primary key, TEXT varchar(160), CREATED_AT datetime not null, FROM_USER varchar(50), TWITTER_ID varchar(50), PROFILE_IMAGE_URL varchar(50), LIST_ID varchar(20));
create table T_LISTS (ID varchar(20) primary key, NAME varchar(160), CREATED_AT datetime not null);

alter table T_TWITTER add constraint FK_TWITTER foreign key (LIST_ID) references T_LISTS(ID) on delete cascade;