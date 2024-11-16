# CONTENIDO DEL TEMA 4
**"Sockets Unix"**

1. **PDF** con las notas de sockets Unix, es decir, de tipo AF_UNIX. Aquí se muestran las estructuras struct y las funciones de los sockets AF_UNIX [VER](01_Sockets_AF_UNIX.pdf)
- **programa01_server_unix_01.c** Este código muestra las funciones socket() y bind() de un servidor tipo sockets UNIX. La intención de este código es mostrar cómo el socket se asocia a un archivo, éste es creado y se mantiene de tamaño cero (0). Para que observen el archivo del socket nombrado, el servidor se duerme 10 segundos. En otra terminal, diríjanse al directorio /tmp y observen el archivo. Pasado ese tiempo, el servidor cierra el socket y termina. Pueden comprobar que cuando el servidor termina, el archivo es eliminado del sistema de archivos. Revisen los comentarios dentro del código. [VER](programa01_server_unix_01.c)
- **Archivo PNG** que muestra gráficamente las funciones de los sockets AF_UNIX [VER](img_procesos_cliente_servidor.png)
- **PDF** con la explicación de los siguientes códigos [VER](02_Sockets_AF_UNIX.pdf)
- **programa02_socket_server.c** Revisen los comentarios dentro del código. [VER](programa02_socket_server.c)
- **programa02_socket_cliente.c** Revisen los comentarios dentro del código. [VER](programa02_socket_cliente.c)
- **programa03_echo_servidor.c** Revisen los comentarios dentro del código. [VER](programa03_echo_servidor.c)
- **programa03_echo_cliente.c** Revisen los comentarios dentro del código. [VER](programa03_echo_cliente.c)