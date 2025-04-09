package view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CupomView extends JFrame{
	JLabel emailJLabel, codigoCupomJLabel;
	JTextField emailField, codigoCupomField;
	JButton ganharCupomButton, sairButton;
	
	public CupomView() {
		super("Ganhar Cupom");
		
		ImageIcon imageIcon = new ImageIcon("mpooStore/icone.png");
		setIconImage(imageIcon.getImage());
		
		setLayout(new FlowLayout());

		setSize(320, 150);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		emailJLabel = new JLabel("Email: ");
		emailField = new JTextField(20);
		
		codigoCupomJLabel = new JLabel("Código Cupom: ");
		codigoCupomField = new JTextField(15);
		
		ganharCupomButton = new JButton("Ganhar Cupom");
		sairButton = new JButton("Sair");
		
		add(emailJLabel);
		add(emailField);
		add(codigoCupomJLabel);
		add(codigoCupomField);
		add(ganharCupomButton);
		add(sairButton);
		setVisible(false);
	}

	public JTextField getEmailField() {
		return emailField;
	}

	public JTextField getCodigoCupomField() {
		return codigoCupomField;
	}

	public JButton getGanharCupomButton() {
		return ganharCupomButton;
	}

	public JButton getSairButton() {
		return sairButton;
	}
	
	
}
