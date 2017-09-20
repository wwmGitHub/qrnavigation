package com.jy.qrcodemake.util;
import org.hibernate.Hibernate;
import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.type.StringType;

import java.sql.Types;

public class CustomMySQLServerDialect extends org.hibernate.dialect.MySQL5Dialect{
	public CustomMySQLServerDialect() {  
		super();
		//Hibernate4以后的配置
		registerHibernateType(Types.LONGVARCHAR, StringType.INSTANCE.getName());
		registerHibernateType(Types.NVARCHAR, StringType.INSTANCE.getName());
		registerHibernateType(Types.LONGNVARCHAR, StringType.INSTANCE.getName());
		//Hibernate3以前的配置
		//registerHibernateType(-1, Hibernate.TEXT.getName());
		//registerHibernateType(-9, Hibernate.STRING.getName());
		//registerHibernateType(-16, Hibernate.STRING.getName());
	}  
}
