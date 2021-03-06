import aluno.AlunosRotinas;
import professor.ProfessorRotinas;
import turma.Turma;
import turma.TurmaRotinas;
import turmaAluno.TurmaAlunoRotinas;

import java.util.Scanner;

public class PrincipalMenu {
        static Scanner lerTeclado = new Scanner(System.in);

        public static void main(String[] args) {
              menuPrincipal();
        }

        static void menuPrincipal(){
            String entrada = "";
            int continuar = 1;
            int valorMenu = 0;

            while (continuar != 0) {
    
                System.out.println("\nEscolha uma opção");
                System.out.println("1 - Acessar Cadastros");
                System.out.println("2 - Operações");
                System.out.println("3 - Relatórios");
                System.out.println("0 - Finalizar");
                entrada = lerTeclado.next();
    
                try{
                    valorMenu = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    continue;
                }

                switch(valorMenu) {
                    case 0:
                        System.out.println("Programa Encerrado ");
                        continuar = 0;
                        break;
                    case 1:
                        menuCadastros();
                        break;
                    case 2:
                        menuOperacoes();
                        break;
                    case 3:
                        menuRelatorios();
                    default:
                        System.out.println("Opção Inválida!" );
                }
            }
        }

        private static void menuCadastros() {
            String entrada = "";
            int continuar = 1;
            int valorMenu = 0;
            while (continuar != 0) {
    
                System.out.println("\nEscolha um Cadastro");
                System.out.println("1 - Professor");
                System.out.println("2 - Alunos");
                System.out.println("3 - Turmas");
                System.out.println("0 - Voltar para menu principal");
                entrada = lerTeclado.next();
    
                try{
                    valorMenu = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    continue;
                }

                switch(valorMenu) {
                    case 0:
                        continuar = 0;
                        break;
                    case 1:
                        ProfessorRotinas.menuProfessor();
                        break;
                    case 2:
                        AlunosRotinas.menuAluno();
                        break;
                    case 3:
                        TurmaRotinas.menuTurma();
                        break;
                    default:
                        System.out.println("Opção Inválida!" );
                }
            }

        }
    
        private static void menuOperacoes() {
            int continuar = 1;
            String entrada = "";
            int valorMenu = 0;

            while (continuar != 0) {

                System.out.println("\nO que deseja fazer ?");
                System.out.println("1 - Turma x Aluno");
                System.out.println("2 - Turma x Professor");
                System.out.println("0 - Voltar para menu principal");
                entrada = lerTeclado.next();

                try{
                    valorMenu = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    continue;
                }

                switch(valorMenu) {
                    case 0:
                        continuar = 0;
                        break;
                    case 1:
                        TurmaAlunoRotinas.menuTurmaAlunos();
                        break;
                    case 2:
                        break;
                    default:
                        System.out.println("Opção Inválida!" );
                }
            }
        }
    
        private static void menuRelatorios() {
            int continuar = 1;
            String entrada = "";
            int valorMenu = 0;

            while (continuar != 0) {

                System.out.println("\nEscolha o Relatório desejado");
                System.out.println("1 - Professores de uma Turma");
                System.out.println("2 - Alunos de Uma Turma");
                System.out.println("0 - Voltar para menu principal");
                entrada = lerTeclado.next();

                try{
                    valorMenu = Integer.parseInt(entrada);
                } catch (NumberFormatException e) {
                    continue;
                }

                switch(valorMenu) {
                    case 0:
                        continuar = 0;
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opção Inválida!" );
                }
            }

        }
    }