package movies;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class Proveedor {
	private String codigo;
	private String nombre;
	private String ciudad;
	private String pais;
	
	public Proveedor(String codigo, String nombre, String ciudad, String pais) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais 	= pais;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public static LinkedList<Proveedor> cargarProveedores() throws IOException {
		LinkedList<Proveedor> clientes=new LinkedList <Proveedor>();
		URL url= Proveedor.class.getResource("proveedores.sol");
		BufferedReader br = new BufferedReader(new FileReader(url.getPath()));
		try {
			String linea = br.readLine();
			linea= br.readLine();
			while ( linea !=null){
				String []atributos = linea.split("\\|");
				Proveedor cl = new Proveedor (atributos[0],atributos[1],atributos[2],atributos[3]);
				clientes.addLast(cl);
				linea=br.readLine();
			}
		}finally{
			br.close();
		}
	return clientes;
	}
	
	public static void guardarProveedor(LinkedList<Proveedor> proveedores) {
		String comm;
		LinkedList<String> toBeWritten = new LinkedList<String>();
		toBeWritten.add("codigo|nombre|ciudad|pais");
		for(Proveedor prov:proveedores){
			comm = prov.getCodigo()+"|"+prov.getNombre()+"|"+prov.getCiudad()+"|"+prov.getPais();
			toBeWritten.add(comm);
		}
		
		try {
			FileOutputStream  fos = new FileOutputStream ("proveedores.sol");
			ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(toBeWritten); 
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public static ArrayList<Proveedor> buscarCiudad(String ciudad, LinkedList<Proveedor> proveedor){
		ArrayList<Proveedor> result = new ArrayList<Proveedor>();
		for (Proveedor prov: proveedor){
			if (prov.getCiudad().equalsIgnoreCase(ciudad)){
				result.add(prov);
			}
		}
		return result;
	}
	
	public static ArrayList<Proveedor> buscarPais(String pais,LinkedList<Proveedor> proveedor){
		ArrayList<Proveedor> result = new ArrayList<Proveedor>();
		for (Proveedor prov: proveedor){
			if (prov.getCiudad().equalsIgnoreCase(pais)){
				result.add(prov);
			}
		}
		return result;
	}

}
