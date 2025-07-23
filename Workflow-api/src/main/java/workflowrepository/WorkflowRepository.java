package workflowrepository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import workflowentity.Workflow;

public interface WorkflowRepository extends JpaRepository<Workflow, Long> {
	
Optional<Workflow> findByWorkflowStr(String workflowStrid);


}
