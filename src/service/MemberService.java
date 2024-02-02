package service;

 

import java.util.List; 

 

import dao.MemberDao;

import dto.MemberDto;

 

public class MemberService {
 MemberDao dao = new MemberDao();

 

 public MemberService() { }
 public MemberService(MemberDao dao) { this.dao = dao; }

 

 public int login(String id, String pw) throws Exception {
  return dao.login(new MemberDto(id, pw, "", 0));
 }

 

 public List<MemberDto> getMemberList() throws Exception {
  return dao.selectAll();
 }

 

 public MemberDto getMemberById(String id) throws Exception {
  return dao.selectOneWithId(id);
 }

 

 public int updateMemberById(MemberDto dto) throws Exception {
  return dao.updateOneById(dto);
 }

 

 public int deleteMember(String id) throws Exception {
  return dao.deleteOne(id);

 }

 

 public int registerMember(MemberDto dto) throws Exception {
  return dao.insertOne(dto);
 }

 

 public int gainMemberPoint(String id, int point) throws Exception {
  return dao.updatePointGain(id, point);
 }

 

 public int gainAllMembersPoint() throws Exception {
  return dao.updatePointGainToAllMembers();
 }

}