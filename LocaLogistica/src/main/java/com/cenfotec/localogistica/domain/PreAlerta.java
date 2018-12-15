package com.cenfotec.localogistica.domain;


import javax.persistence.*;

@Entity
@Table(name = "prealertas")
public class PreAlerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prealerta")
    private Long idPreAlerta;

    @Column(name = "idCourier")
    private int idCourier;

    @Column(name = "id_consignatario")
    private int idConsignatario;

    @Column(name = "courier_nombre")
    private String courierNombre;

    @Column(name = "monto_facturado")
    private float montoFacturado;

    @Column(name = "nombre_tienda")
    private String nombreTienda;

    public PreAlerta() {
    }

    public PreAlerta(int idCourier, int idConsignatario, String courierNombre, float montoFacturado, String nombreTienda) {
        this.idCourier = idCourier;
        this.idConsignatario = idConsignatario;
        this.courierNombre = courierNombre;
        this.montoFacturado = montoFacturado;
        this.nombreTienda = nombreTienda;
    }

    public Long getIdPreAlerta() {
        return idPreAlerta;
    }

    public void setIdPreAlerta(Long idPreAlerta) {
        this.idPreAlerta = idPreAlerta;
    }

    public int getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(int idCourier) {
        this.idCourier = idCourier;
    }

    public int getIdConsignatario() {
        return idConsignatario;
    }

    public void setIdConsignatario(int idConsignatario) {
        this.idConsignatario = idConsignatario;
    }

    public String getCourierNombre() {
        return courierNombre;
    }

    public void setCourierNombre(String courierNombre) {
        this.courierNombre = courierNombre;
    }

    public float getMontoFacturado() {
        return montoFacturado;
    }

    public void setMontoFacturado(float montoFacturado) {
        this.montoFacturado = montoFacturado;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }
}
