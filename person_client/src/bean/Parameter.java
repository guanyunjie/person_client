package bean;

import java.io.Serializable;
import java.util.Map;

public class Parameter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Map<String,Object> params;

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
}
