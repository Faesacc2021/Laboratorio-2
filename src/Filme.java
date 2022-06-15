public class Filme {

    int codigoFilme;
    String tituloFilme;
    String generoFilme;

    public int getCodigoFilme() {
        return codigoFilme;
    }

    public void setCodigoFilme(int codigoFilme) {
        this.codigoFilme = codigoFilme;
    }

    public String getTituloFilme() {
        return tituloFilme;
    }

    public void setTituloFilme(String tituloFilme) {
        this.tituloFilme = tituloFilme;
    }

    public String getGeneroFilme() {
        return generoFilme;
    }

    public void setGeneroFilme(String generoFilme) {
        this.generoFilme = generoFilme;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "codigoFilme=" + codigoFilme +
                ", tituloFilme='" + tituloFilme + '\'' +
                ", generoFilme=" + generoFilme +
                '}';
    }

    static Filme[] filme;

    public static void createVetor(int tamanhoVetor) {
        filme = new Filme[tamanhoVetor];
    }

    public static String consultarFilmes(String nomeFilme, int autoIncrement) {

        for (int ind = 0; ind < autoIncrement; ind++) {
            if (filme[ind].getTituloFilme().equals(nomeFilme)) {
                return filme[ind].getTituloFilme();
            }
        }
        return "";
    }

    public static String excluirFilme(String nomeFilme, int autoIncrement) {
        String filmeExcluido = "";
        for (int ind = 0; ind < autoIncrement; ind++) {
            if (filme[ind].getTituloFilme().equals(nomeFilme)) {
                filmeExcluido = filme[ind].getTituloFilme();
                filme[ind].setTituloFilme("");
                return filmeExcluido;
            }
        }
        return filmeExcluido;
    }
}