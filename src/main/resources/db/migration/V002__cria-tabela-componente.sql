create table componente(
	id bigint not null auto_increment,
    	nome varchar(60) not null,
	status varchar(255) not null,
      localizacao_id bigint not null,

   	primary key (id)
);

alter table componente add constraint fk_localizacao
foreign key (localizacao_id) references localizacao (id) ON DELETE CASCADE ON UPDATE CASCADE;
