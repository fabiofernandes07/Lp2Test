package triptest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class InfoServer extends JFrame implements Runnable {

	private JPanel Frame;
	private Seat[] seat;
	private  Plane plane;

	private ActionListener acaoBotoes;

	int b = 0;
	JPanel jpan;
	JButton[] botao;



	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
   
	
			
			Socket socket = new Socket("127.0.0.1", 4444);
			
        
			InfoServer assentos = new InfoServer(socket);
			Thread t1 = new Thread(assentos);
			t1.start();
			
			assentos.setVisible(true);
        
			
    
	}
	
	public void criarbotao() {

		botao = new JButton[20];
		int posX = 10;
		int posY = 10;
		int fila1 = 1;
		int fila2 = 11;

		for (int i = 0; i < 20; i++) {
			String v = Integer.toString(i);
			botao[i] = new JButton(v);
			this.jpan.add(botao[i]);
			botao[i].setBounds(posX, posY, 50, 20);
			botao[i].setBackground(Color.GREEN);
			botao[i].addActionListener(acaoBotoes);
			posX = posX + 45;

			if (i == fila1 && i < 9) {
				posX = 10;
				posY = posY + 30;
				fila1 = fila1 + 2;

			}

			if (i == 9) {
				posX = 150;
				posY = 10;
			}

			if (i == fila2) {
				posX = 150;
				posY = posY + 30;
				fila2 = fila2 + 2;
			}

			colocaFunc(botao[i]);

		}
	}
	
	private void colocaFunc(JButton jb) {

		jb.addActionListener(new ActionListener() {
			@Override
			public synchronized void actionPerformed(ActionEvent e) {
				
				int idSeat = Integer.parseInt(jb.getText());
				
				TextName.setText(seat[idSeat].getPassageiro().getNome());
				TextSname.setText(seat[idSeat].getPassageiro().getSobrenome());
				TextData.setText(seat[idSeat].getPassageiro().getDataNascimento());
				TextSexo.setText(seat[idSeat].getPassageiro().getSexo());
				TextNacionalidade.setText(seat[idSeat].getPassageiro().getNacionalidade());
				TextRg.setText(seat[idSeat].getPassageiro().getRg());
				textid.setText(jb.getText());
				
				
				
					
					
					
					
				

			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	
	ObjectInputStream input; // comunicação
	ObjectOutputStream output; // bidirecional
	private JTextField TextName;
	private JTextField TextSname;
	private JTextField TextNacionalidade;
	private JTextField TextSexo;
	private JTextField TextData;
	private JTextField TextRg;
	private JLabel textid;
	
	public InfoServer(Socket socketCliente) throws IOException {
		
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		input = new ObjectInputStream(socketCliente.getInputStream());
		output = new ObjectOutputStream(socketCliente.getOutputStream());
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		Frame = new JPanel();
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		
		jpan = new JPanel();
		jpan.setBackground(Color.LIGHT_GRAY);
		jpan.setBounds(239, 63, 260, 166);
		Frame.add(jpan);
		jpan.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Dados dos assentos");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(294, 11, 190, 14);
		Frame.add(lblNewLabel_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(76, 36, 104, 166);
		Frame.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setEnabled(false);
		btnNewButton.setBounds(10, 26, 18, 18);
		panel.add(btnNewButton);
		
		JButton button = new JButton("");
		button.setEnabled(false);
		button.setBackground(Color.ORANGE);
		button.setBounds(10, 55, 18, 18);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setEnabled(false);
		button_1.setBackground(Color.RED);
		button_1.setBounds(10, 84, 18, 18);
		panel.add(button_1);
		
		JLabel lblNewLabel_1 = new JLabel("Livre");
		lblNewLabel_1.setBounds(34, 30, 46, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Processo");
		lblNewLabel_2.setBounds(34, 59, 60, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Vendido");
		lblNewLabel_4.setBounds(38, 84, 46, 14);
		panel.add(lblNewLabel_4);
		
		TextName = new JTextField();
		TextName.setEditable(false);
		TextName.setBounds(215, 349, 117, 20);
		Frame.add(TextName);
		TextName.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(166, 351, 70, 14);
		Frame.add(lblNewLabel);
		
		TextSname = new JTextField();
		TextSname.setEditable(false);
		TextSname.setColumns(10);
		TextSname.setBounds(418, 349, 117, 20);
		Frame.add(TextSname);
		
		JLabel lblNewLabel_5 = new JLabel("Sobrenome");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_5.setBounds(341, 351, 104, 14);
		Frame.add(lblNewLabel_5);
		
		TextNacionalidade = new JTextField();
		TextNacionalidade.setEditable(false);
		TextNacionalidade.setColumns(10);
		TextNacionalidade.setBounds(215, 402, 117, 20);
		Frame.add(TextNacionalidade);
		
		TextSexo = new JTextField();
		TextSexo.setEditable(false);
		TextSexo.setColumns(10);
		TextSexo.setBounds(418, 402, 117, 20);
		Frame.add(TextSexo);
		
		TextData = new JTextField();
		TextData.setEditable(false);
		TextData.setColumns(10);
		TextData.setBounds(215, 453, 117, 20);
		Frame.add(TextData);
		
		TextRg = new JTextField();
		TextRg.setEditable(false);
		TextRg.setColumns(10);
		TextRg.setBounds(418, 453, 117, 20);
		Frame.add(TextRg);
		
		JLabel lblNacionalidade = new JLabel("Nacionalidade");
		lblNacionalidade.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNacionalidade.setBounds(116, 404, 88, 14);
		Frame.add(lblNacionalidade);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDataDeNascimento.setBounds(76, 456, 129, 14);
		Frame.add(lblDataDeNascimento);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexo.setBounds(338, 405, 70, 14);
		Frame.add(lblSexo);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRg.setBounds(390, 455, 70, 14);
		Frame.add(lblRg);
		
		JLabel lblInformaesDoAssento = new JLabel("Informa\u00E7\u00F5es do assento");
		lblInformaesDoAssento.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformaesDoAssento.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblInformaesDoAssento.setBounds(270, 240, 190, 14);
		Frame.add(lblInformaesDoAssento);
		
		textid = new JLabel("");
		textid.setFont(new Font("Tahoma", Font.BOLD, 13));
		textid.setBounds(453, 240, 46, 14);
		Frame.add(textid);
		
		JLabel lblInformaesSobre = new JLabel("Informa\u00E7\u00F5es sobre o passageiro");
		lblInformaesSobre.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformaesSobre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInformaesSobre.setBounds(270, 314, 212, 14);
		Frame.add(lblInformaesSobre);
		
		

		//criarbotao(socketCliente);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		criarbotao();
		while (true) {
			try {
				
				String c = "";
				output.writeObject(c);
				
				Object lido = input.readObject();
				
				if (lido instanceof Seat[]) {
					seat = (Seat[]) lido;
					
//					for (int i = 0; i < seat.length; i++) {
//						if (seat[i].isFree()) {
//							System.out.println(i + " ta livre");
//						}
//						else if(seat[i].isPurchased()) {
//							
//							System.out.println(i + " foi comprado");
//						}
//					}

					for (int i = 0; i < seat.length; i++) {
						if (seat[i].isFree()) {
							botao[i].setBackground(Color.GREEN);
							
							
						} 
						
						else if (seat[i].isPurchased()) {
							botao[i].setBackground(Color.RED);
							
						}
						
						else if(seat[i].isInProcess()) {
							botao[i].setBackground(Color.ORANGE);
							
						}
						repaint();
						revalidate();
						
					}
					
				}
			} 
			catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				break;
			}

		}
	    }
}
