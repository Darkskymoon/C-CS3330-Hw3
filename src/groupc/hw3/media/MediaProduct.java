package groupc.hw3.media;

/**
 * Class: MediaProduct
 * This is the parent class of all of the different media products
 * @param title the name of the media
 * @param price the cost of the media
 * @param year the release date of the media
 * @param genre what genre of media a particular piece of media is 
 */
public class MediaProduct {
	//Variables///////////////////
	protected String title;
	protected double price;
	protected int year;
	protected Genre genre;
	//////////////////////////////

	
	//parameterized constructor
	public MediaProduct(String title, double price, int year, Genre genre) {
		this.title=title;
		this.price=price;
		this.year=year;
		this.genre=genre;
	}
	
	//copy constructor
	public MediaProduct(MediaProduct media) {
		this.title= media.getTitle();
		this.price= media.getPrice();
		this.year= media.getYear();
		this.genre = media.getGenre();
		
	}
	///////////////////////////////


	
	//Getters and Setters/////////
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	//ToString to return a string representing a MediaProduct
	@Override
	public String toString() {
		return (title+","+price +"," + year +"," + genre);
	}
	
}
