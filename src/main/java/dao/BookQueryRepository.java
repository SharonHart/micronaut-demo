package dao;
import model.Book;
import org.jooq.DSLContext;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

import static org.jooq.impl.DSL.*;
import org.jooq.*;
import org.jooq.Record;


import javax.transaction.Transactional;
import java.util.List;


@Singleton
public class BookQueryRepository {

    private static final Table<Record> BOOK_TABLE = table("BOOK");

    @Inject
    DSLContext dslContext;

    @Transactional
    public List<Book> findAllButFirst() {
        return dslContext.select()
                .from(BOOK_TABLE)
                .where(field("id").notEqual(1L))
                .fetchInto(Book.class);
    }

}
