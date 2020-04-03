package triptest;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JProgressBar;

public class InfPassagem extends JFrame {

	private JPanel contentPane;
	private JTextField Nome;
	private JTextField Sobrenome;
	private JTextField Data;
	private JTextField Nascionalidade;
	private JTextField Rg;
	private ButtonGroup grupo;
	
	
	
	public InfPassagem(int idSeat) {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite as informa\u00E7\u00F5es para a compra");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(171, 31, 370, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(122, 115, 74, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataDeNascimento.setBounds(102, 184, 141, 25);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblSobrenome = new JLabel("Sobrenome");
		lblSobrenome.setHorizontalAlignment(SwingConstants.CENTER);
		lblSobrenome.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSobrenome.setBounds(309, 115, 113, 25);
		contentPane.add(lblSobrenome);
		
		JLabel lblNascionalidade = new JLabel("Nascionalidade");
		lblNascionalidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNascionalidade.setBounds(309, 184, 113, 25);
		contentPane.add(lblNascionalidade);
		
		Nome = new JTextField();
		Nome.setBounds(106, 138, 125, 25);
		contentPane.add(Nome);
		Nome.setColumns(10);
		
		Sobrenome = new JTextField();
		Sobrenome.setBounds(309, 138, 125, 25);
		contentPane.add(Sobrenome);
		Sobrenome.setColumns(10);
		
		Data = new JTextField();
		Data.setBounds(106, 208, 125, 25);
		contentPane.add(Data);
		Data.setColumns(10);
		
		Nascionalidade = new JTextField();
		Nascionalidade.setBounds(309, 208, 125, 25);
		contentPane.add(Nascionalidade);
		Nascionalidade.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Rg");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(133, 244, 46, 28);
		contentPane.add(lblNewLabel_2);
		
		Rg = new JTextField();
		Rg.setBounds(106, 272, 125, 25);
		contentPane.add(Rg);
		Rg.setColumns(10);
		
		grupo = new ButtonGroup(); 
		
		JRadioButton Masculino = new JRadioButton("Masculino");
		Masculino.setBounds(309, 284, 109, 23);
		contentPane.add(Masculino);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(340, 259, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JRadioButton Feminino = new JRadioButton("Feminino");
		Feminino.setBounds(309, 314, 109, 23);
		contentPane.add(Feminino);
		
		JRadioButton Outros = new JRadioButton("Outros");
		Outros.setBounds(309, 349, 109, 23);
		contentPane.add(Outros);
		
		grupo.add(Masculino);
		grupo.add(Feminino);
		grupo.add(Outros);
		
		JLabel lblNewLabel_4 = new JLabel("Valor  R$ :1100,00");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(534, 143, 141, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton = new JButton("Comprar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!(Nome.getText().equals("") || Sobrenome.getText().equals("") || Nascionalidade.getText().equals("") 
						|| Rg.getText().equals("") || Data.getText().equals("") || !(Masculino.isSelected() || Feminino.isSelected() || Outros.isSelected())  )) {
					
					String Sexo = null;
					
					if (Masculino.isSelected())
						Sexo = "Masculino";
					else if (Feminino.isSelected())
						Sexo = "Feminino";
					else if(Outros.isSelected())
						Sexo = "Outros";
					
					try {
						Socket s1 = new Socket("127.0.0.1", 4444);
						
						new ModifierT(s1,idSeat,Nome.getText(),Data.getText(),Rg.getText(),Sobrenome.getText(),Nascionalidade.getText(),Sexo).start();
						
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					InfPassagem.super.dispose(); // CUIDADO AQUI, TEM Q VERIFICAR SE OS DADOS ESTÃO COMPLETOS
					Socket s;
					try {
						s = new Socket("127.0.0.1", 4444);
						new ModifierT(s, idSeat, 3).start();
						
						Lojinha.Process -= 1;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Compra efetuada com Sucesso");
					
				}else {
					JOptionPane.showMessageDialog(null, "Não pode haver campos vazios");
				}
				
				
				
			}
		});
		btnNewButton.setBounds(534, 209, 125, 24);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfPassagem.super.dispose(); // Aqui nem precisa
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
		btnNewButton_2.setBounds(534, 249, 125, 24);
		contentPane.add(btnNewButton_2);
	}
}
