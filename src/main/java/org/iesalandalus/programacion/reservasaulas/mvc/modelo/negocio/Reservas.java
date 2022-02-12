package org.iesalandalus.programacion.reservasaulas.mvc.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.mvc.modelo.dominio.Reserva;

public class Reservas {

	private int capacidad, tamano;
	
	Reserva[] coleccionReservas;
	
	public Reservas (int capacidadColeccionReservas) {
		if (capacidadColeccionReservas <= 0)
			throw new IllegalArgumentException("ERROR: La capacidad debe ser mayor que cero.");
		
		// Creamos el array con la capacidad introducida
		coleccionReservas = new Reserva[capacidadColeccionReservas];
		
		// Actualizamos los atributos capacidad y tamaño
		capacidad = capacidadColeccionReservas;
		tamano = 0;
	}
	
	public Reserva[] get() {
		
		return copiaProfundaReservas(coleccionReservas);
	}
	
	private Reserva[] copiaProfundaReservas(Reserva[] coleccionReservasOriginal) {
		
		Reserva[] coleccionCopiaReservas;
		
		coleccionCopiaReservas = new Reserva[getTamano()];
		
		// recorremos todas las citas comparando
		for (int i = 0; i < coleccionReservasOriginal.length && coleccionReservasOriginal[i] != null; i++) {
			Reserva reservaCopia = new Reserva(coleccionReservasOriginal[i]);
			coleccionCopiaReservas[i] = reservaCopia;
		}
		
		return coleccionCopiaReservas;
		
	}
	
	private boolean tamanoSuperado(int indice) {
		boolean superado = false;
		
		// comprobamos que el indice no supere el tamaño
		if (indice >= (tamano))
			superado = true;
		
		return superado;
	}
	
	private boolean capacidadSuperada(int indice) {
		boolean superada = false;
		
		// comprobamos que el indice no supere la capacidad
		if (indice >= (capacidad))
			superada = true;
		
		return superada;
	}
	
	private int buscarIndice (Reserva reserva) {
		if (reserva == null)
			throw new NullPointerException("ERROR: No se puede buscar un aula nula.");
		
		int indice = 0;
		boolean aulaEncontrada = false;
		while (!tamanoSuperado(indice) && !aulaEncontrada) {
			
			if (coleccionReservas[indice].equals(reserva))// en caso de que el objeto del array que estamos consultado sea la cita introducida
				aulaEncontrada = true;
			else
				indice++;
			
		}
		
		return indice;
	}
	
	public void insertar (Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) 
			throw new NullPointerException("ERROR: No se puede insertar una reserva nula.");
		
		int indice = buscarIndice(reserva);
		
		if (capacidadSuperada(indice))
			throw new OperationNotSupportedException("ERROR: No se aceptan más reservas.");
		
		// insertamos la nueva cita y actualizamos el tamaño
		coleccionReservas[indice] = new Reserva(reserva);
		tamano++;
	}
	
	public Reserva buscar (Reserva reserva) {
		if (reserva == null)
			throw new NullPointerException("ERROR: No se puede buscar una reserva nula.");
		
		int indice = buscarIndice(reserva);
		
		// si el indice supera al tamaño, es que no lo ha encontrado y es un objeto nuevo
		if (!tamanoSuperado(indice))
			return new Reserva(coleccionReservas[indice]); 
		else
			return null;
	}
	
	private void desplazarUnaPosicionHaciaIzquierda (int indice) {
		for (int i = indice; !tamanoSuperado(i); i++) { // recorrer todos los objetos hacia la derecha a partir del indice hasta legar al final
			coleccionReservas[i] = coleccionReservas[i+1]; // asignamos en cada posicion el objeto siguiente
		}
	}
	
	public void borrar (Reserva reserva) throws OperationNotSupportedException {
		if (reserva == null) 
			throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");
		
		if (buscar(reserva) == null)
			throw new OperationNotSupportedException("ERROR: No existe ninguna reserva con ese nombre.");
		
		// borrar cita
		int indice = buscarIndice(reserva); // buscamos indice de cita a borrar
		
		coleccionReservas[indice] = null; // asignamos un elemento vacio en esa posicion
		
		desplazarUnaPosicionHaciaIzquierda(indice); // movemos todo para no dejar huecos en medio
		
		// actualizamos tamaño
		tamano--;
	}
	
	public String[] representar() {
		String[] representacion = new String[tamano];
		
		for (int i = 0; !tamanoSuperado(i); i++) {
			representacion[i] = coleccionReservas[i].toString();
		}
		
	
		return representacion;
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public int getTamano() {
		return tamano;
	}
	
	public Reserva[] getReservasProfesor (Profesor profesor) {
		if (profesor ==  null)
			throw new NullPointerException ("ERROR: No se puede buscar una reserva con profesor nulo.");
		
		int indice = 0;
		
		Reserva[] coleccionReservasProfesor;
		
		coleccionReservasProfesor = new Reserva[getTamano()];
		
		// recorremos todas las citas comparando
		for (int i = 0; i < coleccionReservas.length && coleccionReservas[i] != null; i++) {
			Reserva reserva = new Reserva(coleccionReservas[i]);
			
			if (profesor.equals(reserva.getProfesor()))
				coleccionReservasProfesor[indice] = reserva;
				indice++;
		}
		
		return coleccionReservasProfesor;
	}
	
	public Reserva[] getReservasAula (Aula aula) {
		if (aula ==  null)
			throw new NullPointerException ("ERROR: No se puede buscar una reserva con aula nula.");
		
		int indice = 0;
		
		Reserva[] coleccionReservasAula;
		
		coleccionReservasAula = new Reserva[getTamano()];
		
		// recorremos todas las citas comparando
		for (int i = 0; i < coleccionReservas.length && coleccionReservas[i] != null; i++) {
			Reserva reserva = new Reserva(coleccionReservas[i]);
			
			if (aula.equals(reserva.getAula()))
				coleccionReservasAula[indice] = reserva;
				indice++;
		}
		
		return coleccionReservasAula;
	}
}
