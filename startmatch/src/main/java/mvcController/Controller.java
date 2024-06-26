package mvcController;

import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import mvcModel.AccountService;
import mvcModel.AdminService;
import mvcModel.NewsFeedService;
import mvcModel.PostService;
import mvcModel.ProfilService;
import mvcModel.UserService;

import java.io.OutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import entites.Account;
import entites.Admin;
import entites.Newsfeed;
import entites.Post;
import entites.Profil;
import entites.Utilisateur;

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
	private NewsFeedService newsfeedService;
	@EJB
	private PostService postService;
	@EJB
	private AdminService adminService;
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
		String btnValue=request.getParameter("myBtn");
		System.out.println(btnValue);
		if (btnValue != null&&btnValue.equals("select all users") ) {
			List<Utilisateur>users=userService.getAllUtilisateurs();
			String s="";
			
			for (Utilisateur i : users) {
				s+=(i.getIdUser()+" "+i.getEmail()+" "+i.getIsPerson()+"\n");
			}
			if (s.equals(""))s="no user found";
			System.out.println(s);
			
		}else if (btnValue != null&&btnValue.equals("select Utilisateur by id") ) {
			int idUtilisateur=Integer.parseInt(request.getParameter("idUtilisateur"));
			List<Utilisateur>Utilisateurs=userService.getUtilisateurByID(idUtilisateur);
			String s="";
			for (Utilisateur i : Utilisateurs) {
				s+=(i.getIdUser()+" "+i.getEmail()+" "+i.getIsPerson()+"\n");
			}
			if (s.equals(""))s="no Utilisateur found";
			System.out.println(s);
		}else if (btnValue.equals("insert account") &&btnValue != null) {
			Account a=new Account();
			a.setReportsNb(0);
			accountService.createAccount(a);
			List<Account>accounts=accountService.getAllAccounts();
			a=accounts.get(accounts.size()-1);
			System.out.println(""+a.getIdAccount());
		}else if (btnValue != null&&btnValue.equals("insert newsfeed") ) {
			Newsfeed n=new Newsfeed();
			n.setLastFilter("");
			newsfeedService.createNewsfeed(n);
			List<Newsfeed>news=newsfeedService.getAllNews();
			n=news.get(news.size()-1);
			System.out.println(""+n.getIdNewsFeed());
		}else if (btnValue != null&&btnValue.equals("insert profil") ) {
			Profil p=new Profil();
			p.setLogin(request.getParameter("login"));
			p.setPassword(request.getParameter("password"));
			profilService.createProfil(p);
			List<Profil>profils=profilService.getProfilByLogin(p.getLogin());
			p=profils.get(profils.size()-1);
			System.out.println(""+p.getLogin());
		}else if (btnValue != null&&btnValue.equals("insert startup") ) {
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
//insert Utilisateur startup
			Utilisateur u=new Utilisateur();
			u.setAccount(a);
			u.setNewsfeed(n);
			u.setProfil(p);
			u.setAddress(request.getParameter("address"));
			u.setBio(request.getParameter("bio"));
			u.setIsPerson((byte) 0);
			u.setSName(request.getParameter("sname"));
			u.setField(request.getParameter("field"));
			u.setEmail(request.getParameter("email"));
			u.setPhone_Num(Integer.parseInt(request.getParameter("phone_num")));
			LocalDate localDate = LocalDate.now();
			Date sqlDate = Date.valueOf(localDate);
			u.setDate(sqlDate);
			Date date = Date.valueOf(request.getParameter("sdateofcreation"));
			u.setSDateOfCreation(date);
			u.setSName(request.getParameter("sname"));
			userService.createUtilisateur(u);
			List<Utilisateur>Utilisateurs=userService.getAllUtilisateurs();
			u=Utilisateurs.get(Utilisateurs.size()-1);
			System.out.println(""+u.getIdUser());
			response.sendRedirect("login.jsp");
		}else if (btnValue != null&&btnValue.equals("insert person")) {
//insert profil
			Profil p=new Profil();
			p.setLogin(request.getParameter("email"));
			p.setPassword(request.getParameter("password"));
			profilService.createProfil(p);
			List<Profil>profils=profilService.getProfilByLogin(p.getLogin());
			p=profils.get(0);
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
//insert Utilisateur startup
			Utilisateur u=new Utilisateur();
			u.setAccount(a);
			u.setNewsfeed(n);
			u.setProfil(p);
			u.setAddress(request.getParameter("address"));
			u.setBio(request.getParameter("bio"));
			u.setIsPerson((byte) 1);
			u.setField(request.getParameter("field"));
			u.setEmail(request.getParameter("email"));
			u.setPhone_Num(Integer.parseInt(request.getParameter("phone_num")));
			LocalDate localDate = LocalDate.now();
			Date sqlDate = Date.valueOf(localDate);
			u.setDate(sqlDate);
			Date date = Date.valueOf(request.getParameter("pdateofbirth"));
			u.setPDateOfBirth(date);
			u.setPFirst_name(request.getParameter("pfirst_name"));
			u.setPExpertise(request.getParameter("pexpertise"));
			u.setPGender(request.getParameter("pgender"));
			u.setPJobPostition(request.getParameter("pjobposition"));
			u.setPLast_name(request.getParameter("plast_name"));
			userService.createUtilisateur(u);
			List<Utilisateur>Utilisateurs=userService.getAllUtilisateurs();
			u=Utilisateurs.get(Utilisateurs.size()-1);
			System.out.println(""+u.getIdUser());
			response.sendRedirect("login.jsp");
		}else if (btnValue != null&&btnValue.equals("update startup") ) {
			Utilisateur u=new Utilisateur();
			u.setIdUser(Integer.parseInt(request.getParameter("idUtilisateur")));
			u.setAddress(request.getParameter("address"));
			u.setBio(request.getParameter("bio"));
			u.setField(request.getParameter("field"));
			u.setEmail(request.getParameter("email"));
			u.setSName(request.getParameter("sname"));
			Date date = Date.valueOf(request.getParameter("sdateofcreation"));
			u.setSDateOfCreation(date);
			u.setPhone_Num(Integer.parseInt(request.getParameter("phone_num")));
			u=userService.updateUtilisateur(u);
			System.out.println(""+u.getIdUser());
		}else if (btnValue != null&&btnValue.equals("delete user") ) {

			userService.deleteUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur")));
			List<Utilisateur>Utilisateurs=userService.getAllUtilisateurs();
			for (Utilisateur i : Utilisateurs) { 
			System.out.println(""+i.getIdUser()+" "+i.getEmail()+"\n");
			}
		}else if (btnValue != null&&btnValue.equals("select post by id")) {
			int idpost=Integer.parseInt(request.getParameter("idpost"));
			Post post=postService.getPostById(idpost);
			String s="";
				s+=(post.getIdPost()+" "+post.getUtilisateur().getIdUser()+"\n");
			System.out.println(s);
		}else if (btnValue != null&&btnValue.equals("delete post")) {
			int idpost=Integer.parseInt(request.getParameter("idpost"));
			postService.deletePostById(idpost);
		
			List<Post>posts=postService.getAllPost();
			for (Post post : posts) { 
			System.out.println(post.getIdPost()+" "+post.getUtilisateur().getIdUser()+"\n");
			}
		}else if(btnValue!=null && btnValue.equals("Login")){
				//	response.getWriter().append("in");
				System.out.println("in test login");
				String login=request.getParameter("login");
				String pwd=request.getParameter("password");
				Utilisateur user=userService.getUtilisateurByLoginAndPwd(login, pwd);
				List<Utilisateur> users=userService.getAllUtilisateurs();
				List<Utilisateur> users_reported=userService.getAllReportedUsers();
				List<Post> posts=postService.getAllPost();
				List<Post> reportedposts=postService.getReportedPost();
				System.out.println(posts);
				if (user!=null) {
					//System.out.println(user.getProfil().getAdmins().size());
					HttpSession session = request.getSession(true);
		    		session.setMaxInactiveInterval(600000);
		    		session.setAttribute("users_reported", users_reported);
		    		session.setAttribute("reportedposts",reportedposts);
		    		session.setAttribute("posts",posts);
		    		session.setAttribute("users",users);
		    		session.setAttribute("user", user.getIdUser());
		    		session.setAttribute("Bio", user.getBio());
		    		session.setAttribute("Address", user.getAddress());
		    		session.setAttribute("Cpic", user.getCpic());
		    		session.setAttribute("Date", user.getDate());
		    		session.setAttribute("Email", user.getEmail());
		    		session.setAttribute("Field", user.getField());
		    		session.setAttribute("IsPerson", user.getIsPerson());
		    		session.setAttribute("PDateOfBirth", user.getPDateOfBirth());
		    		session.setAttribute("PExpertise", user.getPExpertise());
		    		session.setAttribute("PGender", user.getPGender());
		    		session.setAttribute("PFirst_name", user.getPFirst_name());
		    		session.setAttribute("Phone_Num", user.getPhone_Num());
		    		session.setAttribute("PJobPostition", user.getPJobPostition());
		    		session.setAttribute("PLast_name", user.getPLast_name());
		    		session.setAttribute("Ppic", user.getPpic());
		    		session.setAttribute("SDateOfCreation", user.getSDateOfCreation());
		    		session.setAttribute("SName", user.getSName());
		    		//System.out.println("${sessionScope.user}");
		    		RequestDispatcher rd = request.getRequestDispatcher("newsfeed.jsp");
	    			rd.forward(request, response);
				}else if(pwd.equals("password")&&login.equals("siladmin@start-match.com")) {
					List<Post> posts_ad=postService.getReportedPost();
					Admin admin=adminService.getAllAdmin();
					HttpSession session = request.getSession(true);
		    		session.setMaxInactiveInterval(600000);
		    		session.setAttribute("reportedposts",posts_ad);
		    		session.setAttribute("users",users);
		    		session.setAttribute("admin", admin);
		    		RequestDispatcher rd = request.getRequestDispatcher("consultadminpannel.jsp");
	    			rd.forward(request, response);
				}
				else {
					
	    			
	    			request.setAttribute("erreur", "login et/ou mdp incorrect");
	    			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
	    			rd.forward(request, response);
	    			}
			
		}else if(btnValue!=null && btnValue.equals("consult other")){
            System.out.println("in test consult other");
            int iduser=Integer.parseInt(request.getParameter("iduser"));
            List<Utilisateur>users=userService.getUtilisateurByID(iduser);
            request.setAttribute("user1",users.get(0));
            RequestDispatcher rd =request.getRequestDispatcher("consultOtherprofile.jsp");
            rd.forward(request,response);
            }else if(btnValue!=null && btnValue.equals("Consultmyprofil")) {
            	HttpSession session = request.getSession();
            	System.out.println("Session scope: " + session.getAttribute("IsPerson"));
            	RequestDispatcher rd =request.getRequestDispatcher("ConsultMyProfile.jsp");
                rd.forward(request,response);
            }else if(btnValue!=null && btnValue.equals("report user")){
                System.out.println("in test report user");
                int idaccount=Integer.parseInt(request.getParameter("idaccount"));
                Account acc=accountService.updateNbReports(idaccount);
                if (acc!=null) {System.out.println("report done successfully");}
                RequestDispatcher rd =request.getRequestDispatcher("newsfeed.jsp");
    			rd.forward(request,response);
                }else if(btnValue!=null && btnValue.equals("report post")){
                    System.out.println("in test report post");
                    int idpost=Integer.parseInt(request.getParameter("idpost"));
                    Post p=postService.updateNbReports(idpost);
                    if (p!=null) {System.out.println("report done successfully");}
			RequestDispatcher rd =request.getRequestDispatcher("newsfeed.jsp");
			rd.forward(request,response);
			}else
				if (btnValue != null&&btnValue.equals("Like")) {
					System.out.println("d5alnaaa");
			        int postId = Integer.parseInt(request.getParameter("likePost"));
			        Post post = postService.getPostById(postId);
			        post.setReactNb(post.getReactNb() + 1);
			        System.out.println("setiina");
			        postService.updatelike(post);
			        System.out.println("likeena");
			        request.setAttribute("post", post);
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
