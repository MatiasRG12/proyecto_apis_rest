package co.edu.uniquindio.apis.services.impl;

import co.edu.uniquindio.apis.dtos.CommentDTO;
import co.edu.uniquindio.apis.dtos.ProgramCreateDTO;
import co.edu.uniquindio.apis.dtos.ProgramResponseDTO;
import co.edu.uniquindio.apis.services.ProgramService;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class ProgramServiceImpl implements ProgramService {

    @Override
    public Object createProgram(ProgramCreateDTO programCreateDTO) {
        return null;
    }

    @Override
    public List<ProgramResponseDTO> getAllPrograms() {
        return List.of();
    }

    @Override
    public List<CommentDTO> getAllComments(String id, int offset, int limit) {
        return List.of();
    }

    @Override
    public ProgramResponseDTO getById(String id) {
        return null;
    }

    @Override
    public Object updateProgram(String id, ProgramCreateDTO programCreateDTO) {
        return null;
    }

    @Override
    public Object deleteProgram(String id) {
        return null;
    }


}
