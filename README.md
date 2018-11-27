# logging-util
An logging implementation example 

Pasos para ejecutar correctamente la aplicación.
1. Crear en la ruta deseada la siguiente estructura de carpetas [Unidad]:\LoggingUtil\

2. En el codigo fuente, en la Clase pe.com.vitucheando.logging.util.Constants, ubicar la constante PATH_DEFAULT_PROPERTIES y asignarle el valor de la ruta creada en el punto 1.

3. En la ruta creada en el punto 1, crear las siguientes carpetas
- /config
- /log

4. En la ruta [Unidad]:\LoggingUtil\config\ crear el archivo logging-init.properties y agregar el siguiente contenido
#Valores fijo para la aplicacion Loggin-Util 
logging.to=CONSOLE
logging.level=WARNING

logging.path.file=D:\\LoggingUtil\\log\\logapp.log

logging.db.hostname=[Agregar el host de la BD a la que se desea conectar]
logging.db.port=[Agregar el puerto de la BD a la que se desea conectar]
logging.db.user=[Agregar el usuario de la BD a la que se desea conectar]
logging.db.sid=[Agregar el SID de la BD a la que se desea conectar]
logging.db.password=[Agregar el password de la BD a la que se desea conectar]

5. En la ruta [Unidad]:\LoggingUtil\log\ crear el archivo logapp.log

6. Para probar los escenarios
- Escribir el log en Consola, cambiar en el archivo logging-init.properties el valor de la clave logging.to a CONSOLE
- Escribir el log en Archivo, cambiar en el archivo logging-init.properties el valor de la clave logging.to a FILE
- Escribir el log en BD, cambiar en el archivo logging-init.properties el valor de la clave logging.to a DATABASE

7. En la aplicación, ejecutar el Test1.java
