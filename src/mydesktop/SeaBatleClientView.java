package mydesktop;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SeaBatleClientView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField hostField;
	private JTextField portField;
	private BufferedReader in = null;
	private boolean connected = false;
	private Player player = new Player();
	private Player anotherPlayer = new Player();
	private JTextField nameTextField;
	private JTable table;
	JLabel numberLabel;
	Field panelPole1;
	Field panelPole2;
	int typeShip = 0;

	private static ClientController clientController = new ClientController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeaBatleClientView frame = new SeaBatleClientView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeaBatleClientView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// disConnect();
				System.exit(0);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);

		JButton sendButton = new JButton("Отправить");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientController.sentField(player.getNumberPlayer(), player.getMasPlay());
				System.out.println("Отправить");
			}
		});
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JButton btnNewButton = new JButton("Получить");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anotherPlayer.setMasPlay(clientController.getPlayerField(player.getNumberPlayer()));
				panelPole2.setMasPlay(anotherPlayer.getMasPlay());
			}
		});
		panel.add(btnNewButton);
		panel.add(sendButton);

		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);

		JLabel hostLabel = new JLabel("IP");
		panel_1.add(hostLabel);

		hostField = new JTextField();
		hostField.setText("localhost");
		panel_1.add(hostField);
		hostField.setColumns(8);

		JLabel portLabel_1 = new JLabel("PORT");
		panel_1.add(portLabel_1);

		portField = new JTextField();
		portField.setText("8080");
		panel_1.add(portField);
		portField.setColumns(4);

		JButton connectButton = new JButton("Соединить");
		connectButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (!connected) {
					player.setName(nameTextField.getText());
					player.setNumberPlayer(clientController.connect(player));
					numberLabel.setText(String.valueOf(player.getNumberPlayer()));
					System.out.println("connected");
					connected = true;
				}
				// upDate();

			}
		});

		JLabel lblUsername = new JLabel("username");
		panel_1.add(lblUsername);

		nameTextField = new JTextField();
		nameTextField.setText("username");
		panel_1.add(nameTextField);
		nameTextField.setColumns(10);
		panel_1.add(connectButton);

		JButton disConnectButton = new JButton("Отключить");
		disConnectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Отключить");
				connected = false;
			}
		});
		panel_1.add(disConnectButton);

		numberLabel = new JLabel("Ваш номер ");
		panel_1.add(numberLabel);

		JPanel panelMain = new JPanel();
		contentPane.add(panelMain, BorderLayout.CENTER);

		// player.randomField();
		player.start();
		panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.X_AXIS));

		panelPole1 = new Field(player.getMasPlay());
		panelMain.add(panelPole1);
		panelPole2 = new Field(anotherPlayer.getMasPlay());

		panelMain.add(panelPole2);

		JPanel panel_2 = new JPanel();
		panelMain.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));

		JButton buttonTypeShip4 = new JButton("4");
		buttonTypeShip4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTypeShip(4);
			}
		});
		panel_2.add(buttonTypeShip4);

		JButton buttonTypeShip3 = new JButton("3");
		buttonTypeShip3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTypeShip(3);
			}
		});
		panel_2.add(buttonTypeShip3);

		JButton buttonTypeShip2 = new JButton("2");
		buttonTypeShip2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTypeShip(2);
			}
		});
		panel_2.add(buttonTypeShip2);

		JButton buttonTypeShip1 = new JButton("1");
		buttonTypeShip1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTypeShip(1);
			}
		});
		panel_2.add(buttonTypeShip1);

		JButton buttonTypeShip0 = new JButton("0");
		buttonTypeShip0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTypeShip(0);
			}
		});
		panel_2.add(buttonTypeShip0);

	}

	public void setTypeShip(int type) {
		this.typeShip = type;
	}

	public void upDate() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (connected) {
					System.out.println("upDate");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}).start();
	}
}
