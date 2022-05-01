CREATE TABLE IF NOT EXISTS inscricaonoevento(
        id serial PRIMARY KEY,
        id_evento integer not null,
        id_usuario integer not null,
        data_inscricao timestamp,
        CONSTRAINT fk_inscricao_usuario FOREIGN KEY(id_usuario) REFERENCES usuario(id),
        constraint fk_inscricao_evento FOREIGN KEY (id_evento) references evento(id)
);