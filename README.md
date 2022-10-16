
# Prueba Aldeco: Bartender

## Información de API

    http://localhost:8080/api/<Q>/<id>

## Descripción

El API recibe un numero de iteraciones Q y un número del 1 al 5 que representara el id de la pila de datos a trabajar (script de DB entregados) y entregue el array de respuesta

- Q = número de iteraciones
- id = número Id de la base de datos

En el archivo **aplicaction.properties** se encuentran dos configuraciones para la carga de datos en un ambiente en memoria con la base H2 y posteriormente se agregaron configuraciones para ponectarse a una base de datos MySQL.

### H2
    spring.datasource.url=jdbc:h2:mem:bartender;mode=mysql
    spring.datasource.driverClassName=org.h2.Driver
    spring.datasource.username=sa
    spring.datasource.password=password
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    
    #Loading schema.sql before
    spring.jpa.hibernate.ddl-auto=none

### MySql
    spring.datasource.url=jdbc:mysql://localhost:3306/bartender
    spring.datasource.username=<user>
    spring.datasource.password=<pass>
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
    spring.jpa.generate-ddl=true
    logging.level.org.hibernate.SQL=debug
