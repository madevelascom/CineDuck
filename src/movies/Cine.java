package movies;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.LinkedList;

public class Cine {
	private String codigo;
	private String ciudad;
	private String direccion;
	public Cine(String codigo, String ciudad, String direccion) {
		this.codigo 	= codigo;
		this.ciudad 	= ciudad;
		this.direccion 	= direccion;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	public static LinkedList<Cine> cargarCines() throws IOException {
		LinkedList<Cine> clientes	= new LinkedList <Cine>();
		URL url						= Cine.class.getResource("cines.sol");
		BufferedReader br 			= new BufferedReader(new FileReader(url.getPath()));
		try {
			String linea = br.readLine();
			linea= br.readLine();
			while ( linea !=null){
				String []atributos 	= linea.split("\\|");
				Cine cl 			= new Cine (atributos[0],atributos[1],atributos[2]);
				clientes.addLast(cl);
				linea=br.readLine();
			}
		}finally{
			br.close();
		}
	return clientes;
	}
	
	public static void guardarCines(LinkedList<Cine> cines) {
		String comm;
		LinkedList<String> toBeWritten = new LinkedList<String>();
		toBeWritten.add("codigo|ciudad|direccion");
		for(Cine ciness:cines){
			comm = ciness.getCodigo()+"|"+ciness.getCiudad()+"|"+ciness.getDireccion();
			toBeWritten.add(comm);
		}
		
		try {
			FileOutputStream  fos = new FileOutputStream ("cines.sol");
			ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(toBeWritten); 
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public static Cine buscarCodigo(LinkedList<Cine> cines,String codigo){
		for (Cine  ciness: cines){
			if (ciness.getCodigo().equals(codigo)){
				return ciness;
			}
		}			
		return null;
	}
	
}
