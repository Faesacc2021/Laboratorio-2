package aluno;

public class Aluno {

    private int idAluno;
    private String nome;
    private String cpf;

    public Aluno() {
        super();
        this.idAluno = 0;
        this.nome = "";
        this.cpf = "";
    }

    public Aluno(int idAluno, String nome, String cpf) {
        super();
        this.idAluno = idAluno;
        this.nome = nome;
        this.cpf = cpf;
    }
    public int getIdAluno() {
        return idAluno;
    }
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
