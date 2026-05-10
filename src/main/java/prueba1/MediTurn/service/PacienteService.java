package prueba1.MediTurn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import prueba1.MediTurn.exceptions.IDPacienteNoEncontradoException;
import prueba1.MediTurn.exceptions.PacienteDuplicadoException;
import prueba1.MediTurn.exceptions.RUTPacienteNoEncontradoException;
import prueba1.MediTurn.exceptions.UpdatePacNoEncontradoException;
import prueba1.MediTurn.model.Paciente;
import prueba1.MediTurn.repository.PacienteRepository;

import java.util.List;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<Paciente> getPacientes(){
        return pacienteRepository.obtenerPacientes();
    }

    public Paciente getById(int id){
        Paciente paciente = pacienteRepository.obtenerPorId(id);
        if(paciente == null){
            throw new IDPacienteNoEncontradoException("Paciente con ID: "+id+" No encontrado");
        }
        return paciente;
    }

    public Paciente getByRut(String rut){
        Paciente paciente = pacienteRepository.obtenerPorRut(rut);
        if(paciente == null){
            throw new RUTPacienteNoEncontradoException("Paciente con el RUT: "+ rut + " No encontrado");
        }
        return paciente;
    }

    public Paciente savePaciente(Paciente paciente){
        Paciente pacienteExistente = pacienteRepository.obtenerPorRut(paciente.getRut());
        if(pacienteExistente != null){
            throw new PacienteDuplicadoException("Paciente Duplicado");
        }
        return pacienteRepository.guardar(paciente);
    }

    public Paciente updatePaciente(int id, Paciente paciente){
        Paciente pacienteActual = pacienteRepository.obtenerPorId(paciente.getId());
        if(pacienteActual == null){
            throw new UpdatePacNoEncontradoException("Paciente no encontrado");
        }
        Paciente pacienteConMismoRut = pacienteRepository.obtenerPorRut(paciente.getRut());
        if(pacienteConMismoRut == null){
            throw new UpdatePacNoEncontradoException("Paciente no encontrado");
        }
        return pacienteRepository.guardar(paciente);
    }

    public void deletePaciente(int id){
        Paciente paciente = pacienteRepository.obtenerPorId(id);
        if(paciente == null){
            throw new IDPacienteNoEncontradoException("Paciente con ID: "+id+" No encontrado");
        }
        pacienteRepository.eliminar(id);
    }
}
