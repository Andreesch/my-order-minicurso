package com.app.myorder.entities;

import com.app.myorder.enums.EstadoPedidoEnum;

import javax.persistence.*;

@Entity
@Table(name = "PEDIDO")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "VALOR_TOTAL", nullable = false)
    private Double valorTotal;

    @Column(name = "ESTADO", nullable = false)
    private EstadoPedidoEnum estadoPedido;

    @Column(name = "USUARIO", nullable = false)
    private Usuario usuario;

    @Column(name = "ESTABELECIMENTO", nullable = false)
    private Estabelecimento estabelecimento;

    public Integer getId() {
        return id;
    }

    public Pedido setId(Integer id) {
        this.id = id;
        return this;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public Pedido setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public EstadoPedidoEnum getEstadoPedido() {
        return estadoPedido;
    }

    public Pedido setEstadoPedido(EstadoPedidoEnum estadoPedido) {
        this.estadoPedido = estadoPedido;
        return this;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Pedido setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Pedido setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
        return this;
    }
}
