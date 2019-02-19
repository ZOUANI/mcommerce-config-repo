/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.commandeapiv4.domain.rest.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

/**
 *
 * @author YOUNES
 */
public class CommandeVo {

    private Long id;
    private String reference;
    private String total;
    private List<CommandeItemVo> commandeItemVo;

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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @JsonIgnore
    public List<CommandeItemVo> getCommandeItemVo() {
        return commandeItemVo;
    }

    @JsonSetter
    public void setCommandeItemVo(List<CommandeItemVo> commandeItemVo) {
        this.commandeItemVo = commandeItemVo;
    }

}
