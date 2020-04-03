package triptest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class Confirmar_Compra extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Confirmar_Compra frame = new Confirmar_Compra();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Confirmar_Compra(int idSeat) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Voc\u00EA deseja reservar esse assento?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(80, 11, 265, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("SIM!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Confirmar_Compra.super.dispose();
				InfPassagem frame = new InfPassagem(idSeat);
				frame.setVisible(true);
				
				
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(171, 104, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("N\u00C3O");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Confirmar_Compra.super.dispose();
				Socket s;
				try {
					s = new Socket("127.0.0.1", 4444);
					new ModifierT(s, idSeat, 1).start();
					Lojinha.Process -=1;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(171, 161, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
