package mvcController;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import mvcModel.AccountService;
import mvcModel.NewsFeedService;
import mvcModel.PostService;
import mvcModel.ProfilService;
import mvcModel.UserService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import entites.Post;

/**
 * Servlet implementation class ControllerUpload
 */
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)   // 50MB
public class ControllerUpload extends HttpServlet {
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
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerUpload() {
        super();
        // TODO Auto-generated constructor stub
    }
    private static final String SAVE_DIR = "uploadFiles";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // gets absolute path of the web application
        String appPath = "D:";
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
        String fileName1="";
        for (Part part : request.getParts()) {
        	String fileName = extractFileName(part);
        	if(fileName.equals("")) {
        		fileName1=fileName;
        	}
            // refines the fileName in case it is an absolute path
            fileName = new File(fileName).getName();
            part.write(savePath + File.separator + fileName);
        }
        System.out.println("Upload has been done successfully!");
			Post p=new Post();
			String[] checkedtag=request.getParameterValues("tag");
			StringBuilder checkedValuesFields = new StringBuilder();
			String[] checkedfield=request.getParameterValues("field");
			StringBuilder checkedValuestags = new StringBuilder();
			if (checkedtag != null) {
			    for (String tag : checkedtag) {
			      checkedValuestags.append(tag).append(",");
			    }
			    checkedValuestags.setLength(checkedValuestags.length() - 1); // Remove the last comma
			  }
			if (checkedfield != null) {
			    for (String field : checkedfield) {
			      checkedValuesFields.append(field).append(",");
			    }
			    checkedValuesFields.setLength(checkedValuesFields.length() - 1); // Remove the last comma
			  }
			LocalDate localDate = LocalDate.now();
	        Date sqlDate = Date.valueOf(localDate);
			p.setDateOfCreation(sqlDate);
			p.setField(checkedValuesFields.toString());
			p.setReactNb(0);
			p.setSavesNb(0);
			p.setReportNb(0);
			p.setTags(checkedValuestags.toString());
			p.setTextContent(request.getParameter("textcontent"));
			p.setUtilisateur(userService.getUtilisateurByID(Integer.parseInt(request.getParameter("iduser"))).get(0));
			postService.createPost(p);
			List<Post>post=postService.getAllPost();
			p=post.get(post.size()-1);
			System.out.println(""+p.getIdPost());
		}
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
