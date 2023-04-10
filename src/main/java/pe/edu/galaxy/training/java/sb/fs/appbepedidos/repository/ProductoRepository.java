package pe.edu.galaxy.training.java.sb.fs.appbepedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.entity.ProductoEntity;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {

    //JPQL
    @Query(value = "select p from ProductoEntity p where upper(p.nombre) like upper(:nombre) and p.estado = '1' ")
    List<ProductoEntity> findByLikeNombre(@Param("nombre")String nombre);
}
