package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import commun.myUtilities;

import modele.Article;
import modele.Client;
import modele.RepertoireAbonnes;

public class VoirProduits extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Vector<Article> vectProduits;
	private JScrollPane jspDefileProduits;
	private static final String strEmpty = "";
	private static final String strSpce = "  ";
	private static final String strNewLine = "\n";
	private  JTextArea jtArea;	
	

	VoirProduits( Vector<Article> listeProduits ){
		initialisations( listeProduits );
		printingCustomers();
	}
	
	public void initialisations(Vector<Article> listeProduits){

		vectProduits = listeProduits;
		this.setLayout( new FlowLayout() );
		jtArea = new JTextArea();
		jtArea.setPreferredSize( new Dimension(myUtilities.SCREENSIZE.width/4, 2*myUtilities.SCREENSIZE.height/3) );
		jtArea.setVisible(true);
		jtArea.setEnabled( true );
		jtArea.setFont(new Font("Serif", Font.BOLD, 24));
		jtArea.setLineWrap( false );
		jspDefileProduits = new JScrollPane (jtArea);
		jspDefileProduits.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.add( jspDefileProduits );
		this.setVisible(true);
		jspDefileProduits.setPreferredSize( new Dimension(myUtilities.SCREENSIZE.width-40, 2*myUtilities.SCREENSIZE.height - 40) );

 
	}
	 public void printingCustomers() {
		 
		String strCodeArticle = "Code Article";
	    String nPrix = "Prix";
	    String strDescription = "Description";
	    String strGenre = "strGenre";
	    String strSupport = "Support";
	    String bNouveau = "Nouveau";
	    String bConsommable = "Consommable";
	    String nQte = "nQte";
	    String strTitre = "Titre";
	    String strDate = "Date";
	    
	    String theText = strEmpty;
	    theText += strCodeArticle + strSpce + nPrix + strSpce + strDescription + strSpce + strGenre + strSpce + strSupport +  strSpce+ bNouveau+
	    		bConsommable+ strSpce + nQte + strTitre + strSpce + strDate +strNewLine;
	    int theSize = vectProduits.size();
	    for( int theRow = 0; theRow < theSize; theRow ++ ){
	        strCodeArticle = (String) vectProduits.get(theRow).getCodeArticle();
	        nPrix = (String) strEmpty+vectProduits.get(theRow).getPrix();
	        strDescription = (String) vectProduits.get(theRow).getDescription();
	        strGenre = (String) strEmpty+vectProduits.get(theRow).getGenre();
	        strSupport = (String) vectProduits.get(theRow).getSupport();
	        bNouveau =  vectProduits.get(theRow).getNouveau() ? "Nouveau":"";
	        bConsommable = vectProduits.get(theRow).getConsommable() ? "Consommable":"Film";
	        nQte = (String) strEmpty+vectProduits.get(theRow).getQte();
	        strTitre = (String) vectProduits.get(theRow).getTitre();
	        strDate = (String) strEmpty+vectProduits.get(theRow).getDate();
	       theText += strCodeArticle + strSpce + nPrix + strSpce + strDescription + strSpce + strGenre + strSpce + strSupport +  strSpce+ bNouveau+
		    		bConsommable+ strSpce + nQte + strTitre + strSpce + strDate +strNewLine+strNewLine;
	    }
	    jtArea.setText( theText );
	 }

}



