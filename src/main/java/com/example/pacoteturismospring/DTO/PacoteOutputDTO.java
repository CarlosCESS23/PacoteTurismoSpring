package com.example.pacoteturismospring.DTO;

import com.example.pacoteturismospring.model.Pacote;

public class PacoteOutputDTO {
    private String origem;
    private String destino;

    public PacoteOutputDTO(Pacote pacote){
        setOrigem(pacote.getOrigem());
        setDestino(pacote.getDestino());
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
}
