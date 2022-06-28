package turma;

import filePath.PathFilesTxt;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TurmaFiles {

    static ArrayList<Turma> turmas = new ArrayList<Turma>();
    static Path path = Paths.get( PathFilesTxt.pathFilesTxt + "turma.txt");

    public static ArrayList<Turma> readTurma() throws IOException {
        List<String> linhas = Files.readAllLines(path);
        int i = 0;
        String linha;
        String[] valorComSplit;

        while( i < (linhas.size())) {
            linha = linhas.get(i);
            valorComSplit = linha.split("-");
            turmas.add(new Turma(Integer.parseInt(valorComSplit[0]),
                    valorComSplit[1],
                    valorComSplit[2]));
            i++;
        }
        return turmas;
    }

    public static void gravaTurma(ArrayList<Turma> turmas) throws IOException {
        FileWriter myWriter = new FileWriter(String.valueOf(path));

        for (int i = 0; i < turmas.size(); i++) {
            myWriter.write(turmas.get(i).getIdTurma() + "-" +
                    turmas.get(i).getNomeTurma() + "-" +
                    turmas.get(i).getSiglaTurma() + "\n");

        }
        myWriter.close();
    }
}
