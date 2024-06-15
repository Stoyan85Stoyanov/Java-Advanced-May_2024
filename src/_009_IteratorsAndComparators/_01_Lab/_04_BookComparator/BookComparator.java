package _009_IteratorsAndComparators._01_Lab._04_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    @Override
    public int compare(Book f, Book s) {
        int result = f.getTitle().compareTo(s.getTitle());

        return result != 0
                ? result
                : Integer.compare(f.getYear(), s.getYear());
    }
}
