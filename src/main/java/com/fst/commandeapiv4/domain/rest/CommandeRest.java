/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.commandeapiv4.domain.rest;

import com.fst.commandeapiv4.domain.bean.Commande;
import com.fst.commandeapiv4.domain.bean.CommandeItem;
import com.fst.commandeapiv4.domain.model.service.CommandeItemService;
import com.fst.commandeapiv4.domain.model.service.CommandeService;
import com.fst.commandeapiv4.domain.rest.converter.AbstractConverter;
import com.fst.commandeapiv4.domain.rest.vo.CommandeItemVo;
import com.fst.commandeapiv4.domain.rest.vo.CommandeVo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author YOUNES
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/commande-api/commandes")
public class CommandeRest {

    @Autowired
    private CommandeService commandeService;

    @Autowired
    private CommandeItemService commandeItemService;

    @Autowired
    @Qualifier("commandeItemConverter")
    private AbstractConverter<CommandeItem, CommandeItemVo> commandeItemConverter;

    @Autowired
    @Qualifier("commandeConverter")
    private AbstractConverter<Commande, CommandeVo> commandeConverter;

    @GetMapping("/reference/{reference}/commande-items")
    public List<CommandeItemVo> findByCommande(@PathVariable("reference") String reference) {
        final List<CommandeItem> commandeItems = commandeItemService.findByCommandeReference(reference);
        return commandeItemConverter.toVo(commandeItems);
    }

    @GetMapping("/")
    public List<CommandeVo> findAll() {
        return commandeConverter.toVo(commandeService.findAll());
    }

    @PostMapping("/")
    public CommandeVo saveCommandeWithCommandeItems(@RequestBody CommandeVo commandeVo) {
        Commande myCommande = commandeConverter.toItem(commandeVo);
        Commande commande = commandeService.saveCommandeWithCommandeItems(myCommande);
        return commandeConverter.toVo(commande);
    }

    @GetMapping("/reference/{reference}")
    public CommandeVo findByReference(@PathVariable("reference") String reference) {
        final Commande commande = commandeService.findByReference(reference);
        return commandeConverter.toVo(commande);
    }

    public CommandeService getCommandeService() {
        return commandeService;
    }

    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    public AbstractConverter<Commande, CommandeVo> getCommandeConverter() {
        return commandeConverter;
    }

    public void setCommandeConverter(AbstractConverter<Commande, CommandeVo> commandeConverter) {
        this.commandeConverter = commandeConverter;
    }

}
