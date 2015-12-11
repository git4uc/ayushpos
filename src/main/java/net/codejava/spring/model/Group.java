package net.codejava.spring.model;

	 
	import java.util.Set;
	 
	public class Group {
	 
	    private long id;
	    private String name;
	 
	    private Set<Article> articles;
	 
	    public Group() {
	    }
	 
	    public Group(String name) {
	        this.name = name;
	    }
	 
	    // getters and setters...
	}

