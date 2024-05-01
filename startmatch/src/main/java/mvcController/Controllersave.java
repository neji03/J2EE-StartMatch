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
 * Servlet implementation class Controllersave
 */
@WebServlet("/Controllersave")
public class Controllersave extends HttpServlet  {
	private static final long serialVersionUID = 1L;
	@EJB
	private PostService postService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controllersave() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("I am");
		String saveBtn=request.getParameter("saveBtn");
		String idp=request.getParameter("idpost");
		Post p=postService.getPostById(Integer.parseInt(idp));
		 if(saveBtn!=null && saveBtn.equals("save")) {
			  System.out.println("here");
			 String valeur1=request.getParameter("textcontent");
			 //System.out.println(p.get(0).getIdPost());
			 String saved=postService.updatePostByText(valeur1,p);
			 System.out.println(saved);
			 HttpSession session = request.getSession();
			 List<Post> posts=postService.getAllPost();
			 session.setAttribute("posts", posts);
			 //RequestDispatcher rd = request.getRequestDispatcher("newsfeed.jsp");
			 response.sendRedirect("newsfeed.jsp");
 			//rd.forward(request, response);
			 
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