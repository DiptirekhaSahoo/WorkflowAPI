package workflowentity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Workflow {

	@Id
	private long id;
	private  String workflowStrid;
	private String name;
	
	@OneToMany(mappedBy ="workflow", cascade=CascadeType.ALL)
	private List<Step> steps = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getWorkflowStrid() {
		return workflowStrid;
	}

	public void setWorkflowStrid(String workflowStrid) {
		this.workflowStrid = workflowStrid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	
}
