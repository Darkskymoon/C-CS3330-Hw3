package groupc.hw3.media;
/*
 * Subclass of MediaProduct that represents a tape product
 */
public class TapeRecordProduct extends MediaProduct{
	//base constructor
	public TapeRecordProduct() {
		// TODO 
	}
	
	//parameterized constructor
	public TapeRecordProduct(String title, double price, int year, Genre genre) {
		super(title, price, year, genre);
		
	}
	
	//Copy Constructor
	public TapeRecordProduct(TapeRecordProduct media) {
		super(media);
		
	}

	//ToString method to represent a tape in this format: "tape,title,price,year,genre"
	@Override
	public String toString() {
		return "Tape,"+title+","+price +"," + year +"," + genre;
	}
	
	
	
	//Checks if an object is a tape and is identical to another tape
//	@Override
//	public boolean equals(Object media) {
//		if(media instanceof TapeRecordProduct) {
//			return super.equals(media);
//		}
//		return false;
//	}
//	

	
}
