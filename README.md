## Reto 2: Programacion en Java I

**Implementar una api rest para gestion de blogs.**

### Diagrama de clases

<p>
<a href="https://ibb.co/d6gH4m6"><img src="https://i.ibb.co/2PNp3ZP/Screen-Shot-2022-02-11-at-08-39-00.png" alt="Screen-Shot-2022-02-11-at-08-39-00" border="0"></a><br /><a target='_blank' href='https://imgbb.com/'>bild 3 2</a>
</p>

### Criterios de aceptacion:

- Los estados del blog son: activo, inactivo.
- Los estados del post son: borrador, publicado.
- Un autor puede tener maximo 3 blogs.
- Solo pueden tener blogs los autores mayores a 18 anios.
- Solo se puede publicar un post por dia.
- Solo se puede registrar posts en blogs en estado activo.
- Solo se pueden registrar comentarios en post en estado publicado.
- Al eliminar un autor, debe realizarse una eliminacion en cadena sus blogs, post y comentarios.
- Agregar los datos de prueba (script SQL) necesarios para validar los requerimientos.

## Solucion

### Registramos un author menor de edad (11 anios)

![](https://github.com/jmejiarojas/bootcamp-reto-2/blob/master/src/main/resources/documentation/save-usario.gif)

### Intentaremos crear un blog cuyo author sera el menor de edad creado en el paso anterior cuyo id es igual a 3

![](https://github.com/jmejiarojas/bootcamp-reto-2/blob/master/src/main/resources/documentation/save-blog-menor-edad.gif)

### Data actual de authors, ya se cuenta con 2 authors mayores de edad

<p>
<a href="https://ibb.co/RvMSPgS"><img src="https://i.ibb.co/mDYBtRB/data-authors.png" alt="data-authors" border="0"></a><br /><a target='_blank' href='https://imgbb.com/'>bild 3 2</a>
</p>

### Intentaremos registrar mas de 3 blogs para el author cuyo id es igual a 1

![](https://github.com/jmejiarojas/bootcamp-reto-2/blob/master/src/main/resources/documentation/author-maximo-3-blogs.gif)

### Intentaremos registrar un post en un blog cuyo estado es inactivo

- Cambiaremos el blog cuyo id es igual a 1 a estado inactivo
- Intentaremos registrar un post en dicho blog inactivo
- Cambiaremos el blog cuyo id es igual a 1 a estado activo
- Intentaremos registrar un post en dicho blog activo
- Los posts por regla de negocio se crean con estado "borrador".

![](https://github.com/jmejiarojas/bootcamp-reto-2/blob/master/src/main/resources/documentation/save-post.gif)

### Publicacion de mas de un post por dia

- Puede crearse varios post en un dia siempre y cuando permanezcan con estado borrador.
- Crearemos 2 posts adicionales, es permitido por regla de negocio.
- Haremos la publicacion de mas de un post, no es permitido por regla de negocio.

![](https://github.com/jmejiarojas/bootcamp-reto-2/blob/master/src/main/resources/documentation/publicar-mas-un-dia.gif)

### Solo se pueden registrar comentarios en posts con estado publicado

- Intentaremos crear un comentario en el post con id es igual 2 cuyo estado es borrador, no es permitido por regla de negocio.
- Registraremos un comentario en el post cuyo id es igual a 1 que se ha publicado en el paso anterior.

![](https://github.com/jmejiarojas/bootcamp-reto-2/blob/master/src/main/resources/documentation/save-comment.gif)

### Eliminacion en cascada

- Eliminaremos el author cuyo id es igual a 1
- Se eliminaran los blogs del autor, asi como los posts y comentarios relacionados.

![](https://github.com/jmejiarojas/bootcamp-reto-2/blob/master/src/main/resources/documentation/evidencia-pre-eliminacion.gif)

![](https://github.com/jmejiarojas/bootcamp-reto-2/blob/master/src/main/resources/documentation/delete-author-cascade.gif)

![](https://github.com/jmejiarojas/bootcamp-reto-2/blob/master/src/main/resources/documentation/evidencia-post-cascade.gif)







