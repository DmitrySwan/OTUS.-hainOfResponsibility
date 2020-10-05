import model.PersonList;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;

abstract class Parser {
    static Logger log = Logger.getLogger(Parser.class);

    private Parser next;

    /**
     * Помогает строить цепь из объектов-проверок.
     */
    Parser linkWith(Parser next) {
        this.next = next;
        return next;
    }

    public abstract PersonList parse(File file);

    PersonList parseNext(File file) {
        if (next == null) {
            log.error("File " + file + " can't be parsed.");
            return null;
        }
        return next.parse(file);
    }
}
