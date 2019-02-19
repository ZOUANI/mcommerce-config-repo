/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.commandeapiv4.domain.model.service;

import com.fst.commandeapiv4.domain.bean.Commande;
import java.util.List;

/**
 *
 * @author YOUNES
 */
public interface CommandeService {

    public Commande saveCommandeWithCommandeItems(Commande commande);

    public Commande findByReference(String reference);
    public List<Commande> findAll();

}
