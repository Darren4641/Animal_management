package com.Animal;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnimalListCommand implements AnimalCommand{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
		AnimalDAO animalDAO = AnimalDAO.getInstance();
		List<AnimalDTO> lists = animalDAO.findAll();
		request.setAttribute("list", lists);
		
		return 1;
	}

}
