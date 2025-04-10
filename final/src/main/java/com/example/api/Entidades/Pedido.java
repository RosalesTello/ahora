package com.example.api.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    private LocalDate fecha;
    private String estado;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    
    private List<ComprobantedePago> detalles = new ArrayList<>(); // Inicializa la lista aquí
    
    // Muchos pedidos asociados a una tarjeta
    @ManyToOne
    @JoinColumn(name="tarjeta", referencedColumnName="numero")
    @JsonBackReference
    private Tarjeta tarjeta;

    // Constructor con parámetros
    public Pedido(int idPedido, LocalDate fecha, String estado, List<ComprobantedePago> detalles, Tarjeta tarjeta) {
        super();
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.estado = estado;
        this.detalles = detalles;
        this.tarjeta = tarjeta;
    }

    // Constructor sin parámetros
    public Pedido() {
        super();
        this.detalles = new ArrayList<>(); // Inicializa la lista aquí
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<ComprobantedePago> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ComprobantedePago> detalles) {
        this.detalles = detalles;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}

	
    

