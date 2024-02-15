package groupc.hw3.stockManager;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;


import groupc.hw3.media.CDRecordProduct;
import groupc.hw3.media.Genre;
import groupc.hw3.media.MediaProduct;
import groupc.hw3.media.TapeRecordProduct;
import groupc.hw3.media.VinylRecordProduct;

public class StockManagerSingleton {
	//Creates a static object for StockManagerSingleton so that there can only be 1 instance of the manager
	private static StockManagerSingleton instance = null;
	
	//Initializes the InventoryFilePath to the inventory.csv file provided from the assignment
	//private so that it's path can't be accessed outside the method. Declared final so that the path can't change
	private final String inventoryFilePath = "./src/groupc/hw3/files/inventory.csv";
	
	//an array list to hold all of the media Objects
	private ArrayList<MediaProduct> inventory;
	
	private StockManagerSingleton() {
		this.inventory = new ArrayList<MediaProduct>();
	}
	
	public static StockManagerSingleton getInstance() {
		if(instance == null) {
			instance = new StockManagerSingleton();
		}
		
		return instance;
	}
	
	
	/*
	 * method: initializeStock
	 * This method initializes the StockManager by 
	 * reading in the inventory data from the file found in inventoryFilePath
	 * and adding them to the inventory
	 * 
	 * @return true if initialization is successful, or false if it does not initialize because of some error
	 * 
	 */
	public boolean initializeStock()
	{
		Scanner fileScanner = null ; // initializes fileScanner to null
		
		try
		{
			
			// Attempt to open the file
			fileScanner = new Scanner(new FileInputStream(inventoryFilePath));
			
			// If file is empty, return false
			if(!fileScanner.hasNextLine()) {
				return false;
			}
			
			// Skip over variable / column names
			fileScanner.nextLine();
			
			// While there is a mediaProduct to read in...
			while(fileScanner.hasNextLine()) {
				
				// split line into respective fields
				String[] splitted = fileScanner.nextLine().split(",");
				
				// Check if file line has invalid length
				if(splitted.length != 5) {
					fileScanner.close();
					return false;
				}
				
				// variables to hold each field
				String mediaProductType = splitted[0];
				String title = splitted[1];
				double price = Double.parseDouble(splitted[2]);
				int year = Integer.parseInt(splitted[3]);
				Genre genre = Genre.valueOf(splitted[4]);
				
				// Check mediaProductType and create appropriate object based on it
				if(mediaProductType.equals("CD")) {
					inventory.add(new CDRecordProduct(title, price, year, genre));
				} else if(mediaProductType.equals("Vinyl")) {
					inventory.add(new VinylRecordProduct(title, price, year, genre));
				} else if(mediaProductType.equals("Tape")) {
					inventory.add(new TapeRecordProduct(title, price, year, genre));
				} else {
					// No valid mediaProduct type given so file read was unsuccessful
					inventory.clear();
					fileScanner.close();
					return false;
				}
			}
			
			// close fileScanner to prevent memory leak
			fileScanner.close();
			
			// Return true to indicate file was successfully found and read
			return true;
		}
		catch (Exception e)
		{
			// If the file could not be found or reading/initialization failed, we return false
			return false;
		}
		
	}
	
	
	/*
	 * method: updateItemPrice
	 * This method updates a media product price to an updated price.
	 * @param product product to update
	 * @param newPrice new price for the product to update
	 * @return true if an update succeeds and false if it does not succeed 
	 */
	public boolean updateItemPrice(MediaProduct product, double newPrice) {
		if(product == null) {
			return false;
		}
		product.setPrice(newPrice);
		return true;
	}
	
	/*
	 * method: addItem
	 * This method adds a new media object to the manager inventory
	 * @param product The new MediaProduct to add to the manager
	 * @return true if the item was added and false if it was not added.
	 */
	public boolean addItem(MediaProduct product) {
		if(product == null) {
			return false;
		}
		inventory.add(product);
		return true;
	}
	
	/*
	 * method: removeItem
	 * This method removes a media product from the inventory
	 * @param product The product to remove from the catalog
	 * @return true if the item was removed or false if it was not removed
	 */
	public boolean removeItem(MediaProduct product) {
		//Checks to see if the size of the inventory is 0, in which case, there are no items to remove, hence a failure to remove an item.
		if(inventory.size()==0)
		{
			
			return false;
		}

		//removes the product and returns true if it does and false if it does not.
		return inventory.remove(product);
	}
	
