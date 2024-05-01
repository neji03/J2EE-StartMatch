package mvcController;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Controller_update
 */
public class Controller_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller_update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	System.out.println("bonnaa serra");
    	String btnValue1=request.getParameter("updateBtn1");
    	 if(btnValue1!=null && btnValue1.equals("update")) {
    	String valeur=request.getParameter("sel_post");
    	System.out.println("bonjour");
    	request.setAttribute("sel_post1",valeur);
    	RequestDispatcher rd = request.getRequestDispatcher("updatepost.jsp");
    	rd.forward(request, response);
    	//String idp= request.getParameter("sel_post");
    	}
    	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
