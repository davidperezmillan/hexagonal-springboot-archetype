package ${package}.domain.service;

import ${package}.domain.model.SampleAggregate;
import ${package}.domain.port.in.SampleUseCase;
import ${package}.domain.port.out.SampleRepository;

import java.util.List;
import java.util.Optional;

public class SampleService implements SampleUseCase {

    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    @Override
    public SampleAggregate createSample(String name) {
        SampleAggregate sample = new SampleAggregate();
        sample.setName(name);
        return sampleRepository.save(sample);
    }

    @Override
    public Optional<SampleAggregate> getSampleById(Long id) {
        return sampleRepository.findById(id);
    }

    @Override
    public List<SampleAggregate> getAllSamples() {
        return sampleRepository.findAll();
    }

    @Override
    public SampleAggregate updateSample(Long id, String name) {
        Optional<SampleAggregate> optionalSample = sampleRepository.findById(id);
        if (optionalSample.isPresent()) {
            SampleAggregate sample = optionalSample.get();
            sample.setName(name);
            return sampleRepository.save(sample);
        } else {
            throw new RuntimeException("Sample not found");
        }
    }

    @Override
    public void deleteSample(Long id) {
        sampleRepository.deleteById(id);
    }

}
