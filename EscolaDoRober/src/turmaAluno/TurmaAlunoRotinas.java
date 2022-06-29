package turmaAluno;

import aluno.Aluno;
import aluno.AlunoFiles;
import turma.Turma;
import turma.TurmaFiles;
import turma.TurmaRotinas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class TurmaAlunoRotinas {

    static ArrayList<TurmaAluno> turmaAlunos = new ArrayList<TurmaAluno>();
    static Scanner lerTeclado = new Scanner(System.in);

    static ArrayList<Turma> turmas = new ArrayList<Turma>();
    static ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    static void incluirTurmaAlunos(TurmaAluno turmaMaisAlunos) {

        String idAlunoStr = String.valueOf(turmaMaisAlunos.getIdAluno());
        String idTurmaStr = String.valueOf(turmaMaisAlunos.getIdTurma());
        String id = (idAlunoStr + idTurmaStr);

        turmaMaisAlunos.setId(parseLong(id));
        turmaAlunos.add(turmaMaisAlunos);
    }

    public static void menuTurmaAlunos() {
        String entrada = "";
        int continuar = 1;
        int valorMenu = 0;

        try {
            turmaAlunos.clear();
            turmaAlunos = TurmaAlunoFiles.readTurmaAlunos();
        } catch (IOException e) {
            System.out.println("Não foi possível carregar o arquivo de Turma x Alunos");
        }

        try {
            turmas.clear();
            turmas = TurmaFiles.readTurma();
        } catch (IOException e) {
            System.out.println("Não foi possível carregar o arquivo de turmas");
        }

        try {
            alunos.clear();
            alunos = AlunoFiles.readAluno();
        } catch (IOException e) {
            System.out.println("Não foi possível carregar o arquivo de Alunos");
        }

        while (continuar != 0) {

            System.out.println("Menu Turma x Alunos");
            System.out.println("1 - Associar Turma x Aluno");
            System.out.println("2 - Alterar Associação");
            System.out.println("3 - Listar Todos");
            System.out.println("0 - Voltar para menu de Cadastros");
            entrada = lerTeclado.next();

            try {
                valorMenu = parseInt(entrada);
            } catch (NumberFormatException e) {
                continue;
            }

            switch (valorMenu) {
                case 0:
                    try {
                        TurmaAlunoFiles.gravaTurmaAlunos(turmaAlunos);
                    } catch (IOException e) {
                        System.out.println("Não foi possível gravar o arquivo de Turma x Alunos");
                        System.exit(0);
                    }
                    continuar = 0;
                    break;
                case 1:
                    associarTurmaAlunos();
                    break;
                case 2:
                    alteraTurmaAlunos();
                    break;
                case 3:
                    listaTurmaAlunos();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }

    }

    static void associarTurmaAlunos() {

        TurmaRotinas turmaRotinas = new TurmaRotinas();
        Turma turma = new Turma();
        Aluno aluno = new Aluno();

        int idTurma = 0;
        int idAluno = 0;
        int sair = 777;

        lerTeclado.nextLine();

        while (sair != 0) {
            System.out.print("Tecle <Enter> no Id para sair.\n");
            System.out.println("Digite o Id da Turma");
            idTurma = lerTeclado.nextInt();

            try {
                parseInt(String.valueOf(idTurma));
            } catch (NumberFormatException e) {
                continue;
            }

            turma = consultaTurma(idTurma);
            if (turma == null) {
                continue;
            } else {
                System.out.println("Você vai associar Alunos para turma ==> " + turma.getNomeTurma());
            }

            int sairLoop = 777;

            while (sairLoop != 0) {
                System.out.print("Tecle <Enter> no campo Id para sair.\n");
                System.out.println("Digite o Id do Aluno que deseja associar a turma " + turma.getNomeTurma());
                idAluno = lerTeclado.nextInt();

                try {
                    parseInt(String.valueOf(idAluno));
                } catch (NumberFormatException e) {
                    continue;
                }

                aluno = consultaAluno(idAluno);
                if (turma == null) {
                    continue;
                } else {
                    System.out.println("O Aluno " + aluno.getNome() + " foi associado a " + turma.getNomeTurma());
                }
            }
            TurmaAluno turmaAluno = new TurmaAluno();
            turmaAluno.setNomeTurma(nome);
            turmaAluno.setSiglaTurma(sigla.toUpperCase());
            incluirTurmaAlunos(turmaAluno);

        }
    }

    static void alteraTurmaAlunos() {
        String idTurma = "";
        int saida = 777;
        boolean encontrou = false;

        while (saida != 0) {
            System.out.println("Digite o ID da turmaAluno que deseja Alterar");
            idTurma = lerTeclado.next();

            try {
                parseInt(idTurma);
                saida = 0;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id deve ser numérico!");
                continue;
            }
        }

        for (int index = 0; index < turmaAlunos.size(); index++) {
            if (turmaAlunos.get(index).getIdTurma() == parseInt(idTurma)) {
                System.out.println("\n*********************************************");
                imprimeTurma(turmaAlunos.get(index));
                System.out.println("*********************************************\n");
                encontrou = true;
                entrarNovosDados(index);
                break;
            }
        }
        if (!encontrou) {
            System.out.println("TurmaAluno não encontrada!\n");
        }
    }

    static void entrarNovosDados(int index) {
        String nome = "";
        String sigla = "";

        lerTeclado.nextLine();

        System.out.println("Nome da TurmaAluno: ");
        nome = lerTeclado.nextLine();

        System.out.println("Sigla:");
        sigla = lerTeclado.nextLine();

        if (sigla.length() > 3) {
            System.out.println("Sigla não deve ser maior do que três caracteres ");
        } else {
            turmaAlunos.get(index).setNomeTurma(nome);
            turmaAlunos.get(index).setSiglaTurma(sigla.toUpperCase());
            System.out.println("\nTurmaAluno Alterada com sucesso!\n");
        }
    }

    static void listaTurmaAlunos() {
        int index = 0;
        System.out.println("\n*********************************************");
        while (index < turmaAlunos.size()) {
            imprimeTurma(turmaAlunos.get(index));
            index = index + 1;
        }
        System.out.print("*********************************************\n");
    }

    static void imprimeTurmaAlunos(TurmaAluno turmaAluno) {
        System.out.println("Id TurmaAluno: " + turmaAluno.getIdTurma());
        System.out.println("Nome TurmaAluno: " + turmaAluno.getNomeTurma());
        System.out.println("Endereço: " + turmaAluno.getSiglaTurma() + "\n");
    }

    static Turma consultaTurma(int idTurma){

        Turma turma = new Turma();
        boolean encontrou = false;
        for (int index = 0; index < turmas.size(); index++) {
            if (turmas.get(index).getIdTurma() == idTurma) {
                turma = turmas.get(index);
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Turma não encontrada!\n");
        }
        return turma;
    }

    static Aluno consultaAluno(int idAluno){
        Aluno aluno = new Aluno();
        boolean encontrou = false;
        for (int index = 0; index < alunos.size(); index++) {
            if (alunos.get(index).getIdAluno() == idAluno) {
                aluno = alunos.get(index);
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Aluno não encontrado!\n");
        }
        return aluno;
    }
}
