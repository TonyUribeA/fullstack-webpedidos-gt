package pe.edu.galaxy.training.java.sb.fs.appbepedidos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(schema = "FSJ040323",name = "TBL_PRODUCTO")
@Entity(name = "ProductoEntity")
public class ProductoEntity {
    @Id
    @Column(name = "PRODUCTO_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProducto")
    @SequenceGenerator(sequenceName = "SEQ_PRODUCTO", allocationSize = 1, name = "seqProducto")
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "DESCRIPCION")
    private String descripcion;

    @Column(name = "STOCK_MINIMO")
    private long stockMinimo;

    @Column(name = "STOCK_MAXIMO")
    private long stockMaximo;

    @Column(name = "PRECIO")
    private Double precio;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "FECHA_VENCIMIENTO")
    private String fechaVencimiento;
}
