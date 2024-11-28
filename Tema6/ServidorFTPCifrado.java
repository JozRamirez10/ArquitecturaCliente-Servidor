import java.net.*;
import java.io.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class ServidorFTPCifrado
{
  public static void main(String args[]) throws Exception
  {
    // El servidor genera la llave
    System.out.println( "Generando la llave..." );
    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
    keyGen.init(128);
    Key llave = keyGen.generateKey();
    System.out.println( "llave=" + llave );
    System.out.println( "Llave generada!" );

    // Y guarda el objeto llave en el archivo llave.ser
    ObjectOutput out = new ObjectOutputStream(new FileOutputStream("llaveFTP.ser"));
    out.writeObject( llave );
    out.close();

    // Creamos el objeto de tipo Cipher
    Cipher cifrar = Cipher.getInstance("AES/ECB/PKCS5Padding");

    // Este es el nombre del archivo como String
    String nombreArchivo = "holamundo.txt";
    // Con ese String creamos el objeto File
    File archivoOriginal = new File( nombreArchivo );
    // Y creamos un File (vacio) para el archivo encriptado que aun no existe
    File archivoEncriptado = new File( nombreArchivo + ".encrypt" );

    // La logica de encriptar el archivo la tenemos en la funcion encriptarArchivo
    encriptarArchivo( cifrar, llave, archivoOriginal, archivoEncriptado );

    ServerSocket serverSocket = null;
    Socket socket = null;
    System.out.println("Escuchando por el puerto 8000");
    serverSocket = new ServerSocket( 8000 );
    System.out.println("Esperando a que los clientes se conecten...");
    while(true)
    {
      socket = serverSocket.accept();
      System.out.println("Se conecto un cliente: " + socket.getInetAddress().getHostName());
      DataOutputStream dos = new DataOutputStream( socket.getOutputStream() );

      System.out.println("Paso 1: enviamos el nombre del archivo encriptado");
      dos.writeUTF( nombreArchivo + ".encrypt" );

      System.out.println("Paso 2: enviamos la longitud en bytes del archivo encriptado");
      long size = archivoEncriptado.length();
      dos.writeUTF( Long.toString( size ) );

      System.out.println("Paso 3: enviamos el contenido del archivo");
      FileInputStream fis = new FileInputStream( nombreArchivo + ".encrypt" );
      int contador = 1;
      while( contador <= size )
      {
        int b = fis.read();
        System.out.println( "byte " + contador + ":" + b );
        dos.write( b );
        contador++;
      }
      fis.close();
      System.out.println("Cerrando la conexion");
      socket.close();
      socket = null;
    }
  }

  public static void encriptarArchivo( Cipher cifrar, Key llave, File archivoOriginal, File archivoEncriptado ) throws Exception
  {
    // Se inicializa el objeto Cipher
    cifrar.init(Cipher.ENCRYPT_MODE, llave);
    // Se crean 2 flujos File pero uno es FileInputStream y el otro es FileOutputStream
    FileInputStream fis = new FileInputStream(archivoOriginal);
    FileOutputStream fos = new FileOutputStream(archivoEncriptado);
    byte[] buffer = new byte[64];
    int bytesLeidos;
    while ((bytesLeidos = fis.read(buffer)) != -1)
    {
      byte[] output = cifrar.update(buffer, 0, bytesLeidos);
      if (output != null)
      {
        fos.write(output);
      }
    }
    byte[] outputBytes = cifrar.doFinal();
    if (outputBytes != null)
    {
      fos.write(outputBytes);
    }
    fis.close();
    fos.close();
  }

}