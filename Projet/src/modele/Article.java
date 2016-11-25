package modele;


public class Article extends DescriptionProduit{
	private String strCodeArticle;
	private int nPrix;
	private String strDescription;
	private String strGenre;
	private String strSupport;
	private boolean bNouveau;
	private boolean bConsommable;
	private int nQte;
	private String strTitre;
	private String strDate;	
	public static String SUPPORT_DVD = "DCD";
	public static  String SUPPORT_BLUERAY = "BLUERAY";
	public static int PRIX_VENTE_FILM = 10;
	public static final int PRIX_LOCATION_JOUR = 2;
	public static final int PRIX_LOCATION_HEBDO = 5;
	
	
	public Article( String unCodeArticle, int unPrix, String uneDescription, String unGenre, String unSupport, boolean unNouveau, boolean unConsommable, int uneQte, String unTitre, String uneDate ) {
		super( uneDescription, unPrix, unCodeArticle );
		strCodeArticle = unCodeArticle;
    	nPrix = unPrix;
    	strDescription = uneDescription;
    	strGenre = unGenre;
    	strSupport = unSupport;
    	bNouveau = unNouveau;
    	bConsommable = unConsommable;
    	nQte = uneQte;
    	strTitre = unTitre;        
    	strDate = uneDate;
       
    }
	
    public Article( String unCodeArticle, int unPrix, String uneDescription ){
    	super( uneDescription, unPrix, unCodeArticle );
        strCodeArticle = unCodeArticle;
    	nPrix = unPrix;
    	strDescription = uneDescription;
    }
	
	public void setQte(int uneQte ){
		nQte = uneQte;
	}
	
	public int getQte(){
		return nQte;
	}

	public void setCodeArticle(String unCodeArticle ){
		strCodeArticle = unCodeArticle;
	}
	
	public String getCodeArticle(){
		return strCodeArticle;
	}
	
	public void setPrix(int unPrix ){
		nPrix = unPrix;
	}
	
	public int getPrix(){
		return nPrix;
	}
	
	public void setDescription(String uneDescription ){
		strDescription = uneDescription;
	}
	
	public String getDescription(){
		return strDescription;
	}
	
	public void setGenre(String uneGenre ){
		strGenre = uneGenre;
	}
	
	public String getGenre(){
		return strGenre;
	}

	public void setSupport(String unSupport ){
		strSupport = unSupport;
	}
	
	public String getSupport(){
		return strSupport;
	}
	
	public void setNouveau(boolean unBool ){
		bNouveau = unBool;
	}
	
	public boolean getNouveau(){
		return bNouveau;
	}
	
	public void setConsommable(boolean unBool ){
		bConsommable = unBool;
	}
	
	public boolean getConsommable(){
		return bConsommable;
	}
	public void setTitre(String unTitre ){
		strTitre = unTitre;
	}
	
	public String getTitre(){
		return strTitre;
	}

	public void setDate(String uneDate ){
		strDate = uneDate;
	}
	
	public String getDate(){
		return strDate;
	}
	
	public DescriptionProduit getObjDescription(){
		return new DescriptionProduit( strDescription, nPrix, strCodeArticle );
	}

	
	
	

}
