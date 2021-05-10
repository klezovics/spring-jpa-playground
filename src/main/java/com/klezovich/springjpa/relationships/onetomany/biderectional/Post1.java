package com.klezovich.springjpa.relationships.onetomany.biderectional;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Post1 {

    @Id
    @GeneratedValue
    private long id;
    private String text;

    //TODO How to change this to LAZY without breaking anything
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Comment> comments;

    void addComment(Comment comment) {
        if(comments == null) {
            comments = new HashSet<>();
        }

        comment.setPost(this);
        comments.add(comment);
    }
}
