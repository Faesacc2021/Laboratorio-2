package aluno;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AlunosRotinas {

    static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    static Scanner lerTeclado = new Scanner(System.in);

    static void incluirAluno(Aluno aluno) {
        aluno.setIdAluno(alunos.size() + 1);
        alunos.add(aluno);
    }

    public static void menuAluno() {
        String entrada = "";
        int continuar = 1;
        int valorMenu = 0;

        try {
            alunos.clear();
            alunos = AlunoFiles.readAluno();
        } catch (IOException e) {
            System.out.println("Não foi possível carregar o arquivo de alunos");
            continuar = 1;
        }

        while (continuar != 0) {

            System.out.println("Menu Aluno");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Consultar");
            System.out.println("5 - Listar Todos");
            System.out.println("0 - Voltar para menu de Cadastros");
            entrada = lerTeclado.next();

            try {
                valorMenu = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                continue;
            }

            switch (valorMenu) {
                case 0:
                    try {
                        AlunoFiles.gravaAluno(alunos);
                    } catch (IOException e) {
                        System.out.println("Não foi possível gravar o arquivo de alunos");
                        System.exit(0);
                    }
                    continuar = 0;
                    break;
                case 1:
                    entradaAluno();
                    break;
                case 2:
                    alteraAluno();
                    break;
                case 3:
                    excluiAluno();
                    break;
                case 4:
                    consultaAluno();
                    break;
                case 5:
                    listaAlunos();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }

    }

    static void entradaAluno() {
        String nome = "";
        String cpf = "";

        int sair = 777;
        lerTeclado.nextLine();

        while (sair != 0) {
            System.out.print("Tecle <Enter> no campo nome para sair.\n");
            System.out.println("Nome da Aluno: ");
            nome = lerTeclado.nextLine();

            if (nome.equals("")) {
                sair = 0;
                break;
            }

            System.out.println("CPF:");
            cpf = lerTeclado.nextLine();

            try {
                Long.parseLong(cpf);
            } catch (NumberFormatException e) {
                System.out.println("CPF deve conter apenas números");
                continue;
            }

            Aluno aluno = new Aluno();
            aluno.setNome(nome);
            aluno.setCpf(cpf.toUpperCase());
            incluirAluno(aluno);
            System.out.println("\n\nAluno inserido com sucesso!");
        }
    }

    static void consultaAluno() {
        String matricula = "";
        int saida = 777;
        boolean encontrou = false;

        while (saida != 0) {
            System.out.println("Digite o ID da aluno que deseja consultar");
            matricula = lerTeclado.next();

            try {
                Integer.parseInt(matricula);
                saida = 0;
                break;
            } catch (NumberFormatException e) {
                System.out.println("ID deve ser numérico!");
                continue;
            }
        }

        for (int index = 0; index < alunos.size(); index++) {
            if (alunos.get(index).getIdAluno() == Integer.parseInt(matricula)) {
                System.out.println("\n*********************************************");
                imprimeAluno(alunos.get(index));
                System.out.println("*********************************************\n");
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Aluno não encontrado!\n");
        }
    }

    static void alteraAluno() {
        String idAluno = "";
        int saida = 777;
        boolean encontrou = false;

        while (saida != 0) {
            System.out.println("Digite o ID da aluno que deseja Alterar");
            idAluno = lerTeclado.next();

            try {
                Integer.parseInt(idAluno);
                saida = 0;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id deve ser numérico!");
                continue;
            }
        }

        for (int index = 0; index < alunos.size(); index++) {
            if (alunos.get(index).getIdAluno() == Integer.parseInt(idAluno)) {
                System.out.println("\n*********************************************");
                imprimeAluno(alunos.get(index));
                System.out.println("*********************************************\n");
                encontrou = true;
                entrarNovosDados(index);
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Aluno não encontrado!\n");
        }
    }

    static void entrarNovosDados(int index) {
        String nome = "";
        String cpf = "";

        lerTeclado.nextLine();

        System.out.println("Nome da Aluno: ");
        nome = lerTeclado.nextLine();

        System.out.println("CPF:");
        cpf = lerTeclado.nextLine();

        try {
            Integer.parseInt(cpf);
            alunos.get(index).setNome(nome);
            alunos.get(index).setCpf(cpf.toUpperCase());
            System.out.println("\nAluno Alterado com sucesso!\n");
        } catch (NumberFormatException e) {
            System.out.println("CPF deve conter apenas números");
        }
    }

    static void excluiAluno() {
        String matricula = "";
        int saida = 777;
        boolean encontrou = false;

        while (saida != 0) {
            System.out.println("Digite o ID do Aluno que deseja Excluir");
            matricula = lerTeclado.next();

            try {
                Integer.parseInt(matricula);
                saida = 0;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id da Aluno deve ser numérico!");
            }
        }

        for (int index = 0; index < alunos.size(); index++) {
            if (alunos.get(index).getIdAluno() == Integer.parseInt(matricula)) {
                System.out.println("\n*********************************************");
                imprimeAluno(alunos.get(index));
                System.out.println("*********************************************\n");
                encontrou = true;
                alunos.remove(index);
                System.out.println("Aluno Excluido com sucesso!");
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Aluno não encontrado!\n");
        }
    }

    static void listaAlunos() {
        int index = 0;
        System.out.println("\n*********************************************");
        while (index < alunos.size()) {
            imprimeAluno(alunos.get(index));
            index = index + 1;
        }
        System.out.print("*********************************************\n");
    }

    static void imprimeAluno(Aluno aluno) {
        System.out.println("Id Aluno: " + aluno.getIdAluno());
        System.out.println("Nome Aluno: " + aluno.getNome());
        System.out.println("CPF: " + aluno.getCpf() + "\n");
    }
}
