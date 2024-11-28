import java.net.*;
import java.io.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

public class ClienteFTPCifrado
{
  public static void main(String a[]) throws Exception
  {
    Socket socket = null;
    System.out.println("Me conecto al puerto 8000 del servidor");
    socket = new Socket(a[0],8000);
    DataInputStream dis = new DataInputStream( socket.getInputStream() );

    System.out.println("Paso 1: leo el nombre del archivo");
    String nombreArchivo = dis.readUTF();
    System.out.println("Creamos un archivo nuevo con ese nombre para que se llame igual que en el servidor");
    FileOutputStream fos = new FileOutputStream( nombreArchivo );

    System.out.println("Paso 2: leo el tamano del archivo");
    long size = Long.parseLong( dis.readUTF() );

    System.out.println("Paso 3: leo el contenido del archivo byte por byte");
    int contador = 1;
    while( contador <= size )
    {
      int b = dis.read();
      System.out.println( "byte " + contador + ":" + b );
      fos.write( b );
      contador++;
    }
    fos.close();
    socket.close();
    System.out.println( "Fin de transferencia" );
    System.out.println( "Pero este archivo es el encriptado, por lo que lo vamos a desencriptar" );

    // En este ejemplo, el Cliente tomara la llave del archivo llave.ser
    ObjectInput in = new ObjectInputStream(new FileInputStream("llaveFTP.ser"));
    // El metodo readObject() devuelve un Object generico
    // por eso se hace cast explicito a tipo Key generico
    Key llave = (Key)in.readObject();
    System.out.println( "llave=" + llave );
    in.close();

    // Creamos el objeto de tipo Cipher
    Cipher cifrar = Cipher.getInstance("AES/ECB/PKCS5Padding");

    // Se crea el objeto File del archivo encriptado 
    File archivoEncriptado = new File( nombreArchivo );

    // Se crea el objeto File del archivo desencriptado 
    File archivoDesencriptado = new File( nombreArchivo.replace( ".encrypt", "" ) );

    // La logica de desencriptar el archivo la tenemos en la funcion desencriptarArchivo
    desencriptarArchivo( cifrar, llave, archivoEncriptado, archivoDesencriptado );
  }

  public static void desencriptarArchivo( Cipher cifrar, Key llave, File archivoEncriptado, File archivoDesencriptado ) throws Exception
  {
    cifrar.init(Cipher.DECRYPT_MODE, llave);

    FileInputStream fis = new FileInputStream(archivoEncriptado);
    FileOutputStream fos = new FileOutputStream(archivoDesencriptado);
    byte[] buffer = new byte[64];
    int bytesRead;
    while ((bytesRead = fis.read(buffer)) != -1)
    {
      byte[] output = cifrar.update(buffer, 0, bytesRead);
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