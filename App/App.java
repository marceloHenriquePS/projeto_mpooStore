package App;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import controller.CupomController;
import controller.IndexController;
import model.BaseDeDados;
import view.CupomView;
import view.IndexView;

public class App {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			ImageIcon icon = new ImageIcon("mpooStore/icone.png");
			JOptionPane.showMessageDialog(null, "Erro de Aparência: O sistema será finalizado.", "MPOOStore", JOptionPane.ERROR_MESSAGE, icon);
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			BaseDeDados.createBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		IndexView indexView = new IndexView();
		CupomView cupomView = new CupomView();
		
		IndexController indexController = new IndexController(indexView, cupomView);
		CupomController cupomController = new CupomController(indexView, cupomView);
		
	}

}
