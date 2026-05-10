package prueba1.MediTurn.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    private int id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "El rut es obligatorio")
    private String rut;

    @NotBlank(message = "El correo es obligatorio")
    private String correo;

    @NotBlank(message = "El telefono es obligatorio")
    private String telefono;
}
