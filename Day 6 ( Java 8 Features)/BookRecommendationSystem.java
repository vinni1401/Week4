import java.util.*;
import java.util.stream.Collectors;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    public Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    public BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "📖 " + title + " (⭐ " + rating + ")";
    }
}

public class BookRecommendationSystem {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Dune", "Frank Herbert", "Science Fiction", 4.5),
            new Book("Neuromancer", "William Gibson", "Science Fiction", 4.2),
            new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.3),
            new Book("1984", "George Orwell", "Dystopian", 4.1),
            new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.0),
            new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 4.4),
            new Book("The Martian", "Andy Weir", "Science Fiction", 4.6),
            new Book("Brave New World", "Aldous Huxley", "Science Fiction", 3.9),
            new Book("Children of Time", "Adrian Tchaikovsky", "Science Fiction", 4.7),
            new Book("Red Mars", "Kim Stanley Robinson", "Science Fiction", 4.0),
            new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.3)
        );

        // 1. Filter: Genre "Science Fiction" and rating > 4.0
        List<Book> filtered = books.stream()
            .filter(b -> b.genre.equalsIgnoreCase("Science Fiction") && b.rating > 4.0)
            .collect(Collectors.toList());

        // 2. Transform: BookRecommendation with title and rating
        List<BookRecommendation> recommendations = filtered.stream()
            .map(b -> new BookRecommendation(b.title, b.rating))
            .collect(Collectors.toList());

        // 3. Sort by rating descending
        List<BookRecommendation> sorted = recommendations.stream()
            .sorted(Comparator.comparingDouble(b -> -b.rating))
            .collect(Collectors.toList());

        // 4. Paginate: top 10 books (5 per page)
        int pageSize = 5;
        int page = 1; // Change to 2 for page 2
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, sorted.size());
        List<BookRecommendation> paginated = sorted.subList(fromIndex, toIndex);

        // Display
        System.out.println("Top Book Recommendations (Page " + page + "):");
        paginated.forEach(System.out::println);
    }
}
