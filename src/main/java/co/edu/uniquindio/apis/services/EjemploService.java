package co.edu.uniquindio.apis.services;

import co.edu.uniquindio.apis.dtos.EjemploCreateDTO;
import co.edu.uniquindio.apis.dtos.EjemploResponseDTO;
import co.edu.uniquindio.apis.model.Ejemplo;
import jakarta.enterprise.context.ApplicationScoped;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class EjemploService {

    private final List<Ejemplo> ejemplos = new ArrayList<>();

    public EjemploResponseDTO crearEjemplo(EjemploCreateDTO ejemploCreateDTO) {
        Ejemplo ejemplo = new Ejemplo();
        ejemplo.setId(UUID.randomUUID());
        ejemplo.setTitulo(ejemploCreateDTO.titulo());
        ejemplo.setDescripcion(ejemploCreateDTO.descripcion());
        ejemplo.setContenido(ejemploCreateDTO.contenido());
        ejemplo.setIdCreador(UUID.fromString(ejemploCreateDTO.idCreador()));
        ejemplo.setTags(ejemploCreateDTO.tags());
        ejemplo.setDificultad(ejemploCreateDTO.dificultad());
        ejemplo.setFechaCreacion(LocalDateTime.now());

        ejemplos.add(ejemplo);

        return new EjemploResponseDTO(
                ejemplo.getId().toString(),
                ejemplo.getTitulo(),
                ejemplo.getDescripcion(),
                ejemplo.getContenido(),
                ejemplo.getIdCreador().toString(),
                ejemplo.getTags(),
                ejemplo.getDificultad(),
                ejemplo.getFechaCreacion()
        );
    }

    public List<EjemploResponseDTO> listaEjemplos() {
        return ejemplos.stream()
                .map(ejemplo -> new EjemploResponseDTO(
                        ejemplo.getId().toString(),
                        ejemplo.getTitulo(),
                        ejemplo.getDescripcion(),
                        ejemplo.getContenido(),
                        ejemplo.getIdCreador().toString(),
                        ejemplo.getTags(),
                        ejemplo.getDificultad(),
                        ejemplo.getFechaCreacion()
                ))
                .toList();
    }

    public EjemploResponseDTO obtenerEjemploPorId(String id) {
        return ejemplos.stream()
                .filter(ejemplo -> ejemplo.getId().toString().equals(id))
                .findFirst()
                .map(ejemplo -> new EjemploResponseDTO(
                        ejemplo.getId().toString(),
                        ejemplo.getTitulo(),
                        ejemplo.getDescripcion(),
                        ejemplo.getContenido(),
                        ejemplo.getIdCreador().toString(),
                        ejemplo.getTags(),
                        ejemplo.getDificultad(),
                        ejemplo.getFechaCreacion()
                ))
                .orElse(null);
    }

    public EjemploResponseDTO actualizarEjemplo(String id, EjemploCreateDTO ejemploCreateDTO) {
        Ejemplo ejemplo = ejemplos.stream()
                .filter(e -> e.getId().toString().equals(id))
                .findFirst()
                .orElse(null);

        if (ejemplo != null) {
            ejemplo.setTitulo(ejemploCreateDTO.titulo());
            ejemplo.setDescripcion(ejemploCreateDTO.descripcion());
            ejemplo.setContenido(ejemploCreateDTO.contenido());
            ejemplo.setTags(ejemploCreateDTO.tags());
            ejemplo.setDificultad(ejemploCreateDTO.dificultad());

            return new EjemploResponseDTO(
                    ejemplo.getId().toString(),
                    ejemplo.getTitulo(),
                    ejemplo.getDescripcion(),
                    ejemplo.getContenido(),
                    ejemplo.getIdCreador().toString(),
                    ejemplo.getTags(),
                    ejemplo.getDificultad(),
                    ejemplo.getFechaCreacion()
            );
        }

        return null;
    }

    public boolean eliminarEjemplo(String id) {
        return ejemplos.removeIf(ejemplo -> ejemplo.getId().toString().equals(id));
    }
}