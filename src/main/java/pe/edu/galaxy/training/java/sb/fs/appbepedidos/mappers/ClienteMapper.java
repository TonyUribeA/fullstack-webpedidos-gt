package pe.edu.galaxy.training.java.sb.fs.appbepedidos.mappers;

import org.mapstruct.Mapper;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.dto.ClienteDTO;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.entity.ClienteEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    List<ClienteDTO> toDTO(List<ClienteEntity> lstEntity);
    ClienteEntity toDTO(ClienteDTO dto);
    ClienteDTO toDTO(ClienteEntity entity);
}
