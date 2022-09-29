package pl.migibud.studentcourseapp.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class BookServiceImpl {

    private final BookRepository bookRepository;

    List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    Book addBook(Book book){
        return bookRepository.save(book);
    }

    Book getBookById(Long id){
        return bookRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("Book id does not exist: "+id));
    }
}
