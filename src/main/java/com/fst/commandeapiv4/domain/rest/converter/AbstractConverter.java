/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.commandeapiv4.domain.rest.converter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YOUNES
 */
public abstract class AbstractConverter<T, VO> {

    protected Class<T> classT;
    protected Class<VO> classVo;
    protected String[] attributeToIgnor;


    public abstract T toItem(VO vo);

    public abstract VO toVo(T item);

    public List<T> toItem(List<VO> vos) {
        if (vos == null || vos.isEmpty()) {
            return null;
        } else {
            List<T> items = new ArrayList();
            for (VO vo : vos) {
                items.add(toItem(vo));
            }
            return items;
        }
    }

    public List<VO> toVo(List<T> items) {
        if (items == null || items.isEmpty()) {
            return null;
        } else {
            List<VO> vos = new ArrayList();
            for (T item : items) {
                vos.add(toVo(item));
            }
            return vos;
        }
    }

    public Class<T> getClassT() {
        return classT;
    }

    public void setClassT(Class<T> classT) {
        this.classT = classT;
    }

    public Class<VO> getClassVo() {
        return classVo;
    }

    public void setClassVo(Class<VO> classVo) {
        this.classVo = classVo;
    }

    public String[] getAttributeToIgnor() {
        return attributeToIgnor;
    }

    public void setAttributeToIgnor(String[] attributeToIgnor) {
        this.attributeToIgnor = attributeToIgnor;
    }
    
    //    public AbstractConverter(Class<T> classT, Class<VO> classVo, String[] attributeToIgnor) {
//        this.classT = classT;
//        this.classVo = classVo;
//        this.attributeToIgnor = attributeToIgnor;
//    }
//    
//    public T toItem(VO vo) {
//        if (vo == null) {
//            return null;
//        } else {
//            T item = null;
//            try {
//                Constructor<T> cons = classT.getConstructor();
//                item = cons.newInstance();
//                BeanUtils.copyProperties(item, vo, attributeToIgnor);
//            } catch (Exception ex) {
//                Logger.getLogger(AbstractConverter.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return item;
//        }
//    }
//
//    public VO toVo(T item) {
//        if (item == null) {
//            return null;
//        } else {
//            VO vo = null;
//            try {
//                Constructor<VO> cons = classVo.getConstructor();
//                vo = cons.newInstance();
//                BeanUtils.copyProperties(vo, item, attributeToIgnor);
//            } catch (Exception ex) {
//                Logger.getLogger(AbstractConverter.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            return vo;
//        }
//    }

}
