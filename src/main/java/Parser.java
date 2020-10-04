import org.apache.log4j.Logger;

import java.io.*;

abstract class Parser {
    static Logger log = Logger.getLogger(Parser.class);

    private Parser next;

    /**
     * Помогает строить цепь из объектов-проверок.
     */
    public Parser linkWith(Parser next) {
        this.next = next;
        return next;
    }

    public abstract String parse(File file);

    public boolean parseNext(File file) {
        if (next == null) {
            return true;
        }
        return next.parse();
    }

    private void printToOutputFile(String text) {
        try (FileWriter fw = new FileWriter(outputFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
