package com.test.util;

public class PageVO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int pageNum;
	private int total;
	
	private int amount = 10;
	
	public PageVO(int pageNum, int total, int amount) {
		
		this.pageNum = pageNum;
		this.total = total;
		this.amount = amount;
		
		this.endPage = (int)Math.ceil(this.pageNum / (double)5) * 5;
		this.startPage = endPage - 5 + 1;
		int realEnd = (int)Math.ceil(this.total / (double) this.amount);

		if(this.endPage > realEnd) {
			this.endPage = realEnd;
		}
		
		this.prev = this.startPage > 1;

		this.next = realEnd > this.endPage;
		System.out.println("시작페이지:" + startPage + ", 끝페이지:" + endPage);
		
	}

	//게터세터
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
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

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
