/**
 * Copyright (C) 2012, Xieda Technology, Inc.
 */
package com.jy.qrcodemake.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jy.qrcodemake.dao.CdcDao;
import com.jy.qrcodemake.entity.Log;
import com.jy.qrcodemake.entity.LogDisplayData;
import com.jy.qrcodemake.util.GlobalFunc;



/**
 * Hibernate implementation of <code>CdcDao</code>.
 * 
 * @author frank
 * @since 04/01/2012
 */
@Repository
@Transactional
public class CdcDaoHibernate implements CdcDao {

	/** The SessionFactory. */
	private SessionFactory sessionFactory;
	
	@Autowired
	public CdcDaoHibernate (@Qualifier("sessionFactory")SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
//		CustomerContextHolder.setCustomerType(DataSourceMap.JMCDC);
	}
	
	@Autowired
	private @Qualifier("dataSource")
	DataSource dataSource;

	/**
	 * {@inheritDoc}
	 */
	public void flush() {
		sessionFactory.getCurrentSession().flush();
	}

	/**
	 * {@inheritDoc}
	 */
	public void evict(Object model) {
		sessionFactory.getCurrentSession().evict(model);
	}

	/**
	 * {@inheritDoc}
	 */
	public void mergeModel(Object model) {
		sessionFactory.getCurrentSession().merge(model);
	}

	/**
	 * {@inheritDoc}
	 */
	public void createModel(Object model) {
		sessionFactory.getCurrentSession().save(model);
	}

	/**
	 * {@inheritDoc}
	 */
	public void deleteModel(Object model) {
		sessionFactory.getCurrentSession().delete(model);
	}

