package co.edu.uniquindio.apis.services.example;

import co.edu.uniquindio.apis.dtos.ExampleCreateDTO;
import co.edu.uniquindio.apis.dtos.ExampleResponseDTO;
import co.edu.uniquindio.apis.model.Example;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ExampleService {

    private final List<Example> examples = new ArrayList<>();

    public ExampleResponseDTO createExample(ExampleCreateDTO exampleCreateDTO) {
        Example example = new Example();
        example.setId(UUID.randomUUID().toString());
        example.setTitle(exampleCreateDTO.title());
        example.setDescription(exampleCreateDTO.description());
        example.setContent(exampleCreateDTO.content());
        example.setCreatorId(exampleCreateDTO.creatorId());
        example.setTags(exampleCreateDTO.tags());
        example.setDifficulty(exampleCreateDTO.difficulty());
        example.setCreationDate(LocalDateTime.now());

        examples.add(example);

        return new ExampleResponseDTO(
                example.getId(),
                example.getTitle(),
                example.getDescription(),
                example.getContent(),
                example.getCreatorId(),
                example.getTags(),
                example.getDifficulty(),
                example.getCreationDate()
        );
    }

    public List<ExampleResponseDTO> listExamples() {
        return examples.stream()
                .map(example -> new ExampleResponseDTO(
                        example.getId(),
                        example.getTitle(),
                        example.getDescription(),
                        example.getContent(),
                        example.getCreatorId(),
                        example.getTags(),
                        example.getDifficulty(),
                        example.getCreationDate()
                ))
                .toList();
    }

    public ExampleResponseDTO getExampleById(String id) {
        return examples.stream()
                .filter(example -> example.getId().equals(id))
                .findFirst()
                .map(example -> new ExampleResponseDTO(
                        example.getId(),
                        example.getTitle(),
                        example.getDescription(),
                        example.getContent(),
                        example.getCreatorId(),
                        example.getTags(),
                        example.getDifficulty(),
                        example.getCreationDate()
                ))
                .orElse(null);
    }

    public ExampleResponseDTO updateExample(String id, ExampleCreateDTO exampleCreateDTO) {
        Example example = examples.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (example != null) {
            example.setTitle(exampleCreateDTO.title());
            example.setDescription(exampleCreateDTO.description());
            example.setContent(exampleCreateDTO.content());
            example.setTags(exampleCreateDTO.tags());
            example.setDifficulty(exampleCreateDTO.difficulty());

            return new ExampleResponseDTO(
                    example.getId(),
                    example.getTitle(),
                    example.getDescription(),
                    example.getContent(),
                    example.getCreatorId(),
                    example.getTags(),
                    example.getDifficulty(),
                    example.getCreationDate()
            );
        }

        return null;
    }

    public boolean deleteExample(String id) {
        return examples.removeIf(example -> example.getId().equals(id));
    }
}