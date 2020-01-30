package za.co.discovery.assignment.controller;

public class MyCell {
    private String content;

    public MyCell() {
    }

    public MyCell(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

	@Override
	public String toString() {
		return "MyCell [content=" + content + "]";
	}




}