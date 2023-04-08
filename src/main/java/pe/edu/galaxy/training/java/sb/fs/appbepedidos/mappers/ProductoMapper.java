package pe.edu.galaxy.training.java.sb.fs.appbepedidos.mappers;

import org.mapstruct.Mapper;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.dto.ProductoDTO;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.entity.ProductoEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    List<ProductoDTO> toDTO(List<ProductoEntity> lstEntity);
    ProductoEntity toDTO(ProductoDTO dto);
    ProductoDTO toDTO(ProductoEntity entity);
}
