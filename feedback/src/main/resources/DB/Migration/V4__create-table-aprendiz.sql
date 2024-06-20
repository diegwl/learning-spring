create table aprendiz (
    id integer not null auto_increment,
    ativo bool,
    curso varchar(255),
    edv varchar(255),
    email varchar(255),
    ferias bool,
    faculdade varchar(255),
    idade integer,
    trilha varchar(255),
    turma varchar(255),
    nome varchar(255),
    primary key (id)
);
