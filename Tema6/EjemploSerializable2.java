import java.io.FileInputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class EjemploSerializable2 implements Serializable
{
 public static void main(String[] args) throws Exception
 {
  System.out.println( "Ahora se leera el objeto desde el archivo SER");
  System.out.println("----------------------------");
  ObjectInput in = new ObjectInputStream(new FileInputStream("archivo.ser"));
  EjemploSerializable1 objeto = (EjemploSerializable1)in.readObject();
  in.close();
  System.out.println( "Despues de asignar valores a atributos");
  System.out.println( "nombre=" + objeto.nombre );
  System.out.println( "edad=" + objeto.edad );
 }
}