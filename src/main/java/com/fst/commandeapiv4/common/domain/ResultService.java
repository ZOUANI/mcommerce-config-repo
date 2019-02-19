/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.commandeapiv4.common.domain;

/**
 *
 * @author YOUNES
 */
public class ResultService<T, VO> extends Result<T> {

    private VO vo;

    public ResultService(T t,VO vo) {
        setVoAndObject(t, vo);
    }

    
    public void setVoAndObject(T t,VO vo){
        setMyObject(t);
        setVo(vo);
    }
    public VO getVo() {
        return vo;
    }

    public void setVo(VO vo) {
        this.vo = vo;
    }
    

}
