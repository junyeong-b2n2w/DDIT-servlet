package kr.or.ddit.member.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.MemberVO;
/**
 * 
 * Service객체는 Dao에 설정된 메서드를 원하는 작업에 맞게 호출하여 결과를 받아오고,
 * 받아온 결과 자료를 Controller에게 보내주는 역할을 한다.
 * 보통 DAO의 메서드와 구조를 같게한다.(고급 자바에서 한정)
 * 
 * 
 * @author PC-25
 *
 */


public interface IMemberService {

	/**
	 * MemberVO 에담겨진 자료를 DB에 insert하는 메서드
	 * @param memVo DB에 insert할 자료가 저장된 MemberVO 객체
	 * @return	insert 작업성공 : 1 , 작업실패 : 0
	 */
	public int insertMember(MemberVO memVo);
	
	
	/**
	 * 회원ID 를 매개변수로 DB에담겨진 자료를 DB에서 삭제하는 메서드
	 * @param memId 삭제할 회원ID
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int deleteMember(String memId);
	
	/**
	 * MemberVO자료를 이용하여 DB에 update하는 메서드
	 * 
	 * @param memVo update할 회원 정보가 들어있는 MemberVO객체
	 * @return 작업성공 : 1, 작업실패 : 0
	 */
	public int updateMember(MemberVO memVo);
	
	/**
	 * 전체 회원 정보를 DB에서 가져와 List에 담아서 반환하는 메서드
	 * 
	 * @return 회원정보가 저장될 List 객체
	 */
	public List<MemberVO> getAllMember();
	
	/**
	 * 회원ID를 매개변수로 받아서 해당 회원의 개수를 반환하는 메서드
	 * 
	 * @param memId 검색할 회원ID
	 * @return 검색된 회원 수
	 */
	public int getMemberCount(String memId);
	
	public int updateMemeber2(Map<String, String> paramMap);
}
