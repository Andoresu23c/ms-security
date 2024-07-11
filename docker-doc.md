# Documentación para Dockerizar el Proyecto

## Requisitos previos

1. Docker Desktop instalado en tu máquina (Windows o Mac).
2. El repositorio del proyecto clonado en tu máquina local.

## Paso 1: Crear la imagen de la base de datos

1. Crea el Dockerfile para la base de datos con el siguiente contenido:

    ```Dockerfile
    # Usa la imagen oficial de PostgreSQL
    FROM postgres:13

    # Establece variables de entorno para configurar la base de datos
    ENV POSTGRES_DB=mydatabase
    ENV POSTGRES_USER=user
    ENV POSTGRES_PASSWORD=password

    # Expone el puerto 5432
    EXPOSE 5432
    ```
    1.1 Abrimos la terminal y nos ubicamos en la carpeta que contiene el archivo docker-compose.yml
    ```bash
    docker compose up
    ```

2. Construye la imagen de Docker:

    ```bash
    docker build -t mydatabase:latest -f Dockerfile-postgres .
    ```

## Paso 2: Crear la imagen del microservicio

1. Asegúrate de tener el jar del proyecto generado en la carpeta `target`.
2. Crea el Dockerfile para el microservicio con el siguiente contenido:

    ```Dockerfile
    # Usa una imagen base de OpenJDK
    FROM openjdk:17-jdk-slim

    # Establece el directorio de trabajo dentro del contenedor
    WORKDIR /app

    # Copia el jar del proyecto al contenedor
    COPY target/myapp.jar /app/myapp.jar

    # Expone el puerto en el que correrá la aplicación
    EXPOSE 8080

    # Comando para ejecutar la aplicación
    ENTRYPOINT ["java", "-jar", "myapp.jar"]
    ```

3. Construye la imagen de Docker:

    ```bash
    docker build -t myapp:latest .
    ```

## Paso 3: Correr los contenedores

1. Correr el contenedor de la base de datos:

    ```bash
    docker run -d --name mydatabase -e POSTGRES_PASSWORD=password -e POSTGRES_DB=mydatabase -e POSTGRES_USER=user -p 5432:5432 mydatabase:latest
    ```

2. Correr el contenedor del microservicio:

    ```bash
    docker run -d --name myapp --link mydatabase:postgres -p 8080:8080 myapp:latest
    ```

Ahora deberías tener tu base de datos y tu microservicio corriendo en contenedores Docker. Spring Boot se encargará de crear las tablas y las relaciones según tus entidades.

### Paso 5: Ejecución y verificación

1. **Inicia Docker Desktop** y asegúrate de que esté corriendo.
2. **Clona tu repositorio** del proyecto en tu máquina local.
3. **Abre una terminal** en la raíz de tu proyecto y sigue los pasos de la documentación (`docker-doc.md`) para construir y ejecutar las imágenes Docker.
