-- Criação do banco de dados
CREATE DATABASE vsl;

-- Criação das tabelas
CREATE TABLE clientes (
    clienteID serial primary key,
    nome varchar(50) not null,
    email varchar(100) not null,
    senha varchar(255) not null,
    telefone varchar(15),
    cpf char(11) not null unique
);

CREATE TABLE destinos (
    destinoID serial primary key,
    nomeDestino varchar(100) not null
);

CREATE TABLE voos (
    vooID serial primary key,
    piloto varchar(100) not null,
    data_ida timestamp not null,
    data_volta timestamp not null
);

CREATE TABLE passagens (
    passagemID serial primary key,
    cliente integer references clientes(clienteID),
    local_partida varchar(100) not null,
    destino integer references destinos(destinoID),
    voo integer references voos(vooID),
    valor int not null
);

CREATE TABLE fale_conosco (
    contatoID serial primary key,
    cliente integer references clientes(clienteID),
  	passagem integer references passagens(passagemID),
    mensagem text not null
);