import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EjemploSerializable1 implements Serializable
{
 String nombre;
 int edad;

 public static void main(String[] args) throws Exception
 {
  EjemploSerializable1 objeto = new EjemploSerializable1();
  System.out.println( "Antes de asignar valores a atributos");
  System.out.println( "nombre=" + objeto.nombre );
  System.out.println( "edad=" + objeto.edad );
  System.out.println("----------------------------");
  objeto.nombre = "Mayra";
  objeto.edad = 23;
  System.out.println( "Despues de asignar valores a atributos");
  System.out.println( "nombre=" + objeto.nombre );
  System.out.println( "edad=" + objeto.edad );
  System.out.println("----------------------------");
  System.out.println( "Ahora se guardara el objeto en un archivo SER");
  ObjectOutput out = new ObjectOutputStream(new FileOutputStream("archivo.ser"));
  out.writeObject( objeto );
  out.close();
 }
}