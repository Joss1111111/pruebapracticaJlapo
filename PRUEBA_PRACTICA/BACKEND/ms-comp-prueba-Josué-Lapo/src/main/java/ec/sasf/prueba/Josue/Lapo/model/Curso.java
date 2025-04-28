package ec.sasf.prueba.Josue.Lapo.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private String estado; // EN_CONSTRUCCION, ACTIVO, INACTIVO

    @ManyToOne
    @JoinColumn(name = "creador_id", nullable = false)
    private Usuario creador;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fe_creacion", nullable = false)
    private Date feCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fe_actualizacion")
    private Date feActualizacion;

    public Curso() {
    }

    public Curso(Usuario creador, String descripcion, String estado, Date feActualizacion, Date feCreacion, Long id, String titulo) {
        this.creador = creador;
        this.descripcion = descripcion;
        this.estado = estado;
        this.feActualizacion = feActualizacion;
        this.feCreacion = feCreacion;
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public Date getFeCreacion() {
        return feCreacion;
    }

    public void setFeCreacion(Date feCreacion) {
        this.feCreacion = feCreacion;
    }

    public Date getFeActualizacion() {
        return feActualizacion;
    }

    public void setFeActualizacion(Date feActualizacion) {
        this.feActualizacion = feActualizacion;
    }

    
}