/** @author Lucía González Rosas */

/** En esta parte del programa se creará la compilación necesaria para crear
  * la clase "Sorteo", la cual tendrá de atributos un nombre, su descripción
  * y la fecha del sorteo.
  *
  * Dicha clase buscará una apuesta pòr su nombre.
  */

package Apuestas;

import java.util.Random;

public class Sorteo {
    
    private String nombre;
    private String descripcion;
    private String fecha;
    private int[] numeros;

    public Sorteo(String nombre, String descripcion, String fecha) {
        
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.numeros = new int[3];
        
    }

    public static int[] generarNumerosAleatorios() {
        
        Random rand = new Random();
        
        int[] numerosSorteo = new int[3];
        
        for (int i = 0; i < 3; i++) {
            numerosSorteo[i] = rand.nextInt(10);
        }
        
        return numerosSorteo;
        
    }

    public boolean comprobarGanador(Apuesta apuesta, int[]numerosSorteo) {
        
        int[] numerosApostados = apuesta.getNumerosApostados();
        
        for (int i = 0; i < 3; i++) {
            if (numerosApostados[i] != numeros[i]) {
                return false;
                
            }
        }
        
        return true;
        
    }
}