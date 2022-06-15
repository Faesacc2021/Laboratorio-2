import java.util.Scanner;

public class PrincipalBrinquedos {
    static Scanner ler = new Scanner(System.in);
    public static int autoIncrement = -1;

    public static void main(String[] args) {
        menuBrinquedo();
    }

    public static void menuBrinquedo(){
        int continuar = 7;
        String entrada = "";
        int valorMenu = 0;

        while (continuar != 0){

            System.out.println("Escolha uma opção");
            System.out.println("1 - Incluir Dados do Brinquedo ");
            System.out.println("2 - Lucro Obtido");
            System.out.println("3 - Verifica Estoque Mínimo");
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
                    incluirBrinquedo();
                    break;
                case 2:
                    consultaLucro();
                    break;
                case 3:
                    consultaEstoque();
                    break;
                default:
                    System.out.println("Opção Inválida!" );
            }
        }
    }


    int estoqMinimo;
    int estoqAtual;

    private static void incluirBrinquedo() {
        Brinquedos brinquedo = new Brinquedos();

        System.out.println("Digite o Código do Brinquedo: ");
        brinquedo.setCodigo(ler.nextInt());

        System.out.println("Digite o nome do Brinquedo: ");
        ler.nextLine();
        brinquedo.setDescricao(ler.nextLine());

        System.out.println("Digite o Preço de Compra R$ ");
        brinquedo.setPrecoCompra(ler.nextDouble());

        System.out.println("Digite o Preço de venda R$ ");
        brinquedo.setPrecoVenda(ler.nextDouble());

        System.out.println("Digite o Estoque Mínimo");
        brinquedo.setEstoqMinimo(ler.nextInt());

        System.out.println("Digite o Estoque atual");
        brinquedo.setEstoqAtual(ler.nextInt());

        autoIncrement = autoIncrement + 1;
        Brinquedos.incluirBrinquedos(brinquedo, autoIncrement);
    }

    private static void consultaLucro() {
        int codigo = 0;
        System.out.println("Digite o Código do produto: ");
        codigo = ler.nextInt();
        Brinquedos.consultaLucro(autoIncrement, codigo);
    }

    private static void consultaEstoque() {
        Brinquedos.consultaEstoque(autoIncrement);
    }

}