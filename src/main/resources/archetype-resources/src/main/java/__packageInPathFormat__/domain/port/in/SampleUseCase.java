package ${package}.domain.port.in;

import ${package}.domain.model.SampleAggregate;

import java.util.List;
import java.util.Optional;

public interface SampleUseCase {

    SampleAggregate createSample(String name);

    Optional<SampleAggregate> getSampleById(Long id);

    List<SampleAggregate> getAllSamples();

    SampleAggregate updateSample(Long id, String name);

    void deleteSample(Long id);

}
