package com.cs684.project.news;

import java.util.ArrayList;

public class NewsResponse {

	private String status;
	private int totalResults;
	private ArrayList<Article> articles;

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

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<Article> articles) {
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
