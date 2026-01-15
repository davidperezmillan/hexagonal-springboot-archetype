package ${package}.infrastructure.adapter.out.persistence;

import ${package}.domain.model.SampleAggregate;
import ${package}.domain.port.out.SampleRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaSampleRepository implements SampleRepository {

    private final SpringDataSampleRepository springDataSampleRepository;

    public JpaSampleRepository(SpringDataSampleRepository springDataSampleRepository) {
        this.springDataSampleRepository = springDataSampleRepository;
    }

    @Override
    public SampleAggregate save(SampleAggregate sample) {
        SampleEntity entity = toEntity(sample);
        SampleEntity savedEntity = springDataSampleRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<SampleAggregate> findById(Long id) {
        return springDataSampleRepository.findById(id).map(this::toDomain);
    }

    @Override
    public List<SampleAggregate> findAll() {
        return springDataSampleRepository.findAll().stream().map(this::toDomain).toList();
    }

    @Override
    public void deleteById(Long id) {
        springDataSampleRepository.deleteById(id);
    }

    private SampleEntity toEntity(SampleAggregate sample) {
        SampleEntity entity = new SampleEntity();
        entity.setId(sample.getId());
        entity.setName(sample.getName());
        return entity;
    }

    private SampleAggregate toDomain(SampleEntity entity) {
        return new SampleAggregate(entity.getId(), entity.getName());
    }

}
