public class Vendedor {

    int codigoVendedor;
    String nomeVendedor;
    String TipoMercadoria;

    public int getCodigoVendedor() {
        return codigoVendedor;
    }
    public void setCodigoVendedor(int codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public String getNomeVendedor() {
        return nomeVendedor;
    }
    public void setNomeVendedor(String nomeVendedor) {
        this.nomeVendedor = nomeVendedor;
    }

    public String getTipoMercadoria() {
        return TipoMercadoria;
    }
    public void setTipoMercadoria(String tipoMercadoria) {
        TipoMercadoria = tipoMercadoria;
    }

    static Vendedor[] vendedor;

    public static void createVetor(int tamanhoVetor) {
        vendedor = new Vendedor[tamanhoVetor];
    }

    public static void incluirVendedor(Vendedor vendedor, int autoIncrement) {
        Vendedor.vendedor[autoIncrement] = vendedor;
    }

    public static int consultaTipoMercadoria(String tipo, int autoIncrement) {

        int countTipo = 0;

        for (int ind = 0; ind <= autoIncrement; ind++) {
            if (vendedor[ind].getTipoMercadoria().equals(tipo)) {
                countTipo = countTipo + 1;
            }
        }
        return countTipo;
    }

    public static String excluirVendedor(String nomeVendedor, int autoIncrement) {
        String VendedorExcluido = "";
        for (int ind = 0; ind <= autoIncrement; ind++) {
            if (vendedor[ind].getNomeVendedor().equals(nomeVendedor)) {
                VendedorExcluido = vendedor[ind].getNomeVendedor();
                vendedor[ind].setNomeVendedor("");
                return VendedorExcluido;
            }
        }
        return VendedorExcluido;
    }
}