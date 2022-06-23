public class Brinquedos {

    int codigo;
    String descricao;
    double precoCompra;
    double precoVenda;
    int estoqMinimo;
    int estoqAtual;

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoCompra() {
        return precoCompra;
    }
    public void setPrecoCompra(double precoCompra) {
        this.precoCompra = precoCompra;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }
    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public int getEstoqMinimo() {
        return estoqMinimo;
    }
    public void setEstoqMinimo(int estoqMinimo) {
        this.estoqMinimo = estoqMinimo;
    }

    public int getEstoqAtual() {
        return estoqAtual;
    }
    public void setEstoqAtual(int estoqAtual) {
        this.estoqAtual = estoqAtual;
    }

    public static Brinquedos[] getBrinquedos() {
        return brinquedos;
    }
    public static void setBrinquedos(Brinquedos[] brinquedos) {
        Brinquedos.brinquedos = brinquedos;
    }

    static Brinquedos[] brinquedos = new Brinquedos[40];

    public static void incluirBrinquedos(Brinquedos brinquedos, int autoIncrement) {
        Brinquedos.brinquedos[autoIncrement] = brinquedos;
    }

    @Override
    public String toString() {
        return "Brinquedos{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", precoCompra=" + precoCompra +
                ", precoVenda=" + precoVenda +
                ", estoqMinimo=" + estoqMinimo +
                ", estoqAtual=" + estoqAtual +
                '}';
    }

    public static void consultaLucro(int autoIncrement, int codigo) {
        for (int ind = 0; ind <= autoIncrement; ind++) {
            if (Brinquedos.brinquedos[ind].getCodigo() == codigo) {
                double lucro = Brinquedos.brinquedos[ind].getEstoqAtual() * (Brinquedos.brinquedos[ind].getPrecoVenda() - Brinquedos.brinquedos[ind].getPrecoCompra());
                System.out.printf(Brinquedos.brinquedos[ind].toString() + "Lucro Obtido R$ %.2f\n" , lucro);
            }
        }
    }

    public static void consultaEstoque(int autoIncrement) {
        for (int ind = 0; ind <= autoIncrement; ind++) {
            if (Brinquedos.brinquedos[ind].getEstoqAtual() < Brinquedos.brinquedos[ind].getEstoqMinimo()) {
                System.out.println(Brinquedos.brinquedos[ind].toString());
            }
        }
    }
}

