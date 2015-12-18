import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

import movies.Cartelera;
import movies.Cine;
import movies.Horario;
import movies.Pelicula;
import movies.Proveedor;
import movies.Proyeccion;

public class Utils extends MainCineDuck {
	static Scanner scanner; 
	private static String OPTION = "Ingrese alguna de las opciones anteriores para continuar:";
	static String codigoPelicula;
	static String anio;
	static String mes;
	static String dia;
	static String hora;
	static String min;
	static String anio2;
	static String mes2;
	static String dia2;
	static String hora2;
	static String min2;

	/* Menu principal*/
	public static void menu(){
		String MENU = "========================================"
				+ "\n ¡Bienvenidos!"
				+ "\n Seleccione alguna de las opciones para continuar"
				+ "\n 1. Proveedores"
				+ "\n 2. Peliculas"
				+ "\n 3. Cines"
				+ "\n 4. Estadisticas"
				+ "\n 0. Salir \n";
		String GOODBYE = ("GRACIAS POR USAR EL PROGRAMA");
		
		System.out.println(MENU);
		int option = Utils.getOptionMenu();
		
		if (option == 1){
			menuProveedor();
		}else if(option == 2){
			menuPeliculas();
		}else if (option == 3){
			menuCines();
		}else if (option == 4){
			
		}else {
			System.out.println(GOODBYE);
		}
	}
	
	public static void menuProveedor(){
		String MENU = "\n Ha escogido la opcion de Proveedores"
				+ "\n 1. Buscar proveedor por ciudad"
				+ "\n 2. Buscar proveedor por pais"
				+ "\n 3. Buscar peliculas del proveedor"
				+ "\n 4. Regresar";
		System.out.println(MENU);
		int option = Utils.getOptionProveedor();
		
		if (option == 1){
			System.out.println("Ingrese la ciudad por la que desea buscar el proveedor");
			scanner 						= new Scanner(System.in);
			String ciudad 					=scanner.nextLine();
			ArrayList<Proveedor> result;
			result 							= Proveedor.buscarCiudad(ciudad, proveedores);
			for (Proveedor  proveedor: result){
				System.out.println(proveedor.getNombre());
			}
			menuProveedor();
		}else if(option == 2){
			System.out.println("Ingrese el pais por el que desea buscar el proveedor");
			scanner 						= new Scanner(System.in);
			String pais 					= scanner.nextLine();
			ArrayList<Proveedor> result;
			result 							= Proveedor.buscarPais(pais, proveedores);
			for (Proveedor  proveedor: result){
				System.out.println(proveedor.getNombre());
			}
			menuProveedor();
		}else if (option == 3){
			System.out.println("Ingrese el codigo del proveedor");
			scanner 						= new Scanner(System.in);
			String codigo 					= scanner.nextLine();
			ArrayList<Pelicula> result;
			result 							= Pelicula.buscarProveedor(codigo, peliculas);
			for (Pelicula peli: result){
				System.out.println(peli.getTitulo());
			}
			menuProveedor();
		}else{
			menu();
		}
		
	}
	
	public static void menuPeliculas(){
		String MENU = "\n Ha escogido la opcion de Peliculas"
				+ "\n 1. Buscar pelicula por genero"
				+ "\n 2. Buscar proveedor por año"
				+ "\n 3. Buscar peliculas por codigo"
				+ "\n 4. Regresar";
		System.out.println(MENU);
		int option = Utils.getOptionProveedor();
		
		if (option == 1){
			System.out.println("Ingrese el genero del que desea las peliculas");
			scanner 						= new Scanner(System.in);
			String genero 					=scanner.nextLine();
			ArrayList<Pelicula> result;
			result 							= Pelicula.buscarGenero(genero, peliculas);
			for (Pelicula  peli: result){
				System.out.println(peli.getTitulo());
			}
			menuPeliculas();
			
		}else if(option == 2){
			System.out.println("Ingrese el año del que desea las peliculas");
			scanner 						= new Scanner(System.in);
			String anio 					=scanner.nextLine();
			ArrayList<Pelicula> result;
			result 							= Pelicula.buscarAnio(anio, peliculas);
			for (Pelicula  peli: result){
				System.out.println(peli.getTitulo());
			}
			menuPeliculas();
			
		}else if (option == 3){
			System.out.println("Ingrese el codigo de la pelicula");
			scanner 						= new Scanner(System.in);
			String codigo 					=scanner.nextLine();
			ArrayList<Pelicula> result;
			result 							= Pelicula.buscarCodigo(codigo, peliculas);
			for (Pelicula  peli: result){
				System.out.println("Titulo: "	+peli.getTitulo());
				System.out.println("Año: "		+peli.getAño());
				System.out.println("Género: "	+peli.getGenero());
				System.out.println("Sinopsis: "	+peli.getSinopsis());
				System.out.println("Director: "	+peli.getDirector());
				System.out.println("Actores: "	+peli.getActores());
				System.out.println("Restricción: "+peli.getRestriccion());
				System.out.println("Duración: "	+peli.getDuracion());
				System.out.println("Formato: "	+peli.getFormato());
				System.out.println("Proveedor: "+peli.getProveedor().getNombre());
				
			}
			menuPeliculas();
		}else{
			menu();
		}
	}
	
