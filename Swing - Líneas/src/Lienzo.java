import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Lienzo extends JPanel {

	int n;
	int dx;
	int dy;

	public Lienzo(int ancho, int alto, int numLineas) {
		setPreferredSize(new Dimension(ancho, alto));
		n = numLineas + 1;
		dx = ancho / n;
		dy = alto / n;
	}

	public void setNumeroLineas(int numLineas) {
		n = numLineas + 1;
		dx = getWidth() / n;
		dy = getHeight() / n;
		repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		for (int i = 1; i < n; i++) {
			g.drawLine(getWidth() - 1, getHeight() - 1, dx * (n - i), dy * i);
			g.drawLine(0, 0, dx * (n - i), dy * i);
			g.drawLine(getWidth() - 1, 0, dx * i, dy * i);
			g.drawLine(0, getHeight() - 1, dx * i, dy * i);

		}
	}

}