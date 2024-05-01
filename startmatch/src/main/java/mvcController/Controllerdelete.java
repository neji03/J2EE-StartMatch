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
 * Servlet implementation class Controllerdelete
 */
@WebServlet("/Controllerdelete")
public class Controllerdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
      private PostService postService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controllerdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String btnValue=request.getParameter("deleteBtn");
		System.out.println(btnValue);
		System.out.println("onon2");
		 if (btnValue != null && btnValue.equals("delete")) {
			 System.out.println("onon");
            int idPost = Integer.parseInt(request.getParameter("del_post"));
            Post p=postService.getPostById(idPost);
           // postService.deletePostById(idPost);
            String msg=postService.deletePostById(p.getIdPost());
            	System.out.println(msg);
             HttpSession session = request.getSession();
        	 List<Post> posts=postService.getAllPost();
        	 session.setAttribute("posts", posts);
            RequestDispatcher rd = request.getRequestDispatcher("newsfeed.jsp");
            rd.forward(request, response);
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
