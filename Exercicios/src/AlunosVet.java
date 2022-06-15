public class AlunosVet {

    static Alunos[] alunos = new Alunos[500];

    public static void incluirAlunos(Alunos alunos, int autoIncrement) {
        AlunosVet.alunos[autoIncrement] = alunos;
    }

}
