package egov.cmsystem.test.service;

import org.stringtemplate.v4.compiler.CodeGenerator.list_return;

public class BoardVO {

	/****** 검색Keyword ******/
	private String searchKeyword = "";

	/****** 검색사용여부  ******/
	private String searchUseYn = "";

	/****** 현재페이지  ******/
	private int pageIndex = 1;
	/****** 전체 페이지  ******/
	private int totalIndex=1;

	/****** 페이지갯수  ******/
	private int pageUnit = 10;

	/****** 블록 사이즈  ******/
	private int pageSize = 5;
	/****** 총 블록 사이즈  ******/
	private int totalSize = 1;
	/****** 현재 블록  ******/
	private int sizeIndex = 1;
	
	/****** 총 개시글 수   ******/
	private int totalrecord=1;
	
	/****** 블록내 첫 페이지  ******/
	private int firstIndex = 1;

	/****** 블록내 끝 페이지  ******/
	private int lastIndex = 5;
	
	/****** 페이지 내 시작 글번호  ******/
	private int startPage=1;
	private int lastPage=10;
	
	/****** 이전  ******/
	private boolean prev;
	/****** 다음  ******/
	private boolean next;
	

	
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
	public int getTotalrecord() {
		return totalrecord;
	}

	public void setTotalrecord(int totalrecord) {
		this.totalrecord = totalrecord;
		calcData();
	}
	
	private void calcData() {
		
		totalIndex =(int)Math.ceil(totalrecord/(double)pageUnit);
	
		startPage=pageUnit*(pageIndex-1);
		lastPage=pageUnit*pageIndex;
		
		if(pageIndex>=totalIndex){
			lastPage=totalrecord;
		}
		
		totalSize = (int)Math.ceil(totalIndex/(double)pageSize);
		
		sizeIndex = (int)Math.ceil(pageIndex/(double)pageSize);
		
		firstIndex=sizeIndex*pageSize-4;
		lastIndex=sizeIndex*pageSize;
		
		if(sizeIndex>=totalSize){
			lastIndex=totalIndex;
		}
		prev = sizeIndex > 1 ? true : false; 
		next = sizeIndex < totalSize ? true : false; 
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

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(int totalSize) {
		this.totalSize = totalSize;
	}

	public int getSizeIndex() {
		return sizeIndex;
	}

	public void setSizeIndex(int sizeIndex) {
		this.sizeIndex = sizeIndex;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}


	
	
	
}
