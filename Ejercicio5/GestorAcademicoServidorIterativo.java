import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.net.ServerSocket;
import java.net.Socket;

//
// YodafyServidorIterativo
// (CC) jjramos, 2012
//
public class GestorAcademicoServidorIterativo {

	public static void main(String[] args) {
		int port=8989;
		Socket socketServicio = null;

		try {
			ServerSocket socketServidor = new ServerSocket(port);
			GestorAcademico procesador = new GestorAcademico();

			do {
				try {
					socketServicio = socketServidor.accept();
					procesador.setSocket(socketServicio);
				}
				catch (IOException e) {
					System.out.println("Error:no se pudo aceptar la	conexión solicitada");
				}
				procesador.procesa();

			} while (true);
		}
		catch (IOException e) {
			System.err.println("Error al escuchar en el puerto "+port);
		}

	}

}
