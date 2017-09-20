/**
 * Copyright (C) 2012, Xieda Technology, Inc.
 */
package com.jy.qrcodemake.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.ResultTransformer;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import com.jy.qrcodemake.entity.Log;
import com.jy.qrcodemake.entity.LogDisplayData;


/**
 * DAO interface for operating database "jmcdc", which contains some
 * commonly-used data access methods.
 * 
 * @author Frank
 * @since 04/01/2012
 */
public interface CdcDao {
	/**
	 * Creates a data record with data from a PO entity
	 * 
	 * @param model
	 * 
	 * @throws DataAccessException
	 */
	void createModel(Object model) throws DataAccessException;

	/**
	 * Deletes a data record with a PO with primary key
	 * 
	 * @param model
	 * 
	 * @throws DataAccessException
	 */
	void deleteModel(Object model) throws DataAccessException;

	/**
	 * Flushes a session immediately
	 */
	void flush();

	/**
	 * Gets a data record from database with primary key. Simple loading.
	 * 
	 * @param objType
	 * @param key
	 * 
	 * @return Object
	 * 
	 * @throws DataAccessException
	 */
	<T> T getModel(Class<T> objType, Serializable key) throws DataAccessException;

	/**
	 * Loads all data from a table.
	 * 
	 * @param objType
	 * 
	 * @return List
	 * 
	 * @throws DataAccessException
	 */
	<T> List<T> getModels(Class<T> objType) throws DataAccessException;

	/**
	 * Executes a hql which fetch the count of result.
	 * 
	 * @param hql
	 * 
	 * @return
	 * 
	 * @throws DataAccessException
	 */
	Long hqlCountQuery(String hql) throws DataAccessException;

	/**
	 * Executes a hql which return an integer.
	 * 
	 * @param hql
	 * 
	 * @return Integer
	 * 
	 * @throws DataAccessException
	 *             throw DataAccessException.
	 */
	Integer hqlQueryReturnInteger(String hql) throws DataAccessException;

	/**
	 * Executes a HQL query with parameters.
	 * 
	 * @param hql
	 * @param params
	 * 
	 * @return List
	 * 
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	<T>  List<T> hqlQueryWithParams(String hql, Map params) throws DataAccessException;
	/**
	 * �������������ѯ��������Ϣ
	 * @return �����б�
	 */
	//<T> List<T> findAll(String name,Object value);
	/**
	 * Executes a HQL query with parameters. Pagination is available here.
	 * 
	 * @param hql
	 * @param params
	 * @param pageSize
	 * @param currentPage
	 * 
	 * @return List
	 * 
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	<T> List<T> hqlQueryWithParams(String hql, Map params, int pageSize, int currentPage) throws DataAccessException;

	/**
	 * Executes a hql which return unique result.
	 * 
	 * @param hql
	 * 
	 * @return
	 * 
	 * @throws DataAccessException
	 */
	<T> T hqlQueryWithUniqueResult(String hql) throws DataAccessException;

	/**
	 * Executes a hql which retrieve data from database into an entity class
	 * specified by a resultTransformer.
	 * 
	 * @param hql
	 * @param resultTransformer
	 * 
	 * @return
	 * 
	 * @throws DataAccessException
	 */
	<T> List<T> hqlWithResultTransformer(String hql, ResultTransformer resultTransformer) throws DataAccessException;

	/**
	 * Loads a data record from database with active reference. Especially for
	 * lazy loading.
	 * 
	 * @param objType
	 * @param key
	 * 
	 * @return Object
	 * 
	 * @throws DataAccessException
	 */
	<T> T loadModel(Class<T> objType, Serializable key) throws DataAccessException;

	/**
	 * Merges a data record with data from a PO entity
	 * 
	 * @param model
	 * 
	 * @throws DataAccessException
	 */
	void mergeModel(Object model) throws DataAccessException;

