package com.klezovich.springjpa.hibernate;

import com.klezovich.springjpa.hibernate.manytoone.Book;
import com.klezovich.springjpa.hibernate.manytoone.BookRepository;
import com.klezovich.springjpa.hibernate.manytoone.Review;
import com.klezovich.springjpa.hibernate.manytoone.ReviewRepository;
import com.klezovich.springjpa.product.Product;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;

import javax.persistence.EntityManager;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@Slf4j
class EntityManagerContainerTest {


    @Autowired
    private EntityManager em;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Test
    void testEmSaveAndLoad() {
        var product = Product.builder().name("Mars").price(50).build();

        log.info("Id before persist {}", product.getId());
        em.persist(product);
        log.info("Id after persist {}", product.getId());

        var prodFromDb = em.find(Product.class, product.getId());
        assertEquals("Mars", prodFromDb);
    }

    @Test
    @Commit
    void testCanHandleBiderectionalRelationship() {
        var book = Book.builder().name("War and peace").reviews(new ArrayList<>()).build();
        var review = Review.builder().comment("Awesome").build();

        //KEY TAKEAWAY IN CASE OF A BIDIRECTIONAL RELATIONSHIP
        //ENTITIES MUST BE CONNECTED ON BOTH SIDES !!
        book.addReview(review);
        em.persist(book);
        em.flush();

        assertEquals(1, bookRepository.findAll().spliterator().estimateSize());
        assertEquals(1, bookRepository.findAll().iterator().next().getReviews().size());

        assertEquals(1, reviewRepository.findAll().spliterator().estimateSize());
        assertNotNull(reviewRepository.findAll().iterator().next().getBook());
    }
}