
package com.example.pacoteturismospring.model;
import com.example.pacoteturismospring.ennum.ItemServico;
import com.example.pacoteturismospring.model.Pacote;
import jakarta.persistence.*;


import java.util.List;

@Entity
@Table(name = "itens")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ItemServico tipo;

    private double valor;

    @ManyToMany (mappedBy = "itens")
    private List <Pacote> pacotes;

    public Item() {
    }

    public Item(ItemServico tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ItemServico getTipo() {
        return tipo;
    }

    public void setTipo(ItemServico tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
