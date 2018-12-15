package com.cenfotec.localogistica.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "paquetes")
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_paquete")
    private Long idPaquete;

    @Column(name="num_cuenta_consignatario")
    private int numCuentaCosignatario;

    @Column(name="nombre_consignatario")
    private String nombreConsignatario;

    @Column(name="fecha_hora")
    private Date fechaHora;

    @Column(name="id_courier")
    private int idCourier;

    @Column(name="courier_nombre")
    private String courierNombre;

    @Column(name="vuelo_destino")
    private String vueloDestino;

    public Paquete(){

    }

    public Paquete(int numCuentaCosignatario, String nombreConsignatario, Date fechaHora, int idCourier, String courierNombre, String vueloDestino) {
        this.numCuentaCosignatario = numCuentaCosignatario;
        this.nombreConsignatario = nombreConsignatario;
        this.fechaHora = fechaHora;
        this.idCourier = idCourier;
        this.courierNombre = courierNombre;
        this.vueloDestino = vueloDestino;
    }

    public Long getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(Long idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getNumCuentaCosignatario() {
        return numCuentaCosignatario;
    }

    public void setNumCuentaCosignatario(int numCuentaCosignatario) {
        this.numCuentaCosignatario = numCuentaCosignatario;
    }

    public String getNombreConsignatario() {
        return nombreConsignatario;
    }

    public void setNombreConsignatario(String nombreConsignatario) {
        this.nombreConsignatario = nombreConsignatario;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(int idCourier) {
        this.idCourier = idCourier;
    }

    public String getCourierNombre() {
        return courierNombre;
    }

    public void setCourierNombre(String courierNombre) {
        this.courierNombre = courierNombre;
    }

    public String getVueloDestino() {
        return vueloDestino;
    }

    public void setVueloDestino(String vueloDestino) {
        this.vueloDestino = vueloDestino;
    }
}
