INSERT INTO GENEROS (nombre) VALUES ('TERROR');
INSERT INTO GENEROS (nombre) VALUES ('COMEDIA');
INSERT INTO GENEROS (nombre) VALUES ('ROMANTICA');
INSERT INTO GENEROS (nombre) VALUES ('ANIMADA');
INSERT INTO GENEROS (nombre) VALUES ('THRILLER');
INSERT INTO GENEROS (nombre) VALUES ('CIFI');


INSERT INTO PELICULA_SERIES (titulo, calificacion, CREATION_DATE) VALUES ('Hombres de negro', 10, NOW());
INSERT INTO PELICULA_SERIES (titulo, calificacion, CREATION_DATE) VALUES ('SHREK', 10, NOW());


INSERT INTO PERSONAJES (nombre, edad, peso, historia, filme_id) VALUES ('SHREK', '30', '120', 'Un ogro', 2);
INSERT INTO PERSONAJES (nombre, edad, peso, historia, filme_id) VALUES ('FIONA', '30', '50', 'Una princesa', 2);

INSERT INTO PERSONAJES (nombre, edad, peso, historia, filme_id) VALUES ('Agente K', '60', '60', 'Un agente por retirarse', 1);
INSERT INTO PERSONAJES (nombre, edad, peso, historia, filme_id) VALUES ('Agente J', '30', '75', 'Un policia despedido', 1);

INSERT INTO pelicula_genero (pelicula_id, genero_id) VALUES (1, 2);
INSERT INTO pelicula_genero (pelicula_id, genero_id) VALUES (1, 6);

INSERT INTO pelicula_genero (pelicula_id, genero_id) VALUES (2, 2);
INSERT INTO pelicula_genero (pelicula_id, genero_id) VALUES (2, 3);
INSERT INTO pelicula_genero (pelicula_id, genero_id) VALUES (2, 4);