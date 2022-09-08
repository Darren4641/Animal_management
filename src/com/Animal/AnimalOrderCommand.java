package com.Animal;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnimalOrderCommand implements AnimalCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		AnimalDAO animalDAO = AnimalDAO.getInstance();
		String code = request.getParameter("code");
		List<AnimalDTO> lists = null;
		
		if(code.equals("name"))
			lists = animalDAO.findAllByOrderByNameAsc();
		else if(code.equals("owner"))
			lists = animalDAO.findAllByOrderByOwnerAsc();
		
		request.setAttribute("list", lists);
		
		return 1;
	}

}
