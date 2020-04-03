package triptest;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.Color;

public class Entrada extends JFrame {

	private JPanel contentPane;
	private JTextField EntradaText;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entrada inicio = new Entrada();
					inicio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Entrada() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Texto = new JLabel("Digite Seu Nome ");
		Texto.setForeground(Color.WHITE);
		Texto.setBounds(308, 307, 173, 14);
		Texto.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(Texto);
		
		EntradaText = new JTextField();
		EntradaText.setBounds(256, 332, 217, 28);
		contentPane.add(EntradaText);
		EntradaText.setColumns(10);
		
		
		
		btnNewButton = new JButton("Entrar");
		btnNewButton.setBounds(288, 401, 158, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (!EntradaText.getText().equals("")) {
					Entrada.super.dispose();
					
					Viagens frame = new Viagens();
					frame.setVisible(true);
					JOptionPane.showMessageDialog(null, "Bem Vindo(a) " + EntradaText.getText());
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Digite Seu Nome");
				}
				
				
				
			}	
		});
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Passagem Express ltda");
		lblNewLabel_1.setBounds(51, 48, 589, 102);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Entrada.class.getResource("/triptest/LOGO.png")));
		lblNewLabel_2.setBounds(0, 0, 784, 561);
		contentPane.add(lblNewLabel_2);
	}
	
	
}
