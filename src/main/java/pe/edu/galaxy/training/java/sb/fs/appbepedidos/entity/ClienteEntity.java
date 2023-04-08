package pe.edu.galaxy.training.java.sb.fs.appbepedidos.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(schema = "FSJ040323",name = "TBL_CLIENTE")
@Entity(name = "ClienteEntity")
public class ClienteEntity {
    @Id
    @Column(name = "CLIENTE_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCliente")
    @SequenceGenerator(sequenceName = "SEQ_CLIENTE", allocationSize = 1, name = "seqCliente")
    private Long id;

    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;

    @Column(name = "RUC")
    private String ruc;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "DIRECCION")
    private String direccion;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "ESTADO")
    private String estado;
}
