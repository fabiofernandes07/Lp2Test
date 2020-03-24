package triptest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Viagens extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Viagens frame = new Viagens();
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
	public Viagens() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Destinos");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 11, 612, 82);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("N\u00FAmero do voo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(175, 155, 124, 14);
		contentPane.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(75, 185, 612, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TAM8180");
		lblNewLabel_1.setBounds(127, 11, 53, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnNewButton = new JButton("Selecionar");
		btnNewButton.setBounds(502, 48, 100, 23);
		panel.add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		JLabel lblNewLabel_3 = new JLabel("CANCELADO");
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(255, 11, 80, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7 = new JLabel("LATAM Brasil");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_7.setBounds(24, 11, 93, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_10 = new JLabel("Sex 23:15 -03 GRU -> JFK 07:55 EDT S\u00E1b");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(361, 11, 241, 14);
		panel.add(lblNewLabel_10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBounds(75, 282, 612, 82);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Selecionar");
		btnNewButton_1.setBounds(502, 48, 100, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.setEnabled(false);
		
		JLabel label = new JLabel("CANCELADO");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(256, 11, 80, 14);
		panel_1.add(label);
		
		JLabel lblNewLabel_8 = new JLabel("American Airlines");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_8.setBounds(10, 11, 108, 14);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("AAL950");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(129, 11, 46, 14);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_11 = new JLabel("Sex 22:25 -03 GRU -> JFK 07:15 EDT S\u00E1b");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_11.setBounds(364, 11, 227, 14);
		panel_1.add(lblNewLabel_11);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GREEN);
		panel_2.setBounds(75, 386, 612, 82);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Selecionar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Socket s = new Socket("127.0.0.1", 4444);
					Lojinha assentos = new Lojinha(s);
					Thread t1 = new Thread(assentos);
					
					assentos.setVisible(true);
					t1.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		btnNewButton_2.setBounds(502, 48, 100, 23);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_13 = new JLabel("Gol Transportes Aereos");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_13.setBounds(10, 11, 146, 14);
		panel_2.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("GLO1232");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_14.setBounds(152, 11, 61, 14);
		panel_2.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("PROGRAMADO");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_15.setBounds(260, 11, 93, 14);
		panel_2.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("GRU ->  POA 11:40 -03 S\u00E1b");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_16.setBounds(405, 11, 170, 14);
		panel_2.add(lblNewLabel_16);
		
		JLabel lblNewLabel_4 = new JLabel("Estado");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(331, 156, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Linha Aerea");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(75, 155, 90, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Partida/Chegada");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setBounds(490, 156, 124, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_12.setIcon(new ImageIcon(Viagens.class.getResource("/triptest/paisagem.jpg")));
		lblNewLabel_12.setBounds(-83, 0, 867, 561);
		contentPane.add(lblNewLabel_12);
	}
}
