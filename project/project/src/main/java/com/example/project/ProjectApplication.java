package com.example.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		connect();
	}
	
	public static void connect() {
		String url="jdbc:mysql://localhost:3306/students";
		String user="root";
		String pass="kadirvel.D";
		
		try(Connection conn=DriverManager.getConnection(url, user, pass)){
			if(conn!=null) {
				System.out.print("Connection Succesful");
			}
		}
		catch(SQLException e)
		{
			System.out.print("Connection UnSuccesful"+e.getMessage());
		}
		
	}

}