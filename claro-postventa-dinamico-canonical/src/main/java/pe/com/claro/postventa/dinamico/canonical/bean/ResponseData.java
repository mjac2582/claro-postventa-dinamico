package pe.com.claro.postventa.dinamico.canonical.bean;

import java.util.List;

import pe.com.claro.postventa.dinamico.canonical.types.ItemsType;
import pe.com.claro.postventa.dinamico.canonical.types.LinksType;

public class ResponseData {
	
	private String hasMore;
	
	private String totalResults;
	
	private String limit;
	
	private String offset;
	
	private List<ItemsType> items;
	
	private List<LinksType> links;

	public String getHasMore() {
		return hasMore;
	}

	public void setHasMore(String hasMore) {
		this.hasMore = hasMore;
	}

	public String getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(String totalResults) {
		this.totalResults = totalResults;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public List<ItemsType> getItems() {
		return items;
	}

	public void setItems(List<ItemsType> items) {
		this.items = items;
	}

	public List<LinksType> getLinks() {
		return links;
	}

	public void setLinks(List<LinksType> links) {
		this.links = links;
	}
	
}
