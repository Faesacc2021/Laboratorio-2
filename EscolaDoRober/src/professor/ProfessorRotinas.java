package professor;

import professor.ProfessorFiles;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfessorRotinas {

    static ArrayList<Professor> professores = new ArrayList<Professor>();
    static Scanner lerTeclado = new Scanner(System.in);

    static void incluirProfessor(Professor professor) {
        professor.setMatricula(professores.size() + 1);
        professores.add(professor);
    }

    public static void menuProfessor() {
        String entrada = "";
        int continuar = 1;
        int valorMenu = 0;

        try {
            professores = ProfessorFiles.readProfessor();
        } catch (IOException e) {
            System.out.println("Não foi possível carregar o arquivo de professores");
            continuar = 1;
        }

        while (continuar != 0) {

            System.out.println("Menu Professor");
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
                        ProfessorFiles.gravaProfessor(professores);
                    } catch (IOException e) {
                        System.out.println("Não foi possível gravar o arquivo de professores");
                        System.exit(0);
                    }
                    continuar = 0;
                    break;
                case 1:
                    entradaProfessor();
                    break;
                case 2:
                    alteraProfessor();
                    break;
                case 3:
                    excluiProfessor();
                    break;
                case 4:
                    consultaProfessor();
                    break;
                case 5:
                    listaProfessores();
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }

    }

    static void entradaProfessor() {
        String nome = "";
        String endereco = "";
        String setor = "";
        String data = "";

        int sair = 777;
        lerTeclado.nextLine();

        while (sair != 0) {
            System.out.print("Tecle <Enter> no campo nome para sair.\n");
            System.out.println("Nome Completo: ");
            nome = lerTeclado.nextLine();

            if (nome.equals("")) {
                sair = 0;
                break;
            }

            System.out.println("Endereço:");
            endereco = lerTeclado.nextLine();

            System.out.println("Setor: ");
            setor = lerTeclado.nextLine();

            System.out.println("Data: ");
            data = lerTeclado.nextLine();

            Professor professor = new Professor();
            professor.setNome(nome);
            professor.setEndereco(endereco);
            professor.setSetor(setor);
            professor.setData(data);
            incluirProfessor(professor);
            System.out.println("\n\nprofessor.Professor inserido com sucesso!");
        }
    }


    static void consultaProfessor() {
        String matricula = "";
        int saida = 777;
        boolean encontrou = false;

        while (saida != 0) {
            System.out.println("Digite a Marícula que deseja consultar");
            matricula = lerTeclado.next();

            try {
                Integer.parseInt(matricula);
                saida = 0;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Marícula deve ser numérica!");
                continue;
            }
        }

        for (int index = 0; index < professores.size(); index++){
            if (professores.get(index).getMatricula() == Integer.parseInt(matricula)) {
                System.out.println("\n*********************************************");
                imprimeProfessor(professores.get(index));
                System.out.println("*********************************************\n");
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            System.out.println("professor.Professor não encontrado!\n");
        }
    }

    static void alteraProfessor() {
        String matricula = "";
        int saida = 777;
        boolean encontrou = false;

        while (saida != 0) {
            System.out.println("Digite a Marícula que deseja Alterar");
            matricula = lerTeclado.next();

            try {
                Integer.parseInt(matricula);
                saida = 0;
                break;
            } catch (NumberFormatException e) {
                System.out.println("Marícula deve ser numérica!");
                continue;
            }
        }

        for (int index = 0; index < professores.size(); index++){
            if (professores.get(index).getMatricula() == Integer.parseInt(matricula)) {
                System.out.println("\n*********************************************");
                imprimeProfessor(professores.get(index));
                System.out.println("*********************************************\n");
                encontrou = true;
                entrarNovosDados(index);
                break;
            }
        }
        if (!encontrou) {
            System.out.println("professor.Professor não encontrado!\n");
        }
    }

    static void entrarNovosDados(int index) {
        String nome = "";
        String endereco = "";
        String setor = "";
        String data = "";
        lerTeclado.nextLine();

        System.out.println("Nome Completo: ");
        nome = lerTeclado.nextLine();

        System.out.println("Endereço:");
        endereco = lerTeclado.nextLine();

        System.out.println("Setor: ");
        setor = lerTeclado.nextLine();

        System.out.println("Data: ");
        data = lerTeclado.nextLine();
        professores.get(index).setNome(nome);
        professores.get(index).setEndereco(endereco);
        professores.get(index).setSetor(setor);
        professores.get(index).setData(data);
        System.out.println("\nprofessor.Professor Alterado com sucesso!\n");
    }

    static void excluiProfessor() {
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
                System.out.println("Marícula deve ser numérica!");
                continue;
            }
        }

        for (int index = 0; index < professores.size(); index++) {
            if (professores.get(index).getMatricula() == Integer.parseInt(matricula)) {
                System.out.println("\n*********************************************");
                imprimeProfessor(professores.get(index));
                System.out.println("*********************************************\n");
                encontrou = true;
                professores.remove(index);
                System.out.println("professor.Professor Excluido com sucesso!");
                break;
            }
        }
        if (!encontrou) {
            System.out.println("professor.Professor não encontrado!\n");
        }
    }

    static void listaProfessores() {
        int index = 0;
        System.out.println("\n*********************************************");
        while (index < professores.size() ) {
            imprimeProfessor(professores.get(index));
            index = index + 1;
        }
        System.out.print("*********************************************\n");
    }

    static void imprimeProfessor(Professor professor) {
        System.out.println("Matrícula: " + professor.getMatricula());
        System.out.println("Nome Completo: " + professor.getNome());
        System.out.println("Endereço: " + professor.getEndereco());
        System.out.println("Setor: " + professor.getSetor());
        System.out.println("Data: " + professor.getData() + "\n");
    }
}
