package com.cedge;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String filePath = "D://user.txt"; // Replace with the actual file path

		try {

			File file = new File(filePath);
			if (!file.exists()) {
				throw new FileNotFoundException("File not found: " + filePath);
			}

			try (PrintWriter writer = new PrintWriter(
					new FileWriter(file, true))) {
				// Save data to the text file
				String firstName = request.getParameter("fname");
				String lastName = request.getParameter("lname");
				String gender = request.getParameter("gender");
				String caste = request.getParameter("caste");
				String email = request.getParameter("email");

				writer.println("Firstname: " + firstName);
				writer.println("LastName: " + lastName);
				writer.println("Gender: " + gender);
				writer.println("Caste: " + caste);
				writer.println("Email: " + email);

				writer.println();
			}

			
			request.setAttribute("successMessage", "User registered successfully");

			
			request.getRequestDispatcher("successMessage.jsp").include(request, response);
		} catch (FileNotFoundException e) {
			// File not found exception
			e.printStackTrace();
			request.setAttribute("errorMessage",
					"File not found: " + e.getMessage());
			request.getRequestDispatcher("exception.jsp").forward(request,
					response);
		} catch (IOException e) {
			// Other IO exception
			e.printStackTrace();
			request.setAttribute("errorMessage",
					"Error writing to file: " + e.getMessage());
			request.getRequestDispatcher("exception.jsp").forward(request,
					response);
		}

	}
}
