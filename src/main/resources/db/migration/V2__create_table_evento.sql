CREATE TABLE evento(
	id serial PRIMARY KEY,
	descricao varchar(255),
	data_hora timestamp,
	data_criacao timestamp,
	usuario_id integer,
	CONSTRAINT fk_evento_usuario FOREIGN KEY(usuario_id) REFERENCES usuario(id)
);

