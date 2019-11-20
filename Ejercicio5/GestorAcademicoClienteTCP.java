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
import java.util.Scanner;

public class GestorAcademicoClienteTCP {

	// Scanner para leer inputs
	private static final Scanner in = new Scanner (System.in);

	public static void main(String[] args) {
		String host="localhost";
		int port=8989;
		Socket socketServicio=null;
		PrintWriter outPrinter = null;
		BufferedReader inReader = null;
		String estadoActual = "START";

		try {
			do {
				socketServicio = new Socket (host,port);
				outPrinter = new PrintWriter (socketServicio.getOutputStream(), true);
				inReader = new BufferedReader (new InputStreamReader(socketServicio.getInputStream()));

				String mensaje = in.nextLine();
				System.out.println("CLIENTE - Mensaje enviado: ");
				System.out.println(mensaje);
				outPrinter.println(mensaje);
				outPrinter.println(estadoActual);

				String recibido = new String(inReader.readLine());
				System.out.println("CLIENTE - Recibido: ");
				System.out.println(recibido);

				socketServicio.close();

			} while (estadoApp != Estado.EXIT);

			// Excepciones:
		} catch (UnknownHostException e) {
			System.err.println("Error: Nombre de host no encontrado.");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida al abrir el socket.");
		}
	}
}
