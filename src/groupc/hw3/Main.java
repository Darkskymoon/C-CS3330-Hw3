package groupc.hw3;

import groupc.hw3.stockManager.StockManagerSingleton;
import groupc.hw3.media.Genre;
import groupc.hw3.media.TapeRecordProduct;


public class Main {

	public static void main(String[] args) {
		StockManagerSingleton manager = new StockManagerSingleton();
		manager.initializeStock();
	}

}
