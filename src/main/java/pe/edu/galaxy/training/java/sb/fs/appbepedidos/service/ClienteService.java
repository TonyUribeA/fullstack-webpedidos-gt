package pe.edu.galaxy.training.java.sb.fs.appbepedidos.service;

import pe.edu.galaxy.training.java.sb.fs.appbepedidos.dto.ClienteDTO;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.service.exception.ServiceException;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.service.generic.GenericService;

import java.util.Optional;

public interface ClienteService extends GenericService<ClienteDTO> {
    Optional<ClienteDTO> findByRuc(String ruc) throws ServiceException;
}
