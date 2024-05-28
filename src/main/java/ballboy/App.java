package ballboy;


import ballboy.model.GameEngine;
import ballboy.model.GameEngineImpl;
import ballboy.view.GameWindow;
import javafx.application.Application;
import javafx.stage.Stage;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Map<String, String> params = getParameters().getNamed();

        String s = "Java 11 sanity check";
        if (s.isBlank()) {
            throw new IllegalStateException("You must be running Java 11+. You won't ever see this exception though" +
                    " as your code will fail to compile on Java 10 and below.");
        }

        Path configPath = Path.of("src/main/resources/config/config.json");

        JSONParser parser = new JSONParser();
        Map<String, Object> config = null;

        try{
            config = (Map<String, Object>) parser.parse(new FileReader(configPath.toString()));
        } catch (ParseException | IOException e) {
            System.out.println("failed to open file");
            e.printStackTrace();
        }

        GameEngine model = new GameEngineImpl(config);
        GameWindow window = new GameWindow(model, 640, 400);
        window.run();

        primaryStage.setTitle("Ballboy");
        primaryStage.setScene(window.getScene());
        primaryStage.show();

        window.run();
    }
}
