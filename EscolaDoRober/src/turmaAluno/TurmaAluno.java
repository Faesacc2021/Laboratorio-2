package turmaAluno;

public class TurmaAluno {

    private long id;
    private int idTurma;
    private int idAluno;

    public TurmaAluno() {
        super();
        this.id = 0;
        this.idTurma = 0;
        this.idAluno = 0;
    }

    public TurmaAluno(long id, int idAluno, int idTurma) {
        super();
        this.id = id;
        this.idAluno = idAluno;
        this.idTurma = idTurma;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public int getIdTurma() {
        return idTurma;
    }
    public void setIdTurma(int idTurma) {
        this.idTurma = idTurma;
    }

    public int getIdAluno() {
        return idAluno;
    }
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
}