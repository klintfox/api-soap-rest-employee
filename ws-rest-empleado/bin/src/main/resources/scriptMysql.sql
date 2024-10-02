create database test;
use test;
create  table empleado (
id int primary key auto_increment,
nombres varchar(40),
apellidos varchar(40),
tipo_documento varchar(30),
numero_documento varchar(10), 
fecha_nacimiento date,
fecha_vinculacion date,
cargo varchar(40),
salario decimal(10,2)
);

select * from empleado;