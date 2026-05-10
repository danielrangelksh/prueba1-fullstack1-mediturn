package prueba1.MediTurn.repository;

import org.springframework.stereotype.Repository;
import prueba1.MediTurn.model.Paciente;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PacienteRepository {

    //memoria ram para lista pacientes
    private List<Paciente> listaPacientes = new ArrayList<>();

    //base de datos de pacientes predeterminada
    public PacienteRepository() {
        listaPacientes.add(new Paciente(1, "Alan Alfaro", "12345678-9", "alan@gmail.com", "932453281"));
        listaPacientes.add(new Paciente(2, "Hernan Aguirre", "32423412-4", "hernan@gmail.com", "983249123"));
        listaPacientes.add(new Paciente(3, "Fabian Ortega", "23213928-4", "Fabian@gmail.com", "938293281"));
        listaPacientes.add(new Paciente(4, "Felipe Carcamos", "20123324-4", "Felipe@gmail.com", "923842718"));
        listaPacientes.add(new Paciente(5, "Ivan Guerrera", "18239234-5", "Ivan@gmail.com", "984392819"));
        listaPacientes.add(new Paciente(6, "Dania Alfalfa", "19463273-4", "Dania@gmail.com", "938293222"));
        listaPacientes.add(new Paciente(7, "Cristopher Campos", "19463275-9", "Cristopher@gmail.com", "983293021"));
        listaPacientes.add(new Paciente(8, "Luis Guerra", "10463285-5", "Luis@gmail.com", "944293241"));
        listaPacientes.add(new Paciente(9, "Martin Uribe", "20382942-1", "Martin@gmail.com", "933923401"));
        listaPacientes.add(new Paciente(10, "Diego Soto", "19324234-k", "Diego@gmail.com", "999871627"));
    }

    //Metodo que devuelve lista de listaPacientes
    public List<Paciente> obtenerPacientes(){
        return listaPacientes;
    }

    public Paciente obtenerPorId(int id){
        for (Paciente paciente : listaPacientes){
            if (paciente.getId() == id){
                return paciente;
            }
        }
        return null;
    }

    //buscar por rut
    public Paciente obtenerPorRut(String rut){
        for (Paciente paciente : listaPacientes){
            if (paciente.getRut().equalsIgnoreCase(rut)){
                return paciente;
            }
        }
        return null;
    }

    //guardar paciente
    public Paciente guardar(Paciente paciente){
        listaPacientes.add(paciente);
        return paciente;
    }

    //actualizar paciente
    public Paciente actualizar(Paciente paciente){
        int id = 0;
        int idPosicion = 0;
        for (int i = 0; i < listaPacientes.size(); i++){
            if (listaPacientes.get(i).getId() == paciente.getId()){
                id = paciente.getId();
                idPosicion = i;
            }
        }
        Paciente paciente1 = new Paciente();
        paciente1.setId(id);
        paciente1.setRut(paciente.getRut());
        paciente1.setNombre(paciente.getNombre());
        paciente1.setCorreo(paciente.getCorreo());
        paciente1.setTelefono(paciente.getTelefono());
        listaPacientes.set(idPosicion, paciente1);
        return paciente1;
    }

    //eliminar paciente
    public void eliminar(int id){
        listaPacientes.removeIf(paciente -> paciente.getId() == id);
    }

    //listar pacientes
    public int totalPacientes(){
        return listaPacientes.size();
    }
}
