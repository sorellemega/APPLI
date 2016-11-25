

package commun;


import java.util.Date;
import java.text.SimpleDateFormat;


public class DateFormatee extends java.lang.Object {
	
    private String date;
    
    public DateFormatee() {
        Date today = new Date(); 
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yy:HH:mm:SS");
        date = DATE_FORMAT.format(today);
    }
   
    public String getDateTime(){
        return date;
    }
   
}
