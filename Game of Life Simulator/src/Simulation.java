import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Simulation extends JPanel implements ActionListener{
	int[][] grid = new int[50][50];
	JButton button = new JButton("Play");
	Timer timer = new Timer(100, this);
	
	public static void main(String args[]) {
		Simulation sim = new Simulation();
        JFrame frame = new JFrame("Game of Life Simulation"); // creates JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(sim);    // adds the panel to the JFrame
        frame.pack(); // sizes frame so that all contents are at preferred sizes
        frame.setResizable(true);
        frame.setVisible(true);
	}
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(UI.w, UI.h);
	}
	Simulation() {
		Input in = new Input();
		addMouseListener(in);
		setFocusable(true);
		requestFocusInWindow();
		repaint();
		timer.start();
	}
	public void paint(Graphics n) {
		Graphics2D g = (Graphics2D) n;
		UI.paintBackground(g);
		UI.paintGrid(grid, g);
	}
	public int contain(int x, int y) {
		return 0;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
