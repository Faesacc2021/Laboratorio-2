import java.util.Scanner;


public class PrincipalFilme {
    static Scanner ler = new Scanner(System.in);

    public static void main(String[] args) {
        menuFilme();
    }

    public static void menuFilme(){
        int continuar = 777;
        int valorMenu = 0;
        int tamanhoVetor = 0;
        int autoIncrement = 0;

        System.out.println("Quanto filmes você quer guardar? ");
        Filme.createVetor(ler.nextInt());

        while (continuar != 0){

            System.out.println("Escolha uma opção");
            System.out.println("1 - Incluir Filmes ");
            System.out.println("2 - Consultar Filmes");
            System.out.println("3 - Excluir Filmes");
            System.out.println("0 - Finalizar operações");
            valorMenu = ler.nextInt();

            switch(valorMenu) {
                case 0:
                    System.out.println("Programa Encerrado ");
                    continuar = 0;
                    break;
                case 1:
                    incluirFilmes(autoIncrement);
                    break;
                case 2:
                    consultarFilmes(autoIncrement);
                    break;
                case 3:
                    autoIncrement = excluirFilmes(autoIncrement);
                  default:
                    System.out.println("Opção Inválida!" );
            }
            autoIncrement = autoIncrement + 1;
        }
    }

    private static void incluirFilmes(int autoIncrement) {
        Filme filme = new Filme();

        System.out.println("Digite o nome do Filme: ");
        ler.nextLine();
        filme.setTituloFilme(ler.nextLine());

        System.out.println("Digite o Gênero do Filme: ");
        filme.setGeneroFilme(ler.next());

        filme.setCodigoFilme(autoIncrement);

        Filme.filme[autoIncrement] = filme;
    }
    private static void consultarFilmes(int autoIncrement) {

        System.out.println("Qual filme deseja consultar? ");
        String nomeFilme = ler.next();

        String retornoColsulta = Filme.consultarFilmes(nomeFilme, autoIncrement);

        if (retornoColsulta == "") {
            System.out.println("Filme INEXISTENTE na nossa base");
        } else {
            System.out.println("O Filme " +  retornoColsulta  + " foi localizado !!!");
        }
    }

    private static int excluirFilmes(int autoIncrement) {

        System.out.println("Qual filme deseja excluir? ");
        String nomeFime = ler.next();

        String retornoColsulta = Filme.excluirFilme(nomeFime, autoIncrement);

        if (retornoColsulta == "") {
            System.out.println("Filme INEXISTENTE na nossa base");
        } else {
            System.out.println("O Filme " +  retornoColsulta  + " foi EXCLUIDO !!!");
            return autoIncrement - 1;
        }
        return autoIncrement;
    }
}