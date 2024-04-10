public class OrdenarPorInsercion {
	public static void main(String[] args) {
		
        int cantidadElementos = Integer.parseInt(System.console().readLine("Introduzca la cantidad de elementos que tendrá el array: "));
        int arrayOrdenado[] = new int[];

        for (int i = 1; i < arreglo.length; i++) {
            int variableAuxiliar = arrayOrdenado[i];

            int j = i - 1;

            while (j >= 0 && arrayOrdenado[j] > variableAuxiliar) {
                arrayOrdenado[j + 1] = arrayOrdenado[j];

                j--;

            }

            arrayOrdenado[j + 1] = variableAuxiliar;

        }

        System.out.println("El array ordenado es ");
        imprimirArreglo(arrayOrdenado);
        
    }
    
    public static void imprimirArreglo() {
        
    }
}

