import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.Socket;
import java.util.Random;
import java.util.Date;

ublic class Examen{
   private Date fecha;
   private int nota;

   Examen(int dia, int mes, int anio, int nota){
      this.fecha = Date(anio,mes,dia);
      this.nota = nota;
   }

   String toString(){
      return "Fecha " + fecha + ", nota: " + nota + "\n";
   }
}
