package mvcController;

import jakarta.ejb.EJB;
import jakarta.json.JsonObject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mvcModel.AccountService;
import mvcModel.NewsfeedService;
import mvcModel.PostService;
import mvcModel.ProfilService;
import mvcModel.UserService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import entities.Account;
import entities.Newsfeed;
import entities.Post;
import entities.Profil;
import entities.User;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UserService userService;
	@EJB
	private ProfilService profilService;
	@EJB
	private AccountService accountService;
	@EJB
	private NewsfeedService newsfeedService;
	@EJB
	private PostService postService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		String btnValue=request.getParameter("myBtn");
		if (btnValue.equals("select all users") &&btnValue != null) {
			List<User>users=userService.getAllUsers();
			String s="";
			
			for (User i : users) {
				s+=(i.getIdUser()+" "+i.getEmail()+" "+i.getIsPerson()+"\n");
			}
			if (s.equals(""))s="no user found";
			response.getWriter().append(s);
			
		}else if (btnValue.equals("select user by id") &&btnValue != null) {
			int iduser=Integer.parseInt(request.getParameter("iduser"));
			List<User>users=userService.getUserByID(iduser);
			String s="";
			for (User i : users) {
				s+=(i.getIdUser()+" "+i.getEmail()+" "+i.getIsPerson()+"\n");
			}
			if (s.equals(""))s="no user found";
			response.getWriter().append(s);
		}else if (btnValue.equals("insert account") &&btnValue != null) {
			Account a=new Account();
			a.setReportsNb(0);
			accountService.createAccount(a);
			List<Account>accounts=accountService.getAllAccounts();
			a=accounts.get(accounts.size()-1);
			response.getWriter().append(""+a.getIdAccount());
		}else if (btnValue.equals("insert newsfeed") &&btnValue != null) {
			Newsfeed n=new Newsfeed();
			n.setLastFilter("");
			newsfeedService.createNewsfeed(n);
			List<Newsfeed>news=newsfeedService.getAllNews();
			n=news.get(news.size()-1);
			response.getWriter().append(""+n.getIdNewsFeed());
		}else if (btnValue.equals("insert profil") &&btnValue != null) {
			Profil p=new Profil();
			p.setLogin(request.getParameter("login"));
			p.setPassword(request.getParameter("password"));
			profilService.createProfil(p);
			List<Profil>profils=profilService.getProfilByLogin(p.getLogin());
			p=profils.get(profils.size()-1);
			response.getWriter().append(""+p.getLogin());
		}else if (btnValue.equals("insert startup") &&btnValue != null) {
//insert profil
			Profil p=new Profil();
			p.setLogin(request.getParameter("email"));
			p.setPassword(request.getParameter("password"));
			profilService.createProfil(p);
			List<Profil>profils=profilService.getProfilByLogin(p.getLogin());
			p=profils.get(profils.size()-1);
//insert newsfeed
			Newsfeed n=new Newsfeed();
			n.setLastFilter("");
			newsfeedService.createNewsfeed(n);
			List<Newsfeed>news=newsfeedService.getAllNews();
			n=news.get(news.size()-1);
//insert account
			Account a=new Account();
			a.setReportsNb(0);
			accountService.createAccount(a);
			List<Account>accounts=accountService.getAllAccounts();
			a=accounts.get(accounts.size()-1);
//insert user
			User u=new User();
			u.setAccount(a);
			u.setNewsfeed(n);
			u.setProfil(p);
			u.setAddress(request.getParameter("address"));
			u.setBio(request.getParameter("bio"));
			u.setIsPerson((byte) 0);
			u.setField(request.getParameter("field"));
			u.setEmail(request.getParameter("email"));
			u.setPhone_Num(Integer.parseInt(request.getParameter("phone_num")));
			LocalDate localDate = LocalDate.now();
			Date sqlDate = Date.valueOf(localDate);
			u.setDate(sqlDate);
			Date date = Date.valueOf(request.getParameter("sdateofcreation"));
			u.setSDateOfCreation(date);
			u.setSName(request.getParameter("sname"));
			userService.createUser(u);
			List<User>users=userService.getAllUsers();
			u=users.get(users.size()-1);
			response.getWriter().append(""+u.getIdUser());
		}else if (btnValue.equals("update startup") &&btnValue != null) {
			User u=new User();
			u.setIdUser(Integer.parseInt(request.getParameter("iduser")));
			u.setAddress(request.getParameter("address"));
			u.setBio(request.getParameter("bio"));
			u.setField(request.getParameter("field"));
			u.setEmail(request.getParameter("email"));
			u.setSName(request.getParameter("sname"));
			Date date = Date.valueOf(request.getParameter("sdateofcreation"));
			u.setSDateOfCreation(date);
			u.setPhone_Num(Integer.parseInt(request.getParameter("phone_num")));
			u=userService.updateUser(u);
			response.getWriter().append(""+u.getIdUser());
		}else if (btnValue.equals("insert post") &&btnValue != null) {
			Post p=new Post();
			LocalDate localDate = LocalDate.now();
	        Date sqlDate = Date.valueOf(localDate);
			p.setDateOfCreation(sqlDate);
			p.setField("info");
			p.setReactNb(0);
			p.setSavesNb(0);
			p.setReportNb(0);
			p.setTags("cofunder");
			p.setTextContent("hello les babies");
			p.setUser_idUser(1);
			postService.createPost(p);
			List<Post>post=postService.getAllPost();
			p=post.get(post.size()-1);
			response.getWriter().append(""+p.getIdPost());
		}else if (btnValue.equals("delete user") &&btnValue != null) {

			userService.deleteUserById(Integer.parseInt(request.getParameter("iduser")));
			List<User>users=userService.getAllUsers();
			for (User i : users) { 
			response.getWriter().append(""+i.getIdUser()+" "+i.getEmail()+"\n");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String btnValue=request.getParameter("myBtn");
	}

}
