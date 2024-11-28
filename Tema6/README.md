# CONTENIDO DEL TEMA 6
**"Sockets en lenguaje Java - Cifrado"**

1. **PDF 1** con las notas de introducción a los sockets en el lenguaje Java con envío cifrado de mensajes. [VER](Tema-06-Criptografia.pdf)


- **EjemploLlaveSimetricaDES.java** Este código realiza el cifrado de un texto pasado como argumento desde la línea de comandos. Observen que no es un cliente-servidor, este es un programa que se ejecuta como aplicación unitaria. Utiliza el algoritmo DES. [VER](EjemploLlaveSimetricaDES.java)

- **EjemploLlaveSimetricaAES.java** Este código realiza el cifrado de un texto pasado como argumento desde la línea de comandos. Observen que no es un cliente-servidor, este es un programa que se ejecuta como aplicación unitaria. Utiliza el algoritmo AES. [VER](EjemploLlaveSimetricaAES.java)

2. **PDF 2** con las notas de "Serialización de Objetos" como una opción para que Servidor le comparta su llave al Cliente. [VER](Tema-06-Criptografia-Parte-2.pdf)

- **EjemploSerializable1.java** Este es un programa para recordar cómo funciona la serialización de objetos. Se crea un objeto de tipo EjemploSerializable1 y se guarda en un archivo *.ser [VER](EjemploSerializable1.java)
- **EjemploSerializable2.java** Este programa es el complemento del anterior. Este programa lee el objeto del archivo *.ser. Lo recupera y muestra el valor de sus atributos en pantalla. Observa el cast o conversión explícita que debe hacerse al leer el objeto. [VER](EjemploSerializable2.java)

---

- **ServidorCifrado01.java** Este servidor genera el objeto Key y lo guarda en un archivo llave.ser para que, posteriormente, el cliente lea el objeto de ese archivo y de esa manera Cliente y Servidor utilicen la misma llave para cifrar/descrifrar. En este caso, el cliente envía un mensaje cifrado y termina. El servidor recibe el mensaje cifrado y lo descifra. [VER](ServidorCifrado01.java)
- **ClienteCifrado01.java** Este es el cliente, lee un mensaje del teclado, lo cifra y lo envía al servidor. [VER](ClienteCifrado01.java)
- **llave.ser** Este archivo contiene la llave que el cliente requiere para enviar mensajes cifrados al servidor. Quien vaya a ejecutar el cliente, previamente debe descargar esta llave. [VER](llave.ser)

---

- **ServidorFTPCifrado.java** Este servidor genera el objeto Key y lo guarda en un archivo llave.ser para que, posteriormente, el cliente lea el objeto de ese archivo y de esa manera Cliente y Servidor utilicen la misma llave para cifrar/descrifrar. En este caso, las acciones del servidor son:
    1. El servidor toma un archivo de texto plano (holamundo.txt) o archivo binario (holamundo.pdf), lo encripta y queda en espera de que un cliente se conecte.
    2. Cuando el cliente se conecta, el servidor le envía el nombre del archivo, el tamaño del archivo y después el contenido del archivo, byte a byte.
    [VER](ServidorFTPCifrado.java)
- **ClienteFTPCifrado.java** Este es el cliente, recibe el nombre del archivo encriptado, el tamaño del archivo encriptado y el contenido del archivo encriptado byte a byte. Posteriormente, lo desencripta y crea un archivo nuevo que tendrá el contenido desencriptado. [VER](ClienteFTPCifrado.java)
- **llaveFTP.ser** Este archivo contiene la llave que el cliente requiere para desencriptar los archivos transferidos del servidor. Quien vaya a ejecutar el cliente, previamente debe descargar esta llave. [VER](llaveFTP.ser)