package practice_Serialization;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonPropertyOrder(
	value =  { "projectName",
			"createdBy",
			"status",
			"teamSize"
})

@JsonIgnoreProperties(
		value = {
				"teamSize"
		})

	
class Project{		  //POJO - Plain old java Object
	
	private String projectName;
	@JsonProperty(value = "created By") 
	private String createdBy;
	private int teamSize;
	private String status;
	private Project() {
		
	}
	public Project(String projectName, String createdBy, int teamSize, String status) {
		super();
		this.projectName = projectName;
		this.createdBy = createdBy;
		this.teamSize = teamSize;
		this.status = status;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}

public class Jackson_Ser_Test { 
	public static void main(String [] agrs) throws Throwable 
	{
		Project pObj = new Project("Apple_007", "Deepak", 0, "Created");
		
		ObjectMapper objM = new ObjectMapper();
		objM.writeValue(new File("./project.json"), pObj);
	}

}
