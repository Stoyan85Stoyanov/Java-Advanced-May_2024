package _009_IteratorsAndComparators._01_Lab._02_Library;

import java.util.Arrays;
import java.util.Iterator;

public class Library implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return Arrays.stream(books).iterator();
    }

}
