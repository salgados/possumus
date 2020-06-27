# possumus
Ejercicio tecnico

A continuacion se detallan los pasos para ejecutar el ejercicio.

#crear la base de datos mysql ejecutando desde consola mysql
mysql> create database possumus;
mysql> GRANT ALL PRIVILEGES ON possumus.* TO 'rrhh'@'localhost' IDENTIFIED BY 'rrhh';

#correr desde consola 
mvn spring-boot:run
