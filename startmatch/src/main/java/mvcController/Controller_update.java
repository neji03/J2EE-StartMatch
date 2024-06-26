package mvcController;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import mvcModel.PostService;

import java.io.IOException;
import java.util.List;

import entites.Post;

/**
 * Servlet implementation class Controller_update
 */
@WebServlet("/Controllerupdate")
public class Controller_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
      @EJB
      private PostService postService;
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
		 HttpSession session = request.getSession();
		 List<Post> posts=postService.getAllPost();
		 session.setAttribute("posts", posts);
		String btnValue1=request.getParameter("updateBtn1");
		
		 if(btnValue1!=null && btnValue1.equals("update")) {
			String valeur=request.getParameter("sel_post");
			System.out.println("bonjour");
			Post p=postService.getPostById(Integer.parseInt(valeur));
			request.setAttribute("sel_post1",valeur);
			request.setAttribute("post",p);
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