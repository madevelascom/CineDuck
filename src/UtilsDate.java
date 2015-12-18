import java.time.LocalDateTime;

import movies.Cartelera;
import movies.Pelicula;


public class UtilsDate extends Utils {
	static LocalDateTime date;
	
	public static LocalDateTime createInitDate(String anio, String mes, String dia, String horas , String minutos){
		int year 	= Integer.parseInt(anio);
		int month	= Integer.parseInt(mes);
		int day 	= Integer.parseInt(dia);		
		int hour 	= Integer.parseInt(horas);
		int min 	= Integer.parseInt(minutos);
		date 		= LocalDateTime.of(year, month, day, hour, min);
		return date;}
	
	//NLU
	public static LocalDateTime createEndDate(LocalDateTime date, String duracion){
		int len 	= Integer.parseInt(duracion);
		int year 	= date.getYear();
		int month	= date.getMonthValue();
		int day 	= date.getDayOfMonth();		
		int hour 	= date.getHour();
		int min 	= date.getMinute();
		while (len >= 60){
			hour++;
			len 	= len -60;
		}
		min			= min + len;
		date 		= LocalDateTime.of(year, month, day, hour, min);
		return date;}
	
	/*Convierte a formato de fecha el string de la fecha*/
	public static LocalDateTime toDate(String fecha){
		date = LocalDateTime.parse(fecha);
		return date;
		
	}
	
	public static String crearVisor(Cartelera cartel){
		LocalDateTime date = LocalDateTime.now();
		int hour = date.getHour();
		String result;
		if (cartel.getEstado().equals("ACTIVA")){
			result =  ("\n ======================================================="
					+ (Pelicula.buscarCodigo(cartel.getCodigo(), peliculas).get(0).getTitulo()
					+ "\n ======================================================="

					+ "\n Sinopsis: "
					+ (Pelicula.buscarCodigo(cartel.getCodigo(), peliculas).get(0).getSinopsis()
					+ "\n 6. Cambiar estado de una cartelera"
					+ "\n 7. Visualizar una cartelera con su proyeccion"
					+ "\n 8. Regresar")));
					
					//+" Fecha inicio: " +cartel.getFechaI()+ " Fecha final: " + cartel.getFechaF());
			return result;
		}
		else {
			result = "La pelicula ya no esta mas en exhibicion";
			return result;
		}
		
	}
}
