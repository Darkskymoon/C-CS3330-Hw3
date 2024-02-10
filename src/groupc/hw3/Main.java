package groupc.hw3;

import groupc.hw3.stockManager.StockManagerSingleton;
import groupc.hw3.media.CDRecordProduct;
import groupc.hw3.media.Genre;
import groupc.hw3.media.TapeRecordProduct;
import groupc.hw3.media.VinylRecordProduct;


public class Main {

	public static void main(String[] args) {
		// Creating stockManagerSingleton
		StockManagerSingleton manager = StockManagerSingleton.getInstance();
		StockManagerSingleton managerNew = StockManagerSingleton.getInstance();
		
		// Check that singleton design pattern works
		System.out.println("Are manager and managerNew the same: " + manager.equals(managerNew));
		
		// initializeStock of manager
		manager.initializeStock();
		
		// Create vinyl and add it to the manager
		VinylRecordProduct vinyl1 = new VinylRecordProduct("Ride The Lightning", 29.99, 1984, Genre.ROCK);
		manager.addItem(vinyl1);
		manager.updateItemPrice(vinyl1, 34.99);
	}

}
