package EjercicioLog4java.EjercicioLog4java;

import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class App 
{
	private static Logger logger = LogManager.getLogger(App.class);
    static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args) {
    	
		String methodName = App.class.getSimpleName() + ".main()";
		logger.info("Iniciada ejecución");
 
    	TresEnRaya tresEnRaya = new TresEnRaya();
		logger.info("Tablero iniciado");
 
        int fila;
        int columna;
        boolean posValida;
        boolean correcto;

        while (!tresEnRaya.partidaTerminada()) {
 
            do {
 
                correcto = false;
               
                tresEnRaya.mostrarTurnoActual();
                tresEnRaya.mostrarTablero();
 
                fila = obtenerValor("Introduce la fila:");

                columna = obtenerValor("Introduce la columna:");      

                posValida = tresEnRaya.validarPosicion(fila, columna);
 
                if (posValida) {
            		logger.info("Posición del tablero introducida es valida");
                    if (!tresEnRaya.comprobarValorPosicion(fila, columna)) {
                        correcto = true;
                    } else {
                    	logger.info("Posición ocupada");
                        System.out.println("\n Ya hay una ficha en esa posicion");
                    }
                    
                } else {
                	logger.info("Posición del tablero introducida NO es valida");
                    System.out.println("\n La posicion no es valida");
                }
 
            } while (!correcto);
 
            tresEnRaya.colocarFicha(fila, columna);
            logger.info("Ficha colocada");
 
            tresEnRaya.cambiaTurno();
            logger.info("Cambio de turno");
        }
 
        tresEnRaya.mostrarTablero();
 
        tresEnRaya.mostrarGanador();
        
        logger.info("Partida terminada");
 
    }
 
    public static int obtenerValor(String mensaje) {
 
    		System.out.println(mensaje);
        	return teclado.nextInt()-1;
        	
    }
}
