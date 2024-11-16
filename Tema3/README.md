# CONTENIDO DEL TEMA 3
**"Sockets Internet en lenguaje C"**

1. **PDF** con las notas de definición de Socket, tipos de familias de sockets [VER](01_Sockets.pdf)
2. **PDF** con las notas de sockets Internet, es decir, de tipo AF_INET. Aquí se muestran las estructuras struct y las funciones de los sockets AF_INET [VER](02_Sockets_AF_INTERNET.pdf)

- **programa01_ipaddr.c** Este programa utiliza la función gethostbyname() la cual regresa un apuntador a estructura hostent. Revisa los comentarios dentro del código [VER](programa01_ipaddr.c)
- **Infraestructura global de AWS** [VER](https://aws.amazon.com/es/about-aws/global-infrastructure/)
- **Ubicaciones de regiones de nube pública de Oracle** [VER](https://www.oracle.com/mx/cloud/public-cloud-regions/)
- **Mapa de todos los cables submarinos actualizado al 2024** [VER](https://submarine-cable-map-2024.telegeography.com)
- **Google planea conectar África con Australia a través de un inmenso cable submarino de fibra óptica** [VER](https://www.lavanguardia.com/andro4all/google/google-planea-conectar-africa-con-australia-a-traves-de-un-inmenso-cable-submarino-de-fibra-optica)
- **La compleja infraestructura detrás de Netflix** [VER](https://www.xataka.com/streaming/la-compleja-infraestructura-detras-de-netflix-que-pasa-cuando-le-das-al-play)
- **Escalamiento vertical y Escalamiento horizontal** [VER](http://profesores.fi-b.unam.mx/carlos/acs/Tema-03-Sockets-INTERNET-C/Escalamiento_vertical_y_horizontal.png)

- **Archivo PNG** que muestra gráficamente las funciones de los sockets AF_INET [VER](img_procesos_cliente_servidor_INTERNET.png)
- **programa02_mkget.c** Este programa es un cliente de servidor HTTP. Recibe el dominio del servidor desde línea de argumentos y utiliza el puerto 80. Al conectarse con el servidor, le envía la cadena GET /<enter>. Revisa los comentarios dentro del código [VER](programa02_mkget.c)
- **programa03_mkget.c** Este programa es un cliente de servidor HTTP, muy similar al programa anterior con la diferencia de que ahora envía la GET / HTTP/1.0<enter><enter>. Revisa los comentarios dentro del código [VER](programa03_mkget.c)

---

## Importante:
El siguiente par de códigos puedes probarlo en la misma máquina, abriendo 2 terminales.
Revisa la documentación de las funciones en el sitio de opengroup u otra bibliografía.
- **programa04_servidor_internet.c** Este programa es un servidor de sockets AF_INET que se levanta por el puerto 4898 y atiende un cliente. Cada vez que el cliente se conecta, le envia al cliente la frase "El mensaje del servidor es: Conexion exitosa!". Revisa los comentarios dentro del código [VER](programa04_servidor_internet.c)
- **programa04_cliente_internet.c** Este programa es el cliente del servidor arriba mencionado. Cada vez que este cliente se conecta, recibe la frase "El mensaje del servidor es: Conexion exitosa!". Puedes hacer la prueba levantando el servidor y el cliente en la misma máquina. Observa que el cliente recibe la IP del servidor desde línea de comandos y ahí puedes pasar la IP o el loopback 127.0.0.1
Revisa los comentarios dentro del código [VER](programa04_cliente_internet.c)

---
- **EXAMEN PARCIAL** Este documento contiene las especificaciones del examen parcial. [VER](EXAMEN_PARCIAL.pdf)
--- 

- **programa05_servidor_internet.c** Este programa es un servidor de sockets AF_INET que se levanta por el puerto indicado como argumento desde la línea de comandos. Cada vez que un cliente se conecta, se inicia la comunicación en la que el cliente inicia la conversación sincronizada. La conversación termina cuando el cliente envía la palabra "adios". El servidor continúa vivo, esperando la conexión de otro cliente. El servidor se termina con Control-C. [VER](programa05_servidor_internet.c)
- programa05_cliente_internet.c Este programa es el cliente del servidor arriba mencionado. Cada vez que este cliente se conecta, se inicia una conversación en la que el cliente escribe primero. La conversación es sincronizada y termina cuando el cliente envía la palabra "adios". [VER](programa05_cliente_internet.c)

---

- **programa06_servidor_internet.c** Este servidor es similar al servidor del programa05, con la diferencia de que este servidor que crea hijos con fork() para atender varios clientes en paralelo. Cuando se acepta un cliente, el servidor padre crea un servidor hijo con la llamada a fork() para que el hijo atienda al cliente. Revisa los comentarios dentro del código. [VER](programa06_servidor_internet.c)
- **programa06_cliente_internet.c** El cliente 06 es igual al cliente05 porque solamente cambió la funcionalidad del servidor pero la del cliente es exactamente la misma: una conversación que finaliza con la palabra "adios". Revisa los comentarios dentro del código. [VER](programa06_cliente_internet.c)
