package modele;

public class CodeSecret {
	private int nCode;
	
	public CodeSecret( int unCode ){
		if( nCode >= 0 ) nCode = unCode;	
		else nCode = -1;
	}
	
	public void setCode(int unCode ){
		nCode = unCode;
	}
	
	public int getCode( ){
		return nCode;
	}

}
