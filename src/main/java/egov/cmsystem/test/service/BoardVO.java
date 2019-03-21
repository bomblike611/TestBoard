package egov.cmsystem.test.service;

public class BoardVO {

	/****** 검색Keyword ******/
	private String searchKeyword = "";

	/****** 검색사용여부  ******/
	private String searchUseYn = "";

	/****** 현재페이지  ******/
	private int pageIndex = 1;
	
	private int totalIndex=1;

	/****** 페이지갯수  ******/
	private int pageUnit = 10;

	/****** 페이지사이즈  ******/
	private int pageSize = 5;

	/****** firstIndex  ******/
	private int firstIndex = 1;

	/****** lastIndex  ******/
	private int lastIndex = 10;

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchUseYn() {
		return searchUseYn;
	}

	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	
	public int getTotalIndex() {
		return totalIndex;
	}

	public void setTotalIndex(int totalIndex) {
		this.totalIndex = totalIndex;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}
	
	
	
	
}