	/**
	 * {@inheritDoc}
	 */
	public void updateModel(Object model) {
		sessionFactory.getCurrentSession().saveOrUpdate(model);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <T> T loadModel(Class<T> objType, Serializable key) {
		return (T) sessionFactory.getCurrentSession().load(objType, key);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> T getModel(Class<T> objType, Serializable key) {
		return (T) sessionFactory.getCurrentSession().get(objType, key);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> getModels(Class<T> objType) {
		Query q = sessionFactory.getCurrentSession().createQuery("FROM " + objType.getName());
		return (List<T>) q.list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> hqlQueryWithParams(String hql, Map params) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		setParams(q, params);
		return (List<T>) q.list();
	}

	/**
	 * ��ѯ��������Ϣ
	 * @return �����б�
	 */
	/*public <T> List<T> findAll(String name,Object value){
		return (List<T>)sessionFactory.getCurrentSession().createCriteria(ImmunityChildVaccineTime.class).add(Restrictions.eq(name,value)).list();
	}*/
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> hqlQueryWithParams(String hql, Map params, int pageSize, int currentPage) {
		currentPage = (currentPage > 0) ? currentPage - 1 : currentPage;
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		setParams(q, params);
		q.setMaxResults(pageSize);
		q.setFirstResult(currentPage * pageSize);
		return (List<T>) q.list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> sqlQuery(String sql, int pageSize, int currentPage) {
		currentPage = (currentPage > 0) ? currentPage - 1 : currentPage;
		Query q = sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.setMaxResults(pageSize);
		q.setFirstResult(currentPage * pageSize);
		return (List<T>) q.list();
	}

	/**
	 * Execute a SQL delete. Pagination is available here.
	 * 
	 * @param sql
	 * @param params
	 * @return void {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public void sqlDelete(String sql, Map params) {
		Query q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		setParams(q, params);
		q.executeUpdate();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public void sqlUpdate(String sql, Map params) {
		Query q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		setParams(q, params);
		q.executeUpdate();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> sqlQuery(String sql) {
		Query q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		return (List<T>) q.list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> sqlQueryWithParams(String sql, Map params) {
		Query q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		setParams(q, params);
		return (List<T>) q.list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> sqlQueryWithParams(String sql, Map params, int pageSize, int currentPage) {
		currentPage = (currentPage > 0) ? currentPage - 1 : currentPage;
		Query q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		setParams(q, params);
		q.setMaxResults(pageSize);
		q.setFirstResult(currentPage * pageSize);

		return (List<T>) q.list();
	}

	/**
	 * {@inheritDoc}
	 */
	public <T> T hqlQueryWithUniqueResult(String hql) {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		return (T) q.uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	private void setParams(Query q, Map params) {
		String key;
		if (params != null) {
			Iterator it = params.keySet().iterator();
			while (it.hasNext()) {
				key = (String) it.next();
				q.setParameter(key, params.get(key));
			}
		}

	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public int sqlCountWithParams(String sql, Map params) {
		Query q = sessionFactory.getCurrentSession().createSQLQuery("SELECT COUNT(1) " + sql);
		setParams(q, params);
		List<Integer> list = q.list();
		for (Integer o : list) {
			return (o != null) ? o.intValue() : 0;
		}
		return 0;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public int sqlCountWithParamsAll(String sql, Map params) {
		Query q = sessionFactory.getCurrentSession().createSQLQuery(sql);
		setParams(q, params);
		List<Integer> list = q.list();
		for (Integer o : list) {
			return (o != null) ? o.intValue() : 0;
		}
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> hqlWithResultTransformer(String hql, ResultTransformer resultTransformer) {
		return (List<T>) sessionFactory.getCurrentSession().createQuery(hql).setResultTransformer(resultTransformer).list();
	}

	/**
	 * {@inheritDoc}
	 */
	public Integer hqlQueryReturnInteger(String hql) {
		return (Integer) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<Integer> sqlQueryReturnInteger(String sql) {
		return (List<Integer>) sessionFactory.getCurrentSession().createSQLQuery(sql).list();
	}

	/**
	 * {@inheritDoc}
	 */
	public Long hqlCountQuery(String hql) {
		// Generally, the return type of aggregation function count(*) is Long.
		return (Long) sessionFactory.getCurrentSession().createQuery(hql).uniqueResult();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> sqlWithResultTransformer(String sql, ResultTransformer resultTransformer) {
		return (List<T>) sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(resultTransformer).list();
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> sqlQueryWithParamsForRegexp(String sql, Map params, String variableName, Class<T> clazz) {
		// For "e" in sql, please check EventSearchCriteria.generateParams().
		//Query q = sessionFactory.getCurrentSession().createSQLQuery(sql, variableName, clazz);
		//setParams(q, params);
		//return (List<T>) q.list();
		return null;
	}
	
	/**
	 * @see DnsDao#storeHistory(Log)
	 */
	public void storeLog(Log log) {
		sessionFactory.getCurrentSession().merge(log);
	}

	/**
	 * @see DnsDao#findHistory(LogDisplayData)
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public void findLog(LogDisplayData logDisplayData) {
		
		Query[] queries = getQueryFromLogDisplayData(logDisplayData);

		long totalRecords = (Long) queries[0].uniqueResult();
		// Set totalRecords to make sure we get the right currentPageNo below.
		// See the declaration of this setter(setTotalRecords()).
		logDisplayData.setTotalRecords(totalRecords);

		// Hibernate paging technology. 
		// Just get the records of currentPageNo.
		queries[1].setFirstResult((logDisplayData.getCurrentPageNo() - 1) * logDisplayData.getPageSize());
		queries[1].setMaxResults(logDisplayData.getPageSize());

		List<Log> list = (List<Log>) queries[1].list();
		logDisplayData.setList(list);
	}
	
	/**
	 * Generate two queries that is needed to get totalReords and the list of
	 * history records. Use HQL. This function is only used by findHistory() of
	 * this class.
	 * @author frank
	 * 
	 * @param historyDisplayData
	 *            contains a instance of <code>HistorySearchCriteria</code> to
	 *            generate queries.
	 * @return a Query[] with 2 queries as its values.
	 */
	private Query[] getQueryFromLogDisplayData(LogDisplayData logDisplayData) {
		//LogSearchCriteria logSearchCriteria = logDisplayData.getHistorySearchCriteria();
		// Object[] contains values that is used to replace the "?" in HQL
		Object[] values = new Object[6];
//		Date fromDate = logSearchCriteria.getFromDate();
//		Date toDate = logSearchCriteria.getToDate();
//		String user = logSearchCriteria.getUser();
//		String actionType = logSearchCriteria.getActionType();
//		String zoneName = logSearchCriteria.getInternalZoneName();
		
		// Generate hql
		String hql = "from Log as log";
		// Record the index of values[];
//		int n = 0;
//		if (fromDate != null) {
//			hql += " and log.createdTime>=?";
//			values[n++] = fromDate;
//		} else {
//			values[n++] = null;
//		}
//
//		if (toDate != null) {
//			hql += " and log.createdTime<=?";
//			// To make sure the history records we get contains the record of the day of "todate"
//			// For example: If you choose the date of "to" on history page is 11.16.1986, 
//			// the actual HQL is createdTime<11.17.1986, so we get the records of 11.16.1986
//			values[n++] = CommonUtils.getTomorrow(toDate);
//		} else {
//			values[n++] = null;
//		}
//		
//		if (user != null && !user.equals("")) {
//			// Here we support "*" as fuzzy query.
//			if (user.indexOf("*") != -1) {
//				hql += " and log.user like ?";
//			} else {
//				hql += " and log.user=?";
//			}
//			// For fuzzy query.
//			String userHql = user.replace('*', '%');
//			values[n++] = userHql;
//		} else {
//			values[n++] = null;
//		}
//
//		if (actionType != null && !actionType.equals(Constants.LOG_SEARCH_ACTIONTYPE_ALL)) {
//			// if action type is "zone change", we just add a condition: zoneId>0
//			if (actionType.equals(Constants.LOG_SEARCH_ACTIONTYPE_CDCCHANGE)) {
//				hql += " and log.itemName=?";
//				values[n++] = Constants.LOG_ITEMNAME_CDC;
//			}
//			else if (actionType.equals(Constants.LOG_SEARCH_ACTIONTYPE_USERCHANGE)) {
//				hql += " and log.itemType=?";
//				values[n++] = Constants.LOG_ITEMTYPE_USER;
//			}
//			else {
//				hql += " and log.actionType=? and history.zoneId>?";
//				values[n++] = actionType;
//				values[n++] = 0;
//			}
//		} else {
//			values[n++] = null;
//		}
//		
//		// You will find we don't have "where" in HQL,:(
//		hql = hql.replaceFirst("and", "where");
//
//		String totalCountHql = "select count(*) " + hql;
//
//		// HQL query for total records.
//		Query totalRecordsQuery = this.sessionFactory.getCurrentSession().createQuery(totalCountHql);
//		// Replace the "?" in HQL with the values[].
//		int j = 0;
//		for (int i = 0; i < n; i++) {
//			if (values[i] != null)
//			  totalRecordsQuery.setParameter(j++, values[i]);
//		}
//		
//		// The history records showed on history page should be ordered.
//		String listHql = hql + " order by log.createdTime desc";
//
//		// HQL query for the list of history.
//		Query listQuery = this.sessionFactory.getCurrentSession().createQuery(listHql);
//		j = 0;
//		for (int i = 0; i < n; i++) {
//			if (values[i] != null)
//			  listQuery.setParameter(j++, values[i]);
//		}
//
//		Query[] queries = new Query[2];
//		queries[0] = totalRecordsQuery;
//		queries[1] = listQuery;

//		return queries;
		return null;
	}
	/**
     * @see DnsDao#getDbConnectionInfo()
     */
     public String getDbConnectionInfo() throws HibernateException, SQLException {
	 
	     String dbinfo = "Database: ";
	     String dbname = "";
	     dbname += dataSource.getConnection().getMetaData().getDatabaseProductName();
	     dbinfo += "" + dbname + ", url: ";
	     String url = dataSource.getConnection().getMetaData().getURL();
	     dbinfo += "" + url + ", user: ";
	     String user = dataSource.getConnection().getMetaData().getUserName();
	     String[] userarray = user.split("@");
	     String username = userarray[0];
	     dbinfo += username;
	     return  dbinfo;
     }

	public String getMaxColumn(String sql) throws  SQLException {
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		return GlobalFunc.toString(query.uniqueResult()) ;
	}

	public int getSqlCounts(String sql) throws SQLException {
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		return GlobalFunc.parseInt(query.uniqueResult())  ;
	}
	
	public int getHqlCounts(String hql) throws SQLException {
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		return GlobalFunc.parseInt(query.uniqueResult())  ;
	}
     
     /**�������ݿ��ж�ȡ������¼�����
      * @param prop_tableName ��ʾ��ݿ��
      * @param field Ҫ��ѯ������
      * @param condition Ҫ��ѯ������
      * */
	public   String getFieldValue(String prop_tableName, String field,
			String condition) {
		String sql = "select " + field + " as LLL0 from " + prop_tableName + " where  " + condition;
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		return GlobalFunc.toString(query.uniqueResult()) ;
	}
     
     
	public   String getFieldValue(String sql){
		Query query = this.sessionFactory.getCurrentSession().createSQLQuery(sql);
		return GlobalFunc.toString(query.uniqueResult()) ;
	}
	
	/**
	 *@see
	 *@author zhukai
	 */
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> sqlAllQuery(String sql) {
	 
		Query q = sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
	 
		return (List<T>) q.list();
	}
	
	/**
	 * @see <code>CdcDao#hqlCountWithParams</code>
	 */
	public int hqlCountWithParams(String hql, Map params){
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		setParams(q, params);
		List<Object> list = q.list();
		
		for (Object o: list) {
			return (o != null)? Integer.parseInt(o.toString()): 0;
		}
		return 0;
	}
	
	/**
	 * @see CdcDao#uniqueQueryWithParams(String, Map)
	 */
	public Object uniqueQueryWithParams(String string, Map params) {
		Query query = sessionFactory.getCurrentSession().createQuery(string);
		setParams(query, params);
		try{
			return query.uniqueResult();
		}catch(Exception e){
			return null;
		}
	}
	
	/**
	 * @see CdcDao#qbcCountQuery(DetachedCriteria)
	 */
	public int qbcCountQuery(DetachedCriteria detachedCriteria) {
		Object obj = detachedCriteria.getExecutableCriteria(sessionFactory.getCurrentSession()).uniqueResult();
		return (Integer)obj;
	}
	
	/**
	 * @see CdcDao#qbcQueryWithDetachedCriteria(DetachedCriteria)
	 */
	public List qbcQueryWithDetachedCriteria(DetachedCriteria detachedCriteria) {
		return detachedCriteria.getExecutableCriteria(sessionFactory.getCurrentSession()).list();
	}
	
	
	/**
     * @see ��ҳ����ʵ��
     * @author gongpengpeng
     */
    public String pageQuery(Integer totalcount,Integer pagecount,Integer ipage){
       String link="";
       link="<div id=\"wai\">";
   	   link+="<ul id=\"ul\"><li class=\"showPage\">"+"��"+ipage+"ҳ/��"+pagecount+"ҳ"+"</li><li class=\"li\"><a style=\"width:40px;\" class=\"firstpage\" href=\"?ipage=1\">��ҳ</a></li>";
   	   int x=1,y=0;
   	   if(ipage<5&&ipage>0){
   	   if(pagecount>=5){
   	   x=1;y=5;}
   	   else{x=1;y=pagecount;}
   	   }
   	   if(ipage>2&&(ipage+2)<=pagecount){x=ipage-2;y=ipage+2;}
   	   if(ipage>4&&(ipage+2)>pagecount){x=ipage-3;y=pagecount;}
   	   if(ipage.intValue()==pagecount&&ipage>4){x=ipage-4;y=pagecount;}
   	   if(pagecount==1){x=1;y=1;}
   	   if(pagecount==0){x=1;y=1;}
   	   for(int i=x;i<=y;i++){
   		String cls=(i==ipage?"page02":"page");   
   		link+="<li class=\"li\"><a class=\""+cls+"\" href=\"?ipage="+i+"\">"+i+"</a></li>";
   	   }
   	   link+="<li class=\"li\"><a style=\"width:40px;\" class=\"firstpage\" href=\"?ipage="+pagecount+"\">ĩҳ</a></li></ul></div>";
   	
   	   return link;
    }

	@Override
	public <T> List<T> hqlQueryWithParamsOfEasyUI(String hql, int page,
			int rows, Object... param) throws DataAccessException {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if(param !=null && param.length > 0){
			for(int i=0;i<param.length;i++){
				q.setParameter(i, param[i]);
			}
		}
		
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public <T> List<T> sqlQueryWithParamsOfEasyUI(String sql, int page,
			int rows, Object... param) throws DataAccessException {
		
		Query q = sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		if(param !=null && param.length > 0){
			for(int i=0;i<param.length;i++){
				q.setParameter(i, param[i]);
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	
	
	
	@Override
	public <T> List<T> hqlQueryWithParamsOfEasyUI(String hql, Object... param)
			throws DataAccessException {
		Query q = sessionFactory.getCurrentSession().createQuery(hql);
		if(param !=null && param.length > 0){
			for(int i=0;i<param.length;i++){
				q.setParameter(i, param[i]);
			}
		}
		
		return (List<T>)q.list();
	}

	@Override
	public <T> List<T> sqlQueryWithParamsOfEasyUI(String sql, Object... param)
			throws DataAccessException {
		Query q = sessionFactory.getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		
		if(param !=null && param.length > 0){
			for(int i=0;i<param.length;i++){
				q.setParameter(i, param[i]);
			}
		}
		return (List<T>)q.list();
	}
 
}