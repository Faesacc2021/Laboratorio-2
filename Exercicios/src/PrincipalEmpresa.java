import java.util.Scanner;

public class PrincipalEmpresa {
    static Scanner ler = new Scanner(System.in);
    public static int autoIncrement = -1;

    public static void main(String[] args) {
        menuVendedor();
    }

    public static void menuVendedor(){
        int continuar = 7;
        String entrada = "";
        int valorMenu = 0;

        System.out.println("Quanto vendedores você quer guardar? ");
        Vendedor.createVetor(ler.nextInt());

        while (continuar != 0){

            System.out.println("Escolha uma opção");
            System.out.println("1 - Incluir Vendedores ");
            System.out.println("2 - Excluir Vendedores");
            System.out.println("3 - Consultar Vendedores por Tipo Mercadoria");
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
                    incluirVendedor();
                    break;
                case 2:
                    excluirVendedor();
                case 3:
                    consultaTipo();
                    break;
                default:
                    System.out.println("Opção Inválida!" );
            }
        }
    }

    private static void incluirVendedor() {
        Vendedor vendedor = new Vendedor();

        System.out.println("Digite o nome do Vendedor: ");
        ler.nextLine();
        vendedor.setNomeVendedor(ler.nextLine());

        System.out.println("Digite o Tipo de Mercadoria: ");
        vendedor.setTipoMercadoria(ler.next());

        autoIncrement = autoIncrement + 1;
        vendedor.setCodigoVendedor(autoIncrement);
        Vendedor.incluirVendedor(vendedor, autoIncrement);
    }

    private static void consultaTipo() {

        System.out.println("Qual Tipo de Mercadoria deseja consultar? ");
        String tipo = ler.next();

        int retornoColsulta = Vendedor.consultaTipoMercadoria(tipo, autoIncrement);

        System.out.println("A quantidade de vendedores deste tipo é : " +  retornoColsulta );
    }

    private static void excluirVendedor() {

        System.out.println("Qual vendedor deseja excluir? ");
        String nomeVendedor = ler.next();

        String retornoColsulta = Vendedor.excluirVendedor(nomeVendedor, autoIncrement);

        if (retornoColsulta == "") {
            System.out.println("Vendedor INEXISTENTE na nossa base");
        } else {
            System.out.println("O Vendedor " +  retornoColsulta  + " foi EXCLUIDO !!!");
            autoIncrement = autoIncrement - 1;
        }
    }
}