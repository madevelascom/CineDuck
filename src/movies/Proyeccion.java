package movies;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.LinkedList;

public class Proyeccion {
	private String codigo;
	private String cineID;
	private String IDhorario;


	public Proyeccion(String codigo, String cineID, String iDhorario) {
		super();
		this.codigo = codigo;
		this.cineID = cineID;
		IDhorario = iDhorario;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCineID() {
		return cineID;
	}
	public void setCineID(String cineID) {
		this.cineID = cineID;
	}
	public String getIDhorario() {
		return IDhorario;
	}
	public void setIDhorario(String iDhorario) {
		IDhorario = iDhorario;
	}



	public static LinkedList<Proyeccion> cargarProyecciones() throws IOException {
		
		/*Error si no existe. Depende del ordenador asi que dejo el archivo vacio creado
		 * Exception in thread "main" java.io.IOException: A required privilege is not held by the client
		at java.io.WinNTFileSystem.createFileExclusively(Native Method)
		at java.io.File.createNewFile(Unknown Source)
		at movies.Cartelera.cargarCartelera(Cartelera.java:88)
		at MainCineDuck.main(MainCineDuck.java:20)*/
		File file = new File("proyecciones.sol");
		if (!file.exists()){
			file.createNewFile();}
		
		URL url								= Proyeccion.class.getResource("proyecciones.sol");
		LinkedList<Proyeccion> proyecciones	= new LinkedList <Proyeccion>();
		BufferedReader br 					= new BufferedReader(new FileReader(url.getPath()));
		try {
			String linea = br.readLine();
			linea= br.readLine();
			while ( linea !=null){
				String []atributos = linea.split("\\|");
				Proyeccion cl = new Proyeccion (atributos[0],atributos[1],atributos[2]);
				proyecciones.addLast(cl);
				linea=br.readLine();
			}
		}finally{
			br.close();
		}
		
	return proyecciones;
	}
	
	public static void guardarProyecciones(LinkedList<Proyeccion> proyecciones) {
		String comm;
		LinkedList<String> toBeWritten = new LinkedList<String>();
		toBeWritten.add("codigo|cineID|iDhorario");
		for(Proyeccion proy:proyecciones){
			comm = proy.getCodigo()+"|"+proy.getCineID()+"|"+proy.getIDhorario();
			toBeWritten.add(comm);
		}
		
		try {
			FileOutputStream  fos = new FileOutputStream ("proyecciones.sol");
			ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(toBeWritten); 
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	}

	/*public static Proyeccion crearProyeccion(){
	
	}*/
}
