package com.vopolski.lazytable;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

@ManagedBean(name="dtLazyView")
@ViewScoped
public class LazyView implements Serializable {
    private LazyDataModel<Car> lazyModel;

    private Car selectedCar;

    @ManagedProperty("#{carService}")
    private CarService service;

    @PostConstruct
    public void init() {
        lazyModel = new LazyCarDataModel(service.createCars(200));
    }

    public LazyDataModel<Car> getLazyModel() {
        return lazyModel;
    }

    public Car getSelectedCar() {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }

    public void setService(CarService service) {
        this.service = service;
    }

    public void onRowSelect(SelectEvent event) {
        selectedCar.setBrand("VAZ");
        FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void prepareEditAttrs(){
        System.out.println("Test");

        selectedCar.setBrand("VAZ");


    }
}
