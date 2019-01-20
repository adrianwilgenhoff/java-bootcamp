/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blogg;

/**
 *
 * @author Adrian
 */
public class Entry {

    private String title;
    private String autor;
    private String content;

    public Entry(String title, String autor, String content) {
        this.title = title;
        this.autor = autor;
        this.content = content;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Entry{" + "title=" + title + ", autor=" + autor + ", content=" + content + '}';
    }

}
