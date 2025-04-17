package Controler;
import java.awt.CardLayout;
import java.awt.LayoutManager;
import java.awt.event.*;

import view.FormulaireConnexion;
import view.FormulaireEnregistrement;
import view.MasterPanel;

public class FormulaireEnregistrement_controler extends FormulaireEnregistrement implements ActionListener {
	
	public FormulaireEnregistrement_controler() {
		super();
		this.bouton_enregistrement.addActionListener(this);
		this.bouton_vers_connexion.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent AE1) {
		
		// On récupère le cardlayout du masterPanel qui le contient.
		LayoutManager test = this.getParent().getLayout();
		
		if (test instanceof CardLayout ) {
			
			if ( AE1.getActionCommand() == "Se connecter" ) {
				
				// Si on souhaite plutot se connecter, alors on passe au formulaire de connexion.
				((CardLayout) test).show(this.getParent(), MasterPanel.INDICE_CONNEXION );
				
			} else if ( AE1.getActionCommand() == "S'enregistrer" ) {
				
				// On commence le processus d'enregistrement.
				System.out.println("ON COMMENCE A S ENREGISTRER.");
				/*
				 *  Sous fonction pour l'enregistrement à définir...
				 * */
				((CardLayout) test).show(this.getParent(), MasterPanel.INDICE_LISTING );
				
			}
		}
	}
	
}
