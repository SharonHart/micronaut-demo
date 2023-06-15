package demo.stubs;

import dao.BookRepository;
import io.micronaut.context.annotation.Replaces;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;

@Replaces(BookRepository.class)
@JdbcRepository(dialect = Dialect.H2)
public interface TestBookRepository extends BookRepository {}
