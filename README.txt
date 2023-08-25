Este programa fue desarrolado con fines educativos por:
	*Ulises Becerril Valdés
	*Octavio Daniel Rogríguez González

Es un programa que inserta dentro de una base de datos de Apache Derby, una imagen como tipo de dato BLOB, su nombre y su descripción.
Así mismo, el programa puede consultar de nuevo las imagenes insertadas y devolver sus valores.

Para poder hacer uso del programa, es necesrio contar con una instacia de base de datos Derby en la cual se debe crear un esquema llamado BLOBCollection
y dentro del cual debe existir una tabla "datos" con los campos id, nombre, descripcion y objeto, siendo este ultimo la imagen a insertar en sí.

Para poder crear la tabla se recomienda la siguente sentencia SQL:

CREATE TABLE datos (id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY, nombre VARCHAR(255), descripcion VARCHAR(255), objeto BLOB);

El código completo de este programa puede ser encontrado en:
https://github.com/ubecerrilv/CRUDCDD.git

Para más información, contactar con los autores:
Ulises Becerril Valdés: ulisesbecerril81@gmail.com
Octavio Daniel Rodríguez González: octaviorogo17@gmail.com