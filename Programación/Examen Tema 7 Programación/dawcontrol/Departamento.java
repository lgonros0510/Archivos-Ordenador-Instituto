/** @author Lucía González Rosas */

/* En esta parte del programa se implementará la clase "Departamento()" y todos los métodos que
 * sirvan para manejar la clase "DawControl()", siendo estos "añadirEmpleado()", "añadirOrdenador()",
 * "asignarOrdenador()", "imprimirListaEmpleados()" "imprimirListaOrdenadores()", "eliminarOrdenadoresBaja()",
 * "totalEmpleados()", "totalOrdenadores()" y "bajaOrdenador()".
 */

package dawcontrol;

import java.util.ArrayList;

class Departamento {
    
    private String nombre;
    ArrayList<Empleado> Empleados;
    ArrayList<Ordenador> Ordenadores;

    Departamento(String nombre) {

        this.nombre = nombre;

    }

    String getNombre() {

        return nombre;

    }

    void añadirEmpleado(Empleado e) {

        Empleados.add(e);

    }

    void añadirOrdenador(Ordenador o) {

        Ordenadores.add(o);

    }

    public void asignarOrdenador(int numEmpleado, int numOrdenador) {
        
        
    }

    public void imprimirListaEmpleados() {
        
        Empleados.toArray();
    }

    public void imprimirListaOrdenadores() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'imprimirListaOrdenadores'");
    }

    public void eliminarOrdenadoresBaja() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarOrdenadoresBaja'");
    }

    public int totalEmpleados() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalEmpleados'");
    }

    public int totalOrdenadores() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'totalOrdenadores'");
    }

    public void bajaOrdenador(int numOrdenador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'bajaOrdenador'");
    }
}
