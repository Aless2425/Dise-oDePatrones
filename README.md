# Sistema de Biblioteca CRUD

Este es un proyecto básico que implementa un sistema de biblioteca utilizando Java, con operaciones CRUD (Crear, Leer, Actualizar, Eliminar) para gestionar libros. El sistema permite agregar nuevos libros a la base de datos y mostrar una lista de todos los libros registrados en una interfaz gráfica.

## Descripción

El sistema está diseñado para realizar las siguientes operaciones:

- **Agregar un libro**: Permite ingresar información sobre un libro (título, autor, año, género, ISBN) y agregarlo a la base de datos.
- **Listar libros**: Muestra todos los libros almacenados en la base de datos en un área de texto dentro de la interfaz gráfica.

El sistema está basado en una conexión a MySQL para gestionar la base de datos y utiliza `JDBC` para realizar las operaciones de la base de datos. La base de datos está configurada con una tabla llamada `libro`, que tiene los siguientes campos:

- `id` (INT, PRIMARY KEY, AUTO_INCREMENT)
- `titulo` (VARCHAR)
- `autor` (VARCHAR)
- `anio` (INT)
- `genero` (VARCHAR)
- `isbn` (VARCHAR)

## Tecnologías utilizadas

- **Java**: El lenguaje principal para el desarrollo de la aplicación de escritorio.
- **JDBC (Java Database Connectivity)**: Para conectar y operar con la base de datos MySQL.
- **MySQL**: Base de datos relacional para almacenar los libros.

## Requisitos

- **Java 8 o superior**: Asegúrate de tener Java instalado en tu máquina.
- **MySQL**: Debes tener una instancia de MySQL corriendo en tu máquina.
- **Base de datos "espagueti"**: Debes crear una base de datos llamada `espagueti` en MySQL con la tabla `libro`.

## Instrucciones

1. **Clona el repositorio**:

   ```bash
   git clone [https://github.com/TuUsuario/NombreDelRepositorio.git](https://github.com/Aless2425/Dise-oDePatrones.git)
