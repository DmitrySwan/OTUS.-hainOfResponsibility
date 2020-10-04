import java.io.File;

public class TxtParser extends Parser {

    @Override
    public String parse(File file) {
        log.info("# Обработчик " + this.getClass().getName() + " получил файл " + file.getName());
    }
}
