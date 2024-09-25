# AgenciaViajes

Este proyecto **AgenciaViajes** es una aplicación web diseñada para facilitar la reserva de viajes, que incluye la gestión de vuelos, hoteles y reservas. El proyecto está compuesto por un **frontend en Angular** y varios **microservicios en Spring Boot** que se comunican con una base de datos MySQL.

## Estructura del proyecto

El repositorio está organizado en las siguientes carpetas:

- **front-angular**: Contiene el código del frontend desarrollado en Angular.
- **microservicios-spring-boot**: Contiene los microservicios para gestionar vuelos, hoteles, y reservas.
- **db-mysql.sql**: Script de la base de datos MySQL utilizado para la aplicación.

## Características principales

1. **Registro y autenticación de usuarios**: Los usuarios pueden registrarse y acceder a la plataforma.
2. **Gestión de reservas**: Los usuarios pueden reservar vuelos y hoteles desde una única interfaz.
3. **Vuelos y hoteles dinámicos**: La lista de vuelos y hoteles se obtiene a través de llamadas a microservicios.
4. **Microservicios REST**: Los servicios de backend se exponen a través de APIs REST utilizando Spring Boot.
5. **Persistencia en MySQL**: La información de usuarios, reservas, vuelos y hoteles se almacena en una base de datos MySQL.

## Tecnologías utilizadas

- **Angular**: Para el frontend, permitiendo una experiencia de usuario fluida y moderna.
- **Spring Boot**: Para el backend, gestionando la lógica de negocio y la exposición de APIs REST.
- **MySQL**: Como base de datos relacional para almacenar la información.
- **Git**: Para el control de versiones y la colaboración en el proyecto.

## Instalación y configuración

### 1. Backend

1. Clona el repositorio:
    ```bash
    git clone https://github.com/mortymer1/AgenciaViajes.git
    ```

2. Navega a la carpeta de los **microservicios**:
    ```bash
    cd AgenciaViajes/microservicios-spring-boot
    ```

3. Configura la base de datos:
    - Crea una base de datos MySQL utilizando el script **db-mysql.sql**.
    - Actualiza las propiedades de conexión a la base de datos en los archivos de configuración de cada microservicio (`application.properties`).

4. Inicia los microservicios:
    ```bash
    mvn spring-boot:run
    ```

### 2. Frontend

1. Navega a la carpeta del frontend:
    ```bash
    cd AgenciaViajes/front-angular
    ```

2. Instala las dependencias de Angular:
    ```bash
    npm install
    ```

3. Inicia el servidor de desarrollo:
    ```bash
    ng serve
    ```

4. Accede a la aplicación en tu navegador:
    ```
    http://localhost:4200
    ```

## Endpoints de microservicios

- **Microservicio de clientes**: `http://localhost:10000/clientes`
- **Microservicio de vuelos**: `http://localhost:10003/vuelos`
- **Microservicio de hoteles**: `http://localhost:10001/hoteles`
- **Microservicio de reservas**: `http://localhost:10002/reservas`

## Uso de la aplicación

1. **Registro**: El usuario puede registrarse proporcionando datos como nombre, contraseña, dirección, etc.
2. **Autenticación**: Después de registrarse, el usuario puede iniciar sesión con su nombre y contraseña.
3. **Reservas**: Tras iniciar sesión, el usuario puede realizar reservas seleccionando un destino, hotel y vuelo.
4. **Mis Reservas**: El usuario puede revisar sus reservas anteriores desde la sección "Mis Reservas".


