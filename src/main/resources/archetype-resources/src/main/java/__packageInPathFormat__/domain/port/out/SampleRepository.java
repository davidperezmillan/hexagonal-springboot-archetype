package ${package}.domain.port.out;

import ${package}.domain.model.SampleAggregate;

import java.util.List;
import java.util.Optional;

public interface SampleRepository {

    SampleAggregate save(SampleAggregate sample);

    Optional<SampleAggregate> findById(Long id);

    List<SampleAggregate> findAll();

    void deleteById(Long id);

}
