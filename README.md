# possumus
Ejercicio técnico

A continuación se detallan los pasos para realizar la comprobación del ejercicio.

#1. crear la base de datos mysql ejecutando desde consola mysql
mysql> create database possumus;
mysql> GRANT ALL PRIVILEGES ON possumus.* TO 'rrhh'@'localhost' IDENTIFIED BY 'rrhh';
mysql>  flush privileges;

#2. correr desde consola 
mvn spring-boot:run

#3. documentacion de endpoints
ingresar a la url http://localhost:8080/api/swagger-ui.html
