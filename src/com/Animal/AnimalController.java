package com.Animal;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class AnimalController  extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AnimalCommand command = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnimalController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost");
		doAction(request, response);
	}
	
	private synchronized void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String viewPage = null;
		String commandName = null;
		
		viewPage = requestUri;
		commandName = viewPage.substring(contextPath.length());
		System.out.println("CommandName = " + commandName);
		viewPage = "/animal/index.jsp";
		try {
			if(commandName.equals("/add.do")) {
				viewPage = "/animal/text.jsp";
			}else if(commandName.equals("/addPet.do")) {
				setCommand(new AnimalSaveCommand());
				command.execute(request, response);
			}else if(commandName.equals("/list.do") || commandName.equals("/")) {
				setCommand(new AnimalListCommand());
				command.execute(request, response);
			}else if(commandName.equals("/search.do")) {
				setCommand(new AnimalFindCommand());
				command.execute(request, response);
			}else if(commandName.equals("/list_order.do")) {
				setCommand(new AnimalOrderCommand());
				command.execute(request, response);
			}else {
				viewPage = "/animal/notCommand.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.include(request, response);
			
			return;
			
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private synchronized void setCommand(AnimalCommand command) {
		this.command = command;
	}

}
