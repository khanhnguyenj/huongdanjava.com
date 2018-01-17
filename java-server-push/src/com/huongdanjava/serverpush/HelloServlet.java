package com.huongdanjava.serverpush;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.newPushBuilder()
			.path("/java-server-push/logo.png")
			.push();

		// Setting up the content type of web page
		resp.setContentType("text/html");

		// Writing the message on the web page
		PrintWriter out = resp.getWriter();
		out.println("<img src='/java-server-push/logo.png'>");
		out.println("<h1>Hello World from Huong Dan Java</h1>");
	}
}
