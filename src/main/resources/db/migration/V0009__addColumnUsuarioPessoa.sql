ALTER TABLE pessoa add COLUMN usuario_id BIGINT NOT NULL DEFAULT 0;

ALTER TABLE pessoa ADD CONSTRAINT fk_usuario_pessoa FOREIGN KEY (usuario_id) references usuario(id);