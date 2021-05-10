package com.klezovich.springjpa.relationships.none;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class Post1RepositoryTest {

    @Autowired
    private PostRepository repository;

    @BeforeEach
    void clearDb() {
        repository.deleteAll();
    }

    @Test
    void testCanSaveAndReadPost() {
        var post = Post.builder().text("Post1").build();

        var id = repository.save(post).getId();
        assertNotNull(id);
        assertEquals("Post1", repository.findById(id).get().getText());
    }
}