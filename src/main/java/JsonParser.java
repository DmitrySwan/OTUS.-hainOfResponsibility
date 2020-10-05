import com.google.gson.Gson;
import model.PersonList;
import model.PersonListObject;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;

public class JsonParser extends Parser {
    @Override
    public PersonList parse(File file) {
        log.info("# Обработчик " + this.getClass().getName() + " получил файл " + file.getName());
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return new Gson().fromJson(jsonObject.toJSONString(), PersonListObject.class);
        } catch (Exception e) {
            log.error("File " + file + " can't be parsed in JSON format.");
        }
        return parseNext(file);
    }
}
