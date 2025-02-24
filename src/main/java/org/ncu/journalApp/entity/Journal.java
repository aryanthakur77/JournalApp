package org.ncu.journalApp.entity;

public class Journal {
    private long id;
    private String title;
    private String content;

    public Journal(int id, String title, String content) {
        this.id=id;
        this.content=content;
        this.title=title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }
}
