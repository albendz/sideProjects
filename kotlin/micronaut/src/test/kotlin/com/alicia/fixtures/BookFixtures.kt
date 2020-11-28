package com.alicia.fixtures

import com.alicia.data.Author
import com.alicia.data.Book
import com.alicia.data.Genre
import com.alicia.model.BookResponse
import com.alicia.model.GenreResponse
import java.util.*

object BookFixtures {
    private const val defaultIsbn = "DEFAULT_ISBN"
    private val defaultUuid = UUID.randomUUID()

    val defaultResponse = BookResponse(
        author = "Charles Darwin",
        title = "Origin of Species",
        genre = GenreResponse("Science"),
        isbn = defaultIsbn,
    )

    val defaultBook = Book(
            author = Author(id = defaultUuid),
            title = "Origin of Species",
            genre = Genre(defaultUuid, "Science"),
            isbn = defaultIsbn,
    )
}