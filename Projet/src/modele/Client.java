package modele;


import commun.DateFormatee;

public class Client {

	private Address   objAddress;
	private Telephone objTelephone;
	private CodeSecret objCodeSecret;
	private String    strDateAbonnement;
	private static final String strEmpty = "";
	
	public Client( Address uneAdresse, Telephone unTelephone, CodeSecret unCodesecret  ){
		
			objAddress = uneAdresse;
			objTelephone = unTelephone;
			strDateAbonnement = (new DateFormatee()).getDateTime();
			objCodeSecret = unCodesecret;	
	}
	
	
	public Client (Telephone unTelephone, CodeSecret unCodesecret){
		objTelephone = unTelephone;
		strDateAbonnement = (new DateFormatee()).getDateTime();
		objCodeSecret = unCodesecret;	
	
	}
	
	public boolean isClient(){
		//return objAddress.getNumero() != "-1" && objTelephone.getRegion() != "-1" && objCodeSecret != "-1";
		return true;
	}
	
	public void resetClient(){
			objAddress = null;
			objTelephone = null;
			objCodeSecret = null;
			strDateAbonnement = "-1";
	}
	public void setAddress( Address uneAdresse ){
		objAddress = uneAdresse;
	}
	public Address getDateVente(){
		return objAddress;
	}
	
	public void setTelAcheteur( Telephone unTelephone ){
		objTelephone = unTelephone;
	}
	public Telephone getTelAcheteur(){
		return objTelephone;
	}
	
	public void setCodeSecret( CodeSecret unCode ){
		objCodeSecret = unCode;
	}
	public CodeSecret getCodeSecret(){
		return objCodeSecret;	
	}
	public void setDateAbonnement( String uneDate ){
		strDateAbonnement = uneDate;
	}
	public String getDateAbonnement(){
		return strDateAbonnement;	
	}

}
