import java.net.Socket;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

// Esta clase es auxiliar a la clase del ServidorMultiThread2
// Esta clase es hija de Thread y contiene la logica que hara
// cada uno de los thread/hilos
public class ServerThread extends Thread
{
 // Este atributo corresponde al socket de cada thread/hilo
 // debido a este atributo socket, es como el thread/hilo 
 // se comunicara con el cliente
 private Socket socket = null;

 // Este ArrayList contiene cada objeto ServerThread que se
 // va a crear cuando se conecte cada cliente
 private ArrayList<ServerThread> threadList = null;

 // Este atributo se llama output porque se asocia al
 // flujo de salida del socket lo que permitira escribir
 // a todos los sockets (clientes)
 private PrintWriter output;
 
 // El constructor se invoca cada vez que se acepte un cliente
 // por eso recibe como argumentos:
 // El socket que devolvio el accept() al aceptar al cliente
 // y el ArrayList con los thread/hilos creados hasta este momento
 public ServerThread( Socket socket, ArrayList<ServerThread> threads )
 {
  this.socket = socket;
  this.threadList = threads;
 }

 // Aqui va la logica que haran todos los threads/hilos
 public void run()
 {
  try
  {
   // Se inicializa la variable input, como su nombre lo indica,
   // tiene el flujo de entrada asociado al socket (entrada=lectura)
   BufferedReader input = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
   // La variable output tiene el flujo de salida asociado al socket
   // (salida = escritura)
   output = new PrintWriter(socket.getOutputStream(), true);

   // Inicia ciclo infinito
   // Que se hace en el ciclo infinito?
   while(true)
   {
    // Se lee el flujo de entrada asociado al socket
    String outputString = input.readLine();
    // si lo que se leyo es igual a "exit", rompe el ciclo infinito
    if( outputString.equals( "exit" ) )
     break;
    // si no es "exit", entonces ese mensaje que se leyo se enviara
    // a todos los clientes con la llamada a printToAllClients()
    printToAllClients( outputString );
    System.out.println( "El servidor recibio:" + outputString );
   }
  }
  catch(IOException e)
  {
   System.out.println("java.io.IOException generada");
   e.printStackTrace();
  }
 } // Fin del metodo run()

 public void printToAllClients( String outputString )
 {
  for( ServerThread sT : threadList )
   sT.output.println( outputString );
 }
}
