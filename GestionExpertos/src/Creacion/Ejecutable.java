package Creacion;
import java.io.Serializable;

import javax.swing.JOptionPane;

import ListaD.ExcepcionDeElementoNoEncontrado;
import ListaD.ExcepcionDeListaLlena;
import ListaD.ExcepcionDeListaVacia;

public class Ejecutable implements Serializable{

	private static final long serialVersionUID = 1L; 
	
	public static void main(String[] args) throws ExcepcionDeListaLlena, ExcepcionDeListaVacia, ExcepcionDeElementoNoEncontrado {
		JOptionPane.showMessageDialog(null,"cada experto tiene un numero de control\nal igual "
				+ "que sus trabajos agendados");
		Menu menu = new Menu();
		menu.menuGestion();
	}
	
}
