package manipulation_client;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ConnectionButton extends JButton{
	
	public ConnectionButton() {
		super("Se connecter");
		//setSize(30,100);
		setFont(new Font("Times New Roman", Font.PLAIN, 18));
	}
	
}

class GroupOfRadioButtons extends JPanel {
	
	private ButtonGroup BG1;
	public JRadioButton LISTE1[];
	
	public GroupOfRadioButtons( String titles[] ) {
		
		super();
		
		this.setLayout( new FlowLayout() );
		this.setBackground(Color.CYAN);
		this.setSize(30,100);
		
		this.LISTE1 = new JRadioButton[titles.length];
		this.BG1 = new ButtonGroup();
		
		for ( int i = 0 ; i < titles.length ; i++ ) {
			if ( i == 0 ) {
				this.LISTE1[i] = new JRadioButton(titles[i],true);
			} else {
				this.LISTE1[i] = new JRadioButton(titles[i],false);
			}
		}
		
		for ( JRadioButton JRB : this.LISTE1 ) {
			this.BG1.add(JRB);
			this.add(JRB);
		}
		
	}
	
	public String getValue() {
		for ( JRadioButton JRB : this.LISTE1 ) {
			if ( JRB.isSelected() ) {
				return JRB.getText();
			}
		}
		return "Nothing";
	}
	
}

class TextFieldPlus extends JPanel {
	
	private String base_label;
	private int maxLength;
	
	private JLabel label_du_textfield;
	public JTextField textfield_a_remplir;
	
	public Boolean truthy;
	
	public TextFieldPlus(String label, int max_length) {
		
		// Un TextFieldPlus aura un FlowLayout.
		super();
		this.base_label = label;
		this.maxLength = max_length;
		this.truthy = false;
		setSize( 30 , 100 );
		setBackground( Color.YELLOW );
		
		this.label_du_textfield = new JLabel();
		this.textfield_a_remplir = new JTextField(20);
		this.textfield_a_remplir.addKeyListener( new TextFieldPlus_ActionListener() );
		
		this.add( this.label_du_textfield );
		this.add( this.textfield_a_remplir );
		
		this.update_label();
		
		this.setVisible(true);
		
	}
	
	private void update_label() {
		int longueur_saisie = this.textfield_a_remplir.getText().length();
		if ( longueur_saisie > this.maxLength ) {
			this.label_du_textfield.setForeground(Color.RED);
			this.truthy = false;
		} else {
			this.label_du_textfield.setForeground(Color.BLACK);
			this.truthy = true;
		}
		this.label_du_textfield.setText( this.base_label + "  " + longueur_saisie + "/" + this.maxLength + " : " );
	}
	
	class TextFieldPlus_ActionListener implements KeyListener {
		
		public void keyPressed( KeyEvent KE ) {
			TextFieldPlus.this.update_label();
			//System.out.println(KE);
		}
		
		public void keyReleased( KeyEvent KE ) {
			TextFieldPlus.this.update_label();
		}
		
		public void keyTyped( KeyEvent KE ) {}
		
	}
	
}