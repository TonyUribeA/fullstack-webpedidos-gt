package pe.edu.galaxy.training.java.sb.fs.appbepedidos.rest.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.dto.ClienteDTO;
import pe.edu.galaxy.training.java.sb.fs.appbepedidos.service.ClienteService;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static pe.edu.galaxy.training.java.sb.fs.appbepedidos.rest.constants.APIConstants.API_CLIENTES;

@Slf4j
@RestController
@RequestMapping(API_CLIENTES)
public class ClienteRest {
    private final ClienteService clienteService;

    public ClienteRest(ClienteService clienteService) {
        this.clienteService = clienteService;
    }


    @GetMapping
    public ResponseEntity<?> findByLike(){
        try {
            List<ClienteDTO> lstClienteDTO = clienteService.findByLike(null);

            if(isNull(lstClienteDTO) || lstClienteDTO.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(lstClienteDTO);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
    @GetMapping("/by-RUC")
    public ResponseEntity<?> findByRuc(@RequestParam(name = "ruc", defaultValue = "")String ruc){
        try {

            Optional<ClienteDTO> optionalClienteDTO = clienteService.findByRuc(ruc);

            if(isNull(optionalClienteDTO) || optionalClienteDTO.isEmpty()){
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(optionalClienteDTO);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClienteDTO clienteDTO){
        try {
            ClienteDTO resClienteDTO = clienteService.save(clienteDTO);

            if(isNull(resClienteDTO)){
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(resClienteDTO);
        }catch (Exception e){
            log.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }
}