	/**
	 * Counts total records with parameters in SQL mode.
	 * 
	 * @param criteria
	 * @param params
	 * 
	 * @return int
	 * 
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	int sqlCountWithParams(String criteria, Map params) throws DataAccessException;

	
	
	
	
	@SuppressWarnings("unchecked")
	int sqlCountWithParamsAll(String criteria, Map params) throws DataAccessException;
	/**
	 * Executes a SQL query with parameters.
	 * 
	 * @param sql
	 * @param params
	 * 
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	void sqlDelete(String sql, Map params) throws DataAccessException;

	/**
	 * Executes a SQL query. Pagination is available here.
	 * 
	 * @param sql
	 * @param pageSize
	 * @param currentPage
	 * 
	 * @return List
	 * 
	 * @throws DataAccessException
	 */
	<T> List<T> sqlQuery(String sql, int pageSize, int currentPage) throws DataAccessException;

	/**
	 * Executes a SQL query.
	 * 
	 * @param sql
	 * 
	 * @return List
	 * 
	 * @throws DataAccessException
	 */
	<T> List<T> sqlQuery(String sql) throws DataAccessException;

	/**
	 * Executes a sql which return an integer.
	 * 
	 * @param sql
	 * 
	 * @return Integer
	 * 
	 * @throws DataAccessException
	 *             throws DataAccessException.
	 */
	List<Integer> sqlQueryReturnInteger(String sql) throws DataAccessException;

	/**
	 * Executes a SQL query with parameters.
	 * 
	 * @param sql
	 * @param params
	 * 
	 * @return List
	 * 
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	<T> List<T> sqlQueryWithParams(String sql, Map params) throws DataAccessException;

	/**
	 * Executes a SQL query with parameters. Pagination is available here.
	 * 
	 * @param sql
	 * @param params
	 * @param pageSize
	 * @param currentPage
	 * 
	 * @return List
	 * 
	 * @throws DataAccessException
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> sqlQueryWithParams(String sql, Map params, int pageSize, int currentPage) throws DataAccessException;

	/**
	 * Executes a SQL query with parameters.
	 * 
	 * @param sql
	 * @param params
	 */
	@SuppressWarnings("unchecked")
	void sqlUpdate(String sql, Map params);

	/**
	 * Executes a sql which retrieve data from database into an entity class
	 * specified by a resultTransformer.
	 * 
	 * @param sql
	 * @param resultTransformer
	 * 
	 * @return
	 * 
	 * @throws DataAccessException
	 */
	<T> List<T> sqlWithResultTransformer(String sql, ResultTransformer resultTransformer) throws DataAccessException;

	/**
	 * Updates a data record with data from a PO entity
	 * 
	 * @param model
	 * 
	 * @throws DataAccessException
	 */
	void updateModel(Object model) throws DataAccessException;

	/**
	 * Evicts a model from session.
	 * 
	 * @param model
	 */
	void evict(Object model);

	/**
	 * Use sql query because Hibernate do NOT support "regexp"(regular
	 * expression) query.
	 * 
	 * @param sql
	 *            sql for the query.
	 * @param params
	 *            parameters of objects for the query.
	 * @param variableName
	 *            varibable name used in sql query.
	 * @param clazz
	 *            The class that for the return type.
	 * @return a list of results.
	 */
	<T> List<T> sqlQueryWithParamsForRegexp(String sql, Map params, String variableName, Class<T> clazz);
	
	/**
	 * Retrieve <code>History</code> records from the data store by
	 * <code>HistorySearchCriteria</code> and currentPageNo as fields in
	 * <code>HistoryDisplayData</code>. This function use Hibernate Paging
	 * technology. 
	 * No return value, just change the fields of the instance 
	 * that is passed as a parameter.
	 * 
	 * @author frank
	 * 
	 * @param historyDisplayData contains all values to search for
	 * 
	 */
	void findLog(LogDisplayData logDisplayData) throws DataAccessException;
	
