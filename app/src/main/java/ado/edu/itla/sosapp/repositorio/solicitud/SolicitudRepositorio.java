package ado.edu.itla.sosapp.repositorio.solicitud;

import java.util.List;

import ado.edu.itla.sosapp.entidad.Solicitud;
import ado.edu.itla.sosapp.entidad.Usuario;

public interface SolicitudRepositorio  {
    void guardar(Solicitud solicitud);
    public List<Solicitud> buscarSolicitudesPor(Usuario usuario);
    public List<Solicitud> buscarSolicitudesSeleccionadas (Usuario usuario, String estadoen);
    public List<Solicitud> buscarTodos();

    Solicitud borrar(int id);

    public Solicitud buscarPor(int id);
}
