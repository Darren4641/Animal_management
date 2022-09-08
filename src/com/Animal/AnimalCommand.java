package com.Animal;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AnimalCommand {
	int execute(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
