# Gestión de Turnos

Este proyecto es una aplicación web para la gestión de turnos, que permite a los usuarios realizar diversas operaciones relacionadas con la programación y seguimiento de turnos.

## Supuestos

- El apartado de listado de turnos podria ser solo visible para el administrador y que el se encargara de cambiar el estado de los turnos o eliminarlos.
- Se da por hecho que el usuario conoce la aplicacion y no va a introducir datos erroneos.

## Funcionalidades

- **Programación de nuevos turnos:** Permite a los usuarios programar nuevos turnos ingresando la fecha, hora y descripción del turno, por defecto los turnos se crean con un estado en espera.
- **Visualización de turnos programados:** Muestra en una interfaz la lista de turnos programados, incluyendo detalles como la fecha, hora y estado del turno.
- **Filtrado de turnos por fecha y estado:** Permite a los usuarios filtrar los turnos por fecha y estado, mostrando únicamente los turnos que cumplen con los criterios especificados.
- **Actualización del estado de los turnos:** Permite a los administradores actualizar el estado de los turnos, cambiando entre diferentes estados como "En espera", "Ya atendido".
- **Eliminación de turnos:** Permite a los administradores eliminar turnos previamente programados.

## Tecnologías Utilizadas

- Java: Lenguaje de programación utilizado para el backend de la aplicación.
- Java Servlet: Utilizado para la comunicación entre el frontend y el backend.
- JPA (Java Persistence API): Utilizado para el mapeo objeto-relacional y la interacción con la base de datos.
- MySQL: Base de datos utilizada para almacenar la información de los turnos.
- HTML: Utilizado para la estructura de las páginas web.
- Bootstrap: Framework de CSS utilizado para el diseño de la interfaz.
- Git (control de versiones)

## Estructura del Proyecto

/
|-- src/ # Código fuente Java
|-- WebContent/ # Contenido web (archivos JSP)
|-- lib/ # Bibliotecas externas
|-- META-INF/ # Archivos de metadatos del proyecto
|-- README.md # Archivo README

## Instrucciones de Uso

1. Clona este repositorio en tu máquina local.
2. Configura tu base de datos MySQL y actualiza la configuración de conexión en el archivo `persistence.xml`.
3. Compila y ejecuta el proyecto desde tu IDE.
4. Accede a la aplicación desde tu navegador web e interactúa con las diferentes funcionalidades proporcionadas.

## Requisitos del Sistema

- Java JDK 8 o superior
- Servidor de aplicaciones compatible con Servlets (por ejemplo, Apache Tomcat)
- Base de datos MySQL

## Pruebas Realizadas

- **Programación de nuevos turnos:** Se crean nuevos turnos ingresando la fecha, hora y descripción.
- **Visualización de turnos programados:** Se muestra en la interfaz la lista de turnos programados con sus detalles correspondientes.
- **Filtrado de turnos por fecha y estado:** Se filtran los turnos según la fecha y estado especificados, mostrando solo los turnos que cumplen con los criterios seleccionados.
- **Actualización del estado de los turnos:** Se actualiza el estado de los turnos, cambiando entre los diferentes estados disponibles.
- **Eliminación de turnos:** Se eliminan turnos previamente programados mediante la interfaz de usuario.
- **Si se introduce una ID de ciudadano que no existe en la base de datos al intentar crear un turno, redirige a una página de error.

## Créditos

- Bootstrap: [Sitio web oficial de Bootstrap](https://getbootstrap.com/)
- MySQL Connector/J: [Sitio web oficial de MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)


## Notas Adicionales

- Si encuentras algún error o tienes alguna idea de mejora, no dudes en informarme.
- Para informes de errores, proporciona detalles específicos y pasos para reproducir el problema.
