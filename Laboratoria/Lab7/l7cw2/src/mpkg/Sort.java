package mpkg;
import java.util.Comparator;


public class Sort implements Comparator<Pracownik> {

	
	public int compare(Pracownik o1, Pracownik o2) {
		if(o1.wynagrodzenieBrutto == o2.wynagrodzenieBrutto) return 0;
		else if(o1.wynagrodzenieBrutto > o2.wynagrodzenieBrutto) return 1;
		else  return -1;
		
	}
	
}
