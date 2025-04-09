package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import model.BaseDeDados;
import model.Cliente;
import model.ClienteException;
import model.Cupom;
import model.CupomException;
import model.GerenciarCupom;
import view.CupomView;
import view.IndexView;
import view.MensagemView;

public class CupomController extends KeyAdapter implements ActionListener {
	IndexView indexView;
	CupomView cupomView;
	WindowHandler windowHandler;
	

	public CupomController(IndexView indexView, CupomView cupomView) {
		this.indexView = indexView;
		this.cupomView = cupomView;
		this.windowHandler = new WindowHandler();
		
		cupomView.addWindowListener(windowHandler);
		
		cupomView.getSairButton().addActionListener(this);
		cupomView.getGanharCupomButton().addActionListener(this);
		
		cupomView.getGanharCupomButton().addKeyListener(this);
		cupomView.getSairButton().addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ClienteException clienteException = new ClienteException(null);
		
		if (e.getSource() == cupomView.getSairButton()) {
			cupomView.getEmailField().setText("");
			cupomView.getCodigoCupomField().setText("");
			
			cupomView.setVisible(false);
			indexView.setVisible(true);
		}
		
		if (e.getSource() == cupomView.getGanharCupomButton()) {
			String email = cupomView.getEmailField().getText();
			Cupom cupom = new Cupom(cupomView.getCodigoCupomField().getText());
			
			try {
				Cliente cliente = BaseDeDados.buscarCliente(email);
				
				if(cliente == null) {
					MensagemView.exibirMensagemErro(clienteException.getCLIENTE_NOEXIST_ERROR());
				}
			
				
				GerenciarCupom.adicionarCupom(cliente, cupom);
				JOptionPane.showMessageDialog(null, "Cupom resgatado com sucesso.");
					
			} catch (CupomException e1) {
				MensagemView.exibirMensagemErro(e1.getMessage());
				e1.printStackTrace();

			} catch (ClienteException e1) {
				MensagemView.exibirMensagemErro(e1.getMessage());
				e1.printStackTrace();
			}
			
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (e.getSource() == cupomView.getGanharCupomButton()) {
				cupomView.getGanharCupomButton().doClick();
			}
			if (e.getSource() == cupomView.getSairButton()) {
				cupomView.getSairButton().doClick();
			}
			
		}
		
	}
	
	private class WindowHandler extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			indexView.setVisible(true);	
		}
	}
	
}
