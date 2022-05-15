
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import util.ResizeHelper;

public class StockAlerterApp extends Application{
    
	public static void main(String[] args) {
    	Application.launch();
    }

	@Override
	public void start(Stage stage) throws Exception {
		Scene scene = new StockAlerterController().loadApp();
		stage.setScene(scene);
		stage.getIcons().add(new Image("C:\\Users\\Asror\\Desktop\\java-projects\\stock-alerter\\lib\\src\\main\\resources\\\\bot-icon.png"));
		ResizeHelper.addResizeListener(stage);
		stage.initStyle(StageStyle.UNDECORATED);
		stage.show();
		
	}
}