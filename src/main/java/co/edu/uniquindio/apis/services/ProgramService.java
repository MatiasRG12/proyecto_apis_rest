package co.edu.uniquindio.apis.services;

import co.edu.uniquindio.apis.dtos.CommentDTO;
import co.edu.uniquindio.apis.dtos.ProgramCreateDTO;
import co.edu.uniquindio.apis.dtos.ProgramResponseDTO;

import java.util.List;

public interface ProgramService {
    Object createProgram(ProgramCreateDTO programCreateDTO);

    List<ProgramResponseDTO> getAllPrograms();

    List<CommentDTO> getAllComments(String id, int offset, int limit);
    
    ProgramResponseDTO getById(String id);


    Object updateProgram(String id, ProgramCreateDTO programCreateDTO);

    Object deleteProgram(String id);
}
