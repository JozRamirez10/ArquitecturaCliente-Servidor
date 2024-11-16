import java.net.*;
import java.io.*;

public class ClienteMultiThread2
{
 public static void main(String a[])
 {
  Socket socket = null;
  try
  {
   System.out.println("Me conecto al puerto 8000 del servidor");
   socket = new Socket(a[0],8000);
   // Despues de conectarse se inicializan input y output
   // y tambien el flujo del teclado
   BufferedReader input = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
   PrintWriter output = new PrintWriter( socket.getOutputStream(), true );
   BufferedReader teclado = new BufferedReader( new InputStreamReader( System.in ) );
   String userInput;
   String response;
   String clientName = "empty";
   // Se crea el objeto ClientThread con el socket  
   ClientThread clientThread = new ClientThread( socket );
   // Se llama a start() que a su vez llama a run()
   clientThread.start();
   // y ClientThread se pondra a leer la respuesta del servidor
   // y mientras tanto, en paralelo, aqui se continua con 
   // el siguiente bloque do-while

   // El siguiente bloque lee del teclado lo que le va a enviar
   // al servidor mientras que ClientThread leera la respuesta
   // del servidor. De esta manera, la comunicacion se vuelve asincrona
   do
   {
    // Cada cliente, despues de conectarse
    // pide el nombre del usuario desde teclado
    if( clientName.equals("empty") )
    {
     System.out.println("Introduce tu nombre:");
     userInput = teclado.readLine();
     clientName = userInput;
     // Lee el nombre del teclado y lo escribe al
     // flujo de salida del socket por lo que se 
     // lo envia al servidor
     output.println( userInput );
     if( userInput.equals("exit") )
      break;
    }
    else
    {
     // Despues de pedir el nombre, en los siguientes ciclos
     // leera del teclado el mensaje y le antepone
     // el nombre del usuario
     String message = "(" + clientName + "):";
     System.out.println( message );
     userInput = teclado.readLine();
     output.println( message + " " + userInput );
     if( userInput.equals("exit") )
      break;
    }
    // Eso lo hara en ciclos mientras no sea "exit"
   } while( !userInput.equals("exit") );
  }
  catch(IOException e)
  {
   System.out.println("java.io.IOException generada");
   e.printStackTrace();
  }
 }
}