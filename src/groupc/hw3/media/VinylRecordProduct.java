package groupc.hw3.media;
/*
 * Subclass of the mediaProduct class
 */
public class VinylRecordProduct extends MediaProduct {
	//Base constructor - shouldn't be used
	private VinylRecordProduct() {
		// TODO
	}
	
	//Parameterized Constructor
	public VinylRecordProduct(String title, double price, int year, Genre genre) {
		//Initializes the vinyl using the superclass constructor
		super(title, price, year, genre);
	}
	
	//Copy Constructor
	public VinylRecordProduct(VinylRecordProduct media) {
		super(media);
		
	}

	//toString method to represent a vinyl in the following format: "Vinyl,title,price,year,genre"
	@Override
	public String toString() {
		return "Vinyl,"+title+","+price +"," + year +"," + genre;
	}
	
	
	
	//Equals function that tests if two pieces of media are the same
//	@Override
//	public boolean equals(Object media) {
//		if(media instanceof VinylRecordProduct) {
//			return super.equals(media);
//		}
//		return false;
//	}
	

	
	
	

}
