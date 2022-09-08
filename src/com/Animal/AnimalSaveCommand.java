package com.Animal;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnimalSaveCommand implements AnimalCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		sdf.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
		String name = request.getParameter("name");
		String birth = request.getParameter("birth");
		String kind = request.getParameter("kind");
		String category = request.getParameter("category");
		String owner = request.getParameter("owner");
		String ownerPhone = request.getParameter("ownerPhone");
		String createDate = sdf.format(new Timestamp(System.currentTimeMillis()));
		
		AnimalDAO animalDAO = AnimalDAO.getInstance();
		animalDAO.save(name, birth, kind, category, owner, ownerPhone, createDate);
		PrintWriter writer = response.getWriter();
		writer.println("<script>alert('동물이 추가되었습니다.'); location.href='list.do';</script>");
		writer.close();
		
		return 1;
		
	}

}
