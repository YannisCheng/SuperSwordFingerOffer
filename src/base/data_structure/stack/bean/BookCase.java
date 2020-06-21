package base.data_structure.stack.bean;

public class BookCase {

    private int index;
    private String bookName;
    private String bookAuthor;
    private int bookPrice;
    private int bookPageSize;

    /*public BookBean() {
    }*/

    public BookCase(int index, String bookName, String bookAuthor, int bookPrice, int bookPageSize) {
        this.index = index;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookPageSize = bookPageSize;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookPageSize() {
        return bookPageSize;
    }

    public void setBookPageSize(int bookPageSize) {
        this.bookPageSize = bookPageSize;
    }

    @Override
    public String toString() {
        return "BookBean{" +
                "index=" + index +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice=" + bookPrice +
                ", bookPageSize=" + bookPageSize +
                '}';
    }
}
