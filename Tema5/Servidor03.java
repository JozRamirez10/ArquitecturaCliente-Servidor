import java.net.*;
import java.io.*;

public class Servidor03
{
 public static void main(String a[])
 {
  ServerSocket serverSocket = null;
  Socket socket = null;
  // Peticion es lo que envia el Cliente
  String peticion = "";
  // Respuesta es lo que le respondo al Cliente
  String respuesta = "";

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
  while(true)
  {
   try
   {
    socket = serverSocket.accept();
    System.out.println("Se conecto un cliente: " + socket.getInetAddress().getHostName());
    System.out.println("socket=" + socket);
    // Como ya hay socket, obtengo los flujos asociados a este
    DataInputStream dis = new DataInputStream( socket.getInputStream() );
    DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );
    // Despues de la conexion, Servidor y Cliente deben ponerse de acuerdo
    // para ver quien escribe primero y entonces el otro debe leer
    BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    while( !respuesta.equals( "salir" ) )
    {
     // Como el Cliente escribe, yo debo leer
     peticion = dis.readUTF();
     System.out.println("El mensaje que me envio el cliente es: " + peticion);
     if( peticion.equals( "salir" ) )
     {
      respuesta = "salir";
     }
     else
     {
      // Ahora yo leo del teclado y despues escribo eso al otro proceso
      respuesta = br.readLine();
     }
     System.out.println("El mensaje que le envio al cliente es: " + respuesta);
     dos.writeUTF(respuesta);
    }
    dos.close();
    dis.close();
    socket.close();
   }
   catch(IOException e)
   {
    System.out.println("java.io.IOException generada");
    e.printStackTrace();
   }
  }
 }
}
