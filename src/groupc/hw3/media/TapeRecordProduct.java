package groupc.hw3.media;
/*
 * Subclass of MediaProduct that represents a tape product
 */
public class TapeRecordProduct extends MediaProduct{
	//base constructor - shouldn't be used
	private TapeRecordProduct() {
		
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
	

	
}
