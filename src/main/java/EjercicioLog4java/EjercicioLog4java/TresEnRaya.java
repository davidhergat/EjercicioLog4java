package EjercicioLog4java.EjercicioLog4java;

public class TresEnRaya {

	// Simbolos para los jugadores y cuadro vacio
	private final char J1 = 'X';
	private final char J2 = 'O';
	private final char VACIO = '-';

	private boolean turno;

	private char tablero[][];

	public TresEnRaya() {
		
		this.turno = true;
		this.tablero = new char[3][3];
		this.iniciarTablero();
		
	}

	// Inicia el tablero con todas las celdas vacias
	private void iniciarTablero() {

		for (int i = 0; i < tablero.length; i++) {
			
			for (int j = 0; j < tablero.length; j++) {
				tablero[i][j] = VACIO;
			}
		}

	}

	// Indica si la partida a terminado
	public boolean partidaTerminada() {

		if (tableroLleno() || ganaPorFila() != VACIO || ganaPorColumna() != VACIO
				|| ganaPorDiagonal() != VACIO) {
			return true;
		}

		return false;
	}

	// Indica si el tablero se a llenado de fichas de los jugadores
	public boolean tableroLleno() {
		
		for (int i = 0; i < tablero.length; i++) {
			
			for (int j = 0; j < tablero[0].length; j++) {

				if (tablero[i][j] == VACIO) {
					return false;
				}
			}
		}
		return true;
	}

	// Indica si se a ganado en una fila
	private char ganaPorFila() {

		char simbolo;
		boolean coincide;

		for (int i = 0; i < tablero.length; i++) {

			coincide = true;
			simbolo = tablero[i][0];

			if (simbolo != VACIO) {

				for (int j = 1; j < tablero[0].length; j++) {
					
					if (simbolo != tablero[i][j]) {
						coincide = false;
					}
				}

				if (coincide) {
					return simbolo;
				}

			}

		}

		return VACIO;

	}

	// Indica si se a ganado en una columna
	private char ganaPorColumna() {

		char simbolo;
		boolean coincidencia;

		for (int j = 0; j < tablero.length; j++) {

			coincidencia = true;
			simbolo = tablero[0][j];

			if (simbolo != VACIO) {
				
				for (int i = 1; i < tablero[0].length; i++) {
					
					if (simbolo != tablero[i][j]) {
						coincidencia = false;
					}
				}

				if (coincidencia) {
					return simbolo;
				}

			}

		}

		return VACIO;

	}

	// Indica si se a ganado en alguna de las diagonales
	private char ganaPorDiagonal() {

		char simbolo;
		boolean coincidencia = true;
		simbolo = tablero[0][0];
		
		if (simbolo != VACIO) {

			for (int i = 1; i < tablero.length; i++) {

				if (simbolo != tablero[i][i]) {
					coincidencia = false;
				}
			}

			if (coincidencia) {
				return simbolo;
			}

		}

		coincidencia = true;

		// Diagonal inferior izquierda a superior derecha
		simbolo = tablero[0][2];

		if (simbolo != VACIO) {
			
			for (int i = 1, j = 1; i < tablero.length; i++, j--) {

				if (simbolo != tablero[i][j]) {
					coincidencia = false;
				}
			}

			if (coincidencia) {
				return simbolo;
			}
		}

		return VACIO;

	}

	public void mostrarGanador() {

		char simbolo = ganaPorFila();

		if (simbolo != VACIO) {

			ganador(simbolo, 1);

			return;

		}

		simbolo = ganaPorColumna();

		if (simbolo != VACIO) {

			ganador(simbolo, 2);

			return;

		}

		simbolo = ganaPorDiagonal();

		if (simbolo != VACIO) {

			ganador(simbolo, 3);

			return;

		}

		System.out.println("Empate");

	}

	private void ganador(char simbolo, int tipo) {

		switch (tipo) {
		
			case 1:
				if (simbolo == J1) {
					System.out.println("Ha ganado el Jugador 1 por fila");
				} else {
					System.out.println("Ha ganado el Jugador 2 por fila");
				}
				break;
				
			case 2:
				if (simbolo == J1) {
					System.out.println("Ha ganado el Jugador 1 por columna");
				} else {
					System.out.println("Ha ganado el Jugador 2 por columna");
				}
				break;
				
			case 3:
				if (simbolo == J1) {
					System.out.println("Ha ganado el Jugador 1 por diagonal");
				} else {
					System.out.println("Ha ganado el Jugador 2 por diagonal");
				}
				break;
		}

	}

	//Cambiar simbolo en la matriz dependiendo del turno del jugador
	public void colocarFicha(int fila, int columna) {
		
		if (turno) {
			this.tablero[fila][columna] = J1;
		} else {
			this.tablero[fila][columna] = J2;
		}
	}

	public void mostrarTablero() {

		for (int i = 0; i < this.tablero.length; i++) {
			
			for (int j = 0; j < this.tablero[0].length; j++) {
				System.out.print(this.tablero[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public void mostrarTurnoActual() {

		if (turno) {
			System.out.println("---------------------------");
			System.out.println("Turno del jugador 1 \n");
		} else {
			System.out.println("---------------------------");
			System.out.println("\n Turno del jugador 2 \n");
		}

	}

	public void cambiaTurno() {
		this.turno = !this.turno;
	}

	public boolean validarPosicion(int fila, int columna) {

		if (fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero.length) {
			return true;
		}
		return false;

	}

	//Indica si hay una ficha en la posici�n
	public boolean comprobarValorPosicion(int fila, int columna) {
		
		if (this.tablero[fila][columna] != VACIO) {
			return true;
		}

		return false;
	}

}