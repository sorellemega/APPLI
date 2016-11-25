package modele;

import java.text.DecimalFormat;
import java.util.Vector;

public class GestionnaireLocations {
	public Vente objVente;
	
	public GestionnaireLocations(){
		
	}
	public Client RechercherClient(Telephone unTelephone, CodeSecret unCodeSecret){
		//String unIdentifiant = unCodeSecret.getCode() + unTelephone.getRegion() + unTelephone.getZone()+unTelephone.getId();
		return RepertoireAbonnes.trouveClient(new Client(unTelephone,unCodeSecret));
	}
	
	public boolean CreerNouvelleVente( Telephone unTelephone, CodeSecret unCodeSecret ){
		objVente = new Vente( unTelephone, unCodeSecret );
		objVente.setEstTermine( false );
		if( objVente == null ) return false;
		else return true;		
	}
	
	public DescriptionProduit saisirArticle(String unCodeArticle, int uneQte){
		DescriptionProduit uneDesc = CatalogueProduits.getDescriptionProduit(unCodeArticle);
		objVente.creerLigneArticle(uneDesc, uneQte);
		if( objVente.getLigneArticle() != null ) {
			objVente.getLigneArticlesVector().add( objVente.getLigneArticle() );
			return uneDesc; //ligne cree
			}
		return null;
	}
	public Article saisirArticleetRetourneArticle(String unCodeArticle, int uneQte){
		Article unArticle = CatalogueProduits.getArticle(unCodeArticle);
		objVente.creerLigneArticle(unArticle, uneQte);
		if( objVente.getLigneArticle() != null ) {
			objVente.getLigneArticlesVector().add( objVente.getLigneArticle() );
			return unArticle; //ligne cree
			}
		return null;
	}
	
	public void terminerVente(){
		objVente.setEstTermine( true );
		objVente = null;		
		int totalMontantVente = objVente.getTotal();
		objVente.setTaxes(totalMontantVente);
		float totalVentePlusTaxes = totalMontantVente + objVente.getTaxes();
		String leTotal = new DecimalFormat("0.00").format(totalVentePlusTaxes);
	}
	
	public void creerPaiementACredit(String numCarteCredit){
		boolean thecreation = objVente.creerPaiementACredit(numCarteCredit, objVente.getTotal() + objVente.getTaxes() );
		if( thecreation ) {
			VideoClub.ajouterVenteTerminee( objVente );
			VideoClub.ajouterLocationEnCours( objVente );
			
		}
		else  VideoClub.ajouterVenteRefusee( objVente );
		
	}
	public static Vector<Client> getListeClient(){
		return RepertoireAbonnes.getListedesClients();
	}
	public static Vector<Article> getListeProduits(){
		return CatalogueProduits.getProduits();
	}
	public void demarrerSystem(){
		VideoClub leSingleton = VideoClub.instance();
		leSingleton.initialiserVideoClub();
	}
	
		
	public Vente getObjVente(){
		return objVente;
	}
}
