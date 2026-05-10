package prueba1.MediTurn.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prueba1.MediTurn.model.Paciente;
import prueba1.MediTurn.service.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> listaPacientes(){
        return pacienteService.getPacientes();
    }

    @GetMapping("/{id}")
    public Paciente obtenerPorId(@PathVariable int id){
        return pacienteService.getById(id);
    }

    @GetMapping("/rut/{rut}")
    public Paciente obtenerPorRut(@PathVariable String rut){
        return pacienteService.getByRut(rut);
    }

    @PostMapping
    public String savePaciente(@Valid @RequestBody Paciente paciente){
        pacienteService.savePaciente(paciente);
        return "Paciente guardado correctamente";
    }

    @PutMapping("/{id}")
    public Paciente updatePaciente(@PathVariable int id, @Valid @RequestBody Paciente paciente){
        return pacienteService.updatePaciente(id, paciente);
    }

    @DeleteMapping("/{id}")
    public void deletePaciente(@PathVariable int id){
        pacienteService.deletePaciente(id);
    }

}
