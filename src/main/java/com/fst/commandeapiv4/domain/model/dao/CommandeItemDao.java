/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.commandeapiv4.domain.model.dao;

import com.fst.commandeapiv4.domain.bean.CommandeItem;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author YOUNES
 */
@Repository
public interface CommandeItemDao extends JpaRepository<CommandeItem, Long>{
    public List<CommandeItem> findByCommandeReference(String reference);
}
