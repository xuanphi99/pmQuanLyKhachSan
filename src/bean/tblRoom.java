/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.List;

/**
 *
 * @author Administrator
 */
public class tblRoom {
   private  int id; 
   private String name ;
private String typeString;
private float displayPrice ; 
 private String description ;
 private  int  idHotels;

    public tblRoom() {
    }

    public tblRoom(int id, String name, String typeString, float displayPrice, String description, int idHotels) {
        this.id = id;
        this.name = name;
        this.typeString = typeString;
        this.displayPrice = displayPrice;
        this.description = description;
        this.idHotels = idHotels;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public float getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(float displayPrice) {
        this.displayPrice = displayPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getidHotels() {
        return idHotels;
    }

    public void setidHotels(int idHotels) {
        this.idHotels = idHotels;
    }
    
}
