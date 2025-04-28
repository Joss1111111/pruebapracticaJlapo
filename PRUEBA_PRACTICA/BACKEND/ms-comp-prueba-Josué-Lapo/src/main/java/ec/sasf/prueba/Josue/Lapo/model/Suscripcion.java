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
@Table(name = "suscripciones")
public class Suscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consumidor_id", nullable = false)
    private Usuario consumidor;

    @ManyToOne
    @JoinColumn(name = "curso_id", nullable = false)
    private Curso curso;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fe_creacion", nullable = false)
    private Date feCreacion;

    @Column(nullable = false)
    private Boolean estado = true;

    public Suscripcion(Usuario consumidor, Curso curso, Date feCreacion, Long id, Boolean estado) {
        this.consumidor = consumidor;
        this.curso = curso;
        this.feCreacion = feCreacion;
        this.id = id;
        this.estado = estado;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Usuario consumidor) {
        this.consumidor = consumidor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Date getFeCreacion() {
        return feCreacion;
    }

    public void setFeCreacion(Date feCreacion) {
        this.feCreacion = feCreacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
    
}
