import java.util.Scanner;


public class PrincipalFilme {
    static Scanner ler = new Scanner(System.in);
    public static int autoIncrement = -1;

    public static void main(String[] args) {
        menuFilme();
    }

    public static void menuFilme(){
        int continuar = 7;
        String entrada = "";
        int valorMenu = 0;

        System.out.println("Quanto filmes você quer guardar? ");
        Filme.createVetor(ler.nextInt());

        while (continuar != 0){

            System.out.println("Escolha uma opção");
            System.out.println("1 - Incluir Filmes ");
            System.out.println("2 - Consultar Filmes");
            System.out.println("3 - Excluir Filmes");
            System.out.println("4 - Consultar Filmes por Gênero");
            System.out.println("0 - Finalizar operações");
            entrada = ler.next();

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
                    incluirFilmes();
                    break;
                case 2:
                    consultarFilmes();
                    break;
                case 3:
                    excluirFilmes();
                case 4:
                    consultaGenero();
                default:
                    System.out.println("Opção Inválida!" );
            }
        }
    }

    private static void incluirFilmes() {
        Filme filme = new Filme();

        System.out.println("Digite o nome do Filme: ");
        ler.nextLine();
        filme.setTituloFilme(ler.nextLine());

        System.out.println("Digite o Gênero do Filme: ");
        filme.setGeneroFilme(ler.next());

        autoIncrement = autoIncrement + 1;
        filme.setCodigoFilme(autoIncrement);
        Filme.filme[autoIncrement] = filme;
    }

    private static void consultarFilmes() {

        System.out.println("Qual filme deseja consultar? ");
        String nomeFilme = ler.next();

        String retornoColsulta = Filme.consultarFilmes(nomeFilme, autoIncrement);

        if (retornoColsulta == "") {
            System.out.println("Filme INEXISTENTE na nossa base");
        } else {
            System.out.println("O Filme " +  retornoColsulta  + " foi localizado !!!");
        }
    }

    private static void consultaGenero() {

        System.out.println("Qual Gênero deseja consultar? ");
        String genero = ler.next();

        int retornoColsulta = Filme.consultaGenero(genero, autoIncrement);

           System.out.println("A quantidade de Filmes deste Gênero é : " +  retornoColsulta );
    }

    private static void excluirFilmes() {

        System.out.println("Qual filme deseja excluir? ");
        String nomeFime = ler.next();

        String retornoColsulta = Filme.excluirFilme(nomeFime, autoIncrement);

        if (retornoColsulta == "") {
            System.out.println("Filme INEXISTENTE na nossa base");
        } else {
            System.out.println("O Filme " +  retornoColsulta  + " foi EXCLUIDO !!!");
            autoIncrement = autoIncrement - 1;
        }
    }
}