	public static void menuCines(){
		String scan;
		for (Cine  ciness: cines){
			System.out.println("Ciudad: "+ciness.getCiudad()+ " Direccion: "+ciness.getDireccion()
			+" Codigo: "+ ciness.getCodigo());
		}
		do{
		System.out.print("Seleccione un cine por su codigo");
		scanner = new Scanner(System.in);
		scan = scanner.nextLine();}
		while (!verificarCodigo(scan));
		
		String MENU = "\n 1. Crear una cartelera"
				+ "\n 2. Crear una proyeccion"
				+ "\n 3. Consultar cartelera activa"
				+ "\n 4. Listar carteleras por fecha"
				+ "\n 5. Buscar cartelera por codigo"
				+ "\n 6. Cambiar estado de una cartelera"
				+ "\n 7. Visualizar una cartelera con su proyeccion"
				+ "\n 8. Regresar";
		//Duracion en minutos
		System.out.println(MENU);
		int option = Utils.getOptionCines();
		
		if (option == 1){
			crearCartelera();
			menuCines();
		}else if(option == 2){
			String codigoPelicula;
			String cineID;
			Cartelera cartel = null;

			do {
				System.out.println("Ingrese el codigo de la pelicula");
				scanner 		= new Scanner(System.in);
				codigoPelicula 	= scanner.nextLine();
			}while (!Pelicula.existePelicula(codigoPelicula, peliculas));
			do {
				System.out.println("Ingrese el codigo del cine");
				scanner 		= new Scanner(System.in);
				cineID 			= scanner.nextLine();
			}while (!verificarCodigo(cineID));
			
			for (Cartelera  cart: carteleras){
				if(cart.getCineID().equals(codigoPelicula) && cart.getCodigo().equals(cineID)){
					cartel.setCineID(cart.getCineID());
					cartel.setCodigo(cart.getCodigo());
					cartel.setEstado(cart.getEstado());
					cartel.setFechaF(cart.getFechaF());
					cartel.setFechaI(cart.getFechaI());
					crearProyeccion(cartel);
					break;
				}
			}
			
			
			menuCines();
		}else if (option == 3){
			for (Cartelera  cartel: carteleras){
				if (scan.equals(cartel.getCineID()) && cartel.getEstado().equals("ACTIVA"))
				System.out.println("Nombre: "+(Pelicula.buscarCodigo(cartel.getCodigo(), peliculas).get(0).getTitulo()
						+" Fecha inicio: " +cartel.getFechaI()+ " Fecha final: " + cartel.getFechaF()));
			}
			menuCines();
		}else if (option == 4){
			carteleras = ordenarFecha(carteleras);
			for (Cartelera  cartel: carteleras){
				if (scan.equals(cartel.getCineID()))
				System.out.println("Nombre: "+(Pelicula.buscarCodigo(cartel.getCodigo(), peliculas).get(0).getTitulo()
						+ " Estado: "+ cartel.getEstado()+" Fecha inicio: "
						+ cartel.getFechaI()+ " Fecha final: " + cartel.getFechaF()));
			}
			menuCines();
		}else if (option == 5) {
			System.out.println("Ingrese el codigo de la pelicula");
			scanner 						= new Scanner(System.in);
			String codigo 					=scanner.nextLine();
			LinkedList<Cartelera> result;
			result 							= Cartelera.buscarCodigo(carteleras, codigo);
			for (Cartelera  cartel: result){
				System.out.println("Cine: "			+Cine.buscarCodigo(cines, cartel.getCineID()).getDireccion());
				System.out.println("Estado: "		+cartel.getEstado());
				System.out.println("Fecha Inicio: "	+cartel.getFechaI());
				System.out.println("Fecha Fin: "	+cartel.getFechaF());
				System.out.println("Estado: "		+cartel.getEstado());				
			}
			menuCines();
		}else if (option == 6) {
			//TODO Cambiar el estado de una cartelera
			menuCines();
		}else if (option == 7) {
			//TODO Visualizar cartelera con proyeccion
			menuCines();
		}else{
			menu();
		}
	}
	
	public void menuStats(){
		//TODO no me acuerdo pa que puse esto xd
	}
	
	public static int getOptionMenu(){
		int scan;
		do {
			System.out.print(OPTION);
			scanner = new Scanner(System.in);
			scan = scanner.nextInt();
		}while (!optionIsValidMenu(scan));
		return scan;
	}

	private static boolean optionIsValidMenu(int scan) {
		
		if (scan== 1 ||scan== 2 || scan== 3	|| scan== 4 ||scan== 0 )
			return true;
		else
			return false;
	}
	
	public static int getOptionProveedor(){	
		int scan;
		do {
			System.out.print(OPTION);
			scanner = new Scanner(System.in);
			scan 	= scanner.nextInt();
		}while (!optionIsValidProveedor(scan));
		return scan;
	}
	
