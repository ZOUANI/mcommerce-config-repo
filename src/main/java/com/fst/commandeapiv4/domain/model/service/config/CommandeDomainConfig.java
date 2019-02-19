/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.commandeapiv4.domain.model.service.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *
 * @author YOUNES
 */
@Component
@ConfigurationProperties("domain.commande")
public class CommandeDomainConfig {

    private int nombreLimitProduit;

    public int getNombreLimitProduit() {
        return nombreLimitProduit;
    }

    public void setNombreLimitProduit(int nombreLimitProduit) {
        this.nombreLimitProduit = nombreLimitProduit;
    }

}
