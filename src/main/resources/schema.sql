drop table city;
drop table country;
drop table state;

create table city (
        id integer not null,
        nombre varchar,
        state blob,
        primary key (id)
    );
    
 create table country (
        id integer not null,
        nombre varchar,
        primary key (id)
    ); 
    
 create table state (
       id integer not null,
        country blob,
        nombre varchar,
        primary key (id)
    );
    
    
    
    