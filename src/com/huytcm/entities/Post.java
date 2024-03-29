package com.huytcm.entities;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
public class Post {
    private Long id;
    private String title;
    private String shortContent;
    private PostDetail postDetail;
    private User author;
    private Date createDate;
    private Date updateDate;

    public Post() {
    }

    public Post(Long id, String title, String shortContent, User user, PostDetail postDetail) {
        this.id = id;
        this.title = title;
        this.shortContent = shortContent;
        this.author = user;
        this.postDetail = postDetail;
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

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "short_content")
    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL, mappedBy = "post")
    public PostDetail getPostDetail() {
        return postDetail;
    }

    public void setPostDetail(PostDetail postDetail) {
        this.postDetail = postDetail;
    }

    @JoinColumn(name = "author", referencedColumnName = "username")
    @ManyToOne
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Column(name = "create_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "update_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
