create database vendas;

use vendas;

create table cliente (
id int primary key auto_increment,
nome varchar(100),
cpf varchar(14) unique,
email varchar(100),
telefone varchar(15),
endereco varchar(150),
nascimento DATE);

select * from cliente;