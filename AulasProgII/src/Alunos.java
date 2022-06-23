public class Alunos {

    int matricula;
    String nome;
    double nota01;
    double nota02;

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota01() {
        return nota01;
    }
    public void setNota01(double nota01) {
        this.nota01 = nota01;
    }

    public double getNota02() {
        return nota02;
    }
    public void setNota02(double nota02) {
        this.nota02 = nota02;
    }

    @Override
    public String toString() {
        return "Alunos{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", nota01=" + nota01 +
                ", nota02=" + nota02 +
                '}';
    }

    public static void consultarAlunos(double nota, int autoIncrement) {

        Alunos alunos = new Alunos();

        for (int ind = 0; ind <= autoIncrement; ind++) {
            if (AlunosVet.alunos[ind].getNota01() < nota && AlunosVet.alunos[ind].getNota02() < nota ) {
                alunos = AlunosVet.alunos[ind];
                System.out.println(alunos.toString());
            }
        }
    }


    public static void consultarMedia(int autoIncrement) {

        Alunos alunos = new Alunos();

        for (int ind = 0; ind <= autoIncrement; ind++) {
            double media =( AlunosVet.alunos[ind].getNota01() + AlunosVet.alunos[ind].getNota02() ) /2;
                System.out.printf("Nome: " + AlunosVet.alunos[ind].getNome() + " %.2f\n", media );
        }
    }
}
