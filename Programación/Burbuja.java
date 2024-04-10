public class Burbuja {
    public static void main(String[] args) {
        
        int[] serieNumerica = new int[args.length];

        System.out.println("Los números desardenados son:  ");

        for (int i = 0; i < args.length; i++) {
            serieNumerica[i] = Integer.parseInt(args[i]);

        }

        for (int i = 0; i < serieNumerica.length - 1; i++) {
            for (int j = 0; j < serieNumerica.length - i - 1; j++) {
                if (serieNumerica[j] > serieNumerica[j + 1]) {
                    int ordenar = serieNumerica[j];
                    serieNumerica[j] = serieNumerica[j + 1];
                    serieNumerica[j + 1] = ordenar;

                }
            }
        }

        System.out.println("La serie de números se ordenaría en: ");
        for (int i = 0; i < serieNumerica.length; i++) {
            System.out.print(serieNumerica[i] + " ");
        }

        System.out.println();
        
    }
}