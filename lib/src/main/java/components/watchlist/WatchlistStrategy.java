package components.watchlist;

import components.stock.view.ItemView;
import javafx.scene.layout.Pane;

interface WatchlistStrategy {
	Pane loadWatchlist();
	void add(ItemView stock);
	void remove(ItemView stock);
}
