package pe.edu.galaxy.training.java.sb.fs.appbepedidos.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private long stockMinimo;
    private long stockMaximo;
    private Double precio;
    private String estado;
    private String fechaVencimiento;
}
