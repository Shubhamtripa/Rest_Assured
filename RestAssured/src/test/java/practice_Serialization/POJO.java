package practice_Serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project2{

	   String projectName;
	   String projectStatus;
	   List<String> teamMember;
	   ProjectManager projectManager;

	    public Project2(String projectName, String projectStatus, List<String> teamMember, ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectStatus = projectStatus;
		this.teamMember = teamMember;
		this.projectManager = projectManager;
	}
	    
		public void setProjectName(String projectName) {
	        this.projectName = projectName;
	    }
	    public String getProjectName() {
	        return projectName;
	    }
	    
	    public void setProjectStatus(String projectStatus) {
	        this.projectStatus = projectStatus;
	    }
	    public String getProjectStatus() {
	        return projectStatus;
	    }
	    
	    public void setTeamMember(List<String> teamMember) {
	        this.teamMember = teamMember;
	    }
	    public List<String> getTeamMember() {
	        return teamMember;
	    }
	    
	    public void setProjectManager(ProjectManager projectManager) {
	        this.projectManager = projectManager;
	    }
	    public ProjectManager getProjectManager() {
	        return projectManager;
	    }
	    
	}

class ProjectManager {

  String name;
  String id;

   public ProjectManager(String name, String id) {
	super();
	this.name = name;
	this.id = id;
}
   
public void setName(String name) {
       this.name = name;
   }
   public String getName() {
       return name;
   }
   
   public void setId(String id) {
       this.id = id;
   }
   public String getId() {
       return id;
   }
   
}

public class POJO{
	public static void main(String [] args) throws StreamWriteException, DatabindException, IOException {
		List<String> lst =new ArrayList<String>();
		lst.add("John");
		lst.add("David");
		lst.add("Steve");
		
		ProjectManager pm = new ProjectManager("Sagar", "tp01");
		Project2 pObj = new Project2("Apple", "Completed", lst, pm);
		
		System.out.println(pObj.projectName);
		
		ObjectMapper objM = new ObjectMapper();
		objM.writeValue(new File("./Project1.json"), pObj);
	}
}
