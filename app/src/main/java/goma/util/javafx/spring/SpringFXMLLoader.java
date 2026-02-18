package goma.util.javafx.spring;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javafx.fxml.FXMLLoader;

/**
 * SpringのDIコンテナを利用できるコントローラーを作成するためのFXMLLoaderです。
 * <p>
 * このローダーを使う場合はコントローラーをDIコンテナに登録しておく必要があります。
 * {@link FXMLLoader}の{@code ControllerFactory}をSpringの{@link BeanFactory#getBean(Class)}にすることでDIコンテナからコントローラーを取得するようにしています。
 * <p>
 * NOTE: {@code FXMLLoader}はミュータブルであり直接DIコンテナに登録すると設定を変更されてしまう危険性があるため、
 * このクラスに{@link FXMLLoader#load(InputStream)}のみを委譲して機能を制限することで保護しています。
 */
@Component
public class SpringFXMLLoader {
    private final FXMLLoader fxmlLoader;
    private final ResourceLoader resourceLoader;

    public SpringFXMLLoader(BeanFactory beanFactory, ResourceLoader resourceLoader) {
        this.fxmlLoader = new FXMLLoader();
        this.fxmlLoader.setControllerFactory(beanFactory::getBean);
        this.resourceLoader = resourceLoader;
    }

    public <T> T load(@NonNull String location) throws IOException {
        return this.load(this.resourceLoader.getResource(location));
    }

    public <T> T load(Resource fxml) throws IOException {
        return this.load(fxml.getInputStream());
    }

    public <T> T load(InputStream fxml) throws IOException {
        return this.fxmlLoader.load(fxml);
    }
}
