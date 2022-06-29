package aluno;

import filePath.PathFilesTxt;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AlunoFiles {
    static ArrayList<Aluno> alunos = new ArrayList<Aluno>();
    static Path path = Paths.get( PathFilesTxt.pathFilesTxt + "aluno.txt");

    public static ArrayList<Aluno> readAluno() throws IOException {
        List<String> linhas = Files.readAllLines(path);
        int i = 0;
        String linha;
        String[] valorComSplit;

        while( i < (linhas.size())) {
            linha = linhas.get(i);
            valorComSplit = linha.split("-");
            alunos.add(new Aluno(Integer.parseInt(valorComSplit[0]),
                    valorComSplit[1],
                    valorComSplit[2]));
            i++;
        }
        return alunos;
    }

    public static void gravaAluno(ArrayList<Aluno> alunos) throws IOException {
        FileWriter myWriter = new FileWriter(String.valueOf(path));

        for (int i = 0; i < alunos.size(); i++) {
            myWriter.write(alunos.get(i).getIdAluno() + "-" +
                    alunos.get(i).getNome() + "-" +
                    alunos.get(i).getCpf() + "\n");

        }
        myWriter.close();
    }
}
