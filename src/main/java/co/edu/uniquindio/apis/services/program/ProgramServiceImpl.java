package co.edu.uniquindio.apis.services.program;

import co.edu.uniquindio.apis.dtos.CommentDTO;
import co.edu.uniquindio.apis.dtos.ProgramCreateDTO;
import co.edu.uniquindio.apis.dtos.ProgramResponseDTO;
import co.edu.uniquindio.apis.model.Program;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class ProgramServiceImpl implements ProgramService {

    private List<Program> programs = new ArrayList<>();

    @Override
    public boolean createProgram(ProgramCreateDTO programCreateDTO) {
        Program program = new Program();
        program.setId(UUID.randomUUID().toString());
        program.setTitle(programCreateDTO.title());
        program.setDescription(programCreateDTO.description());
        program.setContent(programCreateDTO.content());
        //program.setCreatorId(programCreateDTO.creatorId());
        program.setComments(new ArrayList<>());
        program.setCreationDate(programCreateDTO.creationDate());
        programs.add(program);
        return true;
    }

    @Override
    public List<ProgramResponseDTO> getAllPrograms() { //puede estar ordenado por orden de creacion
        return List.of();
    }

    @Override
    public List<CommentDTO> getAllComments(String id, int offset, int limit) {
        return List.of();
    }

    @Override
    public ProgramResponseDTO getById(String id) {
        return programs.stream()
                .filter(program -> program.getId().equals(id)) // Filtra por ID
                .map(program -> new ProgramResponseDTO(
                        program.getId(),
                        program.getTitle(),
                        program.getDescription(),
                        program.getContent(),
                        program.getCreatorId(),
                        program.getComments(), // Lista de comentarios
                        program.getCreationDate()
                ))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateProgram(String id, ProgramCreateDTO programCreateDTO) {
//        Program program = getById(id);
//        if (program != null) {
//            program.setTitle(programCreateDTO.title());
//            program.setDescription(programCreateDTO.description());
//            program.setContent(programCreateDTO.content());
//            program.setCreatorId(programCreateDTO.creatorId());
//            program.setCreationDate(programCreateDTO.creationDate());
//        }
        return true;
    }

    @Override
    public boolean deleteProgram(String id) {
        return programs.removeIf(program -> program.getId().equals(id));
    }


}