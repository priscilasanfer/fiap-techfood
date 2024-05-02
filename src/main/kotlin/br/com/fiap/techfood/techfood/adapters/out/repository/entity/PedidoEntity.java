package br.com.fiap.techfood.techfood.adapters.out.repository.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "TB_PEDIDOS")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String UUID;

    private String nome;

    //TODO one to many
    private List<ItemPedidoEntity> itens;

    //TODO ?
    private ClienteEntity cliente;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemPedidoEntity> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedidoEntity> itens) {
        this.itens = itens;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
