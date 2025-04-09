package view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class IndexView extends JFrame{
	JLabel logoJLabel, resgatarCupomJLabel;
	JButton resgatarButton;
	
	public IndexView() {
		super("Index View");
		
		setLayout(new FlowLayout());
		
		setSize(320, 150);
		setResizable(false);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon("mpooStore/logo.png");
		logoJLabel = new JLabel(icon);
		
		resgatarCupomJLabel = new JLabel("Resgate seu cupom: ");
		resgatarButton = new JButton("Resgatar");
		
		add(logoJLabel);
		add(resgatarCupomJLabel);
		add(resgatarButton);
		setVisible(true);
	}

	public JButton getResgatarButton() {
		return resgatarButton;
	}

	public void setResgatarButton(JButton resgatarButton) {
		this.resgatarButton = resgatarButton;
	}
}
