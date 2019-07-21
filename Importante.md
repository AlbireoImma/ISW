En caso que spring no pueda conectarse a la BD, verificar el archivo application.properties en src/main/resources

>>spring.jpa.hibernate.ddl-auto=none !!! En caso que no existan las tablas usar create o update
spring.datasource.url=jdbc:mysql://localhost:3306/barbatos
spring.datasource.username=root
spring.datasource.password=root

En caso que aun continue fallando modificar los permisos de la base de datos

>>ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'root';

Correr phpmyadmin via docker puerto 10000 (suponiendo que esta usado el 8080 con spring)

>>docker run --name myadmin -d --link container-db:db -p 10000:80 phpmyadmin/phpmyadmin

Persistencia de datos para el docker mysql (tambien se le puede pasar un directorio en el flag -v)

>>docker volume create nombre-volumen
docker run --name nombre-container -v mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:latest

Correr MySQL en un docker

>>docker run --name nombre-container -v mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -p 3306:3306 -d mysql:latest
