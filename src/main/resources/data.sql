drop table if EXISTS phones;
drop table if EXISTS usuarios;

CREATE TABLE usuarios (
  id uuid default random_uuid()  PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  created Date not null,
  modified Date not null,
  lastLogin Date not null,
  active VARCHAR(1) not null,
  token VARCHAR(250)
);

CREATE TABLE phones (
  id uuid default random_uuid()  PRIMARY KEY,
  id_user uuid ,
  number VARCHAR(250)  NULL,
  citycode VARCHAR(3)  NULL,
  countrycode VARCHAR(3) NULL
);

ALTER TABLE phones
    ADD FOREIGN KEY (id_user) 
    REFERENCES usuarios(id);


 -- Insert Para Pruebas   
 INSERT INTO USUARIOS  ( ID , NAME , PASSWORD ,EMAIL, CREATED,MODIFIED,LASTLOGIN,ACTIVE )
 VALUES ('123','NombrePrueba','Mipass23','test@test.com',sysdate,sysdate,sysdate,1);

