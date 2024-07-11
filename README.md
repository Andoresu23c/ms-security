# Microservicio de Seguridad (ms-security)

## Descripción

El microservicio `ms-security` se encarga de gestionar todas las funcionalidades relacionadas con la seguridad del sistema, tales como:

- Autenticación de usuarios (login).
- Creación de cuentas de usuario.
- Recuperación de contraseñas.
- Gestión de tokens JWT.

## Estructura del Proyecto

```
ms-security
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── yourcompany
│   │   │           └── mssecurity
│   │   │               ├── controller
│   │   │               │   └── AuthController.java
│   │   │               ├── service
│   │   │               │   └── AuthService.java
│   │   │               ├── repository
│   │   │               │   └── UserRepository.java
│   │   │               ├── model
│   │   │               │   ├── User.java
│   │   │               │   └── Role.java
│   │   │               ├── dto
│   │   │               │   ├── LoginRequest.java
│   │   │               │   ├── SignupRequest.java
│   │   │               │   └── JwtResponse.java
│   │   │               ├── exception
│   │   │               │   └── CustomException.java
│   │   │               ├── config
│   │   │               │   ├── SecurityConfig.java
│   │   │               │   └── JwtUtils.java
│   │   │               └── MsSecurityApplication.java
│   │   ├── resources
│   │   │   ├── application.properties
│   │   │   └── application-dev.properties
│   │   └── docker
│   │       └── Dockerfile
│   └── test
│       └── java
│           └── com
│               └── yourcompany
│                   └── mssecurity
│                       └── AuthServiceTests.java
├── pom.xml
└── README.md
```

## Requisitos Previos

- JDK 11 o superior
- Maven 3.6.3 o superior
- Docker (opcional, para contenedorización)

## Configuración del Proyecto

### Configuración de Maven

Asegúrate de tener Maven instalado y configurado en tu sistema. Puedes verificar la instalación con el siguiente comando:

```sh
mvn -v
```

### Dependencias

El archivo `pom.xml` incluye todas las dependencias necesarias para el proyecto. Asegúrate de incluir las siguientes dependencias en tu `pom.xml`:

```xml
<dependencies>
    <!-- Dependencias de Spring Boot -->
    <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
    <!-- Dependencias de prueba -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

### Configuración de Seguridad

El archivo `SecurityConfig.java` contiene la configuración de seguridad para manejar la autenticación y autorización. Asegúrate de configurarlo adecuadamente según tus necesidades.

### Configuración de JWT

El archivo `JwtUtils.java` contiene utilidades para la generación y validación de tokens JWT. Configura las propiedades JWT en `application.properties`:

```properties
jwt.secret=yourSecretKey
jwt.expirationMs=86400000
```

## Ejecución del Proyecto

Para ejecutar el proyecto localmente, utiliza el siguiente comando de Maven:

```sh
mvn spring-boot:run
```

## Contenedorización con Docker

El proyecto incluye un `Dockerfile` para contenedorización. Para construir y ejecutar la imagen Docker, utiliza los siguientes comandos:

```sh
# Construir la imagen Docker
docker build -t ms-security .

# Ejecutar el contenedor
docker run -p 8080:8080 ms-security
```

## Endpoints

### Autenticación

- `POST /api/auth/login`: Iniciar sesión
- `POST /api/auth/signup`: Crear cuenta
- `POST /api/auth/recover`: Recuperar contraseña

## Contribuciones

Si deseas contribuir al proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Agregar nueva funcionalidad'`).
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo los términos de la licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.
