package Creacion;
import java.io.Serializable;
import java.time.LocalDate;


public class Agenda implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private double x;
	private double y;
	private String actividades;
	private String encargado;
	private String tel;
	
	private int noControl;
	
	
	public Agenda() {
		this.noControl=1000;
	}

	

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setActividades(String actividades) {
		this.actividades = actividades;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}



	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
	


	public int getNoControl() {
		return noControl;
	}



	public void setNoControl(int nu) {
		this.noControl = nu;
	}


	

	public double getX() {
		return x;
	}



	public double getY() {
		return y;
	}



	public String toString() {
		return "la fecha de inicio es: "+this.fechaInicio
				+"\nla fecha de finalizacion es: "+this.fechaFinal
				+"\nlas coordenadas del lugar es: "+this.x+","+this.y
				+"\nlas actividades a realizar son: "+this.actividades
				+"\nel encargado es: "+this.encargado
				+"\nel telefono del encargado es: "+this.tel
				+"\nno.Control: "+this.noControl+"\n";
	}

	public Agenda clonar() {
        Agenda nuevaAgenda = new Agenda();
        nuevaAgenda.setFechaInicio((LocalDate) this.fechaInicio);
        nuevaAgenda.setFechaFinal((LocalDate) this.fechaFinal); 
        nuevaAgenda.setX(this.x);
        nuevaAgenda.setY(this.y);
        nuevaAgenda.setActividades(this.actividades);
        nuevaAgenda.setEncargado(this.encargado);
        nuevaAgenda.setTel(this.tel);
        nuevaAgenda.setNoControl(this.noControl++);
        return nuevaAgenda;
    }
	
}
