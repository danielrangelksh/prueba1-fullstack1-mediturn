package prueba1.MediTurn.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import prueba1.MediTurn.model.Solicitud;
import prueba1.MediTurn.service.SolicitudService;

import java.util.List;

@RestController
@RequestMapping("/api/solicitud")
public class SolicitudController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping
    public List<Solicitud> obtenerSolicitud(){
        return solicitudService.getSolicitudes();
    }

    @GetMapping("/{id}")
    public Solicitud obtenerSolicitudPorId(@PathVariable int id){
        return solicitudService.getSolicitudId(id);
    }

    @PostMapping
    public Solicitud guardarSolicitud(@Valid @RequestBody Solicitud solicitud){
        return solicitudService.saveSolicitud(solicitud);
    }

    @PutMapping("/{id}")
    public Solicitud actualizarSolicitud(@PathVariable int id, @Valid @RequestBody Solicitud solicitud){
        return solicitudService.updateSolicitud(id,solicitud);
    }

    @DeleteMapping("/{id}")
    public void eliminarSolicitud(@PathVariable int id){
        solicitudService.deleteSolicitud(id);
    }

    @GetMapping("/especialidad/{especialidad}")
    public List<Solicitud> obtenerPorEspecialidad(@PathVariable String especialidad){
        return solicitudService.getSolicitudesPorEspecialidad(especialidad);
    }

    @GetMapping("/estado/{estado}")
    public List<Solicitud> obtenerPorEstado(@PathVariable String estado){
        return solicitudService.getSolicitudesPorEstado(estado);
    }
}
