package kr.or.ddit.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class URIActionMapper {
	private static Map<String, String> actionMap = new HashMap<String, String>();
	
	static{
		ResourceBundle rb = ResourceBundle.getBundle("kr.or.ddit.web.uri_mapping");
		
		Enumeration<String> en = rb.getKeys();
		while (en.hasMoreElements()) {
			String key = en.nextElement();
			String value = rb.getString(key).trim();
			
			actionMap.put(key, value);
		}
	}
	
	// 인수값으로 주어진 uri에 맞는 Action객체를 인스턴스화 해서 반환하는 메서드
	public static IAction getAction(String uri){
		IAction action = null;
		
		if(actionMap.containsKey(uri)){
			try {
				// 문자열로된 Action객체의 이름을 이용해서 해당 클래스를 메모리에 로딩한다.
				Class cls = Class.forName(actionMap.get(uri));
				
				// 메모리에 로딩된 Action클래스로 '인스턴스화' 한다.
				action = (IAction) cls.newInstance();
			} catch (Exception e) {
			}
		}
		return action;
	}
}
