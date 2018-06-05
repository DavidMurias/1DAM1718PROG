package grafico;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

	private Random r = new Random(System.nanoTime());
	private Lienzo lienzo;
	
	public Main(int errores) {
		super("Juego del Ahorcado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(lienzo = new Lienzo(errores));
		pack();
		setLocationRelativeTo(null);
	}
	
//	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable(){
//			@Override
//			public void run() {
//				new Main().setVisible(true);
//			}
//		});
//	}

}
