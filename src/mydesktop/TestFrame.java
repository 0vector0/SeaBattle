package mydesktop;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class TestFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame window = new TestFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 900, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Player player = new Player();
		player.start();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		Field panel1 = new Field(player.getMasPlay());
		frame.getContentPane().add(panel1);

		Field panel2 = new Field(player.getMasPlay());
		frame.getContentPane().add(panel2);

	}

}
