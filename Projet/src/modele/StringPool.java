

package modele;


public class StringPool extends Object {
    
    protected static String strRoot;
    protected static String strAttributes;
   
        
    /** Creates new StringPool */
    public StringPool() {
    }
    public static final String strEmpty = "";
    public static final String sp = " ";
    public static final String dash = " - ";
    public static final String sc = ":";
    public static final String nl = "\n";
    public static final String br_s1 = "[";
    public static final String br_s2 = "]";
    public static final String br_c1 = "(";
    public static final String br_c2 = ")";
    public static final String br_c2_sp = ") ";
    public static final String br_s2_sp = "] ";
    
    public static final String str0     = "0";
    public static final String str00    = "00";
    
    protected final static int NO  = 0;
    protected final static int YES = 1;
    protected final static int SELECT   = 0;
    protected final static int UNSELECT = 1;
    protected final static int CANCEL_SELECT = 2;
    protected static String strError;
   
    // Common Dialog
    public static String strYES;
    public static String strNO;
    public static String strYes;
    public static String strNo;
    public static String strCancel;
    public static String strOK;
    public static String strClose;
    public static String strEnable;
    public static String strDisable;
    public static String strReserved;
    
    protected static String [] strNoYes;
    public static String [] strSelect;
    
    // Resource Names
    public static String strFilmAlouer;
    public static String strFilmAVendre;
    public static String strConsommable;

    public static String strNone;
    
   
    
    public static void InitText(){
        strError    = "Error Value";
        strYES      = "YES";
        strNO       = "NO";
        strYes      = "Yes";
        strNo   = "No";
        strCancel   = "Cancel";
        strOK       = "OK";
        strClose    = "Close";
        strEnable   = "Enable";
        strDisable  = "Disable";
        strReserved = "Reserved";
        if( strNoYes == null ) strNoYes = new String[ 2 ];
        strNoYes[ 0 ] = strNO;
        strNoYes[ 1 ] = strYES;
        if( strSelect == null ) strSelect = new String[ 3 ];
        strSelect[ 0 ] = "Select";
        strSelect[ 1 ] = "Unselect";
        strSelect[ 2 ] = strCancel;        
        strNone = "None";
        
        // System Database
    	strRoot = "System Database";
        strFilmAlouer = "Film à louer";
        strFilmAVendre = "Film à louer";
        strConsommable = "Consommable";  
       
        InitLater();
    }
    public static void InitLater(){
        
    }   
   
    static {
        InitText();
    }
    
}

