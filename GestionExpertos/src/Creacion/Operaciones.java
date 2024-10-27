package Creacion;
import java.awt.HeadlessException;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import javax.swing.JOptionPane;

import ListaD.ExcepcionDeElementoNoEncontrado;
import ListaD.ExcepcionDeListaLlena;
import ListaD.ExcepcionDeListaVacia;
import ListaD.ListaDinamica;
import ListaD.ListaEstatica;

public class Operaciones implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Operaciones () {}
	
	public Expertos agregarExperto() throws HeadlessException, ExcepcionDeListaLlena {
		Expertos experto = new Expertos();
		
		experto.setNombre(JOptionPane.showInputDialog("Ingresa el nombre del experto"));
		experto.setEspecialidad(JOptionPane.showInputDialog("Ingresa su especialidad"));
		
		JOptionPane.showMessageDialog(null,"Acontinucaion agregaran sus areas de interes");
		experto.setAreaInteres(areaInteres(experto.getAreaInteres()));
		
		JOptionPane.showMessageDialog(null,"acontinuacion se debe de agregar su residencia para ello\n primero debera ingresar su coordenada en x, posteiormente\n debera agregar su coordenada en y");
		
		experto.setX(Double.parseDouble(JOptionPane.showInputDialog("coodenada en x")));
		experto.setY(Double.parseDouble(JOptionPane.showInputDialog("coodenada en y")));
		experto.setContacto(JOptionPane.showInputDialog("Ingresa el contacto del experto"));
		experto.setTelContacto(JOptionPane.showInputDialog("Ingresa el telefono de dicho contacto"));
		return experto;
	}
	

	public Expertos buscarControl(ListaDinamica<Expertos> experto) throws ExcepcionDeListaVacia {
		experto.reiniciarS();
		Scanner sc = new Scanner(System.in);
		int control;
		System.out.println("ingresa el No.Control del experto");
	 	control = sc.nextInt();
	 	
	 	if(experto.getFirst().getNoControl()==control) {
			return experto.getS().getItem();
		}
	 	
		for(int i =1;i<experto.size(); i++) {
			if(control==experto.obtenerSiguiente().getNoControl()) {
				return experto.getS().getItem();
			}
		}
		
		
		return null;
	}
	
	public ListaEstatica<String>  areaInteres(ListaEstatica<String> area) throws HeadlessException, ExcepcionDeListaLlena {
		Scanner sc = new Scanner(System.in);
		int op;
		for(;;) {
			
			
			op = Integer.parseInt(JOptionPane.showInputDialog("selecciona una opcion\n"
					+ "1.-Agregar area de interes\n"
					+ "2.-Salir"));
			switch(op){
			case 1: area.add(JOptionPane.showInputDialog("ingresa el area de su interes"));;break;
			case 2: break;
			default: System.out.println("Eleccion no valida");	
			}
			if(op==2) {break;}
		}
		
		return area;
	}
	
	public ListaEstatica<String> actualizarAreaDeInteres(ListaEstatica<String> area) throws ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado{
		Scanner sc = new Scanner(System.in);
		int op,i;
		String a;
		for(;;) {
			System.out.println("seleccione el dato a actualizar");
			
			for( i = 0; i<area.size();i++) {
				System.out.println((i+1)+".-"+area.getItem(i+1));
			}
			System.out.println((i+1)+".-Salir");
			
			
			op = sc.nextInt();
			if(op>area.size()) {
				System.out.println( "valor mo balido");
			}
			else {
				area.actualizarItem(JOptionPane.showInputDialog("ingrese el nuevo valor"), op-1);
			}
			
			if(op==i+1) {break;}
		}
		
		return area;
	}
	
	public void imprimirExpertos(ListaDinamica<Expertos> experto) throws ExcepcionDeListaVacia {
		experto.reiniciarS();
		System.out.println(experto.getFirst().toString());
		for(int i =1;i<experto.size(); i++) {
			System.out.println(experto.obtenerSiguiente().toString());
			}
		
	}
	
	
	
	public LocalDate elegirFecha() {
        Scanner scanner = new Scanner(System.in);
        int año, mes, dia;
        LocalDate fecha = null;

        while (fecha == null) {
            try {
            	
                dia = Integer.parseInt(JOptionPane.showInputDialog("ingresa el dia"));
                
                mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes (1-12): "));
			
                año = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año: "));

                fecha = LocalDate.of(año, mes, dia);
            } catch (DateTimeException e) {
            	JOptionPane.showMessageDialog(null,"Fecha inválida. Por favor, intente de nuevo.");
            } catch (NumberFormatException e) {
            	JOptionPane.showMessageDialog(null,"Entrada no válida. Asegúrese de ingresar números.");
            }
        }

        return fecha;
    }
	
	public boolean esMayor(LocalDate fecha1, LocalDate fecha2) {
        return fecha1.isAfter(fecha2);
    }
	
	public void imprimirAgendaExperto(ListaDinamica<Agenda> agenda) throws ExcepcionDeListaVacia {
		agenda.reiniciarS();
		System.out.println(agenda.getFirst().toString());
		for(int i =1;i<agenda.size(); i++) {
			System.out.println(agenda.obtenerSiguiente().toString());
			}
		
	}
	
	public Agenda buscarAgenda(ListaDinamica<Agenda> agenda) throws ExcepcionDeListaVacia {
		Scanner sc = new Scanner(System.in);
		int control;
		agenda.reiniciarS();
		System.out.println("ingresa el No.Control de la agenda");
	 	control = sc.nextInt();
	 	if(control==agenda.getFirst().getNoControl()) {
			return agenda.getFirst();
		}
		for(int i =1;i<agenda.size(); i++) {
			if(control==agenda.obtenerSiguiente().getNoControl()) {
				return agenda.getS().getItem();
			}
		}
		
		
		return null;
	}
	
	public int buscarPosicionExperto(ListaDinamica<Expertos> experto) throws ExcepcionDeListaVacia {
		Scanner sc = new Scanner(System.in);
		int control;
		experto.reiniciarS();
		System.out.println("ingresa el No.Control del experto");
	 	control = sc.nextInt();
	 	
	 	if(experto.getFirst().getNoControl()==control) {
			return 0;
		}
	 	
		for(int i =1;i<experto.size(); i++) {
			if(control==experto.obtenerSiguiente().getNoControl()) {
				return i;
			}
		}
		
		
		return -1;
	}
	
	public int buscarPosicionAgenda(ListaDinamica<Agenda> agenda) throws ExcepcionDeListaVacia {
		Scanner sc = new Scanner(System.in);
		int control,i;
		agenda.reiniciarS();
		System.out.println("ingresa el No.Control de la agenda");
	 	control = sc.nextInt();
	 	
	 	if(agenda.getFirst().getNoControl()==control) {
			return 0;
		}
		for( i =1;i<agenda.size(); i++) {
			if(control==agenda.obtenerSiguiente().getNoControl()) {
				return i;
			}
		}
		
		
		return -1;
	}
	
	public Agenda agregarAgenda(ListaDinamica<Expertos> experto,ListaDinamica<Agenda> agendasExistentes) throws ExcepcionDeListaVacia {
		Agenda agenda = new Agenda();
		
		for(;;) {
			for(;;) {
				for(;;) {
					JOptionPane.showMessageDialog(null,"Deberas agregar la fecha de inicio");
					agenda.setFechaInicio(elegirFecha());
					JOptionPane.showMessageDialog(null,"Ahora deberas ingresar la fecha de retiro");
					agenda.setFechaFinal(elegirFecha());
					
					if(!esMayor(agenda.getFechaInicio(),agenda.getFechaFinal())) {break;}
					JOptionPane.showMessageDialog(null,"Las fechas en orden porfavor");
				}
				
				if(agendasExistentes.size()==0) {break;}
				if(fechasValidasAgenda(agenda.getFechaInicio(),agenda.getFechaFinal(),agendasExistentes)) {
					break;
				}
				else{JOptionPane.showMessageDialog(null,"estas fechas chocan con otras fechas");}
				
				
			}
			
			
			JOptionPane.showMessageDialog(null, "se debe de agregar la ubicacion del lugar en coordenadas");
			agenda.setX(Double.parseDouble(JOptionPane.showInputDialog("ingrese la coordenada en el eje x")));
			agenda.setY(Double.parseDouble(JOptionPane.showInputDialog("ingrese la coordenada en el eje y")));
			
			if(experto.size()==1) {break;}
			
			if(fechasValidasExperto(agenda.getFechaInicio(),agenda.getFechaFinal(),experto,agenda.getX(),agenda.getY())) {break;}
			else {JOptionPane.showMessageDialog(null,"tus fechas y lugan chocan con otro experto");}
		}
		
		agenda.setActividades(JOptionPane.showInputDialog("ingrese las actividades a realizar"));
		agenda.setEncargado(JOptionPane.showInputDialog("ingrese el nombre de el encargado"));
		agenda.setTel(JOptionPane.showInputDialog("ingrese su telefono"));
		return agenda;
	}
	

	public boolean fechasValidasAgenda(LocalDate ini,LocalDate fi,ListaDinamica<Agenda> agendasExistentes) throws ExcepcionDeListaVacia {

		agendasExistentes.reiniciarS();
		for(int i =0;i<agendasExistentes.size(); i++) {
			
				if(agendasExistentes.obtenerItemS().getFechaInicio().isAfter(fi)) {
					
					if(!agendasExistentes.obtenerItemS().getFechaFinal().isAfter(ini)) {return false;}
					
				}
				else {
					if(!agendasExistentes.obtenerItemS().getFechaFinal().isBefore(ini)) {return false;}
				}	
			
			if(i<agendasExistentes.size()-1) {agendasExistentes.obtenerSiguiente();}
		}
		
		
		
		return true;
	}
	
	public boolean fechasValidasExperto(LocalDate ini,LocalDate fi,ListaDinamica<Expertos> experto, double x, double y) {
		experto.reiniciarS();
		Expertos comodin;
		ListaDinamica<Agenda> agenda;
		
		for(int i=0; i<experto.size();i++) {
			comodin = experto.obtenerItemS();
			
				agenda= comodin.getAgendaExperto();
				agenda.reiniciarS();
				
					for(int j=0;j<agenda.size();j++ ) {
						
						if(agenda.obtenerItemS().getX()==x && agenda.obtenerItemS().getY()==y) {
							if(!fechasUnicas(ini,fi,agenda.obtenerItemS())) {return false;}
						}

						if(j<agenda.size()-1) {agenda.obtenerSiguiente();}

					}
				
				
			if(i<experto.size()-1) {experto.obtenerSiguiente();}
		}
		
		
		return true;
	}
	
	public boolean fechasUnicas(LocalDate ini,LocalDate fi,Agenda agenda) {
	
		
			if(agenda.getFechaInicio().isAfter(fi)) {
				
				if(!agenda.getFechaFinal().isAfter(ini)) {return false;}
				
			}
			else {
				if(!agenda.getFechaFinal().isBefore(ini)) {return false;}
			}	
		
		
		return true;
	}
	
	
	
	
	
	public Expertos agregarExperto(int a) throws HeadlessException, ExcepcionDeListaLlena {
		Expertos experto = new Expertos();
		
		experto.setNoControl(a+1);
		
		experto.setNombre(JOptionPane.showInputDialog("Ingresa el nombre del experto"));
		experto.setEspecialidad(JOptionPane.showInputDialog("Ingresa su especialidad"));
		
		JOptionPane.showMessageDialog(null,"Acontinucaion agregaran sus areas de interes");
		experto.setAreaInteres(areaInteres(experto.getAreaInteres()));
		
		JOptionPane.showMessageDialog(null,"acontinuacion se debe de agregar su residencia para ello\n primero debera ingresar su coordenada en x, posteiormente\n debera agregar su coordenada en y");
		
		experto.setX(Double.parseDouble(JOptionPane.showInputDialog("coodenada en x")));
		experto.setY(Double.parseDouble(JOptionPane.showInputDialog("coodenada en y")));
		experto.setContacto(JOptionPane.showInputDialog("Ingresa el contacto del experto"));
		experto.setTelContacto(JOptionPane.showInputDialog("Ingresa el telefono de dicho contacto"));
		return experto;
	}
	
	
	public Agenda agregarAgenda(ListaDinamica<Expertos> experto,ListaDinamica<Agenda> agendasExistentes,int a) throws ExcepcionDeListaVacia {
		Agenda agenda = new Agenda();
		
		agenda.setNoControl(a+1);
		
		for(;;) {
			for(;;) {
				for(;;) {
					JOptionPane.showMessageDialog(null,"Deberas agregar la fecha de inicio");
					agenda.setFechaInicio(elegirFecha());
					JOptionPane.showMessageDialog(null,"Ahora deberas ingresar la fecha de retiro");
					agenda.setFechaFinal(elegirFecha());
					
					if(!esMayor(agenda.getFechaInicio(),agenda.getFechaFinal())) {break;}
					JOptionPane.showMessageDialog(null,"Las fechas en orden porfavor");
				}
				
				if(agendasExistentes.size()==0) {break;}
				if(fechasValidasAgenda(agenda.getFechaInicio(),agenda.getFechaFinal(),agendasExistentes)) {
					break;
				}
				else{JOptionPane.showMessageDialog(null,"estas fechas chocan con otras fechas");}
				
				
			}
			
			
			JOptionPane.showMessageDialog(null, "se debe de agregar la ubicacion del lugar en coordenadas");
			agenda.setX(Double.parseDouble(JOptionPane.showInputDialog("ingrese la coordenada en el eje x")));
			agenda.setY(Double.parseDouble(JOptionPane.showInputDialog("ingrese la coordenada en el eje y")));
			
			if(experto.size()==1) {break;}
			
			if(fechasValidasExperto(agenda.getFechaInicio(),agenda.getFechaFinal(),experto,agenda.getX(),agenda.getY())) {break;}
			else {JOptionPane.showMessageDialog(null,"tus fechas y lugan chocan con otro experto");}
		}
		
		agenda.setActividades(JOptionPane.showInputDialog("ingrese las actividades a realizar"));
		agenda.setEncargado(JOptionPane.showInputDialog("ingrese el nombre de el encargado"));
		agenda.setTel(JOptionPane.showInputDialog("ingrese su telefono"));
		return agenda;
	}
	
}
