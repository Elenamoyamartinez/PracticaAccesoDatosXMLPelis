# Proyecto de Acceso a Datos XML con Java

Este proyecto permite realizar búsquedas en un archivo XML que contiene información sobre películas. Utiliza Java y XML para extraer y mostrar datos como el título, director y actor de una película, basándose en una búsqueda proporcionada por el usuario.

## Descripción

Este proyecto consta de dos partes principales:

1. **XML**: Contiene un conjunto de películas con detalles como título, director y actor. La estructura de este archivo está definida por un archivo DTD.
2. **Java**: Un programa que permite al usuario buscar por título, director o actor. El programa lee el archivo XML, parsea los datos y muestra los resultados que coinciden con la búsqueda.

### Flujo de la aplicación:

- El usuario ingresa un término de búsqueda.
- El programa busca ese término en los campos de director, título o actor de cada película.
- Si se encuentra una coincidencia, se muestran los detalles de la película.
- Si no se encuentran resultados, el programa informa al usuario.

## Estructura del Proyecto

 **PracticaAccesoDatosXMLPelis.java**: Clase principal que realiza la lectura y búsqueda de datos en el archivo XML.
- **xmlData1.xml**: Archivo XML que contiene la información de las películas.
- **xmlData1.dtd**: Documento de definición de tipo de documento (DTD) que define la estructura del archivo XML.
