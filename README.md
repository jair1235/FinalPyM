# FinalPyM
Sistema de Inventario – Tienda de Doña Rosa

Este proyecto es una aplicación web desarrollada con Spring Boot que permite gestionar el inventario de una tienda. La aplicación fue construida como solución a un caso propuesto, donde se requiere administrar productos, controlar existencias y obtener información clave del inventario.



Descripción del problema

Doña Rosa necesita una aplicación que le permita:

Registrar productos nuevos.

Actualizar los productos existentes (precio, cantidad o nombre).

Eliminar productos que ya no estén disponibles.

Conocer cuál es el producto más cercano a agotarse.

Calcular el costo total del inventario.

La aplicación debe ser web, usar una base de datos, permitir operaciones desde el navegador y validar los datos ingresados.

Funcionalidades implementadas

La aplicación cumple con los siguientes requerimientos:

Gestión de productos

Insertar productos nuevos.

Actualizar productos existentes:

Precio

Cantidad

Nombre

Eliminar productos del inventario.

Consultas adicionales

Obtener el producto más cercano a acabarse.

Calcular el costo total del inventario (precio × cantidad).

Otras características

Aplicación web con Spring MVC y Thymeleaf.

Persistencia de datos con JPA y base de datos MySQL.

Validación básica de datos.

Arquitectura en capas:

Controller

Service

Repository

Entity

Tecnologías utilizadas

Java 17

Spring Boot

Spring MVC

Spring Data JPA

Thymeleaf

MySQL

Maven
SOLUCIÓN A PREGUNTAS: 
Base de datos

Se utiliza MySQL como motor de base de datos.

El archivo data/tienda.sql contiene un respaldo de la base de datos.

El archivo src/main/resources/data.sql permite cargar datos iniciales automáticamente al iniciar la aplicación.

Seguridad y confiabilidad de los datos

Los datos se almacenan en una base de datos relacional persistente.

El uso de JPA garantiza integridad y consistencia.

Las operaciones de modificación se validan desde la capa de servicio.

¿Cómo se comprueba que la aplicación funciona?

Las operaciones CRUD pueden ejecutarse desde el navegador.

Los cambios se reflejan inmediatamente en la vista.

El inventario se actualiza correctamente después de cada operación.

Los cálculos (producto más cercano a agotarse y costo total) reflejan los datos reales almacenados.

Evidencia de funcionamiento

Inserción, actualización y eliminación de productos desde la interfaz web.

Persistencia correcta de los datos en la base de datos.

Visualización correcta del inventario usando Thymeleaf.

Autor JAIR NEUTA

Proyecto desarrollado como práctica académica para la gestión de inventarios usando Spring Boot
