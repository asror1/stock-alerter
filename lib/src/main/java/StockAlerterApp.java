
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StockAlerterApp extends Application{
    
	public static void main(String[] args) {
    	Application.launch();
    }

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new StockAlerterController().loadApp();
		stage.setScene(scene);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.sizeToScene();
		stage.show();
		
	}
}