	/**
	 * Save a <code>Log</code> record to the data store, 
	 * either inserting or updating it.
	 * @author frank
	 * 
	 * @param history the <code>History</code>  record to save
	 */
	void storeLog(Log log) throws DataAccessException;
	
    /**
     * this method used to log some information about the currently database machine.
     * @author frank
     * @throws SQLException 
     * @throws HibernateException 
     * @since 21, 07, 2009
     */
	String getDbConnectionInfo() throws HibernateException, SQLException;
	
	
	/**
     * this method used to log some information about the currently database machine.
     * @author zhukai
     * @throws SQLException 
     * @throws HibernateException 
     * @since 09, 04, 2012
     * ��ȡ���е����ֵ
     */
	String getMaxColumn(String sql)throws SQLException;
	
	
	/**
     * ��ȡsql��䵱ǰ�Ķ�����������
     * @author zhukai
     * @throws SQLException 
     * @since 04, 09, 2012
     * @param String sql
     */
	int getSqlCounts(String sql) throws SQLException;
	
	int getHqlCounts(String hql) throws SQLException;
	
	
	
	  /**�������ݿ��ж�ȡ������¼�����
     * @param prop_tableName ��ʾ��ݿ��
     * @param field Ҫ��ѯ������
     * @param condition Ҫ��ѯ������
     * @author zhukai
     * */
	public   String getFieldValue(String prop_tableName, String field, String condition);
	
	/**�������ݿ��ж�ȡ������¼�����
     * @param sql
     * @author zhukai
     * */
	public   String getFieldValue(String sql);
	
	
	/**
	 *@see  ��ѯ���в�����ҳ�ļ���,ֱ�ӽ����ת���ɺ���map������Ӽ�
	 *@author zhukai
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> sqlAllQuery(String sql);
	
	/**
	 * Count records quantity with HQL
	 * 
	 * @param detachedCriteria
	 * @return List
	 * @throws 
	 */
	public int hqlCountWithParams(String hql, Map params);

	/**
	 * Get an object by uniqueQuery.
	 * 
	 * @param string
	 * @param params
	 * @return
	 */
	Object uniqueQueryWithParams(String string, Map params);
	
	/**
	 * Get an integer value with a detachedCriteria.
	 * 
	 * @param detachedCriteria
	 * @return
	 */
	int qbcCountQuery(DetachedCriteria detachedCriteria);
	
	/**
	 * Search with QBC DetachedCriteria
	 * 
	 * @param detachedCriteria
	 * @return List
	 * @throws 
	 */
	List qbcQueryWithDetachedCriteria(DetachedCriteria detachedCriteria);

	
	
	/**
     * @see ��ҳ�����ӿ�.
     * @author gongpengpeng
     */
    String pageQuery(Integer totalcount, Integer pagecount, Integer ipage);
    
    
    
    /**
     * easyuiʹ�õ�HQL��ҳ
     * @param hql
     * @param page
     * @param row
     * @param param
     * @return
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
	<T> List<T> hqlQueryWithParamsOfEasyUI(String hql, int page, int rows, Object... param) throws DataAccessException;
    
    
    
    
    /**
     * easyuiʹ�õ�HQL����ҳ
     * @param hql
     * @param page
     * @param row
     * @param param
     * @return
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
	<T> List<T> hqlQueryWithParamsOfEasyUI(String hql, Object... param) throws DataAccessException;
    
    
    
    
    
    /**
     * easyuiʹ�õ�SQL��ҳ
     * @param hql
     * @param page
     * @param row
     * @param param
     * @return
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
	<T> List<T> sqlQueryWithParamsOfEasyUI(String sql, int page, int rows, Object... param) throws DataAccessException;
    /**
     * easyuiʹ�õ�SQL����ҳ
     * @param hql
     * @param page
     * @param row
     * @param param
     * @return
     * @throws DataAccessException
     */
    @SuppressWarnings("unchecked")
	<T> List<T> sqlQueryWithParamsOfEasyUI(String sql, Object... param) throws DataAccessException;
	 
	 
}
