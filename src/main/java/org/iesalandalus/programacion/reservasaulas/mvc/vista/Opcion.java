package org.iesalandalus.programacion.reservasaulas.mvc.vista;

public enum Opcion {
	SALIR("Salir"){
		public void ejecutar() {
			vista.salir();
		}
	}, 
	INSERTAR_AULA("Insertar aula"){
		vista.insertarAula();
	}
}, 
	BORRAR_AULA("Borrar aula"){
		vista.borrarAula();
	}
}, 
	BUSCAR_AULA("Buscar aula"){
		vista.buscarAula();
	}
}, 
	LISTAS_AULAS("Listar aulas"){
		vista.listarAulas();
	}
}, 
	INSERTAR_PROFESOR("Insertar profesor"){
		vista.insertarProfesor();
	}
}, 
	BORRAR_PROFESOR("Borrar profesor"){
		vista.borrarProfesor();
	}
}, 
	BUSCAR_PROFESOR("Buscar profesor"){
		vista.buscarProfesor();
	}
}, 
	LISTAR_PROFESORES("Listar profesores"){
		vista.listarProfesores();
	}
},
	INSERTAR_RESERVA("Insertar reserva"){
		vista.insertarReserva();
	}
}, 
	BORRAR_RESERVA("Borrar reserva"){
		vista.borrarReserva();
	}
}, 
	LISTAR_RESERVAS("Listar reservas"){
		vista.listarReservas();
	}
}, 
	LISTAR_RESERVAS_AULA("Listar reservas aula"){
		vista.listarReservasAula();
	}
}, 
	LISTAR_RESERVAS_PROFESOR("Listar reservas profesor"){
		vista.listarReservasProfesor();
	}
}, 
	LISTAR_RESERVAS_PERMANENCIA("Listar reservas permanencia"){
		vista.listarReservasPermanencia();
	}
},
	CONSULTAR_DISPONIBILIDAD("Consultar disponibilidad"){
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
