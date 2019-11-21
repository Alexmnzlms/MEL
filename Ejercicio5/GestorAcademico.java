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

   private ArrayList<Alumno> alumnos = new ArrayList<>();
   private Alumno alumnoActual;

   PrintWriter outPrinter = null;
   BufferedReader inReader = null;

   String estadoActual;

   public GestorAcademico(Socket socketServicio) {
      this.socketServicio=socketServicio;
      Alumno aux = new Alumno("prueba","prueba");
      Alumno aux1 = new Alumno("vacio", "vacio");
      alumnos.add(aux);
      alumnos.add(aux1);
      Examen ex = new Examen(18,11,2019, 10);
      Examen ex1 = new Examen(19,11,2019,3);
      Examen ex2 = new Examen(20,11,2019,5);
      Asignatura asig = new Asignatura("Fundamentos de redes", "FR");
      asig.addExamen(ex);
      asig.addExamen(ex1);
      asig.addExamen(ex2);
      alumnos.get(0).addAsignatura(asig);
   }

   public void run() {
      procesa();
   }

   synchronized void procesa(){
		try {

			outPrinter = new PrintWriter(socketServicio.getOutputStream(),true);
			inReader = new BufferedReader(new InputStreamReader(socketServicio.getInputStream()));

         do{
            estadoActual = new String(inReader.readLine());
            System.out.println("Estado actual: ");
            System.out.println(estadoActual);


            String respuesta = new String();
            /*outPrinter.println(respuesta);
            outPrinter.println(estadoActual);
            */

            switch(estadoActual){
               case "START":
                  respuesta = "Bienvenido, introduzca login y contraseña.";
                  System.out.println(respuesta);
                  estadoActual = "NOAUTENTIFICADO";
                  break;
               case "NOAUTENTIFICADO":
                  String usuario = new String(inReader.readLine());
                  String password = new String(inReader.readLine());
                  System.out.println("Usuario - Recibido: ");
                  System.out.println(usuario);
                  System.out.println("Contraseña - Recibido: ");
                  System.out.println(password);

                  boolean loginCorrecto = usuarioValido(usuario,password);
                  if (loginCorrecto) {
                     respuesta = "Bienvenido de nuevo, " + usuario + ".";
                     estadoActual = "AUTENTIFICADO";
                     for(int i = 0; i < alumnos.size(); i++){
                        if(alumnos.get(i).getUsuario().equals(usuario)){
                           alumnoActual = alumnos.get(i);
                        }
                     }
                  } else {
                     respuesta = "Usuario o contraseña incorrectos. Vuelve a intentarlo.";
                     estadoActual = "NOAUTENTIFICADO";
                  }
                  break;
               case "AUTENTIFICADO":
                     String opcion = new String(inReader.readLine());
                     System.out.println("Opcion - Recibido: ");
                     if(opcion.equals("A")){
                        estadoActual = "ANADE";
                     } else if(opcion.equals("V")) {
                        respuesta = "Has entrado en el Modo Visualización.";
                        estadoActual = "VISUALIZACION";
                     } else {
                        respuesta = "Has entrado en el Modo Añade. ¿Que quieres añadir?";
                        estadoActual = "AUTENTIFICADO";
                     }
                  break;
               case "VISUALIZACION":
                  String visual = alumnoActual.pasoString();
                  outPrinter.println(visual);
                  estadoActual = "AUTENTIFICADO";
                  break;
               case "ANADE":
                  break;
               case "ANADE_ASIG":
                  break;
               case "ANADE_NOTA":
                  break;
            }


            System.out.println("Mandar respuesta");
            outPrinter.println(respuesta);
            outPrinter.println(estadoActual);
         } while (!estadoActual.equals("EXIT"));

		} catch (IOException e) {
			System.err.println("Error al obtener los flujos de entrada/salida.");
		}

	}

   boolean usuarioValido(String usu, String pass){
      boolean encontrado = false;
      for(int i = 0; i < alumnos.size() && !encontrado; i++){
         if(alumnos.get(i).getUsuario().equals(usu)){
            if(alumnos.get(i).getPassword().equals(pass)){
               encontrado = true;
            }
         }
      }
      return encontrado;
   }
}
