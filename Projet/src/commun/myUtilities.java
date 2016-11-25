package commun;

import java.awt.Dimension;
import java.awt.Toolkit;



public class myUtilities {
	
	public static final Dimension SCREENSIZE = getScreenSize();
	
	public 	myUtilities()
	{
		
	}
	 
	   public static Dimension getScreenSize(){
		   
	   Toolkit toolkit =  Toolkit.getDefaultToolkit ();
	   Dimension dim = toolkit.getScreenSize();
	   return dim;
	   
	   }
	   
	   public static  char[] sort(String word) {

	        int i, count = 0, k;
	        boolean doublon = false;
	        char[] values;
	         int[] template = new int[word.length()];
	         char[] resultat = new char[word.length()];
	         String realWord = word.trim();  // removing spaces
	           
	      values = realWord.toCharArray();
	        template[count] = (int) ((values.length)*Math.random());
	        count++;
	        while( count <= values.length -1  )
	        	{
	        	k =  (int) (values.length*Math.random());
	        	 for (i = 0; i < count; i++) 
	        	 {
	        	   if( template[i]  == k ) { doublon = true; }
	        	 }
	        	 if( !doublon ) { template[count] = k ;count++; }
	        	 doublon = false; // set doublon to false for next round
	        	}
	        	
	        for (i = 0; i < values.length; i++) {
	        
	        resultat[i] = values[template[i]];
	        }
	        return resultat;
	    }
}

