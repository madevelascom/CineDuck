package movies;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.Scanner;

public class Cartelera{
	private String codigo;
	private String estado;
	private String fechaI;
	private String fechaF;
	private String cineID;
	
	public String getCineID() {
		return cineID;
	}
	public void setCineID(String cineID) {
		this.cineID = cineID;
	}

	static Scanner scanner; 
	
	public Cartelera(String codigo, String cineID, String estado, String fechaI, String fechaF) {
		this.codigo = codigo;
		this.cineID = cineID;
		this.estado = estado;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getFechaI() {
		return fechaI;
	}
	public void setFechaI(String fechaI) {
		this.fechaI = fechaI;
	}
	public String getFechaF() {
		return fechaF;
	}
	public void setFechaF(String fechaF) {
		this.fechaF = fechaF;
	}
	public boolean consultarCarteleraActiva(Cartelera c){
		if (c.getEstado().equals("ACTIVA"))
			return true;
		return false;
		
	}
	
	public static LinkedList<Cartelera> buscarCodigo(LinkedList<Cartelera> peliculas,String codigo){
		LinkedList<Cartelera> result = new LinkedList<Cartelera>();
		for (Cartelera  cartel: peliculas){
			if (cartel.getCodigo().equals(codigo)){
				result.add(cartel);
			}
		}			
		return result;
	}
	public Cartelera cambiarEstado(Cartelera c ) {
		
		if(c.getEstado().equals("ACTIVA")){
			c.setEstado("INACTIVA");
		}
		else{
			c.setEstado("ACTIVA");
		}
			
		return c;
	}
	
public static LinkedList<Cartelera> cargarCartelera() throws IOException {
		
		/*Error si no existe. Depende del ordenador asi que dejo el archivo vacio creado
		 * Exception in thread "main" java.io.IOException: A required privilege is not held by the client
		at java.io.WinNTFileSystem.createFileExclusively(Native Method)
		at java.io.File.createNewFile(Unknown Source)
		at movies.Cartelera.cargarCartelera(Cartelera.java:88)
		at MainCineDuck.main(MainCineDuck.java:20)*/
		File file = new File("cartelera.sol");
		if (!file.exists()){
			file.createNewFile();}
		
		URL url							= Cartelera.class.getResource("cartelera.sol");
		LinkedList<Cartelera> cartelera	= new LinkedList <Cartelera>();
		BufferedReader br 				= new BufferedReader(new FileReader(url.getPath()));
		try {
			String linea = br.readLine();
			linea= br.readLine();
			while ( linea !=null){
				String []atributos = linea.split("\\|");
				Cartelera cl = new Cartelera (atributos[0],atributos[1],atributos[2],atributos[3],atributos[4]);
				cartelera.addLast(cl);
				linea=br.readLine();
			}
		}finally{
			br.close();
		}
		
	return cartelera;
	}

public static void guardarCarteleras(LinkedList<Cartelera> carteleras) {
	String comm;
	LinkedList<String> toBeWritten = new LinkedList<String>();
	toBeWritten.add("codigo|cineID|estado|fechaI|fechaF");
	for(Cartelera cartel:carteleras){
		comm = cartel.getCodigo()+"|"+cartel.getCineID()+"|"+cartel.getEstado()+"|"+cartel.getFechaF()+"|"+cartel.getFechaF();
		toBeWritten.add(comm);
	}
	
	try {
		FileOutputStream  fos = new FileOutputStream ("carteleras.sol");
		ObjectOutputStream oos = new ObjectOutputStream(fos);   
	    oos.writeObject(toBeWritten); 
	    oos.close(); 
	} catch(Exception ex) {
	    ex.printStackTrace();
	}
}

}
