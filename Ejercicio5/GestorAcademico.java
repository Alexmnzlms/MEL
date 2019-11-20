import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.util.Random;
import java.util.Date;

public class GestorAcademico extends Thread{

   private Socket socketServicio;
   // stream de lectura (por aquí se recibe lo que envía el cliente)
   private InputStream inputStream;
   // stream de escritura (por aquí se envía los datos al cliente)
   private OutputStream outputStream;

   private ArrayList<Alumno> alumnos = new ArrayList<>();

   PrintWriter outPrinter = null;
   BufferedReader inReader = null;

   public GestorAcademico(Socket socketServicio) {
      this.socketServicio=socketServicio;
      alumnos.add(Alumno("Prueba","prueba"));
      alumnos.add(Alumno("Vacio", "vacio"));

   }

   public void run() {
      procesa();
      System.out.println("Hola");
   }
}
