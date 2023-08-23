package com.soulcode.goserviceapp.service;

public class PrestadorService {

    public Prestador update(Prestador prestador) {
        Prestador updatePrestador = this.findById(prestador.getId());
        updatePrestador.setNome(prestador.getNome());
        updatePrestador.setEmail(prestador.getEmail());
        updatePrestador.setDescricao(prestador.getDescricao());
        updatePrestador.setTaxaPorHora(prestador.getTaxaPorHora());
        return prestadorRepository.save(updatePrestador);
    }
}
