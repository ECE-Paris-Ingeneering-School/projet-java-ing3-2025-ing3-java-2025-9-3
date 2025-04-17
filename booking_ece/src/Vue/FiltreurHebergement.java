package Vue;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class FiltreurHebergement extends JPanel {

	private JLabel label_categories;
	private JLabel label_rang;
	private JLabel label_prix_minimum;
	private JLabel label_prix_maximum;
	private JLabel label_prix_nombre_personne;
	
	private Color couleur_ECE;
	private Font police_ecriture_critere;
	private GridBagConstraints GBC1;
	private static String categories[] = {"appartement","chalet","manoir","cave","vaisseau spatial"};
	private static String prix[] = {"300-600","600-1000","1000-1500","1500-2000"};
	public JComboBox combobox_categories;
	public JSlider slider_rang;
	public JSlider slider_prix_minimum;
	public JSlider slider_prix_maximum;
	public JSlider slider_nombre_personne;
	public JCheckBox bouton_detail_wifi;
	public JCheckBox bouton_detail_petit_dejeuner;
	public JCheckBox bouton_detail_piscine_interieure;
	public JCheckBox bouton_detail_centre_sportif;
	
	public JButton bouton_recherche;
	
    public FiltreurHebergement() {
        super();
        
        this.setBackground(Color.WHITE);
        this.setMaximumSize(new Dimension(200,900));
        
        this.couleur_ECE = new Color(0,115,123);
        this.police_ecriture_critere = new Font("Cascadia Code",Font.PLAIN,20);
        this.GBC1 = new GridBagConstraints();
        this.GBC1.insets = new Insets(10,10,10,10);
        this.setLayout(new GridBagLayout());
        
        this.label_categories = new JLabel("Catégorie :");
        this.label_categories.setBackground(Color.WHITE);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 1;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(label_categories,this.GBC1);
        
        this.combobox_categories= new JComboBox(FiltreurHebergement.categories);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 2;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.combobox_categories,this.GBC1);
        
        // Renseignement du rang de l'hébergement recherché...
        
        this.label_rang = new JLabel("Rang :");
        this.label_rang.setBackground(Color.WHITE);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 3;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(label_rang,this.GBC1);
        
        this.slider_rang = new JSlider(1,10);
        this.slider_rang.setBackground(Color.WHITE);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 4;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.slider_rang,this.GBC1);
        
        // Renseignement du prix minimum hebdomadaire...
        
        this.label_prix_minimum = new JLabel("Prix minimum :");
        this.label_prix_minimum.setBackground(Color.WHITE);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 5;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(label_prix_minimum,this.GBC1);
        
        this.slider_prix_minimum = new JSlider(100,2000);
        this.slider_prix_minimum.setBackground(Color.WHITE);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 6;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.slider_prix_minimum,this.GBC1);
        
        // Renseignement du prix maximum hebdomadaire...
        
        this.label_prix_maximum = new JLabel("Prix maximum :");
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 7;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(label_prix_maximum,this.GBC1);
        
        this.slider_prix_maximum = new JSlider(100,2000);
        this.slider_prix_maximum.setBackground(Color.WHITE);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 8;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.slider_prix_maximum,this.GBC1);
        
        // Renseignement du nombre de personnes maximal.
        
        this.label_prix_nombre_personne = new JLabel("Nombre de personne(s) :");
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 9;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(label_prix_nombre_personne,this.GBC1);
        
        this.slider_nombre_personne= new JSlider(1,6);
        this.slider_nombre_personne.setBackground(Color.WHITE);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 10;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.slider_nombre_personne,this.GBC1);
        
        // Placement de tous les quatre détails...
        
        this.bouton_detail_wifi = new JCheckBox("Wifi");
        this.bouton_detail_wifi.setBackground(Color.WHITE);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 11;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.bouton_detail_wifi,this.GBC1);
        
        this.bouton_detail_petit_dejeuner = new JCheckBox("Petit Dejeuner");
        this.bouton_detail_petit_dejeuner.setBackground(Color.WHITE);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 12;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.bouton_detail_petit_dejeuner,this.GBC1);
        
        this.bouton_detail_piscine_interieure = new JCheckBox("Piscine intérieure");
        this.bouton_detail_piscine_interieure.setBackground(Color.WHITE);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 13;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.bouton_detail_piscine_interieure,this.GBC1);
        
        this.bouton_detail_centre_sportif = new JCheckBox("Centre sportif");
        this.bouton_detail_centre_sportif.setBackground(Color.WHITE);
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 14;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        this.add(this.bouton_detail_centre_sportif,this.GBC1);
        
        this.bouton_recherche = new JButton("Rechercher");
        this.GBC1.gridx = 1;
        this.GBC1.gridy = 15;
        this.GBC1.gridwidth = 1;
        this.GBC1.fill = GridBagConstraints.HORIZONTAL;
        
        
        this.add(this.bouton_recherche,this.GBC1);
        
    }
    
    
    public static void main(String args[]) {
    	JFrame frame_test_1 = new JFrame("Démonstration FiltreurHebergement");
    	frame_test_1.setSize(960,710);
    	frame_test_1.setLayout(new BorderLayout());
    	FiltreurHebergement FH1 = new FiltreurHebergement();
    	frame_test_1.add(FH1,BorderLayout.LINE_START);
    	frame_test_1.setVisible(true);
    }
    
}
