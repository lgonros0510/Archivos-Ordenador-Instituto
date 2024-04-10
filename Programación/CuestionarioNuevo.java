
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Respuesta {
    String respuesta;
    boolean esCorrecta;

    public Respuesta(String respuesta, boolean esCorrecta) {
        this.respuesta = respuesta;
        this.esCorrecta = esCorrecta;
    }

}

class Pregunta {
    private final String pregunta;
    private final List<Respuesta> respuestas;

    private static final String letras = "abcdefghijklmnñopqrstuvwxyz";

    public Pregunta(String pregunta, List<Respuesta> respuestas) {
        this.pregunta = pregunta;
        this.respuestas = respuestas;
    }

    public Pregunta(String pregunta) {
        this.pregunta = pregunta;
        this.respuestas = new ArrayList<>();
    }

    public void agregarRespuesta(Respuesta r) {
        this.respuestas.add(r);
    }

    public boolean respuestaCorrecta(char respuesta) {
        int indice = letras.indexOf(respuesta);
        if (indice == -1) {
            return false;
        }
        return this.respuestas.get(indice).esCorrecta;
    }

    public boolean preguntar(int numero) {
        System.out.println(numero + ". " + this.pregunta);
        int indice = 0;
        for (Respuesta r : this.respuestas) {
            System.out.printf("%c) %s\n", letras.charAt(indice), r.respuesta);
            indice++;
        }
        System.out.println("Elige: ");
        try (Scanner sc = new Scanner(System.in)) {
            char respuesta = sc.nextLine().charAt(0);
            return this.respuestaCorrecta(respuesta);
        }
    }
}

class Cuestionario {
    private final List<Pregunta> preguntas;
    private int aciertos;
    private int errores;


    public Cuestionario() {
        this.preguntas = new ArrayList<>();
    }

    public void agregarPregunta(Pregunta p) {
        this.preguntas.add(p);
    }

    public void preguntar() {
        int numero = 1;
        for (Pregunta p : this.preguntas) {
            boolean acierta = p.preguntar(numero);
            numero++;
            if (acierta) {
                System.out.println("Correcto");
                this.aciertos++;
            } else {
                System.out.println("Incorrecto");
                this.errores++;
            }
        }
    }

    public void imprimirResultados() {
        int total = this.preguntas.size();
        double porcentajeAciertos = (100 * (double) this.aciertos) / total;
        double porcentajeErrores = (100 * (double) this.errores) / total;
        System.out.printf("Total de preguntas: %d\nAciertos: %d (%.2f %%)\nErrores: %d (%.2f %%)", total, this.aciertos, porcentajeAciertos, this.errores, porcentajeErrores);
    }
}

public class CuestionarioNuevo {

    public static void main(String[] args) {
        Cuestionario c = new Cuestionario();
        c.agregarPregunta(new Pregunta("¿Cómo se incrementa en 3 un carácter (char caracter='A'  pasa a ser 'D\")?", List.of(
                new Respuesta("a) caracter+++;", false),
                new Respuesta("b) caracter = caracter +3;", true),
                new Respuesta("c) caracter = (char) (caracter + 3);", false)
        )));
        c.agregarPregunta(new Pregunta("¿Qué significa el código \n en una cadena?", List.of(
                new Respuesta("a) Cambio de color", false),
                new Respuesta("b) Salto de línea", false),
                new Respuesta("c) Formato de número", false)
        )));
        c.agregarPregunta(new Pregunta("¿Cuál es el resultado de esta expresión, si a=1 y b=2; (a==b) && (a>=b) || (a!=b) && (a<=b)?", List.of(
                new Respuesta("a) No puede evaluarse", false),
                new Respuesta("b) false", true),
                new Respuesta("c) true", false)
        )));

        c.agregarPregunta(new Pregunta("¿Cómo podemos imprimir una variable 'precio' de tipo double en formato de euros?", List.of(
                new Respuesta("a) System.out.printf('Precio: %3.2f €', precio);", false),
                new Respuesta("b) System.out.printf('Precio: %3.2f €' + precio);", true),
                new Respuesta("c) System.out.printf('Precio: %3.2f €' + 'precio');", false)
        )));

        c.agregarPregunta(new Pregunta("¿Cuál de estas variables tiene un nombre más adecuado?", List.of(
                new Respuesta("a) 12", false),
                new Respuesta("b) Linea2", false),
                new Respuesta("c) LineaDos", true)
        )));

        c.preguntar();
        c.imprimirResultados();
    }
}