	/*
	 * method: saveStock
	 * This method updates the inventory in the "inventoryFilePath" csv file and saves it by overwriting the existing file
	 * @return true if the save was successful or false if it was not successful
	 */
	public boolean saveStock() {
		//Try catch to avoid file writing errors
		try
		{
			//open the file
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(inventoryFilePath));
			
			//write the first line: "Type,Title,Price,Year,Genre" to the file
			String FirstLine = "Type,Title,Price,Year,Genre\n";
			bufferedWriter.write(FirstLine);
			
			//Write all of the inventory arraylist to the file
			for(int i=0; i<(inventory.size()); i++){
				//Writes the inventory item at each index as a toString version
				bufferedWriter.write(inventory.get(i).toString());
				//Adds a newline after every inventory item added
				bufferedWriter.write("\n");
			}
			//close the buffered writer
			bufferedWriter.close();
			
		}catch(IOException exception) {
			return false;
		}
		
		//return true signifying that writing was successful
		return true;
	}
	
	/*
	 * Method: getMediaProductBelowPrice
	 * This method creates a list of all of the products below a specified price
	 * @param maxPrice The maximum price of mediaProducts that the user wants to view
	 * @return ArrayList representing all of the media products that are below the price passed into the method
	 */
	
	public ArrayList<MediaProduct> getMediaProductBelowPrice(int maxPrice){
		// Initialize array lis for the matching products
		ArrayList<MediaProduct> inBudgetMediaProducts = new ArrayList<MediaProduct>();
		
		// Check all products in inventory
		for (MediaProduct mediaProduct : inventory ) {


			if (mediaProduct.getPrice() <= maxPrice){

				// Add product to return list if it query
				inBudgetMediaProducts.add(mediaProduct);
			}
		
		}

		// Return list that satisfied query
		return inBudgetMediaProducts;
	}
	
	/*
	 * method: printListOfMediaProduct
	 * This method prints all of the products in the media product list
	 * @param productList The list of products that the user wants to print
	 * 
	 */
	//handle case where an arraylist is used as an argument
	public void printListOfMediaProduct(ArrayList<MediaProduct> productList) {
		// if product list has an input
		for (MediaProduct mediaProduct : productList) {
			System.out.println(mediaProduct.toString());
		}
		return;
}
	//handle case where no argument is input, in this case,
	//method will reference full arraylist in this class
	public void printListOfMediaProduct() {
		// if product list does not have an input, print out all items
		for (MediaProduct mediaProduct : inventory) {
			System.out.println(mediaProduct.toString());
		}
		return;
}
	
	/*
	 * method: getVinylRecordList
	 * This method gets all of the media products that are VINYLS 
	 * @param productList the list of products passed by the user
	 * @return A list representing all of the media products that are VINYLS
	 */
	public ArrayList<VinylRecordProduct> getVinylRecordList(ArrayList<MediaProduct> productList){
		ArrayList<VinylRecordProduct> vinylRecords = new ArrayList<VinylRecordProduct>();
		
		for(MediaProduct product : inventory){
			if (product instanceof VinylRecordProduct) {
				
				vinylRecords.add(new VinylRecordProduct((VinylRecordProduct)product));
			}
		};
		
		return vinylRecords;
	}
	
	/*
	 * method: getCDRecordsList
	 * This method gets all of the media products that are CDS
	 * @param productList the list of products passed by the user
	 * @return A list representing all of the media products that are CDS
	 */
	public ArrayList<CDRecordProduct> getCDRecordsList(ArrayList<MediaProduct> productList){
		ArrayList<CDRecordProduct> cdRecords = new ArrayList<CDRecordProduct>();
		inventory.forEach(product -> {
			if (product instanceof CDRecordProduct) {
				cdRecords.add((CDRecordProduct)product);
			}
		});
		return cdRecords;
	}
	
	/*
	 * method: getTapeRecordList
	 * This method gets all of the media products that are TAPES
	 * @param productList the list of products passed by the user
	 * @return A list representing all of the media products that are TAPES
	 */
	public ArrayList<TapeRecordProduct> getTapeREcordList(ArrayList<MediaProduct> productList){
		
		return null;
	}
}
