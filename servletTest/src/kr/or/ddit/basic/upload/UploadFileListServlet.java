package kr.or.ddit.basic.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UploadFileListServlet.do")
public class UploadFileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//파일이 저장될 폴더 설정
    private static final String UPLOAD_DIR ="d:/d_other/uploadFiles";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File file = new File(UPLOAD_DIR);
		//대상 폴더가 없으면 폴더 생성
		if(!file.exists()){
			file.mkdirs();
		}
		
		//파일이 저장된 폴더에서 파일 목록을 구해와서 List에 저장한다.
		File[] allFiles = file.listFiles();
		
		List<UploadDetail> fileList = new ArrayList<>();
		
		for (File f : allFiles){
			if(!f.isFile()) continue;
			UploadDetail detail = new UploadDetail();
			detail.setFileName(f.getName()); // 파일명
			detail.setFileSize(f.length() / 1024); //파일크기 kb로셋팅
			detail.setUploadStatus("");
			
			fileList.add(detail);
		}
		
		request.setAttribute("uploadFileList", fileList);
		
		
		String view = "/basic/04/fileList.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(view);
		disp.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
