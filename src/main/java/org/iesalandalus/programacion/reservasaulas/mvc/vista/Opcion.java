package org.iesalandalus.programacion.reservasaulas.mvc.vista;

public enum Opcion {
	SALIR("0.- Salir"){
		public void ejecutar() {
			vista.salir();
		}
	}, 
	INSERTAR_AULA("1.- Insertar aula"){
		public void ejecutar() {
		vista.insertarAula();
		}
	}, 
	BORRAR_AULA("2.- Borrar aula"){
		public void ejecutar() {
			vista.borrarAula();
		}
	}, 
	BUSCAR_AULA("3.- Buscar aula"){
		public void ejecutar() {
			vista.buscarAula();
		}
	}, 
	LISTAS_AULAS("4.- Listar aulas"){
		public void ejecutar() {
			vista.listarAulas();
		}
	}, 
	INSERTAR_PROFESOR("5.- Insertar profesor"){
		public void ejecutar() {
			vista.insertarProfesor();
		}
	}, 
	BORRAR_PROFESOR("6.- Borrar profesor"){
	public void ejecutar() {
		vista.borrarProfesor();
		}
	}, 
	BUSCAR_PROFESOR("7.- Buscar profesor"){
		public void ejecutar() {
			vista.buscarProfesor();
		}
	}, 
	LISTAR_PROFESORES("8.- Listar profesores"){
		public void ejecutar() {
			vista.listarProfesores();
		}
	},	
	INSERTAR_RESERVA("9.- Insertar reserva"){
		public void ejecutar() {
			vista.realizarReserva();
		}
	}, 
	BORRAR_RESERVA("10.- Borrar reserva"){
		public void ejecutar() {
			vista.anularReserva();
		}
	}, 
	LISTAR_RESERVAS("11.- Listar reservas"){
		public void ejecutar() {
			vista.listarReservas();
		}
	}, 
	LISTAR_RESERVAS_AULA("12.- Listar reservas aula"){
		public void ejecutar() {
			vista.listarReservasAula();
		}
	}, 
	LISTAR_RESERVAS_PROFESOR("13.- Listar reservas profesor"){
		public void ejecutar() {
			vista.listarReservasProfesor();
		}
	}, 
	LISTAR_RESERVAS_PERMANENCIA("14.- Listar reservas permanencia"){
		public void ejecutar() {
			vista.listarReservasPermanencia();
		}
	},
	CONSULTAR_DISPONIBILIDAD("15.- Consultar disponibilidad"){
		public void ejecutar() {
			vista.consultarDisponibilidad();
		}
	};
	
	private String mensajeAMostrar;
	private static Vista vista;
	
	private Opcion(String mensajeAMostrar) {
		this.mensajeAMostrar = mensajeAMostrar;
	}

	public String getMensajeAMostrar() {
		return mensajeAMostrar;
	}
	
	public abstract void ejecutar();
	
	protected static void setVista(Vista vistaIntoducida) {
		if (vista == null) {
			throw new NullPointerException("ERROR: La vista no pueda ser nula.");
		}
		Opcion.vista = vistaIntoducida;
	}
	
	public String toString() {
		return String.format("%d.- %s", ordinal(), mensajeAMostrar);
	}
	
	public static Opcion getOpcionSegunOrdinal(int ordinal) {
		if (!esOrdinalValido(ordinal)) {
			throw new IllegalArgumentException("Ordinal de la opción no válido");
		}
		return values()[ordinal];
	}

	public static boolean esOrdinalValido(int ordinal) {
		return (ordinal >= 0 && ordinal <= values().length - 1);
	}
	
}
