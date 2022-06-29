package turmaAluno;

import filePath.PathFilesTxt;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TurmaAlunoFiles {
    static ArrayList<TurmaAluno> turmaAlunos = new ArrayList<TurmaAluno>();
    static Path path = Paths.get( PathFilesTxt.pathFilesTxt + "turmaAluno.txt");

    public static ArrayList<TurmaAluno> readTurmaAlunos() throws IOException {
        List<String> linhas = Files.readAllLines(path);
        int i = 0;
        String linha;
        String[] valorComSplit;

        while( i < (linhas.size())) {
            linha = linhas.get(i);
            valorComSplit = linha.split("-");
            turmaAlunos.add(new TurmaAluno(Long.parseLong(valorComSplit[0]),
                    Integer.parseInt(valorComSplit[1]),
                    Integer.parseInt(valorComSplit[2])));
            i++;
        }
        return turmaAlunos;
    }

    public static void gravaTurmaAlunos(ArrayList<TurmaAluno> turmaAlunos) throws IOException {
        FileWriter myWriter = new FileWriter(String.valueOf(path));

        for (int i = 0; i < turmaAlunos.size(); i++) {
            myWriter.write(turmaAlunos.get(i).getId() + "-" +
                    turmaAlunos.get(i).getIdTurma() + "-" +
                    turmaAlunos.get(i).getIdAluno() + "\n");

        }
        myWriter.close();
    }
}
