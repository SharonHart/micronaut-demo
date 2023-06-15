package service;

import com.azure.storage.blob.BlobServiceClient;
import dao.BookQueryRepository;
import dao.BookRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import model.Book;

import java.util.List;

@Singleton
public class BookService {

    @Inject
    BookQueryRepository bookQueryRepository;

    @Inject
    BlobServiceClient blobServiceClient;

    @Inject
    BookRepository bookRepository;

    public List<Book> getAll() {
        blobServiceClient.getServiceVersion().getVersion();
        return bookQueryRepository.findAllButFirst();
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }
}
