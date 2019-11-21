import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.util.Random;
import java.util.Date;

public class Examen{
   private Date fecha;
   private int nota;

   Examen(int dia, int mes, int anio, int nota){
      Date fech = new Date(anio,mes,dia);
      fecha = fech;
      this.nota = nota;
   }

   String pasoString(){
      return "Examen: " + "Fecha-> " + fecha + ", nota-> " + nota + ", ";
   }
}
