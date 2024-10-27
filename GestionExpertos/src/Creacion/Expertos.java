package Creacion;

import java.io.Serializable;

import ListaD.ListaDinamica;
import ListaD.ListaEstatica;


public class Expertos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String especialidad;
	private ListaEstatica<String> areaInteres = new ListaEstatica<>(10);
	private double x;
	private double y;
	private String contacto;
	private String telContacto;
	private int noControl;
	
	
	
	private ListaDinamica<Agenda> agendaExperto = new ListaDinamica<>();
	
	
	public Expertos() {
		this.noControl=1000;
	}




	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}


	public void setContacto(String contacto) {
		this.contacto = contacto;
	}


	public void setTelContacto(String telContacto) {
		this.telContacto = telContacto;
	}


	public void setX(double x) {
		this.x = x;
	}


	public void setY(double y) {
		this.y = y;
	}


	public int getNoControl() {
		return noControl;
	}


	public ListaEstatica<String> getAreaInteres() {
		return areaInteres;
	}


	public void setAreaInteres(ListaEstatica<String> areaInteres) {
		this.areaInteres = areaInteres;
	}

	

	public ListaDinamica<Agenda> getAgendaExperto() {
		return agendaExperto;
	}


	public void setAgendaExperto(ListaDinamica<Agenda> agendaExperto) {
		this.agendaExperto = agendaExperto;
	}
	


	public void setNoControl(int nu) {
		this.noControl = nu;
	}


	public Expertos clonar() {
        Expertos nuevoExperto = new Expertos();
        nuevoExperto.setNombre(this.nombre);
        nuevoExperto.setEspecialidad(this.especialidad);
        nuevoExperto.setContacto(this.contacto);
        nuevoExperto.setTelContacto(this.telContacto);
        nuevoExperto.setX(this.x);
        nuevoExperto.setY(this.y);
        
        nuevoExperto.setAreaInteres(this.areaInteres);
        nuevoExperto.setAgendaExperto(this.agendaExperto);
        nuevoExperto.setNoControl(this.noControl++);

        return nuevoExperto;
    }
	
	public String toString() {
		return "nombre: "+this.nombre
				+"\n especialidad: "+this.especialidad
				+"\n resiencia: "+this.x+","+this.y
				+"\n contacto: "+this.contacto
				+"\n telefono del contacto: "+this.telContacto
				+"\nno.Control: "+this.noControl+"\n";
	}
	
	
	
	
}
