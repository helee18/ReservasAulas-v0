package org.iesalandalus.programacion.reservasaulas.mvc.vista;

public enum Opcion {
	SALIR("0.- Salir"){
		public void ejecutar() {
			vista.salir();
		}
	}, 
	INSERTAR_AULA("1.- Insertar aula"){
		vista.insertarAula();
	}
}, 
	BORRAR_AULA("2.- Borrar aula"){
		vista.borrarAula();
	}
}, 
	BUSCAR_AULA("3.- Buscar aula"){
		vista.buscarAula();
	}
}, 
	LISTAS_AULAS("4.- Listar aulas"){
		vista.listarAulas();
	}
}, 
	INSERTAR_PROFESOR("5.- Insertar profesor"){
		vista.insertarProfesor();
	}
}, 
	BORRAR_PROFESOR("6.- Borrar profesor"){
		vista.borrarProfesor();
	}
}, 
	BUSCAR_PROFESOR("7.- Buscar profesor"){
		vista.buscarProfesor();
	}
}, 
	LISTAR_PROFESORES("8.- Listar profesores"){
		vista.listarProfesores();
	}
},
	INSERTAR_RESERVA("9.- Insertar reserva"){
		vista.insertarReserva();
	}
}, 
	BORRAR_RESERVA("10.- Borrar reserva"){
		vista.borrarReserva();
	}
}, 
	LISTAR_RESERVAS("11.- Listar reservas"){
		vista.listarReservas();
	}
}, 
	LISTAR_RESERVAS_AULA("12.- Listar reservas aula"){
		vista.listarReservasAula();
	}
}, 
	LISTAR_RESERVAS_PROFESOR("13.- Listar reservas profesor"){
		vista.listarReservasProfesor();
	}
}, 
	LISTAR_RESERVAS_PERMANENCIA("14.- Listar reservas permanencia"){
		vista.listarReservasPermanencia();
	}
},
	CONSULTAR_DISPONIBILIDAD("15.- Consultar disponibilidad"){
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
		vista = vistaIntoducida;
	}
	
	public String toString() {
		return mensajeAMostrar;
	}
	
	public static Opcion getOpcionSegunOrdinal(int ordinal) {
		if (!esOrdinalValido(ordinal))
			throw new IllegalArgumentException("ERROR: No es un ordinal valido.");
			
		return Opcion.values()[ordinal];
	}

	public static boolean esOrdinalValido(int ordinal) {
		if(ordinal >= 0 && ordinal < Opcion.values().length)
			return true;
		
		return false;
	}
}
