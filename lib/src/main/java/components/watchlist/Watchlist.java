package components.watchlist;

import components.stock.view.ItemView;
interface Watchlist {
	void add(ItemView stock);
	void remove(ItemView stock);
}
