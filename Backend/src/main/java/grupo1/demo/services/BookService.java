package grupo1.demo.services;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import grupo1.demo.models.Book;
import grupo1.demo.repositories.BookRepository;


@RestController
@CrossOrigin(origins = "*")
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class BookService {

    private final BookRepository bookRepository;

    BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books/count")
    public String countBooks() {
        int total = bookRepository.countBooks();
        return String.format("Tienes %s Libros!", total);
    }

    // Create
    @PostMapping("/books/create")
    @ResponseBody
    public String createBook(@RequestBody Book book) {
        return bookRepository.createBook(book);
    }

    // Read all
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    // uUPODATE
    @PostMapping("/books/updateBook")
    @ResponseBody
    public String updateBook(@RequestBody Book book) {
        return bookRepository.updateBook(book);
    }
    // Delete
    @DeleteMapping("/books/delete/{id}")
    @ResponseBody
    public boolean deleteBook(@PathVariable int id) {
        return bookRepository.deleteBook(id);
    }
    
}
