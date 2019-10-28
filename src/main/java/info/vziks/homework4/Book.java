package info.vziks.homework4;

class Book {

    private String title;
    private String author;
    private boolean isHome;
    private boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null || !"".equals(title)) {
            this.title = title;
        }

    }

    public String getAuthor() {
        return author;
    }

    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }

    public boolean isHome() {
        return isHome;
    }

    public Book setHome(boolean home) {
        isHome = home;
        return this;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public Book setAvailable(boolean available) {
        isAvailable = available;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isHome=" + isHome +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
