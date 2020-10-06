package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.member.dao.IMemberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	private IMemberDao dao; // dao 객체 변수 생성
	private static MemberServiceImpl service;
	

	
	private MemberServiceImpl() {
		dao = MemberDaoImpl.getInstance();
	}
	public static MemberServiceImpl getInstance(){
		if(service == null){
			service = new MemberServiceImpl();
		}
		return service;
	}
	@Override
	public int insertMember(MemberVO memVo) {
		return dao.insertMember(memVo);
	}

	@Override
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}

	@Override
	public int updateMember(MemberVO memVo) {
		return dao.updateMember(memVo);
	}

	@Override
	public List<MemberVO> getAllMember() {
		return dao.getAllMember();
	}

	@Override
	public int getMemberCount(String memId) {
		return dao.getMemberCount(memId);
	}
	@Override
	public int updateMemeber2(Map<String, String> paramMap) {
		
		return dao.updateMemeber2(paramMap);
	}
	@Override
	public MemberVO getOneMember(String memId) {
		return dao.getOneMember(memId);
	}
	
	
	
}
