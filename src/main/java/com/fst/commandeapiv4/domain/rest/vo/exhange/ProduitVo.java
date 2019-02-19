/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.commandeapiv4.domain.rest.vo.exhange;

/**
 *
 * @author YOUNES
 */
public class ProduitVo {

    private Long id;
    private String reference;
    private CategorieProduitVo categorieProduitVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CategorieProduitVo getCategorieProduitVo() {
        return categorieProduitVo;
    }

    public void setCategorieProduitVo(CategorieProduitVo categorieProduitVo) {
        this.categorieProduitVo = categorieProduitVo;
    }

}
