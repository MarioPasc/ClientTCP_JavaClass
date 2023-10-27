/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author <tu nombre aqui>
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientTCP {

	public static void main(String[] args) throws IOException {
		//descomentar si el servidor se toma por linea de comandos
		String serverName = args[0];
		// String serverName = "0.0.0.0";
		//descomentar si el puerto del servidor se toma por linea de comandos
		int portNumber = Integer.parseInt(args[1]);
		// int portNumber = 12345;
		Socket serviceSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			/* COMPLETAR Crear socket y conectar con servidor */
			serviceSocket = new Socket(serverName, portNumber);
			/**/

			/*
			 * COMPLETAR Inicializar los flujos de entrada/salida del socket conectado en
			 * las variables PrintWriter y BufferedReader
			 */
            in = new BufferedReader(new InputStreamReader(serviceSocket.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(serviceSocket.getOutputStream()), true);
			/**/

		} catch (UnknownHostException e) {
			System.err.println("Unknown: " + serverName);
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: " + serverName);
			System.exit(1);
		}

		System.out.println("STATUS: Conectado al servidor ");

		/* Obtener texto por teclado */
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		String userInput;

		System.out.println("Introduzca un texto a enviar (END-TCP para acabar)");

		userInput = stdIn.readLine();
		/* bucle del servicio */

		/* COMPLETAR Comprobar si el usuario ha iniciado el fin de la interacci�n */
		while (userInput.compareTo("END") != 0) {

			/*
			 * COMPLETAR Enviar texto en userInput al servidor a trav�s del flujo de salida
			 * del socket conectado
			 */
			out.println(userInput);
			/* */

			System.out.println("STATUS: Enviando " + userInput); // muestra por pantalla el texto enviado
			System.out.println("STATUS: Esperando eco"); // muestra por pantalla estado

			/*
			 * COMPLETAR Recibir texto en echo enviado por el servidor a trav�s del flujo de
			 * entrada del socket conectado
			 */
			String echo = null;

			echo = in.readLine(); /* leer l�nea de socket conectado en variable echo */

			/* */

			System.out.println("echo: " + echo); // muestra por pantalla el eco recibido

			/* Leer texto de usuario por teclado */
			System.out.println("Introduzca un texto a enviar (FIN para acabar)");
			userInput = stdIn.readLine();
		} /* Fin del bucle de servicio en cliente */

		// salimos porque el cliente quiere terminar la interaccion, ha introducido
		// END-TCP
		System.out.println("STATUS: El cliente quiere terminar el servicio");

		/* COMPLETAR Enviar END al servidor para indicar el fin deL SERVICIO */
		out.println(userInput);
		/* */

		System.out.println("STATUS: Sending " + userInput); // muestra por pantalla el texto enviado
		System.out.println("STATUS: Waiting for the reply"); // muestra por pantalla estado

		/*
		 * COMPLETAR Recibir OK enviado por el servidor confirmando EL FIN DEL SERVICIO
		 */
		String ok = in.readLine();// leer linea de socket conectado en variable ok y comparar con "OK"

		/**/

		System.out.println("STATUS: Cerrando conexion " + ok); // muestra por pantalla el eco recibido

		/* COMPLETAR Cerrar flujos y socket */
		 out.close();
		 in.close();
		 stdIn.close();
		 serviceSocket.close();
		/**/
		System.out.println("STATUS: Conexion cerrada");
	}
}
