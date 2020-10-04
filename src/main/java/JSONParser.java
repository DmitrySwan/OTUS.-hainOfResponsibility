import com.google.gson.Gson;
import model.Person;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonParser extends Parser {
    @Override
    public String parse(File file) {
        log.info("# Обработчик " + this.getClass().getName() + " получил файл " + file.getName());
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file))
        {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return new Gson().fromJson(jsonObject.toJSONString(), Person.class).toString();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return parseNext(file);
    }
