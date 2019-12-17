package info.vziks.exam;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class Library {
    private static LinkedBlockingDeque<Book> books = new LinkedBlockingDeque<>();
    private static ArrayList<Visitor> visitorArrayList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {


        for (int i = 0; i < 10; i++) {
            try {
                books.put(Book.generate());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 2; i++) {
            visitorArrayList.add(new Visitor(i, books));
        }

        for (Visitor visitor : visitorArrayList) {
            Thread thread = new Thread(visitor);
            thread.start();
            thread.join();
        }

        books.forEach(System.out::println);
        System.out.println(books.size());
    }

}


class Visitor implements Runnable {
    private int i;
    private List<Book> visitorBooks = new ArrayList<>();
    private LinkedBlockingDeque<Book> books;

    Visitor(int i, LinkedBlockingDeque<Book> books) {
        this.i = i;
        this.books = books;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            for (int i = 0; i < random.nextInt(5); i++) {
                Book book = books.take();
                if (book.isUnbearable) {
                    books.put(book);
                } else {
                    visitorBooks.add(book);
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        System.out.println("Visitor " + i + " take a books:");
        visitorBooks.forEach(System.out::println);
        System.out.println();
    }

}


class Book {
    private String name;
    boolean isUnbearable;

    private Book(String name, boolean isUnbearable) {
        this.name = name;
        this.isUnbearable = isUnbearable;
    }


    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isUnbearable() {
        return isUnbearable;
    }

    static Book generate() {
        Faker faker = new Faker();
        Random random = new Random();
        return new Book(
                faker.book().title(),
                random.nextBoolean()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return new EqualsBuilder()
                .append(isUnbearable(), book.isUnbearable())
                .append(getName(), book.getName())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getName())
                .append(isUnbearable())
                .toHashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("name='").append(name).append('\'');
        sb.append(", isUnbearable=").append(isUnbearable);
        sb.append('}');
        return sb.toString();
    }
}