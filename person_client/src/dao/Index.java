package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import bean.EntityBean;
import bean.EntityBeanSet;
import bean.Parameter;
import util.JdbcUtil;

public class Index {
	
	public String insertTitles(){
		
		return "";
	}
	
	public EntityBeanSet queryDirectory(Parameter params){
		EntityBeanSet bean = new EntityBeanSet();
		Connection conn = JdbcUtil.connect();
		QueryRunner runner = new QueryRunner();
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select * from directory order by createtime");
			
			List<Map<String,Object>> result = (List<Map<String,Object>>) runner.query(conn,sql.toString(), new MapListHandler());
			
			bean.setService("queryDirectory");
			bean.setStatus("seccuess");
			bean.setResult(result);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return bean;
	}
	
	public EntityBean insertDirectory(Parameter params){
		EntityBean bean = new EntityBean();
		Connection conn = JdbcUtil.connect();
		QueryRunner runner = new QueryRunner();
		try {
			StringBuffer sql = new StringBuffer();
			Map<String,Object> map = params.getParams();
			sql.append("insert into directory values(?,?,?,?)");
			Object[] ps = {map.get("id"),map.get("name"),map.get("icon"),map.get("createtime")};
			int x = runner.update(conn, sql.toString(),ps);
			if(x == 1){
				bean.setStatus("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return bean;
	}
}