	public static int getOptionCines(){	
		int scan;
		do {
			System.out.print(OPTION);
			scanner = new Scanner(System.in);
			scan 	= scanner.nextInt();
		}while (!optionIsValidCines(scan));
		return scan;
	}

	private static boolean optionIsValidProveedor(int scan) {
		if (scan>= 1 && scan<= 4 )
			return true;
		else
			return false;
	}
	
	private static boolean optionIsValidCines(int scan) {
		if (scan>= 1 && scan<= 8 )
			return true;
		else
			return false;
	}
	
	private static boolean verificarCodigo (String scan){
		for (Cine  ciness: cines){
			if (ciness.getCodigo().equalsIgnoreCase(scan))
				return true;
		}
		return false;
	}
	
	public static Cartelera crearCartelera(){
		String codigoPelicula;
		String cineID;
		Cartelera cartel = null;

		do {
			System.out.println("Ingrese el codigo de la pelicula");
			scanner 		= new Scanner(System.in);
			codigoPelicula 	= scanner.nextLine();
		}while (!Pelicula.existePelicula(codigoPelicula, peliculas));
		do {
			System.out.println("Ingrese el codigo del cine");
			scanner 		= new Scanner(System.in);
			cineID 			= scanner.nextLine();
		}while (!verificarCodigo(cineID));
		System.out.println("Ingrese el año de la pelicula");
		scanner 		= new Scanner(System.in);
		anio 			= scanner.nextLine();
		System.out.println("Ingrese el mes de la pelicula");
		scanner 		= new Scanner(System.in);
		mes 			= scanner.nextLine();
		System.out.println("Ingrese el dia de la pelicula");
		scanner 		= new Scanner(System.in);
		dia 			= scanner.nextLine();
		scanner 		= new Scanner(System.in);
		System.out.println("Ingrese la hora de la pelicula");
		hora 			= scanner.nextLine();
		System.out.println("Ingrese el min de la pelicula");
		scanner 		= new Scanner(System.in);
		min 			= scanner.nextLine();
		LocalDateTime date 	= UtilsDate.createInitDate(anio, mes, dia, hora, min);
		System.out.println("Ingrese el año de la pelicula");
		scanner 		= new Scanner(System.in);
		anio2 			= scanner.nextLine();
		System.out.println("Ingrese el mes de la pelicula");
		scanner 		= new Scanner(System.in);
		mes2 			= scanner.nextLine();
		System.out.println("Ingrese el dia de la pelicula");
		scanner 		= new Scanner(System.in);
		dia2 			= scanner.nextLine();
		scanner 		= new Scanner(System.in);
		System.out.println("Ingrese la hora de la pelicula");
		hora2			= scanner.nextLine();
		System.out.println("Ingrese el min de la pelicula");
		scanner 		= new Scanner(System.in);
		min2 			= scanner.nextLine();
		LocalDateTime date2 	= UtilsDate.createInitDate(anio, mes, dia, hora, min);
		
		if (date2.isAfter(date)){
			String inicio 	= date.toString();
			String fin 		= date.toString();
			String estado;
			if (date2.isAfter(LocalDateTime.now())){
				estado = "ACTIVA";}
			else{
				estado = "INACTIVA";
			}
			cartel = new Cartelera (codigoPelicula, cineID, estado,inicio, fin );
			
		}
		carteleras.add(cartel);
		return cartel;}
	
	@SuppressWarnings("null")
	public static void crearProyeccion(Cartelera cartel){
		String codigoPelicula 	= cartel.getCodigo();
		String cineID			= cartel.getCineID();
		String ID;
		Proyeccion proy 		= null;
		Horario hors			= null;
		int k;
		ArrayList<Pelicula> result;
		result 					= Pelicula.buscarCodigo(codigoPelicula, peliculas);
		String dimension		= result.get(0).getFormato();
		
		if (cartel.getEstado().equals("INACTIVA")){
			System.out.println("Ya no se puede programar en esa cartelera");
		}else{
			k 				= Horario.getLastID(horarios) +1 ;
			do {
				System.out.println("Ingrese el horario (14, 18, 22)");
				scanner 		= new Scanner(System.in);
				ID 				= scanner.nextLine();
			}while (!ID.equals("14") || !ID.equals("22")|| !ID.equals("18"));
			
			if (dimension.equals("2D")){
				proy.setCineID(cineID);
				proy.setCodigo(codigoPelicula);
				proy.setIDhorario(String.valueOf(k));
				hors.setCine(proy.getCineID());
				hors.setHora(ID);
				hors.setID(String.valueOf(k));
				hors.setSala("4");
			}else{
				proy.setCineID(cineID);
				proy.setCodigo(codigoPelicula);
				proy.setIDhorario(String.valueOf(k));
				hors.setCine(proy.getCineID());
				hors.setHora(ID);
				hors.setID(String.valueOf(k));
				hors.setSala("1");
			}
		}
		proyecciones.add(proy);
		horarios.add(hors);
		
	}
	
	public static LinkedList<Cartelera> ordenarFecha(LinkedList<Cartelera> c){
		Collections.sort(c, new ComparatorTime());
		return c;
		
	}
}
