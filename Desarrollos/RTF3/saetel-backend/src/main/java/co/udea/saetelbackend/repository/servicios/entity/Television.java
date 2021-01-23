package co.udea.saetelbackend.repository.servicios.entity;

import javax.persistence.*;

@Entity
@Table(name = "television")
public class Television {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_servicio", nullable = false)
    private Integer idServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_servicio", insertable = false, updatable = false, nullable = false)
    private Servicio servicio;

    @Column(name = "cantidad_canales")
    private Integer cantidadCanales;

    @Column(name = "calidad")
    private String calidad;

    @Column(name = "cantidad_decodificadores")
    private Integer cantidadDecodificadores;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Integer getCantidadCanales() {
        return cantidadCanales;
    }

    public void setCantidadCanales(Integer cantidadCanales) {
        this.cantidadCanales = cantidadCanales;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public Integer getCantidadDecodificadores() {
        return cantidadDecodificadores;
    }

    public void setCantidadDecodificadores(Integer cantidadDecodificadores) {
        this.cantidadDecodificadores = cantidadDecodificadores;
    }
}
