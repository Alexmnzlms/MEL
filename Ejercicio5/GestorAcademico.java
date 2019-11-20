import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.util.Random;
import java.util.Date;
import java.util.ArrayList;

public class GestorAcademico extends Thread{
   private Socket socketServicio;
   private InputStream inputStream;
   private OutputStream outputStream;
   private static Estado estadoApp = Estado.START;

   private ArrayList<Alumno> alumnos = new ArrayList<>();

   PrintWriter outPrinter = null;
   BufferedReader inReader = null;

   public GestorAcademico(Socket socketServicio) {
      this.socketServicio=socketServicio;
      Alumno aux = new Alumno("Prueba","prueba");
      Alumno aux1 = new Alumno("Vacio", "vacio");
      alumnos.add(aux);
      alumnos.add(aux1);
   }

   public void run() {
      procesa();
   }

   synchronized void procesa(){
		try {

			outPrinter = new PrintWriter(socketServicio.getOutputStream(),true);
			inReader = new BufferedReader(new InputStreamReader(socketServicio.getInputStream()));


			String peticion = new String(inReader.readLine());
         System.out.println(peticion);

         String respuesta = "Patata";
         outPrinter.println(respuesta);
         String estadoActual = estado.toStrin

		} catch (IOException e) {
			System.err.println("Error al obtener los flujso de entrada/salida.");
		}

	}
}
