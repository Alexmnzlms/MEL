//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class YodafyClienteTCP {

	public static void main(String[] args) {

		//byte []buferEnvio;
		//byte []buferRecepcion=new byte[256];
		//int bytesLeidos=0;

		// Nombre del host donde se ejecuta el servidor:
		String host="localhost";
		// Puerto en el que espera el servidor:
		int port=8989;

		// Socket para la conexión TCP
		Socket socketServicio=null;

		PrintWriter outPrinter = null;
		BufferedReader inReader = null;

		try {
			// Creamos un socket que se conecte a "host" y "port":
			//////////////////////////////////////////////////////
			socketServicio = new Socket (host,port);
			//////////////////////////////////////////////////////

			InputStream inputStream = socketServicio.getInputStream();
			OutputStream outputStream = socketServicio.getOutputStream();


			// Crear un objeto outPrinter para enviar texto
		 	outPrinter = new PrintWriter (socketServicio.getOutputStream(), true);

			String mensaje="Al monte del volcan debes ir sin demora";

			// Enviar el texto
			outPrinter.println(mensaje);

			outputStream.flush();

			// Crear un objeto BufferedReader para leer texto desde el socket
			inReader = new BufferedReader (new InputStreamReader(socketServicio.getInputStream()));
			String recibido = new String(inReader.readLine());

			// MOstremos la cadena de caracteres recibidos:
			System.out.println("Recibido: ");
			System.out.println(recibido);

			// Una vez terminado el servicio, cerramos el socket (automáticamente se cierran
			// el inpuStream  y el outputStream)
			//////////////////////////////////////////////////////
			socketServicio.close();
			//////////////////////////////////////////////////////

			// Excepciones:
		} catch (UnknownHostException e) {
			System.err.println("Error: Nombre de host no encontrado.");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida al abrir el socket.");
		}
	}
}
