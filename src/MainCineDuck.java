import java.io.IOException;
import java.util.LinkedList;
import movies.Proveedor;
import movies.Proyeccion;
import movies.Cartelera;
import movies.Cine;
import movies.Horario;
import movies.Pelicula;


public class MainCineDuck {

	public static LinkedList<Pelicula> 	peliculas 		= new LinkedList<Pelicula>();
	public static LinkedList<Proveedor> proveedores 	= new LinkedList<Proveedor>(); 
	public static LinkedList<Cine> 		cines 			= new LinkedList<Cine>();
	public static LinkedList<Cartelera> carteleras 		= new LinkedList<Cartelera>();
	public static LinkedList<Proyeccion>proyecciones 	= new LinkedList<Proyeccion>();
	public static LinkedList<Horario> 	horarios 		= new LinkedList<Horario>();	

	public static void main(String[] args) throws IOException {
		peliculas 	= Pelicula.cargarPeliculas();
		proveedores = Proveedor.cargarProveedores();
		cines 		= Cine.cargarCines();
		carteleras	= Cartelera.cargarCartelera();
		proyecciones= Proyeccion.cargarProyecciones();
		horarios	= Horario.cargarHorarios();
		
		Utils.menu();
		
		Pelicula.guardarPeliculas(peliculas);
		Proveedor.guardarProveedor(proveedores);
		Cine.guardarCines(cines);
		Cartelera.guardarCarteleras(carteleras);
		Proyeccion.guardarProyecciones(proyecciones);
		Horario.guardarHorarios(horarios);

	}
}
