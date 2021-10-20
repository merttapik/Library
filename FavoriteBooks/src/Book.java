
public class Book {

	private int  bookId;
	private String title;
	private String category;
	private String author;
	private String award;
	private int rating;
	private int year;
	private int pages;
	private String description;
	public Book(int bookId, String title, String category, String author, int rating, int year, int pages,
			String description) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.category = category;
		this.author = author;
		this.rating = rating;
		this.year = year;
		this.pages = pages;
		this.description = description;
		this.award="No award";
	}
	public Book(int bookId, String title, String category, String author, String award, int rating, int year, int pages,
			String description) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.category = category;
		this.author = author;
		this.award = award;
		this.rating = rating;
		this.year = year;
		this.pages = pages;
		this.description = description;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAward() {
		return award;
	}
	public void setAward(String award) {
		this.award = award;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return   bookId + "," + title + "," + category + "," + author
				+ "," + award + "," + rating + "," + year + "," + pages + ","
				+ description ;
	}
	
	
	
	
	
}
