import java.util.LinkedList;
import java.util.List;

import components.watchlist.DefaultWatchlistStrategy;
import components.watchlist.WatchlistComponent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tools.Observer;
import tools.SceneObservable;

public class StockAlerter extends Application implements SceneObservable{
	private List<Observer> observers = new LinkedList<>();
	private double sceneWidth, sceneHeight;
    
	public static void main(String[] args) {
    	Application.launch();
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		WatchlistComponent watchlist = new WatchlistComponent(new DefaultWatchlistStrategy());
		
		Scene scene = new Scene(watchlist,1000,1000);
		this.sceneHeight = scene.getHeight(); this.sceneWidth = scene.getWidth();
		scene.widthProperty().addListener((obs, oldVal, newVal) -> {
			this.sceneWidth = (double) newVal;
		});
		scene.heightProperty().addListener((obs, oldVal, newVal) -> {
			this.sceneHeight = (double) newVal;
		});
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	@Override
	public void notifyObservers() {
		for(var obs: observers) {
			obs.update();
		}
		
	}
	@Override
	public boolean remove(Observer obs) {
		return observers.remove(obs);
	}
	@Override
	public boolean add(Observer obs) {
		return observers.add(obs);
		
	}

	@Override
	public double getWidth() {
		return this.sceneWidth;
	}

	@Override
	public double getHeight() {
		return this.sceneHeight;
	}		
}