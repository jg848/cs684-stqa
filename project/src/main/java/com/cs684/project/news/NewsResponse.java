package com.cs684.project.news;

import java.util.List;

public class NewsResponse {

	private String status;
	private int totalResults;
	private List<Article> articles;

	public NewsResponse() {
		super();
	}

	public NewsResponse(String status, int totalResults, List<Article> articles2) {
		super();
		this.status = status;
		this.totalResults = totalResults;
		this.articles = articles2;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(int totalResults) {
		this.totalResults = totalResults;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		StringBuilder articlesList = new StringBuilder("\n{");
		for (Article article : articles) {
			articlesList.append("\n").append("[").append(article.toString()).append("]");
		}
		return "NewsResponse [status=" + status + ", totalResults=" + totalResults + ", articles="
				+ articlesList.append("\n}") + "]";
	}

}
