package modele;

public class LigneArticle {
	private DescriptionProduit objDescProduit;
	private int nQte; 
	
	
	LigneArticle(DescriptionProduit uneDescdeProduit, int uneQte){
		objDescProduit = uneDescdeProduit;
		nQte = uneQte;
	}
	
	public void setDescriptionProduit( DescriptionProduit uneDesc ){
		objDescProduit = uneDesc;
	}
	public DescriptionProduit getDescriptionProduit(){
		return objDescProduit;
	}
	
	public void setQte( int uneQte ){
		nQte = uneQte;
	}
	public int getQte(){
		return nQte;
	}
}
