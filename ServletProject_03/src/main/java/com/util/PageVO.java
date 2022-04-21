package com.util;

public class PageVO {
	private int totPage;
	private int blockPage;
	private int startPage;
	private int endPage;
	private int currentPage;
	private String field;
	private String word;
	public int getTotPage() {
		return totPage ;
	}
	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public int getStartPage() {
		return startPage ;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage ;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getField() {
		return field == null ? "" : field.trim();
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getWord() {
		return word == null ? "" : word.trim();
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	
}
