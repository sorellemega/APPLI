package modele;

public class DescriptionProduit {
	private String strDescription;
	private int nPrix;
	private String strCodeArticle;
	
	DescriptionProduit( String uneDescription, int unPrix, String unCodeArticle ){
		strDescription = uneDescription;
		nPrix = unPrix;
		strCodeArticle = unCodeArticle;	
		if( !isProductDescription() ) resetDescriptionProduit();
	}
	
	public boolean isProductDescription(){
		return  strDescription.length() > 5  && strDescription.length() < 50  && nPrix > 0 && strCodeArticle.length() == 10; 		
	}
	
	public void resetDescriptionProduit(){
		strDescription = "-1";
		nPrix = -1;
		strCodeArticle = "-1";
	}
	
	public void setDescription( String uneDescription ){
		strDescription = uneDescription;
	}
	public String getDescription(){
		return strDescription;
	}
	
	public void setPrix( int unPrix ){
		nPrix = unPrix;
	}
	public int getPrix(){
		return nPrix;
	}
	
	public void setCodeArticle( String unCodeArticle ){
		strCodeArticle = unCodeArticle;
	}
	public String getCodeArticle(){
		return strCodeArticle;
	}
}
