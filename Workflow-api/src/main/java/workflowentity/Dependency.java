package workflowentity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Dependency {
	@Id
	private Long id;
	@ManyToOne
	private Step step;
	@ManyToOne
	private Step prerequisiteStep;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Step getStep() {
		return step;
	}
	public void setStep(Step step) {
		this.step = step;
	}
	public Step getPrerequisiteStep() {
		return prerequisiteStep;
	}
	public void setPrerequisiteStep(Step prerequisiteStep) {
		this.prerequisiteStep = prerequisiteStep;
	}
	

}
