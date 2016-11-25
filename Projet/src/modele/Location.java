package modele;

import java.util.Vector;

public class Location {
	private Vector<Article> objFilmsLoues;
	private String tmDateLocation;
	private CodeSecret codeLocateur;
	private Telephone telLocateur;
	
	Location( Vente uneVenteApprouvee ){
		objFilmsLoues = new Vector<Article>();
		buildLocation( uneVenteApprouvee );	
		tmDateLocation = uneVenteApprouvee.getDateVente();
		codeLocateur   = uneVenteApprouvee.getcodeAcheteur();
		telLocateur    = uneVenteApprouvee.getTelAcheteur();
	}
	
	public void setDateVente( String uneDate ){
		tmDateLocation = uneDate;
	}
	public String getDateVente(){
		return tmDateLocation;
	}
	
	public void setTelAcheteur( Telephone unTelephone ){
		telLocateur = unTelephone;
	}
	public Telephone getTelAcheteur(){
		return telLocateur;
	}
	
	public void setcodeAcheteur( CodeSecret uneCode ){
		codeLocateur = uneCode;
	}
	public CodeSecret getcodeAcheteur(){
		return codeLocateur;
	}
	public void buildLocation( Vente uneVenteApprouvee ){
		Vector<LigneArticle> lesLigneDeLaVente = uneVenteApprouvee.getLigneArticlesVector();
		int theSize = lesLigneDeLaVente.size();		
		for( int index = 0; index < theSize; index++ ){
			DescriptionProduit laDesc = lesLigneDeLaVente.get(index).getDescriptionProduit();
			Article theArticle = CatalogueProduits.getArticle( laDesc.getCodeArticle() );
			if( !theArticle.getConsommable() ) objFilmsLoues.add( theArticle );
		}	
	}
}
