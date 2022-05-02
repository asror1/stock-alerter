import components.watchlist.DefaultWatchlistStrategy;
import components.watchlist.WatchlistComponent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StockAlerter extends Application {
    public static void main(String[] args) {
    	Application.launch();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		WatchlistComponent watchlist = new WatchlistComponent(new DefaultWatchlistStrategy());
		Scene scene = new Scene(watchlist);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}