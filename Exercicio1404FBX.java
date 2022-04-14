import java.util.Scanner;

public class Exercicio1404FBX {

	public static void main(String[] args) {
		
		
		Scanner ler = new Scanner(System.in);
		
		AlunoAprovados alunosAprovados = new AlunoAprovados();
		RetornaIdade retornaIdade = new RetornaIdade();
		String  nome = ler.next();
		
		alunosAprovados.setNome(nome);
		alunosAprovados.setIdade(54);
		alunosAprovados.setEndereco("Rua das margaridas");
		alunosAprovados.setTelefone("273379999");
		imprimeAluno(alunosAprovados);
		
		int idadeAluno = retornaIdade.retornaIdade(alunosAprovados);
		System.out.println("====> " + idadeAluno);
		System.out.println("====> " + alunosAprovados.getTelefone());
	}

	
	public static void imprimeAluno(AlunoAprovados alunosAprovados){
		
		System.out.println(alunosAprovados.nome);
		System.out.println(alunosAprovados.idade);
		System.out.println(alunosAprovados.endereco);
		System.out.println(alunosAprovados.telefone);

	}
	
}
