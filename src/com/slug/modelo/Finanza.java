package com.slug.modelo;

import java.util.UUID;


public class Finanza {
    private String id;
    private String monto;
    private String fecha;
    private String metodoPago;
    private String tipo;
    private String comentarios;

    public Finanza() {
                this.id = UUID.randomUUID().toString();

    }

    public Finanza(String monto, String fecha, String metodoPago, String tipo, String comentarios) {
        this.id = UUID.randomUUID().toString();
        this.monto = monto;
        this.fecha = fecha;
        this.metodoPago = metodoPago;
        this.tipo = tipo;
        this.comentarios = comentarios;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
}
