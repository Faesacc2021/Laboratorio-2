import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static Scanner entrada = new Scanner(System.in);
    public static Arvore arvore = new Arvore();
    public static String[] nomes;
    public static void main(String[] args) {
        System.out.println("====== Sistema do banco ======" +
                "");
        int numero = 0;
        String senha = "";

        while (numero != 1111 || !senha.equals("adminis")) {
            System.out.print("Digite o número para entrar no sistema: ");
            numero = entrada.nextInt();
            if (numero != 1111) {
                System.out.println("\nNúmero incorreto");
                continue;
            }
            System.out.print("Digite a senha para entrar no sistema: ");
            senha = entrada.next();
            if (!senha.equals("adminis")) {
                System.out.println("\nSenha incorreta");
            }
        }

        int opcao = 0;
        int saida = 777;
        while (saida != 6) {
            System.out.println("\n====== MENU DE OPCOES ======");
            System.out.println(" 1 - Cadastrar Clientes");
            System.out.println(" 2 - Consultar dados pessoais de um cliente");
            System.out.println(" 3 - Listar clientes em ordem alfabética");
            System.out.println(" 4 - Consultar média de saldo dos clientes");
            System.out.println(" 5 - Listar cliente com maior saldo no banco");
            System.out.println(" 6 - Sair do banco");
            System.out.print("> ");
            opcao = entrada.nextInt();
            try {
                opcao = Integer.parseInt(String.valueOf(opcao));
            } catch (NumberFormatException e) {
                continue;
            }
            switch (opcao) {
                case 1:
                    cadastrarClientes();
                    break;
                case 2:
                    consultarClientes();
                    break;
                case 3:
                    listarClienteAlfabetica();
                    break;
                case 4:
                    consultarMediaSaldo();
                    break;
                case 5:
                    clienteMaiorSaldo();
                    break;
                case 6:
                    System.out.println("Programa Encerrado ");
                    saida = 6;
                    break;
                default:
                    System.out.println("Opção Inválida!");
            }
        }
    }
    static void cadastrarClientes() {
        System.out.print("Quantos clientes serão inseridos? ");
        int quantidade = entrada.nextInt();
        for (int i = 0; i < quantidade; i++) {
            System.out.print("Nome: ");
            entrada.nextLine();
            String nome = entrada.nextLine();
            while (verificaCliente(nome)) {
                System.out.println("Cliente já existe");
                System.out.print("Insira um novo cliente: ");
                nome = entrada.nextLine();
            }

            System.out.print("CPF: ");
            String cpf = entrada.next();
            while(!(verificarCpf(cpf) == null)) {
                System.out.println("CPF já existe");
                System.out.print("Insira um novo cpf:");
                cpf = entrada.next();
            }

            System.out.print("Telefone: ");
            long telefone = entrada.nextLong();

            System.out.print("Email: ");
            String email = entrada.next();

            System.out.print("Saldo: ");
            double saldo = entrada.nextDouble();
            arvore.inserir(new Cliente(nome, cpf, telefone, email, saldo));
            nomes = new String[quantidade];
            nomes[i] = nome;
            System.out.println((i + 1) + "º cliente inserido com sucesso\n");
        }
    }

    public static void consultarClientes () {
        System.out.print("Qual cliente você deseja pesquisar? ");
        entrada.nextLine();
        String nome = entrada.nextLine();
        NoArv resultado = arvore.pesquisar(nome, arvore.getRaiz());
        if (resultado != null) {
            System.out.println(resultado.getInfo());
        } else {
            System.out.println("Cliente não foi encontrado");
        }
    }

    public static void listarClienteAlfabetica () {
        String[] resultado = arvore.CamCentralString();
        System.out.println(Arrays.toString(resultado));
    }

    public static void consultarMediaSaldo () {
        double[] resultado = arvore.CamCentralInt();
        System.out.println(Arrays.toString(resultado));
    }

    public static void clienteMaiorSaldo () {

        if (arvore.getQuantNos() == 0) {
            System.out.println("Não há Clientes para consultar!");
        } else {
            int index = 0;
            double maiorSaldo = 0;
            String nomeCliente = "";

            Cliente[] resultado = arvore.CamCentral();
            while ( index < resultado.length ) {
                if (resultado[index].getSaldoCliente() > maiorSaldo) {
                    maiorSaldo = resultado[index].getSaldoCliente();
                    nomeCliente = resultado[index].getNomeCliente();
                }
                index = index + 1;
            }
            System.out.println("O cliente com maior saldo é      o " + nomeCliente);
            System.out.printf("Seu saldo atuar é de R$ %.2f", maiorSaldo);
        }
    }

    static boolean verificaCliente (String nome) {
        boolean existeCliente;
        existeCliente = arvore.pesquisar(nome);
        return existeCliente;
    }

    static NoArv verificarCpf(String cpf) {
        NoArv existeCpf = arvore.pesquisarCPF(cpf, arvore.getRaiz());
        return existeCpf;
    }
}
