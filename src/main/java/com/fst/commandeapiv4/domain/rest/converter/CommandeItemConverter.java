/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.commandeapiv4.domain.rest.converter;

import com.fst.commandeapiv4.common.util.NumberUtil;
import com.fst.commandeapiv4.domain.bean.CommandeItem;
import com.fst.commandeapiv4.domain.rest.vo.CommandeItemVo;
import org.springframework.stereotype.Component;

/**
 *
 * @author YOUNES
 */
@Component
public class CommandeItemConverter extends AbstractConverter<CommandeItem, CommandeItemVo> {

    @Override
    public CommandeItem toItem(CommandeItemVo vo) {
        if (vo == null) {
            return null;
        } else {
            CommandeItem item = new CommandeItem();
            item.setId(vo.getId());
            item.setReferenceProduit(vo.getReferenceProduit());
            item.setPrix(NumberUtil.toBigDecimal(vo.getPrix()));
            item.setQte(NumberUtil.toBigDecimal(vo.getQte()));
            return item;
        }
    }

    @Override
    public CommandeItemVo toVo(CommandeItem item) {
        if(item==null){
        return null;
        }else{
            CommandeItemVo vo = new CommandeItemVo();
            vo.setId(item.getId());
            vo.setPrix(NumberUtil.toString(item.getPrix()));
            vo.setQte(NumberUtil.toString(item.getQte()));
            vo.setReferenceProduit(item.getReferenceProduit());
            return vo;
        }
    }

}
