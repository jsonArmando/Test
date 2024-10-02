# Proyecto de Spring Boot

Este es un proyecto de ejemplo utilizando Spring Boot, JPA, y H2 Database.

## Requisitos

- Java 17
- Maven 3.6.0 o superior

## Configuración del Proyecto

### Clonar el Repositorio

```sh
git clone https://github.com/tu-usuario/tu-repositorio.git
cd tu-repositorio
```

### Compilar y Construir el Proyecto

Para limpiar y construir el proyecto, ejecuta los siguientes comandos en la raíz del proyecto:

```sh
mvn clean install
```

### Ejecutar la Aplicación

Para ejecutar la aplicación, usa el siguiente comando:

```sh
mvn spring-boot:run
```

### Probar la API

Puedes probar la API utilizando `curl` o cualquier herramienta de tu elección como Postman. Aquí tienes ejemplos de cómo registrar un usuario e iniciar sesión utilizando `curl`:

1. Registrar un nuevo usuario:

```sh
curl --location 'http://localhost:8080/api/auth/register' \
--header 'Content-Type: application/json' \
--data-raw '{
  "name": "Juan Rodriguez",
  "email": "juan@rodriguez.org",
  "password": "Hunter2@",
  "phones": [
    {
      "number": "1234567",
      "citycode": "1",
      "countrycode": "57"
    }
  ]
}'
```

2. Iniciar sesión con el usuario registrado:

```sh
curl --location 'http://localhost:8080/api/auth/login' \
--header 'Content-Type: application/json' \
--data-raw '{
  "email": "juan@rodriguez.org",
  "password": "Hunter2@"
}'
```

### Configuración de la Base de Datos H2

La aplicación está configurada para usar H2 Database en memoria. Puedes acceder a la consola de H2 Database en la siguiente URL:

```
http://localhost:8080/h2-console
```

Usa las siguientes credenciales para iniciar sesión:

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **User Name:** `sa`
- **Password:** `password`

### Estructura del Proyecto

- **src/main/java/com/assessment:** Contiene las clases principales del proyecto.
  - **controller:** Controladores REST.
  - **entities:** Entidades JPA.
  - **repositories:** Repositorios JPA.
  - **services:** Servicios de negocio.
  - **security:** Clases relacionadas con la seguridad y JWT.
- **src/main/resources:** Contiene los archivos de configuración.
  - **application.properties:** Configuración de la aplicación.

### Dependencias Principales

- **Spring Boot Starter Data JPA:** Para la persistencia de datos.
- **Spring Boot Starter Web:** Para construir aplicaciones web, incluyendo RESTful.
- **Spring Boot Starter Security:** Para la seguridad de la aplicación.
- **H2 Database:** Base de datos en memoria para desarrollo y pruebas.
- **Lombok:** Para reducir el código boilerplate.
- **JJWT:** Para la implementación de JSON Web Tokens.

### Anotaciones de Lombok

Este proyecto utiliza Lombok para generar constructores, getters y setters automáticamente. Asegúrate de tener instalado el plugin de Lombok en tu IDE.

### Problemas Comunes

- **Error de Sintaxis en SQL:** Si ves un error relacionado con la palabra reservada `user`, asegúrate de que el nombre de la tabla esté escapado o cambiado a un nombre no reservado.
- **Problemas con JWT:** Asegúrate de que la clave secreta en `application.properties` sea lo suficientemente larga (al menos 256 bits).

### Contribuir

Si deseas contribuir a este proyecto, por favor sigue los siguientes pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva funcionalidad'`).
4. Sube tus cambios (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

### Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.