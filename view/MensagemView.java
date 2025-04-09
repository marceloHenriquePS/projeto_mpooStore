package view;

import javax.swing.JOptionPane;

public class MensagemView {
	
	public static void exibirMensagemErro(String mensagem) {
		JOptionPane.showInternalMessageDialog(null, mensagem, "MPOOSTORE", 0);
	}
}
