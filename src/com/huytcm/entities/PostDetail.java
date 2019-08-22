package com.huytcm.entities;

import javax.persistence.*;

@Entity
@Table(name = "post_detail")
public class PostDetail {
    private Long id;
    private Post post;
    private String content;

    public PostDetail() {
    }

    public PostDetail(Long id, Post post, String content) {
        this.id = id;
        this.post = post;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Column(name = "content", columnDefinition = "LONGTEXT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
