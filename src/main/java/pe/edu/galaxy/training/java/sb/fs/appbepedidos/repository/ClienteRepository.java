package pe.edu.galaxy.training.java.sb.fs.appbepedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.entity.ClienteEntity;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    @Query(value = "select r from ClienteEntity r where r.ruc = :ruc")
    Optional<ClienteEntity> findByRuc(@Param("ruc")String ruc);
}
