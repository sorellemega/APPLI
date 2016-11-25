package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import commun.myUtilities;

import modele.Client;

public class VoirClients extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<Client> vectClients;
	private JScrollPane jspDefileClients;
	private static final String strEmpty = "";
	private static final String strSpce = "  ";
	private static final String strNewLine = "\n";
	private  JTextArea jtArea;	
	

	VoirClients( Vector<Client> listeClients ){
		initialisations(listeClients);
		printingCustomers();
	}
	
	public void initialisations(Vector<Client> listeClients){

		vectClients = listeClients;
		this.setLayout( new FlowLayout() );
		jtArea = new JTextArea();
		jtArea.setPreferredSize( new Dimension(myUtilities.SCREENSIZE.width, 2*myUtilities.SCREENSIZE.height) );
		jtArea.setVisible(true);
		jtArea.setEnabled( true );
		jtArea.setFont(new Font("Serif", Font.BOLD, 24));
		jtArea.setLineWrap( false );
		jspDefileClients = new JScrollPane (jtArea);
		jspDefileClients.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add( jspDefileClients );
		this.setVisible(true);
		jspDefileClients.setPreferredSize( new Dimension(myUtilities.SCREENSIZE.width/4, 2*myUtilities.SCREENSIZE.height/3) );

 
	}
	 public void printingCustomers() {
		 
		String phoneHeading = "Téléphone";
	    String secretCodeHeading = "CodeSecret";
	    String date = "Date adhésion";
	    String theText = strEmpty;
	    theText += phoneHeading + strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + secretCodeHeading+
	    		strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + date+strNewLine;
	    int theSize = vectClients.size();
	    for( int theRow = 0; theRow < theSize; theRow ++ ){
	    	phoneHeading = (String) vectClients.get(theRow).getTelAcheteur().getRegion()+" "+vectClients.get(theRow).getTelAcheteur().getZone()+"-"+ vectClients.get(theRow).getTelAcheteur().getId();
	    	secretCodeHeading = (String) strEmpty+vectClients.get(theRow).getCodeSecret().getCode();
	    	date = (String) strEmpty+vectClients.get(theRow).getDateAbonnement();
	       theText += phoneHeading + strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + secretCodeHeading+
		    		strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + strSpce + date+strNewLine;
	    }
	    jtArea.setText( theText );
	 }

}


