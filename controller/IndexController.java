package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import view.CupomView;
import view.IndexView;

public class IndexController {
	IndexView indexView;
	CupomView ganharCupomView;
	ButtonHandler buttonHandler;
	KeyHandler keyHandler;
	
	public IndexController(IndexView indexView, CupomView ganharCupomView) {
		this.indexView = indexView;
		this.ganharCupomView = ganharCupomView;
		this.buttonHandler = new ButtonHandler();
		this.keyHandler = new KeyHandler();
		control();
	}
	
	private void control() {
		indexView.getResgatarButton().addActionListener(buttonHandler);
		indexView.getResgatarButton().addKeyListener(keyHandler);
		indexView.addKeyListener(keyHandler);
	}
	
	private class ButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == indexView.getResgatarButton()) {
				indexView.setVisible(false);
				ganharCupomView.setVisible(true);
			}
			
		}
	}
	
	private class KeyHandler extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
				int confirmarSaida = JOptionPane.showConfirmDialog(indexView, "Deseja realmente sair?", "MPOOStore", JOptionPane.YES_NO_OPTION);
				
				if (confirmarSaida == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				indexView.getResgatarButton().doClick();
			}
			
		}
		
	}
	
}
