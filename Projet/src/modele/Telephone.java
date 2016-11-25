package modele;

public class Telephone {
	private String strRegion;
	private String strZone;
	private String strId;

	public Telephone( String uneRegion, String uneZone, String unId ){		
			strRegion = uneRegion;
			strZone = uneZone;
			strId = unId;
	}
	
	public boolean isTelephone( ){
		return ( strRegion.length() == 3 ) && ( strZone.length() == 3 ) && ( strId.length() == 4 );
	}

	public void setRegion(String uneRegion ){
		strRegion = uneRegion;
	}
	
	public String getRegion( ){
		return strRegion;
	}
	
	public void setZone(String uneZone ){
		strZone = uneZone;
	}
	
	public String getZone( ){
		return strZone;
	}
	
	public void setId(String unId ){
		strId = unId;
	}
	
	public String getId( ){
		return strId;
	}
	
	public void resetTelephone( ){
		strRegion = "-1";
		strZone = "-1";
		strId = "-1";
	}
}
