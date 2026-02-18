package goma.page;

import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

@Component
public class RootController {
    @FXML
    private Label label;

    public void initialize() {
        final var javaVersion = System.getProperty("java.version");
        final var javafxVersion = System.getProperty("javafx.version");
        final var message = """
                Hello, JavaFX %s
                Running on Java %s.
                """.formatted(javafxVersion, javaVersion);
        label.setText(message);
    }
}
