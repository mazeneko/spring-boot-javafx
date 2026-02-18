package goma;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import goma.util.javafx.spring.SpringFXMLLoader;
import goma.util.javafx.spring.SpringJavaFXApplicationLauncher;
import javafx.scene.Parent;
import javafx.scene.Scene;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Runner implements ApplicationRunner {
    private final SpringJavaFXApplicationLauncher springJavaFXApplicationLauncher;
    private final SpringFXMLLoader fxmlLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        springJavaFXApplicationLauncher.launch(args.getSourceArgs(), primaryStage -> {
            final var root = fxmlLoader.<Parent>load("classpath:page/root.fxml");
            final var scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        });
    }
}
