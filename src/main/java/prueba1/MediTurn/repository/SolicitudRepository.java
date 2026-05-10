package prueba1.MediTurn.repository;

import org.springframework.stereotype.Repository;
import prueba1.MediTurn.model.Solicitud;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SolicitudRepository {

    //memoria ram para solicitud e iniciador de id
    private List<Solicitud> listaSolicitud = new ArrayList<>();
    private int ultimoId = 0;

    //lista de todas las solicitudes
    public List<Solicitud> obtenerSolicitudes(){
        return listaSolicitud;
    }

    //Buscar por id
    public Solicitud obtenerPorId(int id){
        for (Solicitud solicitud : listaSolicitud){
            if (solicitud.getId() == id){
                return solicitud;
            }
        }
        return null;
    }

    //Guardar una solicitud
    public Solicitud guardar(Solicitud solicitud){
        ultimoId++;
        solicitud.setId(ultimoId);
        listaSolicitud.add(solicitud);
        return solicitud;
    }

    //eliminar una solicitud
    public boolean eliminar(int id){
        for(int i = 0; i < listaSolicitud.size(); i++){
            if(listaSolicitud.get(i).getId() == id){
                listaSolicitud.remove(i);
                return true;
            }
        }
        return false;
    }

    //Actualizar una solicitud
    public Solicitud actualizar(int id,Solicitud solicitud){
        for(int i = 0; i < listaSolicitud.size(); i++){
            if(listaSolicitud.get(i).getId() == id){
                solicitud.setId(id);
                listaSolicitud.set(i, solicitud);
                return solicitud;
            }
        }
        return null;
    }

    //buscar por especialidad
    public List<Solicitud> obtenerPorEspecialidad(String especialidad){
        List<Solicitud> resultado = new ArrayList<>();
        for (Solicitud solicitud : listaSolicitud){
            if (solicitud.getEspecialidad().equalsIgnoreCase(especialidad)){
                resultado.add(solicitud);
            }
        }
        return resultado;
    }

    //buscar por estado
    public List<Solicitud> obtenerPorEstado(String estado){
        List<Solicitud> resultado = new ArrayList<>();
        for (Solicitud solicitud : listaSolicitud){
            if(solicitud.getEstado().equalsIgnoreCase(estado)){
                resultado.add(solicitud);
            }
        }
        return resultado;
    }

}
