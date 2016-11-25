package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import commun.myUtilities;
import modele.Article;
import modele.Client;
import modele.CodeSecret;
import modele.GestionnaireLocations;
import modele.LigneArticle;
import modele.Telephone;

public class Principalefenetre extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private Vector<Client> vectClients;
	private JScrollPane jspDefileClients;
	private static final String strEmpty = "";
	private static final String strSpce = "  ";
	private static final String strNewLine = "\n";
	private  JTextArea jtArea;	
	private static final long serialVersionUID1 = 1L;
	private JDesktopPane theDesktop;
	private JTextField jtPhoneRegion;
	private JTextField jtPhoneZone;
	private JTextField jtPhoneId;
	private JTextField jtCodeSecret;
	
	private JLabel jlPhoneRegion;
	private JLabel jlPhoneZone;
	private JLabel jlPhoneId;
	private JLabel jlCodeSecret;
	private JButton    jbOKClient;
	private JButton    jbCancelClient;
	
	private JTextField jtCodeArticle;
	private JTextField jtQte;
	private JTextField jtCumulVente;
	private JButton    jbFinVente;
	private JLabel jlCodeArticle;
	private JLabel jlQte;
	private JLabel jlCumulVente;
	private JButton    jbOKVente;
	private JButton    jbCancelVente;
	private static GestionnaireLocations leControleur;
	private JOptionPane uneReponse;
	private JMenu menuFichier;
	private JMenu menuLouer;
	private JMenu menuConsulter;
	private JMenuItem quitterAction;
    
	private JMenuItem identifierClientAction;
	private JMenuItem creerNouvelleVenteAction;
	private JMenuItem saisirArticleAction;
	private JMenuItem terminerVenteAction;
	private JMenuItem creerPaiementACreditAction;
    
	private JMenuItem consulterClientsAction;
	private JMenuItem consulterProduitsAction;
	static Principalefenetre me;
	
	
	public Principalefenetre() {
        
        setTitle("Gestion de vidéo club, l'olympien!");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        setSize((int)width, (int)height);
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        menuFichier = new JMenu("Fichier");
        menuLouer = new JMenu("Louer film");
        menuConsulter = new JMenu("Consulter");
        quitterAction = new JMenuItem("Quitter");
        
        identifierClientAction = new JMenuItem("Identifier client");
        creerNouvelleVenteAction = new JMenuItem("Nouvelle vente");
        saisirArticleAction = new JMenuItem("Saisir article");
        terminerVenteAction = new JMenuItem("Terminer vente");
        creerPaiementACreditAction = new JMenuItem("Créer paiement");
        
        consulterClientsAction = new JMenuItem("Clients");
        consulterProduitsAction = new JMenuItem("Produits");
        
        menuBar.add(menuFichier);
        menuBar.add(menuLouer);
        menuBar.add(menuConsulter);        
       
      
       
        menuFichier.add(quitterAction);
        
        menuLouer.add(identifierClientAction);
        menuLouer.addSeparator();
        menuLouer.add(creerNouvelleVenteAction);
        menuLouer.add(saisirArticleAction);
        menuLouer.add(terminerVenteAction);
        menuLouer.addSeparator();
        menuLouer.add(creerPaiementACreditAction);
        
        menuConsulter.add(consulterClientsAction);
        menuConsulter.add(consulterProduitsAction);
        creerNouvelleVenteAction.setEnabled(false);
        saisirArticleAction.setEnabled(false);
        terminerVenteAction.setEnabled(false);
        creerPaiementACreditAction.setEnabled(false);
  //*******************************************************************************************************************************************************//
        jtPhoneRegion = new JTextField();
    	jtPhoneZone = new JTextField();
    	jtPhoneId = new JTextField();
    	jtCodeSecret = new JTextField();
    	jlPhoneRegion = new JLabel("Region");
    	
    	jlPhoneRegion = new JLabel("Region");
    	jlPhoneZone = new JLabel("Zone");
    	jlPhoneId = new JLabel("Phone");
    	jlCodeSecret = new JLabel("Code secret");
    	jbOKClient = new JButton("OK");
    	jbCancelClient = new JButton("Annuler");
    	
    	jtCodeArticle = new JTextField();
    	jtQte = new JTextField();
    	jtCumulVente = new JTextField();
    	jbFinVente = new JButton("Finir vente");
    	jbOKVente = new JButton("OK");
    	jbCancelVente = new JButton("Annuler");
    	
    	jlCodeArticle = new JLabel("CodeArticle");
    	jlQte = new JLabel("Quantite");
    	jlCumulVente = new JLabel("CumulVente($)");
        
  //*******************************************************************************************************************************************************// 
        quitterAction.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event) 
					{						
						System.exit(0);				
					}			
				}
				);
        identifierClientAction.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event) 
					{						
						JInternalFrame frame = new JInternalFrame(
						"Traitements des locations", true, true, true, true);
				      
				        GridLayout gridLayout = new GridLayout(5,2);
						Container container = frame.getContentPane();
						container.setLayout( gridLayout );
						container.add(jlPhoneRegion);
						container.add(jtPhoneRegion);
						
						container.add(jlPhoneZone);
						container.add(jtPhoneZone);
						
						container.add(jlPhoneId);
						container.add(jtPhoneId);
						
						container.add(jlCodeSecret);
						container.add(jtCodeSecret);
						
						container.add(jbOKClient);
						container.add(jbCancelClient);
						
						frame.pack();
						theDesktop.add(frame);
						frame.setPreferredSize( new Dimension(myUtilities.SCREENSIZE.width/5, myUtilities.SCREENSIZE.height/5) );
						frame.setVisible(true);		
						
						
					}			
				}
				);	
        creerNouvelleVenteAction.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event) 
					{	if( !leControleur.getObjVente().EstTermine() ){						
							
						/*	JOptionPane.showMessageDialog( me, "Une vente est déjà en cours.", "Recherche de client", JOptionPane.ERROR_MESSAGE);
							return;*/
					}		
						JInternalFrame frame = new JInternalFrame(
								"Vente en cours!", true, true, true, true);
						      
						        GridLayout gridLayout = new GridLayout(5,2);
								Container container = frame.getContentPane();
								container.setLayout( gridLayout );
								container.add(jlCodeArticle);
								container.add(jtCodeArticle);
								
								container.add(jlQte);
								container.add(jtQte);
								
								container.add(jlCumulVente);
								container.add(jtCumulVente);
								jtCumulVente.setEnabled(false);
								
								container.add(jbOKVente);
								container.add(jbCancelVente);
								
								container.add(jbFinVente);
								
								frame.pack();
								theDesktop.add(frame);
								frame.setPreferredSize( new Dimension(myUtilities.SCREENSIZE.width/5, myUtilities.SCREENSIZE.height/5) );
								frame.setVisible(true);		
											
					}			
				}
				);	
        saisirArticleAction.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event) 
					{						
						System.exit(0);				
					}			
				}
				);	
        terminerVenteAction.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event) 
					{						
						System.exit(0);				
					}			
				}
				);	
        creerPaiementACreditAction.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event) 
					{						
						System.exit(0);				
					}			
				}
				);
        consulterClientsAction.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event) 
					{						
						JInternalFrame frame = new JInternalFrame(
						"Liste des clients abonnés", true, true, true, true);
						Container container = frame.getContentPane();
						VoirClients listeClients = new VoirClients( GestionnaireLocations.getListeClient() );
						container.add(listeClients, BorderLayout.CENTER);
						frame.pack();
						theDesktop.add(frame);
						frame.setPreferredSize(myUtilities.SCREENSIZE);
						frame.setVisible(true);			
					}			
				}
				);	
        consulterProduitsAction.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event) 
					{						
						JInternalFrame frame = new JInternalFrame(
						"Liste des produits en stock", true, true, true, true);
						Container container = frame.getContentPane();
						VoirProduits listeProduits = new VoirProduits( GestionnaireLocations.getListeProduits() );
						container.add(listeProduits, BorderLayout.CENTER);
						frame.pack();
						theDesktop.add(frame);
						frame.setPreferredSize(myUtilities.SCREENSIZE);
						frame.setVisible(true);					
					}			
				}
				);
        
        jbOKClient.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event) 
					{							
						if( jtPhoneRegion.getText().equals("") || jtPhoneZone.getText().equals("") || jtPhoneId.getText().equals("") || jtCodeSecret.getText().equals("")){
							JOptionPane.showMessageDialog( me, "Tous les champs doivent être non nuls.", "Recherche de client", JOptionPane.ERROR_MESSAGE);
							return;
						}
						Telephone unTelephone = new Telephone( jtPhoneRegion.getText(), jtPhoneZone.getText(), jtPhoneId.getText() );
						CodeSecret unCodeSecret = new CodeSecret( Integer.parseInt( jtCodeSecret.getText() ) );
						Client unClient = leControleur.RechercherClient( unTelephone, unCodeSecret );
						if( unClient != null ){							
        					JOptionPane.showMessageDialog( me, "Le client bien abonné.  \n Vous pouvez lui ouvrir une vente.", "Recherche de client.", JOptionPane.INFORMATION_MESSAGE);
        					boolean leBoolean = leControleur.CreerNouvelleVente( unTelephone, unCodeSecret );
        					creerNouvelleVenteAction.setEnabled( leBoolean );
        					saisirArticleAction.setEnabled( leBoolean );
        				    terminerVenteAction.setEnabled( leBoolean );
						}
						
						else {
								
							JOptionPane.showMessageDialog( me, "Le client n'est pas un abonné.", "Recherche de client", JOptionPane.WARNING_MESSAGE);
						}
							
							
					}			
				}
				);
        
        jbCancelClient.addActionListener(
    				new ActionListener(){
    					public void actionPerformed(ActionEvent event) 
    					{	
    						if( jtPhoneRegion.getText() != "" ) jtPhoneRegion.setText("");
    						if( jtPhoneZone.getText() != "" ) jtPhoneZone.setText("");
    						if( jtPhoneId.getText() != "" ) jtPhoneId.setText("");
    						if( jtCodeSecret.getText() != "" ) jtCodeSecret.setText("");    						
    							
    					}			
    				}
    				);
  //********************************************************************************************************************************************************
        jbOKVente.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event) 
					{	
						if( jtCodeArticle.getText().equals("") || jtQte.getText().equals("") ){
							JOptionPane.showMessageDialog( me, "Tous les champs doivent être non nuls.", "Processus de vente ouvert", JOptionPane.ERROR_MESSAGE);
							return;
						}
						int uneQte = Integer.parseInt( jtQte.getText() );
						String unCodeArticle = jtCodeArticle.getText();
						Article unArticle = leControleur.saisirArticleetRetourneArticle(unCodeArticle, uneQte );
						if( unArticle != null ){
							Vector<LigneArticle> sigmaLignesArticles = leControleur.getObjVente().getLigneArticlesVector();
							int leCumul = 0;
							int laLOngueur = sigmaLignesArticles.size();
							for( int laLigne = 0; laLigne < laLOngueur; laLigne++){
								leCumul = sigmaLignesArticles.get( laLigne ).getQte()*sigmaLignesArticles.get( laLigne ).getDescriptionProduit().getPrix();
							}
							jtCumulVente.setText( ""+( leCumul ) );
						}
						
						else {
								
							JOptionPane.showMessageDialog( me, "L'article n'existe pas ou est en rupture de stock.", "Recherche d'un article", JOptionPane.WARNING_MESSAGE);
						}
							
							
					}			
				}
				);
        jbCancelVente.addActionListener(
    				new ActionListener(){
    					public void actionPerformed(ActionEvent event) 
    					{	
    						if( jtCodeArticle.getText() != "" ) jtCodeArticle.setText("");
    						if( jtCumulVente.getText() != "" ) jtCumulVente.setText("");
    						if( jtQte.getText() != "" ) jtQte.setText("");  						
    							
    					}			
    				}
    				);
       
  //********************************************************************************************************************************************************
       
   
		theDesktop = new JDesktopPane();
		getContentPane().add(theDesktop);
		
		setSize( (int)myUtilities.SCREENSIZE.getWidth(), (int)myUtilities.SCREENSIZE.getHeight());
		
		setVisible( true );
	}
	

	public static void main(String[] args) {
		try{	    	
	    	leControleur =  new GestionnaireLocations();
	    	leControleur.demarrerSystem();
	    	me = new Principalefenetre();	    	
	        me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
		catch(Exception e){
			e.printStackTrace();
		}
    }
}
