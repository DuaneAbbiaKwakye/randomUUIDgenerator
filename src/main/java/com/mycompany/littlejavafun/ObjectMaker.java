package com.mycompany.littlejavafun;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author duane
 */
import java.util.UUID;
        
public class ObjectMaker {
//Object Variables           
    private UUID genUUID;
//---------------------------------------------------

    public ObjectMaker() {
        this.genUUID = UUID.randomUUID();
    }
    
    
    public UUID getGenUUID() {
        return genUUID;
    }


    @Override
    public String toString() {
        return "{" + genUUID + "}";
    }
    
}
