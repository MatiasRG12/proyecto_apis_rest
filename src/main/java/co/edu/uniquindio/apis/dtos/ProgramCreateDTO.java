package co.edu.uniquindio.apis.dtos;

public record ProgramCreateDTO(

    //id automatico
    String title,
    String description,
    String content,
    String authorId //revisar si se deja String
    //cuando se crea aun no tiene comentarios
    //fecha automatica

) {

}
