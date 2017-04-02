package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import bean.Student;

/**
 * Servlet implementation class MainServlet
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * 1,解析ajax传过来的json数据
	 * 2,数据库操作
	 * 3,返回json数据
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post!!!");
		StringBuffer json = new StringBuffer();
		//	读
		BufferedReader reader = request.getReader();
		String line = "";
		while ((line = reader.readLine()) != null) {
			json.append(line);
		}
		//	数据操作
		System.out.println(json.toString());
		
		Student s = new Student();
		s.setName("guanyj");
		s.setId(UUID.randomUUID().toString().replaceAll("-", ""));
		String result = JSON.toJSONString(s);
		
		//	写
		response.getOutputStream().write(result.getBytes());
	}
}
