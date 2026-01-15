package ${package}.infrastructure.adapter.in.rest;

import ${package}.domain.model.SampleAggregate;
import ${package}.domain.port.in.SampleUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/samples")
public class SampleController {

    private final SampleUseCase sampleUseCase;

    public SampleController(SampleUseCase sampleUseCase) {
        this.sampleUseCase = sampleUseCase;
    }

    @PostMapping
    public ResponseEntity<SampleAggregate> createSample(@RequestBody CreateSampleRequest request) {
        SampleAggregate sample = sampleUseCase.createSample(request.getName());
        return ResponseEntity.ok(sample);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SampleAggregate> getSample(@PathVariable Long id) {
        return sampleUseCase.getSampleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<SampleAggregate>> getAllSamples() {
        List<SampleAggregate> samples = sampleUseCase.getAllSamples();
        return ResponseEntity.ok(samples);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SampleAggregate> updateSample(@PathVariable Long id, @RequestBody UpdateSampleRequest request) {
        SampleAggregate sample = sampleUseCase.updateSample(id, request.getName());
        return ResponseEntity.ok(sample);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSample(@PathVariable Long id) {
        sampleUseCase.deleteSample(id);
        return ResponseEntity.noContent().build();
    }

    public static class CreateSampleRequest {
        private String name;

        public CreateSampleRequest() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class UpdateSampleRequest {
        private String name;

        public UpdateSampleRequest() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
