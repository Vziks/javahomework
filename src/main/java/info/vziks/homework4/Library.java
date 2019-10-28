package info.vziks.homework4;

import java.util.Arrays;

class Library {

    private Book[] books;


    public Library() {
        this.books = new Book[0];
    }


    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public void addBook(Book book) {
        int n = books.length;
        books = Arrays.copyOf(books, n + 1);
        books[n] = book;
    }

    public void addBook(Book... arrayBooks) {

        Book[] tempBooks = Arrays.copyOf(books, books.length + arrayBooks.length);

        for (int i = 0; i < arrayBooks.length; i++) {
            tempBooks[books.length + i] = arrayBooks[i];
        }
        books = tempBooks;
    }


    public String getInfo(String bookTitle) {

//        System.out.println(bookTitle);

        String result = "Такой книги в библиотеке нет";
        if (bookTitle == null || "".equals(bookTitle)) {
            return  "Вы не задали условия поиска";
        }

        for (Book book : this.getBooks()) {
            if (bookTitle.equals(book.getTitle())) {
                result = String.format("%s , %s, выдача на дом %s, есть ли в библиотеке на данный момент - %s",
                        book.getAuthor(),
                        book.getTitle(),
                        (book.isHome() ? "доступна" : "не доступна"),
                        (book.isAvailable() ? "да" : "нет")
                );
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + Arrays.toString(books) +
                '}';
    }
}
