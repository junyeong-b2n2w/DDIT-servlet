package kr.or.ddit.member.dao;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.util.BuildSqlMapClient;
import kr.or.ddit.vo.MemberVO;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MemberDaoImpl implements IMemberDao{
	
	private static MemberDaoImpl dao;
	private SqlMapClient smc; //ibatis용 SqlMapClient
	
	
	private MemberDaoImpl(){
	
		smc = BuildSqlMapClient.getSqlMapClient();
		
		
	}
	
	public static MemberDaoImpl getInstance(){
		if(dao == null){
			dao = new MemberDaoImpl();
		}
		
		return dao;
	}

	@Override
	public int insertMember(MemberVO memVo) {

		int cnt =0;
		try {
			
			Object obj = smc.insert("mymember.insertMember",memVo);
			if(obj==null) cnt=1;
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
		
			
		
	}

	@Override
	public int deleteMember(String memId) {
		
		int cnt =0;
		try {
			
			cnt = smc.delete("mymember.deleteMember", memId);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
		}
		return cnt;
		
	}

	@Override
	public int updateMember(MemberVO memVo) {
		
		int cnt =0;
		try {
			
			cnt=smc.update("mymember.updateMember", memVo);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			return cnt;
		
			
		
		
	
	}
	@Override
	public List<MemberVO> getAllMember() {

		
		List<MemberVO> list=null;
		try {
			list = smc.queryForList("mymember.getAllMember");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
		
		
	}

	@Override
	public int getMemberCount(String memId) {
		int cnt =0;
		try {
			
			cnt = (int)smc.queryForObject("mymember.getMemberCount",memId);
			
		} catch (Exception e) {
			e.printStackTrace();
		
		
		
			

		
	}
		return cnt;
	
}
	
	public int updateMemeber2(Map<String, String> paramMap){
		int cnt =0;
		try {
			cnt = smc.update("mymember.updateMember2", paramMap);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cnt;
	}
	
	
}