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
		System.out.println("Testing whether Singleton design pattern works...");
		System.out.println("\tAre manager and managerNew the same: " + manager.equals(managerNew));
		
		// initializeStock of manager
		System.out.println("\ninitializeStock method's return when...");
		System.out.println("\tGiven normal conditions (correct file path): " + manager.initializeStock());
		
		// Create vinyl
		VinylRecordProduct vinyl1 = new VinylRecordProduct("Ride The Lightning", 29.99, 1984, Genre.ROCK);
		
		//Test addItem method
		System.out.println("\naddItem method's return when...");
		System.out.println("\tAdding valid product: " + manager.addItem(vinyl1));
		System.out.println("\tAdding invalid product: " + manager.addItem(null));
		
		//Test updateItemPrice method
		System.out.println("\nupdateItemPrice method's return when...");
		System.out.println("\tUpdating valid product: " + manager.updateItemPrice(vinyl1, 34.99));
		System.out.println("\tUpdating invalid product: " + manager.updateItemPrice(null, 49.99));
		
		//Creates a second Vinyl and adds it to the manager
		VinylRecordProduct vinyl2 = new VinylRecordProduct("The Moss", 29.99, 2015, Genre.ELECTRONIC);
		manager.addItem(vinyl2);
		
		//Creates a tape
		TapeRecordProduct tape1= new TapeRecordProduct("The Mind Electric", 400.0, 2012, Genre.ELECTRONIC);
		manager.addItem(tape1);
		
		//creates a CD
		CDRecordProduct CD1= new CDRecordProduct("Copacabana (At the Copa)", 32.99, 1985, Genre.POP);
		manager.addItem(CD1);
		
		//tests printListOfMediaProduct output
		manager.printListOfMediaProduct();
		
		//tests GetCDRecordsList output
		System.out.println(manager.getCDRecordsList());
		
		//Tests the removal of vinyl2
		System.out.println(manager.removeItem(vinyl2));
		System.out.println(manager.removeItem(vinyl2));

		//Tests that saveStock worked correctly
		manager.saveStock();

		// Prints list of products with price <= 13
		manager.printListOfMediaProduct(manager.getMediaProductBelowPrice(13));
	}

}
