package dao;

 

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;

import common.DBConnection;
import dto.MemberDto;

 

public class MemberDao {
 Connection conn = DBConnection.getConnection();
 PreparedStatement pstmt = null;
 ResultSet rs = null;

 

 public int login(MemberDto dto) throws Exception { // returns 1:Success 0:Fail
  String sql = "select count(*) from Member where id=? and pw=?";
  pstmt = conn.prepareStatement(sql);
  pstmt.setString(1, dto.getId());
  pstmt.setString(2, dto.getPw());
  rs = pstmt.executeQuery();
  int cnt = -1;
  if(rs.next()) {
   cnt = rs.getInt(1);
  }
  rs.close();
  pstmt.close();
  return cnt;
 }

 

 public List<MemberDto> selectAll() throws Exception {
  List<MemberDto> list = new ArrayList<MemberDto>();
  String sql = "select id, pw, name, point from Member";
  pstmt = conn.prepareStatement(sql);
  rs = pstmt.executeQuery();
  while(rs.next()) {
   String id = rs.getString("id");
   String pw = rs.getString("pw");
   String name = rs.getString("name");
   int point = rs.getInt("point");
   MemberDto dto = new MemberDto(id, pw, name, point);
   list.add(dto);
  }
  rs.close();
  pstmt.close();
  return list;
 }

 

 public MemberDto selectOneWithId(String id) throws Exception {

  String sql = "select * from Member where id=?";
  pstmt = conn.prepareStatement(sql);
  pstmt.setString(1, id);
  rs = pstmt.executeQuery();
  if(rs.next()) {
   String pw = rs.getString("pw");
   String name = rs.getString("name");
   int point = rs.getInt("point");
   MemberDto dto = new MemberDto(id, pw, name, point);
   return dto;
  }
  rs.close();
  pstmt.close();
  return null;
 }

 

 public int updateOneById(MemberDto dto) throws Exception {
  String sql = "update Member set pw=?, name=?, point=? where id=?";
  pstmt = conn.prepareStatement(sql);
  pstmt.setString(1, dto.getPw());
  pstmt.setString(2, dto.getName());
  pstmt.setInt(3, dto.getPoint());
  pstmt.setString(4, dto.getId());
  int r = pstmt.executeUpdate();
  pstmt.close();
  return r;

 }

 

 public int insertOne(MemberDto dto) throws Exception {
  String sql = "insert into Member(id, pw, name) values (?,?,?)";
  pstmt = conn.prepareStatement(sql);
  pstmt.setString(1, dto.getId());
  pstmt.setString(2, dto.getPw());
  pstmt.setString(3, dto.getName());
  int r = pstmt.executeUpdate();
  pstmt.close();
  return r;

 }

 

 public int deleteOne(String id) throws Exception {
  String sql = "DELETE FROM member WHERE id=?";
  pstmt = conn.prepareStatement(sql);
  pstmt.setString(1, id);
  int r = pstmt.executeUpdate();
  pstmt.close();
  return r;

 }

 

 public int updatePointGain(String id, int point) throws Exception {
  String sql = "update Member set point=point+1000 where id=?";
  pstmt = conn.prepareStatement(sql);
  pstmt.setString(1, id);
  int r = pstmt.executeUpdate();
  pstmt.close();
  return r;

 }

 

 public int updatePointGainToAllMembers() throws Exception {
  String sql = "update Member set point=point1000";
  pstmt = conn.prepareStatement(sql);
  int r = pstmt.executeUpdate();
  pstmt.close();
  return r;

 }

}