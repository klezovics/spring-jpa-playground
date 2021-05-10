package com.klezovich.springjpa.relationships.onetomany.biderectional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class Post1RepositoryTest {

    @Autowired
    private Post1Repository repository;

    @BeforeEach
    void clearDb() {
        repository.deleteAll();
    }

    @Test
    void testCanSaveAndReadPostWithComments() {
        var post = Post1.builder().text("Post1Text").build();
        post.addComment(Comment.builder().text("Post1C1").build());
        post.addComment(Comment.builder().text("Post1C2").build());

        var id = repository.save(post).getId();

        var savedPost = repository.findById(id).get();

        assertEquals("Post1Text", savedPost.getText());

        var savedComments = savedPost.getComments();
        assertEquals(2, savedComments.size());

        var commentTexts = savedComments.stream().map(Comment::getText).collect(toList());
        assertThat(commentTexts, containsInAnyOrder("Post1C1","Post1C2"));
    }
}