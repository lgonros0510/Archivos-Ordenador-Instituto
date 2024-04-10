/** @author Lucía González Rosas */

/** En esta parte del programa se creará la compilación necesaria para crear
  * la clase "Apuesta", la cual mostará el nombre del participante (junto a
  * sus datos personales), el nombre del sorteo y la cantidad apostada.
  *
  * Dicha clase tendrá un getter para los números apostados.
  */

package Apuestas;

public class Apuesta {
    
    private Participante participante;
    private String nombreSorteo;
    private double cantidadApostada;
    private int[] numerosApostados;

    public Apuesta(Participante participante, String nombreSorteo, double cantidadApostada, int[] numerosApostados) {
        
        this.participante = participante;
        this.nombreSorteo = nombreSorteo;
        this.cantidadApostada = cantidadApostada;
        this.numerosApostados = numerosApostados;
        
    }

    public int[] getNumerosApostados() {
        return numerosApostados;
    }

    public double getCantidadApostada() {
        
        return cantidadApostada;
        
    }

    public String getNombreSorteo() {
        
        return nombreSorteo;
        
    }

    public Participante getParticipante() {
        
        return participante;
        
    }


    public double calcularPremio(int[] numerosSorteo) {
    
        int coincidencias = 0;
    
        for (int numero : numerosApostados) {
            for (int numeroSorteo : numerosSorteo) {
                if (numero == numeroSorteo) {
                    coincidencias++;
            
                }
            }
        }
    
        double premio = cantidadApostada * coincidencias;
        System.out.println("Tu premio es de " + premio + "€.");
    
        return premio;

    }
}