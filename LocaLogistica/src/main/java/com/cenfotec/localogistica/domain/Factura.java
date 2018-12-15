package com.cenfotec.localogistica.domain;

import javax.persistence.*;


@Entity
@Table(name = "facturas")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_factura")
    private Long idFactura;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_paquete")
    private Paquete paquete = new Paquete();

    @Column(name = "monto_facturado")
    private String montoFacturado;

    @Column(name = "nombre_tienda")
    private String nombreTienda;


    public Factura() {
    }

    public Factura(Paquete paquete, String montoFacturado, String nombreTienda) {
        this.paquete = paquete;
        this.montoFacturado = montoFacturado;
        this.nombreTienda = nombreTienda;
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public String getMontoFacturado() {
        return montoFacturado;
    }

    public void setMontoFacturado(String montoFacturado) {
        this.montoFacturado = montoFacturado;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }
}
