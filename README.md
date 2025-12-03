# Proyecto Final TechLab – Spring Boot + MySQL

Este es un proyecto backend desarrollado con **Spring Boot**, utilizando **MySQL** como base de datos.  
El objetivo es permitir una configuración sencilla y segura mediante **variables de entorno**, evitando exponer credenciales dentro del repositorio.

---

## 🚀 Tecnologías utilizadas

- **Java 21+**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **MySQL**
- **Maven**
- **Hibernate**
- **JPA**
- **Variables de entorno (ENV)**

---

## ⚙️ Configuración previa

Antes de ejecutar la aplicación, necesitás:

1. Tener **MySQL instalado** y corriendo.
2. Configurar las siguientes variables de entorno:

  | Variable       | Descripción                              |
  |----------------|-------------------------------------------|
  | `DB_URL`       | URL JDBC de conexión a la base de datos   |
  | `DB_USER`  | Usuario de MySQL                          |
  | `DB_PASSWORD`  | Contraseña del usuario                    |

   DB_URL=jdbc:mysql://localhost:3306/techlabdb?createDatabaseIfNotExist=true&useSSL=false

## 🤝 Endpoints disponibles
- GET /productos?nombre=... (Query Param opcional)
- GET /productos/{id}
- POST /productos
- PUT /productos/{id}
- DELETE /productos/{id}
