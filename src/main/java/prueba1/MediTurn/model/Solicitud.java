package prueba1.MediTurn.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Solicitud {

    private int id;

    @Min(value = 1, message = "Debe ingresar un ID de paciente válido.")
    private int idPaciente;

    private String nombrePaciente;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @NotBlank(message = "Ingresar un estado es obligatorio")
    private String estado;

    @Min(value = 2025, message = "El año ingresado debe ser mayor a 2025")
    @Max(value = 2026, message = "El año ingresado debe ser menos o igual a 2026")
    private int fechaRegistro;
}
