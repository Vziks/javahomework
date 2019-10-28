package info.vziks.homework4;

import info.vziks.utils.Command;

class Task41Command implements Command {


    @Override
    public void execute() {


        Library library = new Library();

        Book book1 = new Book("Name1", "Author1");
        Book book2 = new Book("Name2", "Author2");
        Book book3 = new Book("Name3", "Author3");
        Book book4 = new Book("Name4", "Author4");
        Book book5 = new Book("Name5", "Author5");
        Book book6 = new Book("Name6", "Author5");
        Book book7 = new Book("Name7", "Author5");
        Book book8 = new Book("Name8", "Author5");
        Book book9 = new Book("Name9", "Author5");
        Book book10 = new Book("Name10", "Author5");


        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6, book7, book8, book9);


        System.out.println(library);

        for (Book book : library.getBooks()) {

            System.out.println(book);

        }


        System.out.println(library.getInfo("Name1"));
        System.out.println(library.getInfo("Name9"));
        System.out.println(library.getInfo(""));
        System.out.println(library.getInfo("Name11"));
        System.out.println(library.getInfo(null));


    }
}
