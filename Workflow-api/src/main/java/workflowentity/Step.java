package workflowentity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Step {
	
	@Id
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStepStrId() {
		return stepStrId;
	}

	public void setStepStrId(String stepStrId) {
		this.stepStrId = stepStrId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Workflow getWorkflow() {
		return workflow;
	}

	public void setWorkflow(Workflow workflow) {
		this.workflow = workflow;
	}

	private String stepStrId;
	private String description;
	
	@ManyToOne
	private Workflow workflow;

}
