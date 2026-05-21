drop database adocao;
create database adocao;
use adocao;

create table adocao (
idadocao int auto_increment primary key,
nome varchar(100) not null,
idade varchar (4) not null,
tipo enum ('CACHORRO','GATO','PAPAGAIO','CHINCHILA') not null,
raca varchar (30),
endereco varchar(100)not null,
telefone varchar (11) not null
);
SELECT * FROM adocao
WHERE nome = 'igor';