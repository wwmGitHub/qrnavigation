/**
 * Copyright (C) 2012, Xieda Technology, Inc.
 */
package com.jy.qrcodemake.entity;

import java.util.ArrayList;
import java.util.List;

import com.jy.qrcodemake.util.ActionTypeEnum;
import com.jy.qrcodemake.util.Constants;

/**
 * Simple JavaBean domain object holding all information of View History page, which
 * contains an instance of <code>HistorySearchCriteria</code> and a list of
 * <code>History</code> records of currentPageNo.
 * The rest of the fields are used for paging technology.
 * 
 * @author frank
 * @since 4/5/2012
 */
public class LogDisplayData {

	/** Default page size. */
	private static int DEFAULT_PAGE_SIZE = 500;

	/** The amount of total records. */
	private long totalRecords;

	/** The amount of total pages. */
	private int totalPages;

	/** The amount of records shows on one page. */
	private int pageSize;

	/** Current page number. */
	private int currentPageNo;

	/** Previous page number. */
	private int previousPageNo;

	/** Next page number. */
	private int nextPageNo;

	/** Is first page. */
	private boolean isFirstPage;

	/** Is last page. */
	private boolean isLastPage;

	/** Has previous page. */
	private boolean hasPreviousPage;

	/** Has next page. */
	private boolean hasNextPage;

	/** An instance of HistorySearchCriteria. */ 
//	private LogSearchCriteria historySearchCriteria;

	/** The list of history records shows on current page. */
	private List<Log> list;

	/** Creates a new instance of HistoryDisplayData with default values. */
	public LogDisplayData() {
		this.totalRecords = 0L;
		this.totalPages = 0;
		this.pageSize = DEFAULT_PAGE_SIZE;
		this.currentPageNo = 1;
		this.previousPageNo = 0;
		this.nextPageNo = 0;
		this.isFirstPage = false;
		this.isLastPage = false;
		this.hasPreviousPage = false;
		this.hasNextPage = false;
//		this.historySearchCriteria = new LogSearchCriteria();
		this.list = null;
	}

	/**
	 * @return the currentPageNo.
	 */
	public int getCurrentPageNo() {
		return currentPageNo;
	}

	/**
	 * setting the currentPageNo will influence related fields which are boolean types.
	 * For example: if you change the currentPageNo to 1, then hasPreviousPgae will be false.
	 * 
	 * @param currentPageNo the currentPageNo to set
	 */
	public void setCurrentPageNo(int currentPageNo) {
		if (currentPageNo < 1) {
			this.currentPageNo = 1;
		} else if (currentPageNo > this.totalPages) {
			// Just set it to the max page no(totalPages).
			this.currentPageNo = this.totalPages;
		} else {
			this.currentPageNo = currentPageNo;
		}
		// set current page No. will influence related fields
		this.isFirstPage = (this.currentPageNo == 1) ? true : false;
		this.isLastPage = (this.currentPageNo == this.totalPages) ? true : false;
		this.hasPreviousPage = (this.currentPageNo == 1) ? false : true;
		this.hasNextPage = (this.currentPageNo == this.totalPages) ? false : true;
		this.previousPageNo = (this.hasPreviousPage) ? (this.currentPageNo - 1) : this.currentPageNo;
		this.nextPageNo = (this.hasNextPage) ? (this.currentPageNo + 1) : this.currentPageNo;
	}

	/**
	 * @return the hasNextPage.
	 */
	public boolean isHasNextPage() {
		return hasNextPage;
	}

	/**
	 * @return the hasPreviousPage.
	 */
	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	/**
	 * @return the isFirstPage.
	 */
	public boolean isIsFirstPage() {
		return isFirstPage;
	}

	/**
	 * @return the isLastPage.
	 */
	public boolean isIsLastPage() {
		return isLastPage;
	}

	/**
	 * @return the pageSize.
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @return the previousPageNo.
	 */
	public int getPreviousPageNo() {
		return previousPageNo;
	}

	/**
	 * @return the nextPageNo.
	 */
	public int getNextPageNo() {
		return nextPageNo;
	}

	/**
	 * Setting totalRecords may influence totalPages.
	 * 
	 * @param totalRecords the totalRecords to set
	 */
	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
		// set totalRecords may change totalPages.
		int pages = (int) (this.totalRecords / getPageSize());
		if (this.totalRecords % getPageSize() > 0) {
			pages += 1;
		}
		setTotalPages(pages);
	}

	/**
	 * @return the totalPages.
	 */
	public int getTotalPages() {
		return totalPages;
	}

	/**
	 * Setting totalPages may influence currentPageNo.
	 * 
	 * @param totalPages the totalPages to set
	 */
	private void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
		// set totalPages may change currentPageNo.
		setCurrentPageNo(getCurrentPageNo());
	}

	/**
	 * @return the totalRecords.
	 */
	public long getTotalRecords() {
		return totalRecords;
	}

	/**
	 * @param historySearchCriteria the historySearchCriteria to set
	 */
//	public void setHistorySearchCriteria(LogSearchCriteria historySearchCriteria) {
//		this.historySearchCriteria = historySearchCriteria;
//	}
//
//	/**
//	 * @return the historySearchCriteria.
//	 */
//	public LogSearchCriteria getHistorySearchCriteria() {
//		return historySearchCriteria;
//	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<Log> list) {
		this.list = list;
	}

	/**
	 * @return the list.
	 */
	public List<Log> getList() {
		return list;
	}

	/** Generate option values for page No. dropdown on history page. */
	public List<Integer> getTotalPagesList() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < getTotalPages(); i++) {
			list.add((Integer) (i + 1));
		}
		return list;
	}

	/** Generate options values for action dropdown on history page. */
	public List<String> getActionTypeList() {
		List<String> list = new ArrayList<String>();
		list.add(Constants.LOG_SEARCH_ACTIONTYPE_ALL);
		list.add(ActionTypeEnum.ADD.name());
		list.add(ActionTypeEnum.EDIT.name());
		list.add(ActionTypeEnum.DELETE.name());
		list.add(Constants.LOG_SEARCH_ACTIONTYPE_CDCCHANGE);
		list.add(Constants.LOG_SEARCH_ACTIONTYPE_USERCHANGE);
		return list;
	}

}
