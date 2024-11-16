import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.io.IOException;

public class ServidorMultiThread2
{
 public static void main(String a[])
 {
  ArrayList<ServerThread> threadList = new ArrayList<>(0);
  ServerSocket serverSocket = null;
  try
  {
   System.out.println("Escuchando por el puerto 8000");
   serverSocket = new ServerSocket(8000); 
  }
  catch(IOException e)
  {
   System.out.println("java.io.IOException generada");
   e.printStackTrace();
  }

  System.out.println("Esperando a que los clientes se conecten...");
  try
  {
   // Dentro del ciclo infinito, se acepta al cliente.
   // Para cada cliente que es aceptado, se realiza lo siguiente:
   // - Se inicializa la variable socket
   // - Se crea un objeto ServerThread
   // - Se agrega ese objeto ServerThread al ArrayList
   // - Se llama a start() el cual a su vez llama a run()
   while(true)
   {
    Socket socket = serverSocket.accept();
    System.out.println("Se conecto un cliente: " + socket.getInetAddress().getHostName());
    System.out.println("Invoca a la clase ServerThread");
    ServerThread serverThread = new ServerThread(socket, threadList);
    threadList.add( serverThread );
    serverThread.start();
   } // fin del while
  }
  catch(IOException e)
  {
   System.out.println("java.io.IOException generada");
   e.printStackTrace();
  }
 } // fin del main
}