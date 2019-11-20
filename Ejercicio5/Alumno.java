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

public class Alumno{
   private String usuario;
   private String password;
   private ArrayList<Asignatura> asignaturas = new ArrayList<>();

   Alumno(String usario, String password){
      this.usuario = usuario;
      this.password = usuario;
   }

   String toString(){
      String alumno;
      alumno = "Usuario =" + usuario + "\n";
      for(int i = 0; i < asignaturas.length; i++){
         alumno = alumno + asignaturas[i].toString() + "\n";
      }
      return alumno;
   }
   void addAsignatura();

}
