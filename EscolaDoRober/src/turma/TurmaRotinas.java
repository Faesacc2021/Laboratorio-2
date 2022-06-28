package turma;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TurmaRotinas {

    static ArrayList<Turma> turmas = new ArrayList<Turma>();
    static Scanner lerTeclado = new Scanner(System.in);

    static void incluirTurma(Turma turma) {
        turma.setIdTurma(turmas.size() + 1);
        turmas.add(turma);
    }

    public static void menuTurma() {
        String entrada = "";
        int continuar = 1;
        int valorMenu = 0;

        try {
            turmas = TurmaFiles.readTurma();
        } catch (IOException e) {
            System.out.println("Não foi possível carregar o arquivo de turmas");
            continuar = 1;
        }

        while (continuar != 0) {

            System.out.println("Menu Turma");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Consultar");
            System.out.println("5 - Listar Todos");
            System.out.println("0 - Voltar para menu principal");
            entrada = lerTeclado.next();

            try {
                valorMenu = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                continue;
            }

            switch (valorMenu) {
                case 0:
                    try {
                        TurmaFiles.gravaTurma(turmas);
                    } catch (IOException e) {
                        System.out.println("Não foi possível gravar o arquivo de turmas");
                        System.exit(0);
                    }
                    continuar = 0;
                    break;
                case 1:
                    entradaTurma();
                    break;
                case 2:
                    alteraTurma();
                    break;
                case 3:
                    excluiTurma();
                    break;
                case 4:
                    consultaTurma();
                    break;
                case 5:
                    listaTurmaes();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }

    }

    static void entradaTurma() {
        String nome = "";
        String sigla = "";

        int sair = 777;
        lerTeclado.nextLine();

        while (sair != 0) {
            System.out.print("Tecle <Enter> no campo nome para sair.\n");
            System.out.println("Nome da Turma: ");
            nome = lerTeclado.nextLine();

            if (nome.equals("")) {
                sair = 0;
                break;
            }

            System.out.println("Sigla:");
            sigla = lerTeclado.nextLine();

            if (sigla.length() > 3) {
                System.out.println("Sigla não deve ser maior do que três caracteres ");
                continue;
            }

            Turma turma = new Turma();
            turma.setNomeTurma(nome);
            turma.setSiglaTurma(sigla.toUpperCase());
            incluirTurma(turma);
            System.out.println("\n\nTurma inserida com sucesso!");
        }
    }


    static void consultaTurma() {
        String matricula = "";
        int saida = 777;
        boolean encontrou = false;

        while (saida != 0) {
            System.out.println("Digite o ID da turma que deseja consultar");
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

        for (int index = 0; index < turmas.size(); index++) {
            if (turmas.get(index).getIdTurma() == Integer.parseInt(matricula)) {
                System.out.println("\n*********************************************");
                imprimeTurma(turmas.get(index));
                System.out.println("*********************************************\n");
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Turma não encontrada!\n");
        }
    }

    static void alteraTurma() {
        String idTurma = "";
        int saida = 777;
        boolean encontrou = false;

        while (saida != 0) {
            System.out.println("Digite o ID da turma que deseja Alterar");
            idTurma = lerTeclado.next();

            try {
                Integer.parseInt(idTurma);
                saida = 0;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id deve ser numérico!");
                continue;
            }
        }

        for (int index = 0; index < turmas.size(); index++) {
            if (turmas.get(index).getIdTurma() == Integer.parseInt(idTurma)) {
                System.out.println("\n*********************************************");
                imprimeTurma(turmas.get(index));
                System.out.println("*********************************************\n");
                encontrou = true;
                entrarNovosDados(index);
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Turma não encontrada!\n");
        }
    }

    static void entrarNovosDados(int index) {
        String nome = "";
        String sigla = "";

        lerTeclado.nextLine();

        System.out.println("Nome da Turma: ");
        nome = lerTeclado.nextLine();

        System.out.println("Sigla:");
        sigla = lerTeclado.nextLine();

        if (sigla.length() > 3) {
            System.out.println("Sigla não deve ser maior do que três caracteres ");
        } else {
            turmas.get(index).setNomeTurma(nome);
            turmas.get(index).setSiglaTurma(sigla.toUpperCase());
            System.out.println("\nTurma Alterada com sucesso!\n");
        }
    }

    static void excluiTurma() {
        String matricula = "";
        int saida = 777;
        boolean encontrou = false;

        while (saida != 0) {
            System.out.println("Digite a Marícula que deseja Excluir");
            matricula = lerTeclado.next();

            try {
                Integer.parseInt(matricula);
                saida = 0;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Id da Turma deve ser numérico!");
            }
        }

        for (int index = 0; index < turmas.size(); index++) {
            if (turmas.get(index).getIdTurma() == Integer.parseInt(matricula)) {
                System.out.println("\n*********************************************");
                imprimeTurma(turmas.get(index));
                System.out.println("*********************************************\n");
                encontrou = true;
                turmas.remove(index);
                System.out.println("Turma Excluida com sucesso!");
                break;
            }
        }
        if (!encontrou) {
            System.out.println("Turma não encontrada!\n");
        }
    }

    static void listaTurmaes() {
        int index = 0;
        System.out.println("\n*********************************************");
        while (index < turmas.size()) {
            imprimeTurma(turmas.get(index));
            index = index + 1;
        }
        System.out.print("*********************************************\n");
    }

    static void imprimeTurma(Turma turma) {
        System.out.println("Id Turma: " + turma.getIdTurma());
        System.out.println("Nome Turma: " + turma.getNomeTurma());
        System.out.println("Endereço: " + turma.getSiglaTurma() + "\n");
    }
}
