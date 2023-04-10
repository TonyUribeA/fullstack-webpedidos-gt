package pe.edu.galaxy.training.java.sb.fs.appbepedidos.service;

import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.dto.ClienteDTO;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.entity.ClienteEntity;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.mappers.ClienteMapper;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.repository.ClienteRepository;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }
    @Override
    public List<ClienteDTO> findByLike(ClienteDTO clienteDTO) throws ServiceException {
        try {
            return clienteMapper.toDTO(clienteRepository.findAll());
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }

    @Override
    public Optional<ClienteDTO> findByID(Long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) throws ServiceException {
        try {
            ClienteEntity clienteEntity = clienteRepository.save(clienteMapper.toDTO(clienteDTO));
            return clienteMapper.toDTO(clienteEntity);
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }

    @Override
    public Boolean update(ClienteDTO clienteDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(ClienteDTO clienteDTO) throws ServiceException {
        return null;
    }

    @Override
    public Optional<ClienteDTO> findByRuc(String ruc) throws ServiceException {
        try {
            Optional<ClienteEntity> optionalClienteEntity = clienteRepository.findByRuc(ruc);
            if(optionalClienteEntity.isPresent()) {
                return Optional.ofNullable(clienteMapper.toDTO(optionalClienteEntity.get()));
            }
            return Optional.empty();

        }catch (Exception e){
            throw new ServiceException(e);
        }
    }
}
