import java.util.ArrayList;
import java.util.Vector;

import classes.Aluno;


public class VetorAluno {

	public static void main(String[] args) {

		ArrayList<Aluno> vetor = new ArrayList<Aluno>();
		
		vetor.add(criaAluno(1,"Franz Blauth"));
		vetor.add(criaAluno(2,"Heitor"));
		vetor.add(criaAluno(3,"Julia"));
		vetor.add(criaAluno(4,"Matheus"));
		vetor.add(criaAluno(5,"Henrique"));

		for(int ind = 0; ind < vetor.size(); ind++){
			System.out.println("The new Vector is: " + vetor.get(ind).getIdAluno() + " " + vetor.get(ind).getNameAluno());
		}
	}

	public static Aluno criaAluno(int id, String nome){
		Aluno aluno = new Aluno();
		aluno.setIdAluno(id);
		aluno.setNameAluno(nome);
		return aluno;
	}

}
