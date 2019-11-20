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

public class Asignatura{
   private String nombre;
   private String siglas;
   private ArrayList<Examen> examenes = new ArrayList<>();

   Asignatura(String nombre, String siglas){
      this.nombre = nombre;
      this.siglas = siglas;
   }

   String pasoString(){
      String asign;
      asign = "Nombre=" + nombre + "\n" + "Siglas=" + siglas + "\n";
      for(int i=0; i<examenes.size(); i++){
         asign = asign + examenes.get(i).pasoString() + "\n";
      }
      return asign;
    }
}
