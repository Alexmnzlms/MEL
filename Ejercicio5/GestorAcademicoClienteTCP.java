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
			socketServicio = new Socket (host,port);
			outPrinter = new PrintWriter (socketServicio.getOutputStream(), true);
			inReader = new BufferedReader (new InputStreamReader(socketServicio.getInputStream()));
			do {
				// Enviar estadoActual
				outPrinter.println(estadoActual);

				// Tomar decisión
				switch(estadoActual){
	            case "START":
						//El cliente no hace nada
						break;

					case "NOAUTENTIFICADO":
						System.out.println("Usuario: ");
						String usuario = in.nextLine();
						outPrinter.println(usuario);
						System.out.println("Contraseña: ");
						String password = in.nextLine();
						outPrinter.println(password);
						break;

					case "AUTENTIFICADO":
						System.out.println("¿Que desea hacer? Introduzca una letra:");
						System.out.println("[A] Modo Añadir");
						System.out.println("[V] Modo Visualización");
						System.out.println("[E] Salir");
						String opcion = in.nextLine();
						outPrinter.println(opcion);
						break;
					case "VISUALIZACION":
						System.out.println("Asignatura:");
						String asignaturas = new String(inReader.readLine());
						System.out.println(asignaturas);
						break;
					case "ANADE":
						System.out.println("¿Que desea añadir? Introduzca una letra:");
						System.out.println("[A] Añadir Asignatura");
						System.out.println("[N] Añadir Nota");
						System.out.println("[E] Salir");
						String aniade = in.nextLine();
						outPrinter.println(aniade);
						break;
					case "ANADE_ASIG":
						System.out.println("Nombre de la asignatura: ");
						String nombre = in.nextLine();
						outPrinter.println(nombre);
						System.out.println("Siglas de la asignatura: ");
						String siglas = in.nextLine();
						outPrinter.println(siglas);
						break;
					case "ANADE_NOTA":
						System.out.println("Codigo de asignatura: ");
						String cod_asig = in.nextLine();
						outPrinter.println(cod_asig);
						System.out.println("Dia: ");
						String dia = in.nextLine();
						outPrinter.println(dia);
						System.out.println("Mes: ");
						String mes = in.nextLine();
						outPrinter.println(mes);
						System.out.println("Año: ");
						String anio = in.nextLine();
						outPrinter.println(anio);
						System.out.println("Nota: ");
						String nota = in.nextLine();
						outPrinter.println(nota);
						break;
	         }

				// Respuesta del servidor
				String recibido = new String(inReader.readLine());
				System.out.println("CLIENTE - Mensaje recibido: ");
				System.out.println(recibido);
				estadoActual = new String(inReader.readLine());
				System.out.println(estadoActual);

			} while (!estadoActual.equals("EXIT"));

			socketServicio.close();

			// Excepciones:
		} catch (UnknownHostException e) {
			System.err.println("Error: Nombre de host no encontrado.");
		} catch (IOException e) {
			System.err.println("Error de entrada/salida al abrir el socket.");
		}
	}
}
