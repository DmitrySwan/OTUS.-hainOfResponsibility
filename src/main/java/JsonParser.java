import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Person;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonParser extends Parser {
    @Override
    public List<Person> parse(File file) {
        log.info("# handler " + this.getClass().getName() + " gets file " + file.getName());
        JSONParser parser = new JSONParser();
        try (FileReader reader = new FileReader(file)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            Type listType = new TypeToken<List<Person>>() {}.getType();
            return new Gson().fromJson(jsonObject.get("persons").toString(), listType);
        } catch (Exception e) {
            log.error("File " + file + " can't be parsed in JSON format.");
        }
        return parseNext(file);
    }
}
