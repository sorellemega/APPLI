package modele;

public class Address {
	
	private String strNumero;
	private String strRue;
	private String strAppartement;
	private String strVille;
	private String strProvince;
	private String strPays;
	private String strCodePostal;
	
	Address( String unNumero, String uneRue, String unAppartement, String uneVille, String uneProvince, String unPays, String unCodePostal ){		
			strNumero = unNumero;
			strRue = uneRue;
			strAppartement = unAppartement;
			strVille = uneVille;
			strProvince = uneProvince;
			strPays = unPays;
			strCodePostal = unCodePostal;	
	}
	
	public void setNumero(String unNumero){
		strNumero = unNumero;
	}
	
	public String getNumero(){
		return strNumero;
	}
	
	public void setRue(String uneRue){
		strRue = uneRue;
	}
	
	public String getRue(){
		return strRue;
	}
	
	public void setAppartement(String unAppartement){
		strAppartement = unAppartement;
	}
	
	public String getAppartement(){
		return strAppartement;
	}
	
	public void setVille(String uneVille){
		strVille = uneVille;
	}
	
	public String getVille(){
		return strVille;
	}
	
	public void setProvince(String uneProvince){
		strProvince = uneProvince;
	}
	
	public String getProvince(){
		return strProvince;
	}
	
	public void setPays(String unPays){
		strPays = unPays;
	}
	
	public String getPays(){
		return strPays;
	}
	
	public void setCodePostal(String unCodePostal){
		strNumero = unCodePostal;
	}
	
	public String getCodePostal(){
		return strCodePostal;
	}
	
	public boolean isAddress(){
		
		return  !(( strNumero.length() <= 0 || strNumero.length() > 4 ) || 
				( strRue.length() <= 0 || strRue.length() > 50 ) || 
				( strAppartement.length() <= 0 || strAppartement.length() > 4) || 
				( strVille.length() <= 3 || strVille.length() > 50 ) || 
				( strProvince.length() <= 0 || strProvince.length() > 50 ) 
				|| ( !strPays.toLowerCase().equals("canada") ) ||
				( strCodePostal.length() != 6 ));
	}
	
	public void resetAddress(){
		strNumero = "-1";
		strRue = "-1";
		strAppartement = "-1";
		strVille = "-1";
		strProvince = "-1";
		strPays = "-1";
		strCodePostal = "-1";
	}
	

}
