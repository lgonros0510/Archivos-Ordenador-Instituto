class Camiseta {

    static int totalCamisetas = 0;

    private int codigo;
    String descripcion;
    private int stockS;
    private int stockM;
    private int stockL;

    public Camiseta(int codigo, String descripcion, int stockS, int stockM, int stockL) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.stockS = stockS;
        this.stockM = stockM;
        this.stockL = stockL;

        totalCamisetas += stockS + stockM + stockL;

    }

    public void actualizarStock(String talla, int cantidad) {

        switch (talla) {
            case "S":
                stockS += cantidad;
                break;

            case "M":
                stockM += cantidad;
                break;

            case "L":
                stockL += cantidad;
                break;

        }

        totalCamisetas += cantidad;

    }

    public String getDescripcion() {

        return descripcion;

    }

    public int getStockS() {

        return stockS;

    }

    public int getStockM() {

        return stockM;

    }

    public int getStockL() {

        return stockL;

    }

    @Override
    public String toString() {

        return "Código: " + codigo + " | Descripción: " + descripcion + " | Stock (S/M/L): " + stockS + "/" + stockM + "/" + stockL;

    }
}