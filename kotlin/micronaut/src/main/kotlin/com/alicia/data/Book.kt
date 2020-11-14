package com.alicia.data

import com.alicia.model.BookResponse
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "book")
data class Book (
    @Id
    @Column(name = "isbn")
    var isbn: String? = null,

    @ManyToOne
    var author: Author? = null,

    @ManyToOne
    var genre: Genre? = null,

    @Column(name = "publication_date")
    var publicationDate: Date? = null,

    @Column(name = "title")
    var  title: String? = null,
) {
    fun toBookResponse(): BookResponse =
            BookResponse(
                author = "${author?.lastName}, ${author?.firstName}",
                genre = genre?.toGenreResponse(),
                isbn = isbn,
                publicationDate = publicationDate?.let { DateTimeFormatter.ISO_DATE.withZone( ZoneId.of("UTC")).format(it.toInstant()) },
                title = title,
            )
}