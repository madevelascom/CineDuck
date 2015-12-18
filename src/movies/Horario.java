package movies;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;

public class Horario {
	private String ID;
	private String cine;
	private String sala;
	private String hora;
	
	public Horario(String iD, String cine, String sala, String hora) {
		ID = iD;
		this.cine = cine;
		this.sala = sala;
		this.hora = hora;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCine() {
		return cine;
	}
	public void setCine(String cine) {
		this.cine = cine;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}

	public static LinkedList<Horario> cargarHorarios() throws IOException {
		LinkedList<Horario> horarios= new LinkedList <Horario>();
		URL url						= Horario.class.getResource("horarios.sol");
		BufferedReader br 			= new BufferedReader(new FileReader(url.getPath()));
		try {
			String linea = br.readLine();
			linea= br.readLine();
			while ( linea !=null){
				String []atributos 	= linea.split("\\|");
				Horario cl 			= new Horario (atributos[0],atributos[1],atributos[2], atributos[3]);
				horarios.addLast(cl);
				linea=br.readLine();
			}
		}finally{
			br.close();
		}
	return horarios;
	}
	
	public static void guardarHorarios(LinkedList<Horario> horarios) {
		String comm;
		LinkedList<String> toBeWritten = new LinkedList<String>();
		toBeWritten.add("iD|cine|sala|hora");
		for(Horario horass:horarios){
			comm = horass.getID()+"|"+horass.getCine()+"|"+horass.getSala();
			toBeWritten.add(comm);
		}
		
		try {
			FileOutputStream  fos = new FileOutputStream ("horarios.sol");
			ObjectOutputStream oos = new ObjectOutputStream(fos);   
		    oos.writeObject(toBeWritten); 
		    oos.close(); 
		} catch(Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public static int getLastID(LinkedList<Horario> horarios){
		int result;
		if (horarios.isEmpty()){
			 result = 0;
		}else{
			 result = Integer.parseInt(horarios.getLast().getID());
		}
		
		return result;
	}
	
	public static ArrayList<Horario> buscarAnio(String id,LinkedList<Horario> horarios){
		ArrayList<Horario> result = new ArrayList<Horario>();
		for (Horario hori: horarios){
			if (hori.getID().equalsIgnoreCase(id)){
				result.add(hori);
			}
		}
		return result;
	}
	
	

		
	
}