package goma.util.javafx.spring;

import javafx.stage.Stage;

public interface JavaFXApplicationHandler {
    default void init() throws Exception {
    };

    void start(Stage primaryStage) throws Exception;

    default void stop() throws Exception {
    };
}
