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

    public void excluirProfessor(Professor professor) {
        professores.remove(professor);
    }

    public Professor getProfessor(int matricula) {
        Professor professor = new Professor();
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getMatricula() == matricula) {
                professor = professores.get(i);
                return professor;
            }
        }
        return professor;
    }

    public boolean alteraProfessor(Professor professor) {
        int matricula = professor.getMatricula();
        for (int i = 0; i < professores.size(); i++) {
            if (professores.get(i).getMatricula() == matricula) {
                professores.set(i, professores.get(i));
                return true;
            }
        }
        return false;
    }

    static void menuProfessor() {
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
            System.out.println("4 - Listar");
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
                        continue;
                    }
                    continuar = 0;
                    break;
                case 1:
                    entradaProfessor();
                    break;
                case 2:
                    //();
                    break;
                case 3:
//                       cadastroTurmas();
                case 4:
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
            System.out.println("\n\nProfessor inserido com sucesso!");
        }
    }

    static void listaProfessores() {
        int index = 0;
        System.out.println("\n*********************************************");
        while (index < professores.size() ) {
            System.out.println("\nMatrícula: " + professores.get(index).getMatricula());
            System.out.println("Nome Completo: " + professores.get(index).getNome());
            System.out.println("Endereço: " + professores.get(index).getEndereco());
            System.out.println("Setor: " + professores.get(index).getSetor());
            System.out.println("Data: " + professores.get(index).getData());
            index = index + 1;
        }
        System.out.println("*********************************************\n\n");
    }
}
