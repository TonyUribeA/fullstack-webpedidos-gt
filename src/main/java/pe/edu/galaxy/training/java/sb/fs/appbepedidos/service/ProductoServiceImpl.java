package pe.edu.galaxy.training.java.sb.fs.appbepedidos.service;

import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.dto.ProductoDTO;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.entity.ProductoEntity;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.mappers.ProductoMapper;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.repository.ProductoRepository;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.service.exception.ServiceException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService{
    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    public ProductoServiceImpl(ProductoRepository productoRepository, ProductoMapper productoMapper) {
        this.productoRepository = productoRepository;
        this.productoMapper = productoMapper;
    }
    @Override
    public List<ProductoDTO> findByLike(ProductoDTO productoDTO) throws ServiceException {
        try {
            return productoMapper.toDTO(productoRepository.findAll());
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }
    @Override
    public Optional<ProductoDTO> findByID(Long id) throws ServiceException {
        return Optional.empty();
    }

    @Override
    public ProductoDTO save(ProductoDTO productoDTO) throws ServiceException {
        try {
            ProductoEntity productoEntity = productoRepository.save(productoMapper.toDTO(productoDTO));
            return productoMapper.toDTO(productoEntity);
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }

    @Override
    public Boolean update(ProductoDTO productoDTO) throws ServiceException {
        return null;
    }

    @Override
    public Boolean delete(ProductoDTO productoDTO) throws ServiceException {
        return null;
    }
}
