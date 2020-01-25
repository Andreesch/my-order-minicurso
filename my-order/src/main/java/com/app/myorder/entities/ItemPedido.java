package com.app.myorder.entities;

import javax.persistence.*;

@Entity
@Table(name = "ITEM_PEDIDO")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "PEDIDO", nullable = false)
    private Pedido pedido;

    @Column(name = "QUANTIDADE", nullable = false)
    private Integer quantidade;

    @Column(name = "PRODUTO", nullable = false)
    private Produto produto;

    public Integer getId() {
        return id;
    }

    public ItemPedido setId(Integer id) {
        this.id = id;
        return this;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public ItemPedido setPedido(Pedido pedido) {
        this.pedido = pedido;
        return this;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public ItemPedido setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public Produto getProduto() {
        return produto;
    }

    public ItemPedido setProduto(Produto produto) {
        this.produto = produto;
        return this;
    }
}
