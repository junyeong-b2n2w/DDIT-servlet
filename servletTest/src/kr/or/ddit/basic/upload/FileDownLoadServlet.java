package kr.or.ddit.basic.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FileDownLoadServlet.do")
public class FileDownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//파일이 저장될 폴더 설정
    private static final String UPLOAD_DIR ="d:/d_other/uploadFiles";
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파일명을 파라미터로 받는다.
		String fileName = request.getParameter("fileName");
		
		String filePath = UPLOAD_DIR + File.separator + fileName;
		File file= new File(filePath);
		if(file.exists()){
			FileInputStream fin = null;
			OutputStream out = null;
			try {
			
			// Content-type 설정
			response.setContentType("application/octet-stream; charset=utf-8");
			
			String encodedFileName = 
					getFileNameEncoding(fileName, getBrowser(request));
			
			// Response의 Header에 content-disposition속성 설정
			response.setHeader("Content-Disposition",
					"attachment; filename=\"" + encodedFileName + "\""	);
			
			
				// 출력용 스트림 객체 생성 => Response객체 이용
				out = response.getOutputStream();
				
				// 파일 입력용 스트림 객체 생성
				fin = new FileInputStream(file);
				
				byte[] buffer = new byte[8192];
				
				int bytesRead = -1;
				
				// byte배열을 이용해서 파일내용을 읽어와 출력용 스트림으로 출력한다.
				while( (bytesRead = fin.read(buffer)) != -1 ){
					out.write(buffer, 0,bytesRead);
					
				}
				out.flush();
				
				
				
				
				
			} catch (IOException e) {
				System.out.println("입출력오류 : " + e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(fin != null) fin.close();
				if(out != null) out.close();
			}
			
		}else{  // 파일이 없을 경우의 처리
			response.setContentType("text/html");
			response.getWriter().println("<h3>파일이 존재하지 않습니다.</h3>");
		}
		
		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	//사용중인 웹브라우저 종류를 반환하느 메서드
	
	private String getBrowser(HttpServletRequest request){
		String header = request.getHeader("User-Agent");
		
		
		if(header.indexOf("MSIE")>-1){
			return "MSIE";
		}else if(header.indexOf("Chrome")>-1){
			return "Chrome";
		}else if(header.indexOf("Opera")>-1){
			return "Opera";
		}else if(header.indexOf("Trident/7.0")>-1){   // ie 11.0이상
			return "MSIE";
		}
		
		return "Firefox";
	}
	
	// 웹 브라우저별로 한글 파일명을 encoding해서 반환하는 메서드
	private String getFileNameEncoding(String fileName, String browser) throws Exception{
		String encodingFileName =null;
		
		if("MSIE".equals(browser)){
			encodingFileName = URLEncoder.encode(fileName, "utf-8").replaceAll("\\+", "%20");
		}else if("Firefox".equals(browser) || "Opera".equals(browser)){
			encodingFileName = "\""+new String(fileName.getBytes("utf-8"), "8859_1")+"\"";
		}else if("Chrome".equals(browser)){
			StringBuffer sb = new StringBuffer();
			for(int i=0; i<fileName.length(); i++){
				char c = fileName.charAt(i);
				if(c > '~'){  // ~문자는 ASCII 문자중 제일 마지막
					sb.append(URLEncoder.encode(""+c,"utf-8"));
				}else{
					sb.append(c);
				}
			}
			encodingFileName = sb.toString();
		}else{
			throw new RuntimeException("Not supported Browser");
		}
		
		
		return encodingFileName;
		
		
		
	}
	
	
	
}
