/**
 * 
 */
package com.wenky.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wenky.model.Project;
import com.wenky.util.DbUtil;

/**
 * @author prasad
 *
 */
public class ProjectDao {
	private Connection con;
	
	/**
	 * 
	 */
	public ProjectDao() {
		con = DbUtil.getConnection();
	}
	
	public List<Project> getProjects(){
		List<Project> projects = new ArrayList<Project>();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery("select * from projects");
			while (rs.next()) {
				Project project = new Project();
				project.setId(rs.getInt("id"));
				project.setName(rs.getString("name"));
				project.setDescription(rs.getString("description"));
				project.setCost(rs.getFloat("cost"));
				project.setStartDate(rs.getDate("start_date"));
				project.setEstimatedEndDate(rs.getDate("estimated_end_date"));
				project.setDate(rs.getDate("date"));
				project.setStatus(rs.getString("status"));
				
				projects.add(project);
			}
			rs.close();
			statement.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return projects;
	}

}
