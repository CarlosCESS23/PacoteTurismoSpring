
package com.example.pacoteturismospring.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Pacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String origem;

    @Column(nullable = false)
    private String destino;


    @ManyToMany
    @JoinTable(
            name = "pacote_item",
            joinColumns = @JoinColumn(name = "pacote_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> itens = new ArrayList<>();

    public Pacote() {
    }

    public Pacote(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
    }

    public void adicionarItens(Item item) {
        itens.add(item);
    }

    @Transient
    public Double getTotal() {
        double total = 0.0;

        for (Item item : itens) {
            total += item.getValor();
        }

        return total;
    }

    @Transient
    public double getTaxa() {
        return getTotal() * 0.10;
    }

    @Transient
    public double getTotalComTaxa() {
        return getTotal() + getTaxa();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens.clear();

        if (itens != null) {
            this.itens.addAll(itens);
        }
    }

    public void listarItens() {
        for (Item item : itens) {
            System.out.println(
                    "Tipo: " + item.getTipo() +
                            " | Valor: " + item.getValor()
            );
        }
    }

    @Override
    public String toString() {
        return "Pacote{" +
                "origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", Valor total=" + getTotal() +
                '}';
    }
}
