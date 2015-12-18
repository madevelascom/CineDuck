package movies;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class Pelicula {
	private String codigo;
	private String titulo;
	private String año;
	private String genero;
	private String sinopsis;
	private String director;
	private String actores;
	private String restriccion;
	private String duracion;
	private String formato;
	private String poster;
	private Proveedor proveedor;
	
	public Pelicula(String codigo, String titulo, String año, String genero, String sinopsis, String director,
			String actores, String restriccion, String duracion, String formato, String poster ) {
		this.codigo 	= codigo;
		this.titulo 	= titulo;
		this.año 		= año;
		this.genero 	= genero;
		this.sinopsis 	= sinopsis;
		this.director	= director;
		this.actores 	= actores;
		this.restriccion = restriccion;
		this.duracion 	= duracion;
		this.formato 	= formato;
		this.poster 	= poster;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActores() {
		return actores;
	}

	public void setActores(String actores) {
		this.actores = actores;
	}

	public String getRestriccion() {
		return restriccion;
	}

	public void setRestriccion(String restriccion) {
		this.restriccion = restriccion;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public static LinkedList<Pelicula> cargarPeliculas() throws IOException {
		
		URL url							= Pelicula.class.getResource("peliculas.sol");
		LinkedList<Pelicula> clientes	= new LinkedList <Pelicula>();
		BufferedReader br 				= new BufferedReader(new FileReader(url.getPath()));
		try {
			String linea = br.readLine();
			linea= br.readLine();
			while ( linea !=null){
				String []atributos = linea.split("\\|");
				Pelicula cl = new Pelicula (atributos[0],atributos[1],atributos[2],atributos[3],
						atributos[4],atributos[5],atributos[6],atributos[7],atributos[8],atributos[9],atributos[10]);
				clientes.addLast(cl);
				linea=br.readLine();
			}
		}finally{
			br.close();
		}
	return clientes;
	}
	
	public static void guardarPeliculas(LinkedList<Pelicula> peliculas) {
		String comm;
		LinkedList<String> toBeWritten = new LinkedList<String>();
		toBeWritten.add("codigo|titulo|anio|genero|sinopsis|director|actores|restriccion|duracion|formato|poster|proveedor");
		for(Pelicula pelis:peliculas){
			comm = pelis.getCodigo()+"|"+pelis.getTitulo()+"|"+pelis.getAño()+"|"+pelis.getGenero()+"|"+pelis.getSinopsis()
			+"|"+pelis.getDirector()+"|"+pelis.getActores()+"|"+pelis.getRestriccion()+"|"+pelis.getDuracion()
			+"|"+pelis.getFormato()+"|"+pelis.getPoster();
			toBeWritten.add(comm);
		}
		
		try {
			FileOutputStream  fos = new FileOutputStream ("peliculas.sol");
			ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(toBeWritten); 
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public static ArrayList<Pelicula> buscarAnio(String anio,LinkedList<Pelicula> pelicula){
		ArrayList<Pelicula> result = new ArrayList<Pelicula>();
		for (Pelicula peli: pelicula){
			if (peli.getAño().equalsIgnoreCase(anio)){
				result.add(peli);
			}
		}
		return result;
	}
	
	public static ArrayList<Pelicula> buscarGenero(String genero,LinkedList<Pelicula> pelicula){
		ArrayList<Pelicula> result = new ArrayList<Pelicula>();
		for (Pelicula peli: pelicula){
			if (peli.getGenero().equalsIgnoreCase(genero)){
				result.add(peli);
			}
		}
		return result;
	}
	
	public static ArrayList<Pelicula> buscarCodigo(String codigo,LinkedList<Pelicula> pelicula){
		ArrayList<Pelicula> result = new ArrayList<Pelicula>();
		for (Pelicula peli: pelicula){
			if (peli.getCodigo().equalsIgnoreCase(codigo)){
				result.add(peli);
			}
		}
		return result;
	}
	
	public static ArrayList<Pelicula> buscarProveedor(String proov,LinkedList<Pelicula> pelicula){
		ArrayList<Pelicula> result = new ArrayList<Pelicula>();
		for (Pelicula peli: pelicula){
			if (peli.getCodigo().equalsIgnoreCase(proov)){
				result.add(peli);
			}
		}
		return result;
	}
	
	
	public static boolean existePelicula (String codigo,LinkedList<Pelicula> pelicula){
		for (Pelicula peli: pelicula){
			if (peli.getCodigo().equalsIgnoreCase(codigo)){
				return true;
			}
		}
		return false;
	}
	
}

