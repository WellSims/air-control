create table agenda(
	id bigint not null auto_increment,
   	dia_semana varchar(60) not null,
	comando varchar(60) not null,
   	equipamento_id bigint not null,
    
    	primary key (id)
);

alter table agenda add constraint fk_equipamento
foreign key (equipamento_id) references equipamento (id) ON DELETE CASCADE ON UPDATE CASCADE;
