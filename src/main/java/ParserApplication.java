import model.PersonList;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

class ParserApplication {

    private File outputFile;
    private File inputFile;

    void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    void parse() {
        getFileSetFromInputFile()
                .forEach(file -> {
                    Parser parser = new CsvParser();
                    parser.linkWith(new XMLParser())
                            .linkWith(new JsonParser())
                            .linkWith(new TxtParser()); //chain of repository
                    printToOutputFile(parser.parse(file));
                });
    }


    private Set<File> getFileSetFromInputFile() {
        Set<File> files = new LinkedHashSet<>();
        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                files.add(new File(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    private void printToOutputFile(PersonList personList) {
        try (FileWriter fw = new FileWriter(outputFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(personList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
