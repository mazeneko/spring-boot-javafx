package goma.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import goma.feature.SuperService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

@Component
public class RootController {
    @FXML
    private Label label;
    @Autowired
    private SuperService superService;

    public void initialize() {
        final var greeting = superService.superGreet();
        final var javaVersion = System.getProperty("java.version");
        final var javafxVersion = System.getProperty("javafx.version");
        final var message = """
                %s JavaFX %s
                Running on Java %s.
                """.formatted(greeting, javafxVersion, javaVersion);
        label.setText(message);
    }
}
