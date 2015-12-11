package net.codejava.spring.model;



public class Article {
    private long id;
    private String title;
    private String description;
    private String keywords;
    private String content;
 
    private Group grp;
 
    public Article() {
    }
 
    public Article(String title, String description, String keywords,
            String content, Group group) {
        this.title = title;
        this.description = description;
        this.keywords = keywords;
        this.content = content;
        this.grp = group;
    }
 
    // getters and setters...
}