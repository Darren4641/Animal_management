package com.Animal;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnimalFindCommand implements AnimalCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		AnimalDAO animalDAO = AnimalDAO.getInstance();
		String name = request.getParameter("name");
		List<AnimalDTO> lists = animalDAO.findByNameContaining(name);
		request.setAttribute("list", lists);
		
		return 1;
	}

}
