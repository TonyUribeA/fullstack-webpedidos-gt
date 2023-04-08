package pe.edu.galaxy.training.java.sb.fs.appbepedidos.service.generic;

import pe.edu.galaxy.training.java.sb.fs.appbepedidos.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

public interface GenericService<T> {
    List<T> findByLike(T t) throws ServiceException;
    Optional<T> findByID(Long id) throws ServiceException;
    T save(T t) throws ServiceException;
    Boolean update(T t) throws ServiceException;
    Boolean delete(T t) throws ServiceException;
}
