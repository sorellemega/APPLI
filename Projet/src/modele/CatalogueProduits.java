package modele;

import java.util.Vector;

public class CatalogueProduits {
	private static Vector<Article> arrProduits;
	private static final String strEmpty = "";
    private String strSpace8 = "        ";
	private String strSpace30 = "                              ";
	private String strSpace40 = "                                        ";
	
	CatalogueProduits(){
	}
	
	public static void initCatalog(){
		DescriptionMap.ChargerArticles();
		
		arrProduits = new Vector<Article>();
		int theSize = DescriptionMap.getNumbreDeConsosommables();
		for( int unIndex = 0; unIndex < theSize; unIndex++ ){
			arrProduits.add( DescriptionMap.trouveArticle( "conso"+unIndex ) );
		}
		
		theSize = DescriptionMap.getNumbreDeFilms();
		for( int unIndex = 0; unIndex < theSize; unIndex++ ){
			arrProduits.add( DescriptionMap.trouveArticle( "film"+unIndex ) );
		}
		
	}
	
	public static DescriptionProduit getDescriptionProduit( String unCodeArticle ){
		return DescriptionMap.trouveDescription( unCodeArticle );
	}
	
	public static Article getArticle( String unCodeArticle ){
		return DescriptionMap.trouveArticle( unCodeArticle );
	}
	
	public static Vector<Article> getProduits(){
		return arrProduits;
	}
/*	public void PrintingStock( javax.swing.text.Document aDoc, javax.swing.text.Style aStyle, int aCase) throws javax.swing.text.BadLocationException {
	       Vector<Article> lesArticles = CatalogueProduits.getProduits();
		   int theSize = lesArticles.size();
	       for( int theRow = 0; theRow < theSize; theRow ++ ){
	            String codeArticle = (String) lesArticles.get(theRow).getCodeArticle();
	            String description = (String) lesArticles.get(theRow).getDescription();
	            String prix = (String) strEmpty+lesArticles.get(theRow).getPrix();
	            String titre = (String) strEmpty+lesArticles.get(theRow).getTitre();
	            String mode = lesArticles.get(theRow).getConsommable() ? "Consommable":"Location";
	            String qte = (String) strEmpty+lesArticles.get(theRow).getQte();
	            putLine( strSpace8 + codeArticle + strSpace8 + description + strSpace8 + prix + strSpace8 + titre + strSpace8 + mode  + strSpace8 +qte);
	        }
	    }

	*/
	
	
	

}
