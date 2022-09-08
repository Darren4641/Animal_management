package com.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.DBDAO;

public class AnimalDAO {
	private static AnimalDAO instance = null;
	//싱글톤 정적변수
	private static DBDAO db = DBDAO.getInstance();
	
	private Connection conn = null;
	private PreparedStatement pstmt= null;
	private ResultSet rs = null;
	
	
	//싱글톤 패턴
	public static AnimalDAO getInstance() {
		if(instance == null)
			instance = new AnimalDAO();
		
		return instance;
	}
	
	//private 로 기본 생성자 차단
	private AnimalDAO() { }
	
	//회원가입
	public void save(String name, String birth, String kind, String category, String owner, String ownerPhone, String createDate) { 
		try {
			conn = DBDAO.getConnection();
			pstmt = conn.prepareStatement(Query.INSERT.getValue());
			
			pstmt.setString(1, name);
			pstmt.setString(2, birth);
			pstmt.setString(3, kind);
			pstmt.setString(4,  category);
			pstmt.setString(5,  owner);
			pstmt.setString(6,  ownerPhone);
			pstmt.setString(7,  createDate);
			
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
	
	}
	
	public AnimalDTO findById(int id) {
		AnimalDTO animal = null;
		
		try {
			conn = DBDAO.getConnection();
			pstmt = conn.prepareStatement(Query.SELECTID.getValue());
			
			pstmt.setInt(1,  id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				animal = new AnimalDTO();
				animal.setName(rs.getString("name"));
				animal.setBirth(rs.getString("birth"));
				animal.setKind(rs.getString("kind"));
				animal.setCategory(rs.getString("category"));
				animal.setOwner(rs.getString("owner"));
				animal.setOwnerPhone(rs.getString("ownerPhone"));
				animal.setCreateDate(rs.getString("createDate"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		
		return animal;
	}
	
	public List<AnimalDTO> findAll() {
		List<AnimalDTO> animalLists = null;
		try {
			conn = DBDAO.getConnection();
			pstmt = conn.prepareStatement(Query.SELECTALL.getValue());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				animalLists = new ArrayList<AnimalDTO>();
				do {
					AnimalDTO animal = new AnimalDTO();
					animal.setId(rs.getInt("id"));
					animal.setName(rs.getString("name"));
					animal.setBirth(rs.getString("birth"));
					animal.setKind(rs.getString("kind"));
					animal.setCategory(rs.getString("category"));
					animal.setOwner(rs.getString("owner"));
					animal.setOwnerPhone(rs.getString("ownerPhone"));
					animal.setCreateDate(rs.getString("createDate"));
					
					animalLists.add(animal);
				}while(rs.next());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return animalLists;
	}
	
	public List<AnimalDTO> findByNameContaining(String name) {
		List<AnimalDTO> animalLists = null;
		try {
			conn = DBDAO.getConnection();
			pstmt = conn.prepareStatement(Query.SEARCH.getValue());
			pstmt.setString(1, '%'+name+'%');
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				animalLists = new ArrayList<AnimalDTO>();
				do {
					AnimalDTO animal = new AnimalDTO();
					animal.setId(rs.getInt("id"));
					animal.setName(rs.getString("name"));
					animal.setBirth(rs.getString("birth"));
					animal.setKind(rs.getString("kind"));
					animal.setCategory(rs.getString("category"));
					animal.setOwner(rs.getString("owner"));
					animal.setOwnerPhone(rs.getString("ownerPhone"));
					animal.setCreateDate(rs.getString("createDate"));
					
					animalLists.add(animal);
				}while(rs.next());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return animalLists;
	}
	
	public List<AnimalDTO> findAllByOrderByNameAsc() {
		List<AnimalDTO> animalLists = null;
		try {
			conn = DBDAO.getConnection();
			pstmt = conn.prepareStatement(Query.ORDERBYNAME.getValue());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				animalLists = new ArrayList<AnimalDTO>();
				do {
					AnimalDTO animal = new AnimalDTO();
					animal.setId(rs.getInt("id"));
					animal.setName(rs.getString("name"));
					animal.setBirth(rs.getString("birth"));
					animal.setKind(rs.getString("kind"));
					animal.setCategory(rs.getString("category"));
					animal.setOwner(rs.getString("owner"));
					animal.setOwnerPhone(rs.getString("ownerPhone"));
					animal.setCreateDate(rs.getString("createDate"));
					
					animalLists.add(animal);
				}while(rs.next());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return animalLists;
	}
	
	public List<AnimalDTO> findAllByOrderByOwnerAsc() {
		List<AnimalDTO> animalLists = null;
		try {
			conn = DBDAO.getConnection();
			pstmt = conn.prepareStatement(Query.ORDERBYOWNER.getValue());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				animalLists = new ArrayList<AnimalDTO>();
				do {
					AnimalDTO animal = new AnimalDTO();
					animal.setId(rs.getInt("id"));
					animal.setName(rs.getString("name"));
					animal.setBirth(rs.getString("birth"));
					animal.setKind(rs.getString("kind"));
					animal.setCategory(rs.getString("category"));
					animal.setOwner(rs.getString("owner"));
					animal.setOwnerPhone(rs.getString("ownerPhone"));
					animal.setCreateDate(rs.getString("createDate"));
					
					animalLists.add(animal);
				}while(rs.next());
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return animalLists;
	}
	
	
	
	private void closeAll() {
		if(rs != null) try {rs.close();}catch(SQLException ex ) {}
		if(pstmt != null) try {pstmt.close();}catch(SQLException ex) {}
		if(conn != null) try {conn.close();}catch(SQLException ex) {}
	}
	
	
	
	
	
	
}
