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
import java.net.DatagramSocket;
import java.net.UnknownHostException;
import java.net.InetAddress;
import java.net.DatagramPacket;

public class YodafyClienteTCP {

	public static void main(String[] args) {

		byte []buferEnvio;
		byte []buferRecepcion = new byte[256];

		// Nombre del host donde se ejecuta el servidor:
		String host="localhost";
		// Puerto en el que espera el servidor:
		int port=8989;
		InetAddress direccion;
		DatagramPacket paquete;

		// Socket para la conexión UDP
		DatagramSocket socketServicio=null;

		try {
			// Creamos un socket que se conecte a "host" y "port":
			//////////////////////////////////////////////////////
			socketServicio = new DatagramSocket();
			direccion = InetAddress.getByName(host);
			//////////////////////////////////////////////////////

			// Si queremos enviar una cadena de caracteres por un OutputStream, hay que pasarla primero
			// a un array de bytes:
			buferEnvio="Al monte del volcan debes ir sin demora".getBytes();

			// Enviamos el array por el outputStream;
			//////////////////////////////////////////////////////
			paquete = new DatagramPacket(buferEnvio, buferEnvio.length, direccion, port);
			socketServicio.send(paquete);
			//////////////////////////////////////////////////////

			// Leemos la respuesta del servidor. Para ello le pasamos un array de bytes, que intentará
			// rellenar. El método "read(...)" devolverá el número de bytes leídos.
			//////////////////////////////////////////////////////
			paquete = new DatagramPacket(buferRecepcion, buferRecepcion.length);
			socketServicio.receive(paquete);
			buferRecepcion = paquete.getData();
			direccion = paquete.getAddress();
			port = paquete.getPort();
			//////////////////////////////////////////////////////


			// MOstremos la cadena de caracteres recibidos:
			String peticion = new String(buferRecepcion,0,buferRecepcion.length);
      	System.out.print(peticion);

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
