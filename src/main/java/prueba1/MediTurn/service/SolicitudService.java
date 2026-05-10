package prueba1.MediTurn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import prueba1.MediTurn.exceptions.*;
import prueba1.MediTurn.model.Paciente;
import prueba1.MediTurn.model.Solicitud;
import prueba1.MediTurn.repository.SolicitudRepository;

import java.util.List;

@Service
public class SolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;
    @Autowired
    private PacienteService pacienteService;

    public List<Solicitud> getSolicitudes(){
        List<Solicitud> listaSolicitudes = solicitudRepository.obtenerSolicitudes();
        for (Solicitud solicitud : listaSolicitudes){
            Paciente pacienteAsociado = obtenerPacienteAsociado(solicitud.getIdPaciente());
            solicitud.setNombrePaciente(pacienteAsociado.getNombre());
        }
        return listaSolicitudes;
    }

    public Solicitud saveSolicitud(Solicitud solicitud){
        Paciente pacienteAsociado = obtenerPacienteAsociado(solicitud.getIdPaciente());
        Solicitud nuevaSolicitud = solicitudRepository.guardar(solicitud);
        nuevaSolicitud.setNombrePaciente(pacienteAsociado.getNombre());
        return nuevaSolicitud;
    }

    public Solicitud getSolicitudId(int id){
        Solicitud solicitud = solicitudRepository.obtenerPorId(id);
        if(solicitud == null){
            throw new IDSolicitudNoEncontradaException("Solicitud con ID: "+id+" No encontrada");
        }
        Paciente pacienteAsociado = obtenerPacienteAsociado(solicitud.getIdPaciente());
        solicitud.setNombrePaciente(pacienteAsociado.getNombre());
        return solicitud;
    }

    public Solicitud updateSolicitud(int id, Solicitud solicitud){
        Solicitud solicitudActual = solicitudRepository.obtenerPorId(id);
        if (solicitudActual == null){
            throw new UpdateSoliNoEncontradaException("Solicitud con ID: "+id+" No encontrada");
        }
        Paciente pacienteAsociado = obtenerPacienteAsociado(solicitud.getIdPaciente());
        Solicitud solicitudActualizada = solicitudRepository.actualizar(id, solicitud);
        solicitudActualizada.setNombrePaciente(pacienteAsociado.getNombre());
        return solicitudActualizada;
    }

    public boolean deleteSolicitud(int id){
        boolean eliminado = solicitudRepository.eliminar(id);
        if(!eliminado){
            throw new IDSolicitudNoEncontradaException("Solicitud para eliminar con ID:"+id+" No encontrada");
        }
        return true;
    }

    public List<Solicitud> getSolicitudesPorEspecialidad(String especialidad){
        List<Solicitud> listaFiltrada = solicitudRepository.obtenerPorEspecialidad(especialidad);
        if(listaFiltrada.isEmpty()){
            throw new EspSolicitudNoEncontradaException("Solicitud con espcialidad: "+ especialidad+ " No encontrada");
        }
        for(Solicitud solicitud : listaFiltrada){
            Paciente p = obtenerPacienteAsociado(solicitud.getIdPaciente());
            solicitud.setNombrePaciente(p.getNombre());
        }
        return listaFiltrada;
    }

    public List<Solicitud> getSolicitudesPorEstado(String estado){
        List<Solicitud> listaFiltrada = solicitudRepository.obtenerPorEstado(estado);
        if(listaFiltrada.isEmpty()){
            throw new EstadoSoliNoEncontradaException("Solicitud con estado: "+estado+" No encontrada");
        }
        for(Solicitud solicitud : listaFiltrada){
            Paciente p = obtenerPacienteAsociado(solicitud.getIdPaciente());
            solicitud.setNombrePaciente(p.getNombre());
        }
        return listaFiltrada;
    }

    private Paciente obtenerPacienteAsociado(int idPaciente) {
        try {
            return pacienteService.getById(idPaciente);
        } catch (ResponseStatusException ex) {
            throw new PacSoliNoEncontradoException("Solicitud con idPaciente: "+ idPaciente+" No encontrada");
        }
    }

}
