import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StockAlerter extends Application {
    public static void main(String[] args) {
    	Application.launch();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane stackPane = new StackPane();
		    Scene scene = new Scene(stackPane);
		    primaryStage.initStyle(StageStyle.TRANSPARENT);
		    primaryStage.setScene(scene);
		    primaryStage.show();
		
	}
}