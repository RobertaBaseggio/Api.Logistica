CREATE TABLE role_usuarios(
    usuarios_id bigint not null,
    role_nome_role varchar(45) not null
);

ALTER TABLE role_usuarios ADD CONSTRAINT fk_usuarios FOREIGN KEY (usuarios_id) references usuario(id);
ALTER TABLE role_usuarios ADD CONSTRAINT fk_role FOREIGN KEY (role_nome_role) references role(nome_role);