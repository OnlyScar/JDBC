package com.dbutils.util;

import java.sql.ResultSet;

/**
* @ClassName: ResultSetHandler
* @Description:������������ӿ�
* @author: �°�����
* @date: 2014-10-5 ����12:01:27
*
*/ 
public interface ResultSetHandler {
    
    /**
    * @Method: handler
    * @Description: �����������
    * @Anthor:�°�����
    *
    * @param rs ��ѯ�����
    * @return
    */ 
    public Object handler(ResultSet rs);
}
