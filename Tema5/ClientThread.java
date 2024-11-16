import java.net.*;
import java.io.*;

// Esta clase es auxiliar a la clase del ClienteMultiThread2
// Esta clase es hija de Thread y contiene la logica que hara
// cada uno de los thread/hilos
public class ClientThread extends Thread
{
 // Este atributo corresponde al socket de cada thread/hilo
 // debido a este atributo socket, es como el thread/hilo
 // se comunicara con el servidor.
 // Gracias a esta clase, la comunicacion es asincrona ya que 
 // cada cliente no se espera a escribir para leer
 private Socket socket = null;

 // Este atributo se llama input porque se asocia al
 // flujo de entrada del socket lo que permitira leer
 // a todos los sockets (clientes)
 private BufferedReader input;

 // El constructor recibe el socket
 // Inicializa el socket y el atributo input
 public ClientThread(Socket s) throws IOException
 {
  this.socket = s;
  this.input = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
 }

 // En el metodo run() esta la logica que haran todos los threads/hilos
 public void run()
 {
  try
  {
   // Lo que hace el ciclo infinito es...
   while( true )
   {
    // ...leer el flujo de entrada del socket
    String response = input.readLine();
    // e imprimirlo en pantalla
    System.out.println( response );
   }
  }
  catch(IOException e)
  {
   System.out.println("java.io.IOException generada");
   e.printStackTrace();
  }
  finally
  {
   try
   {
    input.close();
   }
   catch( Exception e )
   {
    e.printStackTrace();
   }
  }
 }
}