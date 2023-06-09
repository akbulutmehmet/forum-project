package com.akbulutmehmet.webservice.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Post implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "content",nullable = false)
    private String content;
    @Column(name = "user_id",nullable = false)
    private String userId;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Comment> commentSet;

    public Post() {
    }

    public Post(String id, String title, String content, String userId, Category category, Set<Comment> commentSet) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.category = category;
        this.commentSet = commentSet;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }
}
