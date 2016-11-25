package modele;

import java.util.Vector;

import commun.DateFormatee;

public class Vente {
	private String    strDateVente;
	private Vector<LigneArticle>   objLar;
	private boolean bEstTermine;
	private Telephone telAcheteur;
	private CodeSecret codeAcheteur;
	private LigneArticle objLigneArticle;
	private float TVQ;
	private float TPS;
	private PaiementAcredit objPaiement;
	
	Vente(Telephone unTelephone, CodeSecret unCodeSecret){
		telAcheteur = unTelephone;
		codeAcheteur = unCodeSecret;
		bEstTermine = false;
		strDateVente = ( new DateFormatee() ).getDateTime();
		objLar = new Vector<LigneArticle>();
	}
	
	public void creerLigneArticle( DescriptionProduit uneDesc, int uneQte ){
		objLigneArticle = new LigneArticle( uneDesc, uneQte);
	}
	
	public void terminer(){
		
	}
	public boolean creerPaiementACredit( String numCarteCredit , float unMontant ){
		PaiementAcredit unPaiement = new PaiementAcredit( numCarteCredit, unMontant );
		VideoClub theSingleton = unPaiement.getSingleton();
		boolean uneAutorisation = theSingleton.getServiceAutorisationCredit( numCarteCredit );
		objPaiement.setAutorisation( uneAutorisation );
		return uneAutorisation;
	}
	
	public int getTotal(){
		int theSize = objLar.size();
		int prixTotal = 0;
		for( int unIndexdeLigne = 0; unIndexdeLigne < theSize; unIndexdeLigne++){
			prixTotal += objLar.get( unIndexdeLigne ).getDescriptionProduit().getPrix()*objLar.get( unIndexdeLigne ).getQte();
		}
		return prixTotal;
	}
	
	public void setTaxes(int unPrix){
		
		float lesTaxes[] = new float[2];
		lesTaxes = CalculateurTaxes.getTaxes(unPrix);
		TPS = lesTaxes[0];
		TVQ = lesTaxes[1];
	}
	
	public float getTaxes(){		
		
		return TPS + TVQ;
	}
	
	public void setEstTermine( boolean aBool ){
		bEstTermine = aBool;
	}
	public boolean EstTermine(){
		return bEstTermine;
	}
	public Vector<LigneArticle> getLigneArticlesVector(){
		return objLar;
	}
	public void setLigneArticle( LigneArticle uneLigneArticle ){
		objLigneArticle = uneLigneArticle;
	}
	public LigneArticle getLigneArticle(){
		return objLigneArticle;
	}
	
	//
	public void setDateVente( String uneDate ){
		strDateVente = uneDate;
	}
	public String getDateVente(){
		return strDateVente;
	}
	
	public void setTelAcheteur( Telephone unTelephone ){
		telAcheteur = unTelephone;
	}
	public Telephone getTelAcheteur(){
		return telAcheteur;
	}
	
	public void setcodeAcheteur( CodeSecret uneCode ){
		codeAcheteur = uneCode;
	}
	public CodeSecret getcodeAcheteur(){
		return codeAcheteur;
	}
	
	

}
