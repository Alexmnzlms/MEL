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

   Alumno(String usuario, String password){
      this.usuario = usuario;
      this.password = usuario;
   }

   String pasoString(){
      String alumno;
      alumno = "Usuario = " + usuario + ", ";
      for(int i = 0; i < asignaturas.size(); i++){
         alumno = alumno + asignaturas.get(i).pasoString() + " ";
      }
      return alumno;
   }
   void addAsignatura(Asignatura asign){
      asignaturas.add(asign);
   }

   String getUsuario(){
      return this.usuario;
   }

   String getPassword(){
      return this.password;
   }

}
