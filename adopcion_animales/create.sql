
    create table adopciones (
       id_adopcion bigint not null auto_increment,
        fecha_adopcion datetime(6),
        id_adoptante bigint,
        id_animal bigint,
        primary key (id_adopcion)
    ) engine=InnoDB;

    create table adoptantes (
       id bigint not null auto_increment,
        apellido varchar(255),
        direccion varchar(255),
        email varchar(255),
        nombre varchar(255),
        telefono integer,
        primary key (id)
    ) engine=InnoDB;

    create table alberge (
       id bigint not null auto_increment,
        asociacion varchar(255),
        direccion varchar(255),
        email varchar(255),
        telefono integer,
        primary key (id)
    ) engine=InnoDB;

    create table animales (
       id bigint not null auto_increment,
        fecha_entrada datetime(6),
        fecha_salida datetime(6),
        nombre varchar(255),
        patologia varchar(255),
        raza varchar(255),
        tipo integer,
        primary key (id)
    ) engine=InnoDB;

    create table empleados (
       id bigint not null auto_increment,
        cargo varchar(255),
        especializacion varchar(255),
        nombre varchar(255),
        primary key (id)
    ) engine=InnoDB;
