/** @author Lucía González Rosas */

/* En esta parte del programa se implementará la clase "Empleado()", donde se instaurá
 * sus atributos principales y los métodos "Empleado()", "getOrdenador()", "setOrdenador()"
 * y "toString()".
 */

package dawcontrol;

public class Empleado {
    
    static String nombre;
    static String dni;
    static int telefono;
    private Ordenador ordenador;

    public Empleado(String nombre, String dni, int telefono) {

        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;

    }

    private Object getOrdenador() {

        return ordenador;

    }

    private void setOrdenador(Ordenador ordenador) {

        this.ordenador = ordenador;

    }

    public String toString() {

        return String.format("%20s" , nombre) +
        " || " + String.format("%12s", dni) + " || " + String.format("%12s", telefono);
        
    }
}
