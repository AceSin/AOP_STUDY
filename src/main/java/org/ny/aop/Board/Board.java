package org.ny.aop.Board;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Board {

    @Id
    @GeneratedValue
    private Long idx;

    @Column
    private String title;

    @Column
    private String content;

    public Board(){

    }

    public Board(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
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
}
