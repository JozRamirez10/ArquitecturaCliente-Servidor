# CONTENIDO DEL TEMA 5
**"Sockets en lenguaje Java"**

1. **PDF** con las notas de sockets en el lenguaje Java. Aquí ya no son estructuras struct, en su lugar son clases: ServerSocket y Socket [VER](Tema_05.pdf)

---

- **Servidor01.java** Este código representa un servidor en lenguaje Java. Observen el uso de las clases ServerSocket (el socket del servidor) y la clase Socket (que representa el socket del cliente del lado del servidor). Cada Socket tiene asociados 2 flujos: uno de entrada y otro de salida. Para manejar cadenas o strings en texto plano, se pueden utilizar readUTF() y writeUTF(). [VER](Servidor01.java)
- **Cliente01.java** Este código representa un cliente en lenguaje Java. Observen que el cliente solamente utiliza la clase Socket. Cada Socket tiene asociados 2 flujos: uno de entrada y otro de salida. Para manejar cadenas o strings en texto plano, se pueden utilizar readUTF() y writeUTF(). [VER](Cliente01.java)

---

- **Servidor02.java** Este código no maneja textos en código duro, sino que lee el flujo del teclado, utilizando la clase BufferedReader. [VER](Servidor02.java)
- **Cliente02.java** Este código lee el mensaje del flujo del teclado para enviarlo al servidor y recibe de él una respuesta. [VER](Cliente02.java)

---

- **Servidor03.java** Este código es la modificación del Servidor02. Consiste en tener una conversación que se encuentra ciclada hasta que el cliente escribe la palabra clave "salir". Debido a que después de que el cliente escribe, debe leer entonces cuando el cliente escribe la palabra "salir", el servidor responde automáticamente la palabra "salir" y es lo que provoca que el cliente termine. Posteriormente el servidor se queda atento a otra conexión. [VER](Servidor03.java)
- **Cliente03.java** Este código es la modificación del Cliente02. Consiste en tener una conversación que se encuentra ciclada hasta que el cliente escribe la palabra clave "salir". [VER](Cliente03.java)

---

- **ServidorMultiThread.java** Este código es la modificación del Servidor03. Consiste en crear un thread/hilo por cada cliente que se conecte. Esto lo hace un servidor de clientes concurrentes. Al igual que con el Servidor03, cada cliente debe escribir la palabra clave "salir". Debido a que después de que el cliente escribe, debe leer entonces cuando el cliente escribe la palabra "salir", el servidor responde automáticamente la palabra "salir" y es lo que provoca que el cliente termine.
**Consideren los siguientes aspectos en el diseño del código:**
    - La clase ServidorMultiThread extiende/hereda a la clase Thread. Por lo que cada instancia de la clase ServidorMultiThread es un thread/hilo.
    - Al conectarse un cliente, el servidor creará un thread/hilo. Por lo que en el código, la creación de cada objeto thread/hilo se realiza después de la llamada a accept().
    - La clase tendrá un método run() con la lógica de lo que va a hacer cada uno de los threads/hilos.
    - ServerSocket y Socket se sacan del método main() para que queden al nivel de la clase, como variables con alcance a todos los métodos.
    - ServerSocket se hace variable estática porque debe tener el mismo valor para todos los threads/hilos.
    - Socket se hace variable de instancia ya que su valor debe ser independiente y diferente entre los threads/hilos.
    - Cuando el servidor acepta la conexión del cliente, devuelve la variable local de tipo Socket y ésta se iguala a la variable de instancia socket.
    [VER codigo ServidorMultiThread.java](ServidorMultiThread.java)

- **ClienteMultiThread.java** Debido a que la lógica de multithread está en el servidor, observen que el cliente multithread es el mismo código que el Cliente03. Consiste en tener una conversación que se encuentra ciclada hasta que el cliente escribe la palabra clave "salir". [VER](ClienteMultiThread.java)

---

- **ServidorMultiThread2.java** Revisa los comentarios dentro del código. [VER](ServidorMultiThread2.java)
- **ServerThread.java** Esta es la clase auxiliar del servidor. Revisa los comentarios dentro del código. [VER](ServerThread.java)
- **ClienteMultiThread2.java** Revisa los comentarios dentro del código. [VER](ClienteMultiThread2.java)
- **ClientThread.java** Esta es la clase auxiliar del cliente. Revisa los comentarios dentro del código. [VER](ClientThread.java)

---

- **Archivo PDF** Con las funciones para el manejo de los flujos de socket. [VER](flujos.pdf)

---

- **ServidorFTP.java** Este código realiza la transferencia de archivos del servidor al cliente. Pueden ser archivos de texto y también binarios. [VER](ServidorFTP.java)
- **ClienteFTP.java** Este código recibe el archivo que le transfiere el servidor. [VER](ClienteFTP.java)

