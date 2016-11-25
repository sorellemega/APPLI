package modele;

public class CalculateurTaxes {
	public final static float TAUX_TVQ = (float) 0.1;
	public final static float TAUX_TPS = (float) 0.05;
	
	
	public static float[] getTaxes( int unPrix ){
		float[] leresultat = new float[2];
		leresultat[0] = unPrix*TAUX_TPS;
		leresultat[1] = ( leresultat[0] + unPrix )*TAUX_TVQ;
		return leresultat;
	}

}
