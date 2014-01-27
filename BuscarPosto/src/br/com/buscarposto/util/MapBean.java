package br.com.buscarposto.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

public class MapBean implements Serializable {  
	  
    private MapModel emptyModel;  
      
    private String nomeEmpresa;  
      
    private double lat;  
      
    private double lng;  
  
    public MapBean() {  
        emptyModel = new DefaultMapModel();  
    }  
      
    public MapModel getEmptyModel() {  
        return emptyModel;  
    }  
      
    public void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
      
    public String getNomeEmpresa() {  
        return nomeEmpresa;  
    }  
  
    public void setNomeEmpresa(String nomeEmpresa) {  
        this.nomeEmpresa = nomeEmpresa;  
    }  
  
    public double getLat() {
        return lat;  
    }  
  
    public void setLat(double lat) {  
        this.lat = lat;  
    }  
  
    public double getLng() {  
        return lng;  
    }  
  
    public void setLng(double lng) {  
        this.lng = lng;  
    }  
      
    public void addMarker(ActionEvent actionEvent) {  
        Marker marker = new Marker(new LatLng(lat, lng), nomeEmpresa);  
        emptyModel.addOverlay(marker);  
          
        addMessage(new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));  
    }  
  
} 
