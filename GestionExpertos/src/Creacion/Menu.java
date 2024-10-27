package Creacion;

import java.io.Serializable;
import java.util.Scanner;

import javax.swing.JOptionPane;

import ListaD.ExcepcionDeElementoNoEncontrado;
import ListaD.ExcepcionDeListaLlena;
import ListaD.ExcepcionDeListaVacia;
import ListaD.ListaDinamica;
import Serializacion.Archivar;

public class Menu implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public void menuGestion() throws ExcepcionDeListaLlena, ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		Scanner sc = new Scanner(System.in);
		Archivar archivo = new Archivar();
		Operaciones operaciones = new Operaciones();
		ListaDinamica<Expertos> experto = new ListaDinamica<>();
		
		Expertos comodin;
		Agenda agenda=null;
		byte op=0;
		
		experto = (archivo.activarArchivos());
		
		
		
		
		
		for(;;) {

			System.out.println("Selecciona una opcion:\n"
					+ "1.-Agregar nuevo experto\n"
					+ "2.-Actualizar datos de un experto\n"
					+ "3.-Eliminar el experto de la lista\n"
					+ "4.-Mostrar la lista de expertos\n"
					+ "5.-Agregar un compromiso a la agenda de un experto\n"
					+ "6.-Actualizar un compromiso agendado\n"
					+ "7.-Eliminar un compromiso de la agenda de un experto\n"
					+ "8.-Listar la agenda completa de un experto\n"
					+ "9.-Salir");
			op = sc.nextByte();
			
			switch(op) {
			case 1: 
				if(experto.size()!=0) {
				experto.add(operaciones.agregarExperto(experto.getLast().getNoControl()).clonar());break;	
				}
				experto.add(operaciones.agregarExperto().clonar());
				//agregar nuevo experto 
				break;
			case 2: 
				comodin =operaciones.buscarControl(experto);
			if(comodin!=null){menuActualizarExperto(comodin);break;}
				System.out.println("\nNo se encontro");
				//Actualizar datos de un experto 
				break;
			case 3:comodin =operaciones.buscarControl(experto);
				if(comodin!=null) {experto.delete(operaciones.buscarPosicionExperto(experto));break;}
				System.out.println("\nNo se encontro");
				// Eliminar el experto de la lista 
				break;
			case 4: 
				if(experto.size()!=-0) {operaciones.imprimirExpertos(experto);break;}
				System.out.println("\nno hay elementos en la lista");
				//Mostrar la lista de expertos 
				break;
			case 5: 
				comodin=operaciones.buscarControl(experto);
				if(comodin!=null) {
					if(comodin.getAgendaExperto().size()==0) {
					comodin.getAgendaExperto().add(operaciones.agregarAgenda(experto,comodin.getAgendaExperto()).clonar());break;
					}
					comodin.getAgendaExperto().add(operaciones.agregarAgenda(experto,comodin.getAgendaExperto(),comodin.getAgendaExperto().getLast().getNoControl()).clonar());break;
				}
				System.out.println("\nNo se encontro");
				//Agregar un compromiso a la agenda de un experto 
				break;
			case 6:
				comodin=operaciones.buscarControl(experto);
				if(comodin!=null) {
					if(comodin.getAgendaExperto().size()!=0) {
						agenda =operaciones.buscarAgenda(comodin.getAgendaExperto());
						if(agenda!=null) {
						actualizarAgenda(agenda);break;}
						else {System.out.println("\n no se encontro");break;}
					}
					System.out.println("\nno hay agendas");
				}
				else {System.out.println("\nNo se encontro");}
				//Actualizar un compromiso agendado 
				break;
			case 7: 
				comodin=operaciones.buscarControl(experto);
				if(comodin!=null) {
					comodin.getAgendaExperto().delete(operaciones.buscarPosicionAgenda(comodin.getAgendaExperto()));	
				}
				else {System.out.println("\nNo se encontro");}
				//Eliminar un compromiso de la agenda de un experto 
				break;
			case 8: 
				comodin=operaciones.buscarControl(experto);
				if(comodin!=null) {
					if(comodin.getAgendaExperto().size()!=0) {
						operaciones.imprimirAgendaExperto(comodin.getAgendaExperto());break;
					}
					System.out.println("\nno hay alguna agenda");
				}
				else{System.out.println("\nNo se encontro");}
				//Listar la agenda completa de un experto. 
				break;
			case 9:archivo.agregarArchivos(experto); break;
			default: System.out.println("\nseleccione una opcion valida");break;
			}
			if(op==9) {break;}
			
		}
		
		
		
		
	}
	
	
	public void menuActualizarExperto(Expertos experto) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		Scanner sc = new Scanner(System.in);
		Operaciones operaciones = new Operaciones();
		byte op=0;
		
		for(;;) {
			System.out.println("Selecciona el dato a actualizar: \n"
					+ "1.-Nombre\n"
					+ "2.-Especialidad\n"
					+ "3.-Area\n"
					+ "4.-Residencia\n"
					+ "5.-Contacto\n"
					+ "6.-Telefono del contacto\n"
					+ "7.-Salir");

			op = sc.nextByte();
			
			switch(op) {
			case 1: experto.setNombre(JOptionPane.showInputDialog("Ingresa el nombre del experto"));break;
			case 2: experto.setEspecialidad(JOptionPane.showInputDialog("Ingresa su especialidad"));break;
			case 3: operaciones.actualizarAreaDeInteres(experto.getAreaInteres());break;
			case 4: JOptionPane.showMessageDialog(null,"acontinuacion se debe de agregar su residencia para ello\n primero debera ingresar su coordenada en x, posteiormente\n debera agregar su coordenada en y");
			
			experto.setX(Double.parseDouble(JOptionPane.showInputDialog("coodenada en x")));
			experto.setY(Double.parseDouble(JOptionPane.showInputDialog("coodenada en y")));
			break;
			case 5: experto.setContacto(JOptionPane.showInputDialog("Ingresa el contacto del experto"));break;
			case 6: experto.setTelContacto(JOptionPane.showInputDialog("Ingresa el telefono de dicho contacto"));break;
			case 7: break;
			default:System.out.println("Opcion no valida");break;
			}
			
			if(op == 7) {break;}
			
		}
	    
		//return experto;
	}
	
	public void actualizarAgenda(Agenda agenda) {
		Scanner sc = new Scanner(System.in);
		byte op;
		
		for(;;) {
			
			System.out.println("selecciona una opcion a actualizar"
					+ "\n1.-Actividades a ddesarrollar"
					+ "\n2.-Encargado de la atencion"
					+ "\n3.-Telefono del encargado"
					+ "\n4.-Salir");
			op = sc.nextByte();
			switch(op){
			case 1:agenda.setActividades(JOptionPane.showInputDialog("ingresa las actividades a desarrolar")); break;
			case 2:agenda.setEncargado(JOptionPane.showInputDialog("ingresa el nombre del encargado")); break;
			case 3:agenda.setTel(JOptionPane.showInputDialog("ingresa el numero telefonico del encargado")); break;
			case 4: break;
			default: System.out.println("eleccion no valida ");
			}
			
			if(op==4) {break;}
		}
		
	}
	
	
}
