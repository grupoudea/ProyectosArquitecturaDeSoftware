package co.udea.saetelbackend.repository.servicios.entity;

import javax.persistence.*;

@Entity
@Table(name = "linea_movil")
public class LineaMovil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_servicio", nullable = false)
    private Integer idServicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_servicio", insertable = false, updatable = false, nullable = false)
    private Servicio servicio;

    @Column(name = "tipo_plan")
    private String tipoPlan;

    @Column(name = "datos_megas")
    private String datosMegas;

    @Column(name = "mensajes_textos")
    private String mensajesTextos;

    @Column(name = "minutos")
    private String minutos;

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

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public String getDatosMegas() {
        return datosMegas;
    }

    public void setDatosMegas(String datosMegas) {
        this.datosMegas = datosMegas;
    }

    public String getMensajesTextos() {
        return mensajesTextos;
    }

    public void setMensajesTextos(String mensajesTextos) {
        this.mensajesTextos = mensajesTextos;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }
}
