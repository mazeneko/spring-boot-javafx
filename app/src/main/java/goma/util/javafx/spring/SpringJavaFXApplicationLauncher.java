package goma.util.javafx.spring;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SpringJavaFXApplicationLauncher {
    private final ConfigurableApplicationContext context;

    public void launch(String[] args, JavaFXApplicationHandler handler) throws Exception {
        SpringJavaFXApplication.launch(args, context, handler);
    }
}
