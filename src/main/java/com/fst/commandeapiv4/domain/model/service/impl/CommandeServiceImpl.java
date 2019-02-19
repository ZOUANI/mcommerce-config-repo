/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.commandeapiv4.domain.model.service.impl;

import com.fst.commandeapiv4.domain.model.dao.CommandeDao;
import com.fst.commandeapiv4.domain.bean.Commande;
import com.fst.commandeapiv4.domain.bean.CommandeItem;
import com.fst.commandeapiv4.domain.model.service.CommandeItemService;
import com.fst.commandeapiv4.domain.model.service.CommandeService;
import com.fst.commandeapiv4.domain.model.service.config.CommandeDomainConfig;
import com.fst.commandeapiv4.domain.rest.proxy.ProduitProxy;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author YOUNES
 */
@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeDao commandeDao;
    @Autowired
    private CommandeItemService commandeItemService;
    @Autowired
    private ProduitProxy produitProxy;

    @Autowired
    private CommandeDomainConfig commandeDomainConfig;

    @Override
    public List<Commande> findAll() {
        return commandeDao.findAll();
    }

    @Override
    public Commande saveCommandeWithCommandeItems(Commande commande) {
        if (validateCommande(commande.getCommandeItems())) {
            calculerTotal(commande, commande.getCommandeItems());
            commandeDao.save(commande);
            commandeItemService.saveCommandeItems(commande, commande.getCommandeItems());
            return commande;
        } else {
            return null;
        }
    }

    @Override
    public Commande findByReference(String reference) {
        return commandeDao.findByReference(reference);
    }

    private void calculerTotal(Commande commande, List<CommandeItem> commandeItems) {
        BigDecimal total = BigDecimal.ZERO;
        if (commandeItems != null && !commandeItems.isEmpty()) {
            for (CommandeItem commandeItem : commandeItems) {
                total = total.add(commandeItem.getPrix().multiply(commandeItem.getQte()));
            }
        }
        commande.setTotal(total);
    }

    private boolean validateCommande(List<CommandeItem> commandeItems) {
        return validateReferenceProduit(commandeItems);
    }

    private boolean validateReferenceProduit(List<CommandeItem> commandeItems) {
        if (commandeItems == null || commandeItems.isEmpty()) {
            return false;
        } else if(commandeItems.size()>commandeDomainConfig.getNombreLimitProduit()){
            return false;
        }else {
            int cmp = 0;
            for (CommandeItem commandeItem : commandeItems) {
                if (produitProxy.findByReference(commandeItem.getReferenceProduit()) != null) {
                    cmp++;
                }
            }
            return (cmp == commandeItems.size());
        }
    }

    public CommandeDao getCommandeDao() {
        return commandeDao;
    }

    public void setCommandeDao(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    public CommandeItemService getCommandeItemService() {
        return commandeItemService;
    }

    public void setCommandeItemService(CommandeItemService commandeItemService) {
        this.commandeItemService = commandeItemService;
    }

    public ProduitProxy getProduitProxy() {
        return produitProxy;
    }

    public void setProduitProxy(ProduitProxy produitProxy) {
        this.produitProxy = produitProxy;
    }

    public CommandeDomainConfig getCommandeDomainConfig() {
        return commandeDomainConfig;
    }

    public void setCommandeDomainConfig(CommandeDomainConfig commandeDomainConfig) {
        this.commandeDomainConfig = commandeDomainConfig;
    }

}
