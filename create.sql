create table tb_task (id bigserial not null, description varchar(255), user_id bigint, primary key (id));
create table tb_user (id bigserial not null, password varchar(255), username varchar(255), primary key (id));
alter table if exists tb_task add constraint FKekk0jr4msqy626yiiiyrikprb foreign key (user_id) references tb_user;
