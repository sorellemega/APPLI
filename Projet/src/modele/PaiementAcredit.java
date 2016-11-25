package modele;

public class PaiementAcredit {
	private boolean bPaiementAcredit;
	private String strCarteDeCredit;
	private float fTotalPaiement;
	private static VideoClub objVideoClub;
	private boolean bAutorisation;
	
	public  PaiementAcredit( String unNumeroDecarteDeCredit, float totalVente ){
		bPaiementAcredit = true;
		strCarteDeCredit = unNumeroDecarteDeCredit;
		fTotalPaiement = totalVente;
		bAutorisation = false;
		
	}
	static{

		objVideoClub = VideoClub.instance();
	}
	
	public void setGenreDePaiement( boolean unBool){
		bPaiementAcredit = unBool;
	}
	public boolean getGenreDePaiement( ){
		return bPaiementAcredit;
	}
	
	public void setCarteDeCredit( String uneCarteDeCredit ){
		strCarteDeCredit = uneCarteDeCredit;
	}
	public String getCarteDeCredit( ){
		return strCarteDeCredit;
	}
	
	
	public void setTotalPaiement( float unPaiement){
		fTotalPaiement = unPaiement;
	}
	public float getTotalPaiement( ){
		return fTotalPaiement;
	}
	
	public static VideoClub getSingleton(){
		return objVideoClub;
	}
	public void setAutorisation( boolean unBool ){
		bAutorisation = unBool;
	}
	
	public boolean getAutorisation(){
		return bAutorisation;
	}
	
}