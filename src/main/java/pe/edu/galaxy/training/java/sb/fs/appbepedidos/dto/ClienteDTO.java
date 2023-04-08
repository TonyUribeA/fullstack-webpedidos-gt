package pe.edu.galaxy.training.java.sb.fs.appbepedidos.dto;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long id;
    private String razonSocial;
    private String ruc;
    private String correo;
    private String direccion;
    private String telefono;
    private String estado;
}
