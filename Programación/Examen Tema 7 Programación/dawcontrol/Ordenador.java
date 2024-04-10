/** @author Lucía González Rosas */

/* En esta parte del programa se implementará la clase "Ordenador()", donde se instaurá
 * sus atributos principales y los métodos "Ordenador()", "getHost()", "getEstado()",
 * "setEstado()" y "toString()".
 */

package dawcontrol;

public class Ordenador {
    
    static String host;
    static String so;
    static int ram;
    static int disco;
    private Estado estado;

    public Ordenador(String host, String so, int ram, int disco) {

        this.host = host;
        this.so = so;
        this.ram = ram;
        this.disco = disco;

    }

    private String getHost() {

        return host;

    }

    private Estado getEstado() {

        return estado;

    }

    private void setEstado(Estado estado) {

        this.estado = estado;

    }

    public String toString() {

        return String.format("%4s" , host) + " || " + String.format("%8s", so) + 
        " || " + String.format("%2s", ram) + " || " + String.format("%1s", disco);

    }
}
