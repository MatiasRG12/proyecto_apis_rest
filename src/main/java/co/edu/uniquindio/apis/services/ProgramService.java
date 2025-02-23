package co.edu.uniquindio.apis.services;

import co.edu.uniquindio.apis.model.Program;
import co.edu.uniquindio.apis.dtos.ProgramCreateDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProgramService {

    private List<Program> programs = new ArrayList<>();

    public Program createProgram(ProgramCreateDTO programCreateDTO) {
        Program program = new Program();
        program.setId(UUID.randomUUID());
        program.setTitle(programCreateDTO.title());
        program.setDescription(programCreateDTO.description());
        program.setContent(programCreateDTO.content());
        program.setCreatorId(programCreateDTO.creatorId());
        program.setComments(new ArrayList<>());
        program.setCreationDate(programCreateDTO.creationDate());
        programs.add(program);
        return program;
    }

    public List<Program> getAllPrograms(boolean orderByCreationDate) {
        if (orderByCreationDate) {
            programs.sort((p1, p2) -> p2.getCreationDate().compareTo(p1.getCreationDate()));
        }
        return programs;
    }

    public Program getProgramById(UUID id) {
        return programs.stream()
                .filter(program -> program.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Program updateProgram(UUID id, ProgramCreateDTO programCreateDTO) {
        Program program = getProgramById(id);
        if (program != null) {
            program.setTitle(programCreateDTO.title());
            program.setDescription(programCreateDTO.description());
            program.setContent(programCreateDTO.content());
            program.setCreatorId(programCreateDTO.creatorId());
            program.setCreationDate(programCreateDTO.creationDate());
        }
        return program;
    }

    public boolean deleteProgram(UUID id) {
        return programs.removeIf(program -> program.getId().equals(id));
    }
}