import java.time.LocalDateTime;
import java.util.Comparator;

import movies.Cartelera;

public class ComparatorTime extends UtilsDate implements Comparator<Cartelera>  {

	@Override
	public int compare(Cartelera arg0, Cartelera arg1) {
		LocalDateTime d1 = toDate(arg0.getFechaI());
		LocalDateTime d2 = toDate(arg1.getFechaI());
		if (d1.isAfter(d2))
            return 1;
        else if (d1.isBefore(d2))
            return -1;
        else
            return 0;
	}

}
