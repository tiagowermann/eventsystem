CREATE TABLE IF NOT EXISTS evento(
	id serial PRIMARY KEY,
	descricao varchar(255),
	data_hora_inicio timestamp,
	data_hora_termino timestamp,
	data_criacao timestamp,
        local_evento varchar(255)
);

