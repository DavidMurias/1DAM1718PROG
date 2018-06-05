package codigo;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import grafico.Lienzo;
import grafico.Main;

public class Cosos {

	private Random r = new Random(System.nanoTime());
	private Lienzo lienzo;

	ArrayList<String> palabras = new ArrayList<String>();
	String jugacion;
	char[] escondido;
	int errores = 0;

	public Cosos() {

	}

	public void rellenarPalabra() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("palabras.txt"));
			while (in.ready()) {
				String line = in.readLine();
				palabras.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void iniciarJuego() {
		Random r = new Random();

		int posi = r.nextInt(palabras.size());
		jugacion = palabras.get(posi);
		escondido = new char[jugacion.length()];

		for (int i = 0; i < jugacion.length(); i++) {
			escondido[i] = '_';
		}
	}

	public String mostrarEscondido() {
		return String.valueOf(escondido);
	}

	public boolean comprobacion(char c) {

		boolean adivinar = false;

		for (int i = 0; i < escondido.length; i++) {
			if (jugacion.charAt(i) == c) {
				escondido[i] = jugacion.charAt(i);
				adivinar = true;
			}
		}
		if (adivinar == false) {
			errores++;
		}
		return adivinar;
	}

	public void jugar() {

		Scanner in = new Scanner(System.in);

		rellenarPalabra();
		iniciarJuego();
		System.out.println(mostrarEscondido());

		do {
			System.out.println("Introduzca un caracter: ");
			char letra = in.next().charAt(0);
			if (!comprobacion(letra)) {

				// mostrar frame
				mostrarFrame();
			}
			System.out.println(mostrarEscondido());
		} while (errores < 10);
	}

	public void mostrarFrame() {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Main m = new Main(errores);
				m.setVisible(true);
			}
		});
	}

	public static void main(String[] args) {

		Cosos m = new Cosos();
		m.jugar();

	}

}
