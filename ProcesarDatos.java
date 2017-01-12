package Java;

import java.io.*;

public class ProcesarDatos {
	public String nombre;
	public String apellido1;
	public String apellido2;
	public String mail;
	public String direccion;
	public String telefono;
	public String idioma;
	public String tituloReglado;
	public String tituloNoReglado;
	public File cv;
	
	public ProcesarDatos(){
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
		this.mail= "";
		this.direccion= "";
		this.telefono = "";
		this.idioma= "";
		this.tituloReglado= "";
		this.tituloNoReglado= "";
	}
	
	public ProcesarDatos( String nombre, String apellido1, String apellido2, String mail, String dire, String telefono, String idioma, 
			String reglado, String noReglado){
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.mail= mail;
		this.direccion= dire;
		this.telefono = telefono;
		this.idioma= idioma;
		this.tituloReglado= reglado;
		this.tituloNoReglado= noReglado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getTituloReglado() {
		return tituloReglado;
	}

	public void setTituloReglado(String tituloReglado) {
		this.tituloReglado = tituloReglado;
	}

	public String getTituloNoReglado() {
		return tituloNoReglado;
	}

	public void setTituloNoReglado(String tituloNoReglado) {
		this.tituloNoReglado = tituloNoReglado;
	}

	public File getCv() {
		return cv;
	}

	public void setCv(File cv) {
		this.cv = cv;
	}
	
	public String ComprobarElemento(String elemento, String dato){
		String msg = "Es Correcto";
		if(dato.equals(" ")){
		switch(elemento){
		case "nombre":
			msg = "Introzuca correctamente su nombre";
			break;
		case "apellido":
			msg = "Introzuca correctamente su primer Apellido";
			break;
		case "apellido2":
			msg = "Introzuca correctamente su segundo Apellido";
			break;
		case "mail":
			msg = "Su mail no es correcto";
			break;
		case "telefono":
			msg = "Ese n&uacute;mero no existe";
			break;
			
		case "direccion":
			msg = "¿Est&aacute; segururo que vive aqu&iacute;?";

			break;
			
		case "idioma":
			msg = "No existe tal idioma";

			break;
			
		case "estudios":
			msg = "No ha introducido ning&uacute;n dato sobre sus estudios";

			break;
		}
			
				
			}
		return msg;
	}
	
	public String GuardarCV(){
		String msg = "Es Correcto";
		BufferedWriter bw;
		this.cv = new File("home/usuario/Proyectos/PR02/web/WEB-INF/"+this.apellido1+this.apellido2+"txt");
		try {
			bw = new BufferedWriter(new FileWriter(this.cv,true));
			bw.write(this.nombre+";"+this.apellido1+";"+this.apellido2+";"+this.mail+";"+this.direccion+";"+this.telefono);
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = "Ha ocurrido un error intentelo m&aacute;s tarde";
		}
		return msg;
	}
	
	public String[] getDatosFichero(){
		String[] datos = new String[0];
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.cv));
			if(br.readLine()!=null){
				datos = br.readLine().split(";");
			}else{
				datos[0]="Sin Datos";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datos;
	}
	
}
