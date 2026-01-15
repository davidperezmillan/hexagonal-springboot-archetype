package ${package}.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataSampleRepository extends JpaRepository<SampleEntity, Long> {
}
