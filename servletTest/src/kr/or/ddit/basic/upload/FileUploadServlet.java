package kr.or.ddit.basic.upload;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;



/*
 * Servlet 3.0에서는 업로드 데이터 작업을 지원하는 API를제공한다
 * 
 * -Servlet 3.0에서 multipart d요청을 사용하려면 해당 servlet에 
 * @MultipartConfig 애노테이션을 설정해얗나다
 * 
 * - @MultipartConfig 애노테이션 => multipart/form-data 요청을 처리하는 변수를 갖는 애노테이션
 * 
 * - @MultipartConfig의 속성들 
 *    1. fileSizeThreshold : 임계값
 *    			=> 지정된 임계값보다 큰 파일이 전송되면
 *    				메모리에 저장하는대신 디스크에 직접 기록한다,
 *    2. maxFileSize : 1개의 파일의 최대 용량( 단위 : byte )
 *    3. maxRequestSize : multipart/form-data로 보낼수 있는 전체 용량 ( 단위 : byte )
 *    4. location : Part.write() 메서드로 저장할때 저장할 디렉토리 
 * 
 *    -----------------
 *    
 * Part객체 => multipart/form-data로 보내는 데이터의 각 part부분을 나타내는 객체
 * 	part객체의 메서드 
 * 1. getInputStream() : part의 내용을 읽는 데 사용할 InputStream 객체 반환
 * 2. getSize() : 해당 part의 전체 용량(즉 파일의 용량 크기와 같다)
 * 3. write("저장할 파일 경로 및 파일 명") : 지정한 위치에 해당 part에 속한 파일을 저장한다
 * 
 *    
 *    -----------------------------------------------
 *  Part 객체를 구하는 방법 (Requset 객체를 이용한다)
 *  1. Requset객체.getParts(): 전체 part가 저장된 컬렉션을 반환한다.
 *  2. Requset객체.getPart("part이름") => 지정된 이름을 가진 개별 Part객체를 반환한다.
 *  
 *   
 *    
 *    
 *    
 *  */

@WebServlet("/FileUploadServlet.do")
@MultipartConfig(
		fileSizeThreshold = 1024 * 1024 * 10, // 10메가정도
		maxFileSize = 1024 * 1024 * 30,       // 30메가정도
		maxRequestSize = 1024 * 1024 * 50	  // 메가 정도
		)
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//파일이 저장될 폴더 설정
    private static final String UPLOAD_DIR ="d:/d_other/uploadFiles";
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일업로드에서는 get방식을 사용할 수 없다.
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장될 폴더가 없으면 해당 폴더를 생성한다.
		File fileUploadDirectory = new File(UPLOAD_DIR);
		if(!fileUploadDirectory.exists()){
			fileUploadDirectory.mkdirs();
		}
		
		String fileName = ""; // 업로드한 파일명이 저장될 변수
		
		
		List<UploadDetail> fileList = new ArrayList<>();
		
		for(Part part : request.getParts()){
			fileName = getFileName(part);
			
			if("".equals(fileName)) continue;
			
			
			UploadDetail details = new UploadDetail();
			details.setFileName(fileName);;
			details.setFileSize(part.getSize() / 1024);//kb단위로 변환
			
			try {
				part.write(UPLOAD_DIR + File.separator + fileName); // 파일저장
				details.setUploadStatus("Success");
			} catch (IOException e) {
				details.setUploadStatus("fail : " + e.getMessage());
			}
			fileList.add(details);
			
			
			
		}
		
		request.setAttribute("uploadFileList", fileList);
		
		
		String view = "/basic/04/fileList.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(view);
		disp.forward(request, response);
		
	}
	
	// Part영역에서 업로드 한 파일이름을 구해서 반환 하는 메서드
	private String getFileName(Part part){
		/*
		  part 의 구조
		  1)파일이 아닌경우
		  -------------agsdfsagsdf ==>part의 구분선
		  Content-Disposition : form-data; name="memid" ==> 파라미터명
		  									=> 빈줄
		  a001   							=> 파라미터값
		  
		  2)파일인 경우
		   -------------agsdfsagsdf ==>part의 구분선
		  Content-Disposition : form-data; name="fileUpload1"; filename="test1.txt" ==> 파일정보
		  									=> 빈줄
		  dfasgasfsdfs  					=> 파일내용
		  
		 */
		
		
		String fileName="";
		String contentDisposition = part.getHeader("content-disposition");
		String[] items = contentDisposition.split(";");
		for(String item : items){
			if(item.trim().startsWith("filename")){
				fileName = item.substring(item.indexOf("=")+2, item.length()-1);
			}
		}
		
		
		
		return fileName;
	}

}
