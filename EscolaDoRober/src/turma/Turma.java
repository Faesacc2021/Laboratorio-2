package turma;

public class Turma {

    int idTurma;
    String nomeTurma;
    String siglaTurma;

    public Turma() {
        super();
        this.idTurma = 0;
        this.nomeTurma = "";
        this.siglaTurma = "";
    }

    public Turma(int idTurma, String nomeTurma, String siglaTurma) {
        super();
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.siglaTurma = siglaTurma;
    }

    public int getIdTurma() {
        return idTurma;
    }

    public void setIdTurma(int idTurma) { this.idTurma = idTurma; }
    public String getNomeTurma() { return nomeTurma; }
    public void setNomeTurma(String nomeTurma) {
        this.nomeTurma = nomeTurma;
    }
    public String getSiglaTurma() {
        return siglaTurma;
    }
    public void setSiglaTurma(String siglaTurma) {
        this.siglaTurma = siglaTurma;
    }
}
