package workflowrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import workflowentity.Step;
import workflowentity.Workflow;

public interface StepRepository extends JpaRepository<Step, Long> {
	Optional<Step>findByStepStridAndWorkflow(String stepStrid, Workflow workflow);

}
