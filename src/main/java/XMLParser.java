import java.io.File;

public class XmlParser extends Parser {
    @Override
    public String parse(File file) {
        log.info("# Обработчик " + this.getClass().getName() + " получил файл " + file.getName());
    }
}
