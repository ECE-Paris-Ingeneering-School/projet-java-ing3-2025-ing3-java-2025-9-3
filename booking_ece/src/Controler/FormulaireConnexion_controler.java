package Controler;
import view.MasterPanel;
import java.awt.event.*;
import java.awt.*;
import view.FormulaireConnexion;
import view.MasterPanel;

public class FormulaireConnexion_controler extends FormulaireConnexion implements ActionListener {
	
	public FormulaireConnexion_controler() {
		super();
		this.bouton_connexion.addActionListener(this);
		this.bouton_enregistrement.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent AE1) {
		
		// On récupère le cardlayout du masterPanel.
		LayoutManager test = this.getParent().getLayout();
		MasterPanel parent = (MasterPanel)this.getParent();
		
		if (test instanceof CardLayout ) {
			
			if ( AE1.getActionCommand() == "Connexion" ) {
				
				// Si on appuie sur le bouton connexion, on commence le processus de connexion...
				System.out.println("ON COMMENCE A SE CONNECTER");
				/*
				 *  Sous fonction pour la connexion à définir...
				 * */
				System.out.println(parent);
				parent.update_nom(this.saisi_nom_utilisateur.getText());
				
				((CardLayout) test).show(this.getParent(), MasterPanel.INDICE_LISTING );
				
			} else if ( AE1.getActionCommand() == "S'enregistrer" ) {
				
				// Si on souhaite plutot s'enregistrer alors on passe au formulaire d'enregistrement...
				((CardLayout) test).show(this.getParent(), MasterPanel.INDICE_ENREGISTREMENT );
				
			}
			
		}
	}
	
}
