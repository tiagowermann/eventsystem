CREATE TABLE IF NOT EXISTS usuario (
  id SERIAL NOT NULL,
  nome VARCHAR(50) NOT NULL,
  sobrenome VARCHAR(50) NOT NULL,
  email VARCHAR(45) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  PRIMARY KEY (id)
);



CREATE TABLE IF NOT EXISTS evento(
	id serial PRIMARY KEY,
	descricao varchar(255),
	data_hora_inicio timestamp,
	data_hora_termino timestamp,
	data_criacao timestamp,
    local_evento varchar(255)
);



CREATE TABLE IF NOT EXISTS login(
	id serial PRIMARY KEY,
	nome varchar(255),
	usuario varchar(255),
	senha varchar(255)
);



INSERT INTO login(id, nome, usuario, senha)
VALUES(nextval('login_id_seq'), 'admin', 'admin', '$2a$10$spuYmIqTfhPQnKJFgxSP5eqqTA0qNzvNaDWOngiLRwqWYltgMVX6K');




CREATE TABLE IF NOT EXISTS inscricao(
        id serial PRIMARY KEY,
        id_evento integer not null,
        id_usuario integer not null,
        data_inscricao timestamp,
        CONSTRAINT fk_inscricao_usuario FOREIGN KEY(id_usuario) REFERENCES usuario(id),
        constraint fk_inscricao_evento FOREIGN KEY (id_evento) references evento(id)
);