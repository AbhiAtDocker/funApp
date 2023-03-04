package abhi.base.beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Word{

	
	private long id;
	
	
	private String word;
	
	
	private String categories;
	
	
	private String meanings;
	
	
	private Date date;
	
	
    private String newContext; 
    
    private String notes;
    
    private String message;
    
    
    	
/*	@Transient
	private JsonObject jsonObj;
	
    
	
    public JsonObject getJsonObj() {
		return jsonObj;
	}

	public void setJsonObj(JsonObject jsonObj) {
		this.jsonObj = jsonObj;
	}*/

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
	private List<String> context = new ArrayList<String>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getCategories() {
		return categories;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getMeanings() {
		return meanings;
	}

	public void setMeanings(String meanings) {
		this.meanings = meanings;
	}

	public String getNewContext() {
		return newContext;
	}

	public void setNewContext(String newContext) {
		this.newContext = newContext;
	}

	public List<String> getContext() {
		return context;
	}

	public void setContext(List<String> context) {
		this.context = context;
	}

	
}


