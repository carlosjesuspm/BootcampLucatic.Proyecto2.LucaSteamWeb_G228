CREATE DATABASE lucasteam;

USE lucasteam;

CREATE TABLE editor(
    id int not null auto_increment,
    editor varchar(100) not null,
    primary key  (id)
);

CREATE TABLE plataforma(
    id int not null auto_increment,
    plataforma varchar(100) not null,
    primary key (id)
);

CREATE TABLE genero(
    id int not null auto_increment,
    genero varchar(100) not null,
    primary key (id)
);

CREATE TABLE juegos(
    id int not null auto_increment,
    rango int not null,
    nombre varchar (150) not null,
    id_plataforma int not null,
    fecha int(4),
    id_genero int not null,
    id_editor int not null,
    NA_ventas double,
    EU_ventas double,
    JP_ventas double,
    otras_ventas double,
    ventas_globales double,
    primary key (id),
    foreign key (id_genero) references genero(id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (id_plataforma) references plataforma(id) ON DELETE CASCADE ON UPDATE CASCADE,
    foreign key (id_editor) references editor(id) ON DELETE CASCADE ON UPDATE CASCADE
    );

Enviar mensaje a #notas-recursos
