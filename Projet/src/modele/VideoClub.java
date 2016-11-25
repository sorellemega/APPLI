package modele;

import java.util.Vector;

import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

public class VideoClub {
	private static Vector<Vente> VentesTerminees;
	private static Vector<Vente> VentesRefusees;
	private static Vector<Vente> LocationsEnCours;	
	private static VideoClub instance = null;
	
	
	public static VideoClub instance() {
		 if (instance == null) {
		 instance = new VideoClub();
		}
		return instance;
	}
	static{
		VentesTerminees = new Vector<Vente>();
		VentesRefusees = new Vector<Vente>();
		LocationsEnCours = new Vector<Vente>();
	}
	public void initialiserVideoClub(){
		CatalogueProduits.initCatalog();
		RepertoireAbonnes.ChargerAbonnes();
	}
	
	
	public static boolean getServiceAutorisationCredit(String CarteCredit){
		int leRandom100 = (int)(100*Math.random());
    	if( leRandom100 < 11 ) return false;
		return true;
	}
	
		
	public static void ajouterVenteTerminee(Vente venteAcceptee ){
		VentesTerminees.add( venteAcceptee );		
	}
	
	public static void ajouterVenteRefusee(Vente venteRefusee ){
		VentesRefusees.add(venteRefusee);
	}
	public static void ajouterLocationEnCours(Vente uneVenteApprouvee ){
		
		LocationsEnCours.add( uneVenteApprouvee );
	}
	
	
	 

}
