package components.watchlist;

import components.stock.StockView;
import javafx.scene.layout.Pane;

interface WatchlistStrategy {
	Pane loadWatchlist();
	void add(StockView stock);
	void remove(StockView stock);
}
