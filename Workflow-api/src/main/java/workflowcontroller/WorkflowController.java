package workflowcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import workflowentity.Dependency;
import workflowentity.Step;
import workflowentity.Workflow;
import workflowrepository.DependencyRepository;
import workflowrepository.StepRepository;
import workflowrepository.WorkflowRepository;

import java.util.*;

@RestController
@RequestMapping("/workflows")

public class WorkflowController {

	
	

	    @Autowired private WorkflowRepository workflowRepo;
	    @Autowired private StepRepository stepRepo;
	    @Autowired private DependencyRepository depRepo;

	    @PostMapping
	    public ResponseEntity<?> createWorkflow(@RequestBody Map<String, String> body) {
	        Workflow wf = new Workflow();
	        wf.setWorkflowStrid(body.get("workflow_str_id"));
	        wf.setName(body.get("name"));
	        workflowRepo.save(wf);

	        return ResponseEntity.ok(Map.of(
	                "internal_db_id", wf.getId(),
	                "workflow_str_id", wf.getWorkflowStrid(),
	                "status", "created"
	        ));
	    }

	    @PostMapping("/{workflowId}/steps")
	    public ResponseEntity<?> addStep(@PathVariable String workflowId, @RequestBody Map<String, String> body) {
	        Workflow workflow = workflowRepo.findByWorkflowStr(workflowId)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Workflow not found"));

	        Step step = new Step();
	        step.setStepStrId(body.get("step_str_id"));
	        step.setDescription(body.get("description"));
	        step.setWorkflow(workflow);
	        stepRepo.save(step);

	        return ResponseEntity.ok(Map.of(
	                "internal_db_id", step.getId(),
	                "step_str_id", step.getStepStrId(),
	                "status", "step_added"
	        ));
	    }

	    @PostMapping("/{workflowId}/dependencies")
	    public ResponseEntity<?> addDependency(@PathVariable String workflowId, @RequestBody Map<String, String> body) {
	        Workflow workflow = workflowRepo.findByWorkflowStr(workflowId)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Workflow not found"));

	        Step step = stepRepo.findByStepStridAndWorkflow(body.get("step_str_id"), workflow)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Step not found"));
	        Step prereq = stepRepo.findByStepStridAndWorkflow(body.get("prerequisite_step_str_id"), workflow)
	                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Prerequisite step not found"));

	        Dependency dep = new Dependency();
	        dep.setStep(step);
	        dep.setPrerequisiteStep(prereq);
	        depRepo.save(dep);

	        return ResponseEntity.ok(Map.of("status", "dependency_added"));
	    }
	}

