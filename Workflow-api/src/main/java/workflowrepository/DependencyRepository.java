package workflowrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import workflowentity.Dependency;

public interface DependencyRepository extends JpaRepository<Dependency, Long> {

	
}
