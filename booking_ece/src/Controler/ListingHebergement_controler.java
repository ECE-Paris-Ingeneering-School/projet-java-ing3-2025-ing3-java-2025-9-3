package Controler;
import view.ListingHebergement;
import view.HebergementCellule;

import Modele.Hebergement;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class ListingHebergement_controler extends ListingHebergement implements ActionListener {
	
	public ListingHebergement_controler( String in_nom_utilisateur ) {
		super(in_nom_utilisateur);
		this.FH1.bouton_recherche.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent AE1) {
		
		
		
		if ( AE1.getSource() == this.FH1.bouton_recherche ) {
			//System.out.println("On appuie sur le bouton de filtration");
			// On récupère tous les critères demandés !
			String categorie = this.FH1.combobox_categories.getSelectedItem().toString();
			int prix_minimum = this.FH1.slider_prix_minimum.getValue();
			int prix_maximum = this.FH1.slider_prix_maximum.getValue();
			int rang = this.FH1.slider_rang.getValue();
			int nombre_personne = this.FH1.slider_nombre_personne.getValue();
			Boolean detail_wifi = this.FH1.bouton_detail_wifi.isSelected();
			Boolean detail_petit_dejeuner = this.FH1.bouton_detail_petit_dejeuner.isSelected();
			Boolean detail_piscine_interieure = this.FH1.bouton_detail_piscine_interieure.isSelected();
			Boolean detail_centre_sportif = this.FH1.bouton_detail_centre_sportif.isSelected();
			
			// On crée un hébergement à partir d'une partie des informations récupérées...
			//this.hebergementeur.removeAll();
			
			try {
				Hebergement medium = new Hebergement(-1,"","",categorie,rang,1000,null,null,nombre_personne,detail_wifi,detail_petit_dejeuner,detail_piscine_interieure,detail_centre_sportif,-1);
				ArrayList<Hebergement> resultat_recherche = medium.getByCategorie();
				this.LH1.ajouterHebergementCellules(resultat_recherche);
			} catch ( SQLException SQLE1 ) {
				System.out.println("Erreur à ListingHebergement_controler : Erreur SQL !");
				SQLE1.printStackTrace();
			}
			
			//this.LH1.revalidate();
			//this.LH1.repaint();
			
		}
		
		
	}
	
	public static void main(String args[]) {
		JFrame frame_test_1 = new JFrame("Démonstration ListingHebergement_controler");
		frame_test_1.setSize(960,710);
		frame_test_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ListingHebergement_controler LHC1 = new ListingHebergement_controler("XXX TEST UTILISATEUR XXX");
		frame_test_1.add(LHC1);
		frame_test_1.setVisible(true);
		frame_test_1.setResizable(false);
	}
	
}
