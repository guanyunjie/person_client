package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapListHandler;

import bean.EntityBean;
import bean.EntityBeanSet;
import bean.Parameter;
import dao.param.DaoParam;
import util.JdbcUtil;

public class Index implements DaoParam{
	
	public String insertTitles(){
		
		return "";
	}
	
	/**
	 * @param params
	 * @return
	 */
	public EntityBeanSet queryDirectory(Parameter params){
		EntityBeanSet bean = new EntityBeanSet();
		Connection conn = JdbcUtil.connect();
		QueryRunner runner = new QueryRunner();
		try {
			StringBuffer sql = new StringBuffer();
			sql.append("select * from directory order by createtime");
			
			List<Map<String,Object>> result = runner.query(conn,sql.toString(), new MapListHandler());
			
			bean.setService("queryDirectory");
			bean.setStatus(SUCCESS);
			bean.setResult(result);
			System.out.println(result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		return bean;
	}
	
		
	/**
	 * @param params
	 * @return
	 */
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
				bean.setStatus(SUCCESS);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return bean;
	}
	
	public EntityBeanSet queryIcons(Parameter params){
		EntityBeanSet bean = new EntityBeanSet();
		Connection conn = JdbcUtil.connect();
		QueryRunner runner = new QueryRunner();
		try {
			StringBuffer sql = new StringBuffer();
			Map<String,Object> map = params.getParams();
			sql.append("select * from icons limit 50 offset 0");
			List<Map<String,Object>> result = runner.query(conn, sql.toString(), new MapListHandler());					
			bean.setService("queryIcons");
			bean.setStatus(SUCCESS);
			bean.setResult(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		return bean;
	}
}
