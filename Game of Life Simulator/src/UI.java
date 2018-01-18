import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JFrame;

public class UI {
	static final int w = 1200, h = 750;
	static int gridSize = min(w, h) - 40;
	
	public static void paintBackground(Graphics2D g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 5000, 5000);
		paintText(g);

		g.setStroke(new BasicStroke(3));
		g.drawRect(20, 20, min(w, h) - 40, min(w, h) - 40); // doesn't support a rectangle taller than wide
	}

	public static void paintGrid(int[][] arr, Graphics2D g) {
		g.setStroke(new BasicStroke(1));
		int cols = arr.length, rows = arr[0].length;
		for (int i = 0; i < cols; i++) {
			g.drawLine(20, 20 + i * gridSize / cols, min(w, h) - 20, 20 + i * gridSize / cols);
		}
		for (int i = 0; i < rows; i++) {
			g.drawLine(20 + i * gridSize / rows, 20, 20 + i * gridSize / rows, min(w, h) - 20);
		}
		for (int i = 0; i < cols; i++) {
			for (int j = 0; j < rows; j++) {
				if (arr[i][j] == 1)
					g.fillRect(20 + i * gridSize / rows, 20 + j * gridSize / cols, gridSize / rows, gridSize / cols);
			}
		}
	}

	private static void paintText(Graphics2D g) {
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Arial", Font.PLAIN, 27));

		drawCentered("The Game of Life", 200, g);
		drawCentered("Made by", 300, g);
		drawCentered("Brion Ye", 400, g);
	}

	private static void drawCentered(String s, int height, Graphics2D g) {
		int temp = g.getFontMetrics().stringWidth(s);
		g.drawString(s, w - (w - min(w, h)) / 2 - temp / 2, height);
	}

	static int min(int a, int b) {
		if (a < b)
			return a;
		else
			return b;
	}
}
