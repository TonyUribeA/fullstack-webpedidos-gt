package pe.edu.galaxy.training.java.sb.fs.appbepedidos.rest.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.dto.ProductoDTO;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.service.ProductoService;

import static java.util.Objects.isNull;
import java.util.List;

import static pe.edu.galaxy.training.java.sb.fs.appbepedidos.rest.constants.APIConstants.API_PRODUCTO;
@Slf4j
@RestController
@RequestMapping(API_PRODUCTO)
public class ProductoRest {

    private final ProductoService productoService;

    public ProductoRest(ProductoService productoService) {
        this.productoService = productoService;
    }


    @GetMapping
    public ResponseEntity<?> findByLike(){
        try {
            List<ProductoDTO> lstProductoDTO = productoService.findByLike(null);

            if(isNull(lstProductoDTO) || lstProductoDTO.isEmpty()){
                return ResponseEntity.noContent().build();
            }
                return ResponseEntity.ok(lstProductoDTO);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductoDTO productoDTO){
        try {
            ProductoDTO resProductoDTO = productoService.save(productoDTO);

            if(isNull(resProductoDTO)){
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(resProductoDTO);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
