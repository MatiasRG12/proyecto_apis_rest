package co.edu.uniquindio.apis.services.example;

import co.edu.uniquindio.apis.dtos.ExampleCreateDTO;
import co.edu.uniquindio.apis.dtos.ExampleResponseDTO;
import co.edu.uniquindio.apis.model.Example;
import co.edu.uniquindio.apis.repositories.example.ExampleRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ExampleServiceImpl implements ExampleService {

    @Inject
    ExampleRepository exampleRepository;

    @Override
    @Transactional
    public ExampleResponseDTO createExample(ExampleCreateDTO exampleCreateDTO) {
        Example example = new Example();
        example.setTitle(exampleCreateDTO.title());
        example.setDescription(exampleCreateDTO.description());
        example.setContent(exampleCreateDTO.content());
        example.setCreatorId(exampleCreateDTO.creatorId());
        example.setTags(exampleCreateDTO.tags());
        example.setDifficulty(exampleCreateDTO.difficulty());
        example.setCreationDate(LocalDateTime.now());

        exampleRepository.persist(example);

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

    @Override
    public List<ExampleResponseDTO> listExamples() {
        return exampleRepository.listAll().stream()
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
                .collect(Collectors.toList());
    }

    @Override
    public ExampleResponseDTO getExampleById(Long id) {
        Example example = exampleRepository.findById(id);
        if (example != null) {
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

    @Override
    @Transactional
    public ExampleResponseDTO updateExample(Long id, ExampleCreateDTO exampleCreateDTO) {
        Example example = exampleRepository.findById(id);
        if (example != null) {
            example.setTitle(exampleCreateDTO.title());
            example.setDescription(exampleCreateDTO.description());
            example.setContent(exampleCreateDTO.content());
            example.setTags(exampleCreateDTO.tags());
            example.setDifficulty(exampleCreateDTO.difficulty());

            exampleRepository.persist(example);

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

    @Override
    @Transactional
    public boolean deleteExample(Long id) {
        return exampleRepository.deleteById(id);
    }
}