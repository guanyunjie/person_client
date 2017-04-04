package controller;

import com.alibaba.fastjson.JSON;

import bean.EntityBean;
import bean.EntityBeanSet;
import bean.Parameter;
import dao.Index;

/**
 * 
 * @author Guanyunjie
 * @since 2017/4/4
 *
 */
public class MainController {
	/**
	 * 
	 * @param params
	 * @return
	 */
	public String queryDirectory(Parameter params){
		Index index = new Index();
		EntityBeanSet result = index.queryDirectory(params);
		return JSON.toJSONString(result);
	}
	/**
	 * 
	 * @param params
	 * @return
	 */
	public String insertDirectory(Parameter params){
		Index index = new Index();
		EntityBean result = index.insertDirectory(params);
		return JSON.toJSONString(result);
	}
	
}
