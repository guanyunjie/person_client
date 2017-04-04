package bean;

import java.io.Serializable;
import java.util.Map;

public class EntityBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String service;
	private String status;
	private Map<String,Object> result;
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Map<String, Object> getResult() {
		return result;
	}
	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}
