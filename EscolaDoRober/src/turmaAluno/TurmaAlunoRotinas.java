package turmaAluno;

import aluno.Aluno;
import aluno.AlunoFiles;
import turma.Turma;
import turma.TurmaFiles;
import turma.TurmaRotinas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class
TurmaAlunoRotinas {

    static ArrayList<TurmaAluno> turmaAlunos = new ArrayList<TurmaAluno>();
    static Scanner lerTeclado = new Scanner(System.in);

    static ArrayList<Turma> turmas = new ArrayList<Turma>();
    static ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    static void incluirTurmaAlunos(TurmaAluno turmaMaisAlunos) {

        String idAlunoStr = String.valueOf(turmaMaisAlunos.getIdAluno());
        String idTurmaStr = String.valueOf(turmaMaisAlunos.getIdTurma());
        String id = (idTurmaStr + idAlunoStr);

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
            Collections.sort(turmaAlunos);
        } catch (IOException e) {
            System.out.println("Não foi possível carregar o arquivo de Turma x Alunos");
        }

        try {
            turmas.clear();
            turmas = TurmaFiles.readTurma();
        } catch (IOException e) {
            System.out.println("Não foi possível carregar o arquivo de Turmas.");
            System.out.println("Verifique se existem Turmas Cadastradas");
            continuar = 0;
        }

        try {
            alunos.clear();
            alunos = AlunoFiles.readAluno();
        } catch (IOException e) {
            System.out.println("Não foi possível carregar o arquivo de Alunos");
            System.out.println("Verifique se existem Alunos Cadastrados");
            continuar = 0;
        }

        while (continuar != 0) {

            System.out.println("\nMenu Turma x Alunos");
            System.out.println("1 - Associar Turma x Aluno");
            System.out.println("2 - Listar Todos");
            System.out.println("0 - Voltar para menu de Cadastros");
            entrada = lerTeclado.next();

            try {
                valorMenu = parseInt(entrada);
            } catch (NumberFormatException e) {
                continue;
            }

            switch (valorMenu) {
                case 0:
                    continuar = 0;
                    break;
                case 1:
                    associarTurmaAlunos();
                    break;
                case 2:
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

        while (sair != 0) {
            System.out.print("Tecle <Enter> no Id para sair.\n");
            System.out.println("Digite o Id da Turma que quer associar alunos");
            idTurma = lerTeclado.nextInt();

            if (idTurma == 0) {
                try {
                    if (turmaAlunos.size() > 0){
                        TurmaAlunoFiles.gravaTurmaAlunos(turmaAlunos);
                    }
                } catch (IOException e) {
                    System.out.println("Não foi possível gravar o arquivo de Turma x Alunos");
                }
                sair = 0;
                break;
            }

            try {
                parseInt(String.valueOf(idTurma));
            } catch (NumberFormatException e) {
                continue;
            }

            turma = consultaTurma(idTurma);
            if (turma == null) {
                System.out.println("Turma não encontrada!");
                continue;
            } else {
                System.out.println("Você vai associar Alunos para turma >>> " + turma.getNomeTurma().toUpperCase() + " <<<\n");
            }

            int sairLoop = 777;

            while (sairLoop != 0) {
                System.out.print("Tecle < 0 > no campo Id para sair.\n");
                System.out.println("Digite o Id do Aluno que deseja associar a turma >>> " + turma.getNomeTurma());
                idAluno = lerTeclado.nextInt();

                if (idAluno == 0) {
                    sairLoop = 0;
                    break;
                }

                try {
                    parseInt(String.valueOf(idAluno));
                } catch (NumberFormatException e) {
                    continue;
                }


                aluno = consultaAluno(idAluno);
                if (turma == null) {
                    System.out.println("Aluno não encontrada!");
                    continue;
                } else {
                    System.out.println("O Aluno >>> " + aluno.getNome().toUpperCase() + " <<< foi associado a >>> " + turma.getNomeTurma() + "\n");
                    TurmaAluno turmaAluno = new TurmaAluno();
                    turmaAluno.setIdTurma(idTurma);
                    turmaAluno.setIdAluno(idAluno);
                    incluirTurmaAlunos(turmaAluno);
                }
            }
        }
    }

    static void listaTurmaAlunos() {
        int index = 0;
        System.out.println("\n****************************************************************");
        while (index < turmaAlunos.size()) {
            imprimeTurmaAlunos(turmaAlunos.get(index));
            index = index + 1;
        }
        System.out.print("\n*****************************************************************\n");
    }

    static int turmaAnterior = 0;
    static void imprimeTurmaAlunos(TurmaAluno turmaAluno) {
        if (turmaAnterior != turmaAluno.getIdTurma()){
            System.out.println("\nNome da Turma: " + consultaTurma(turmaAluno.getIdTurma()).getNomeTurma());
            turmaAnterior = turmaAluno.getIdTurma();
        }
        System.out.println("Nome Aluno: "  + consultaAluno(turmaAluno.getIdAluno()).getNome());
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
