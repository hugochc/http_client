package br.com.xpto.httpclient.model;

import java.io.Serializable;

public class Task implements Serializable {
	
	private static final long serialVersionUID = 8498307094885933423L;

	private Integer userId;
	
	private Integer id;
	
	private String title;
	
	private boolean completed;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[userId=").append(this.getUserId()).append(",");
		builder.append(" id=").append(this.getId()).append(",");
		builder.append(" title=").append(this.getTitle()).append(",");
		builder.append(" completed=").append(this.isCompleted()).append("]");
		return builder.toString();
	}
	
}
