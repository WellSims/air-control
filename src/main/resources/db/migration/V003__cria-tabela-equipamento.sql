create table equipamento(
	id bigint not null auto_increment,
   	nome varchar(255) not null,
   	componente_id bigint not null,
    
    	primary key (id)
);

alter table equipamento add constraint fk_componente
foreign key (componente_id) references componente (id) ON DELETE CASCADE ON UPDATE CASCADE;
