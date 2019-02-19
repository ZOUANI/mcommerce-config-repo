/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fst.commandeapiv4.common.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YOUNES
 */
public abstract class Result<T> {
    protected T myObject;
    protected List<String> errors;
    protected List<String> infos;
    protected List<String> warnings;

    
    public boolean containErrors(){
        return !getErrors().isEmpty();
    }
    public void addError(String message){
        getErrors().add(message);
    }
    
     public void addWarning(String message){
        getWarnings().add(message);
    }

    public Result(T myObject) {
        this();
        this.myObject = myObject;
    }
     
     public Result(){
       errors= new ArrayList();
       infos= new ArrayList();
       warnings= new ArrayList();
    }
      public void addInfo(String message){
        getInfos().add(message);
    }
    
    public T getMyObject() {
        return myObject;
    }

    public void setMyObject(T myObject) {
        this.myObject = myObject;
    }

    public List<String> getErrors() {
        if(errors==null){
            errors= new ArrayList();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getInfos() {
          if(infos==null){
            infos= new ArrayList();
        }
        return infos;
    }

    public void setInfos(List<String> infos) {
        this.infos = infos;
    }

    public List<String> getWarnings() {
          if(warnings==null){
            warnings= new ArrayList();
        }
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }
    
    
    
}
