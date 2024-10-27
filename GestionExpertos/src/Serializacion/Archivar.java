package Serializacion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Creacion.Expertos;
import ListaD.ListaDinamica;

public class Archivar {

	public Archivar() {}
	public void agregarArchivos(ListaDinamica<Expertos> experto) {
		
        try (FileOutputStream fileOut = new FileOutputStream("listaExpertos.ser");
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(experto);
            System.out.println("Lista de expertos guardada en listaExpertos.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	
	public ListaDinamica<Expertos> activarArchivos() {
		 ListaDinamica<Expertos> lista = null;
		 File archivo = new File("listaExpertos.ser");
		 
		 if (archivo.exists()) {
	        try (FileInputStream fileIn = new FileInputStream("listaExpertos.ser");
	             ObjectInputStream in = new ObjectInputStream(fileIn)) {
	            lista = (ListaDinamica<Expertos>) in.readObject();
	            System.out.println("Lista de expertos cargada:");
	            
	        } catch (IOException | ClassNotFoundException e) {
	        	
	            e.printStackTrace();
	            
	        }
		 }
		 else {
		        lista = new ListaDinamica<>(); 
		    }
		return lista;
	}
	
}
