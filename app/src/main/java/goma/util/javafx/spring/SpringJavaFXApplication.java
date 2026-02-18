package goma.util.javafx.spring;

import org.springframework.context.ConfigurableApplicationContext;

import javafx.application.Application;
import javafx.stage.Stage;

public class SpringJavaFXApplication extends Application {
    private static ConfigurableApplicationContext context = null;
    private static JavaFXApplicationHandler handler = null;

    public static void launch(
            String[] args,
            ConfigurableApplicationContext context,
            JavaFXApplicationHandler handler) {
        SpringJavaFXApplication.context = context;
        SpringJavaFXApplication.handler = handler;
        SpringJavaFXApplication.launch(args);
    }

    @Override
    public void init() throws Exception {
        handler.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        handler.start(primaryStage);
    }

    @Override
    public void stop() throws Exception {
        handler.stop();
        // JavaFXアプリケーションの終了時にSpringアプリケーションを終了させます。
        context.close();
    }
}
