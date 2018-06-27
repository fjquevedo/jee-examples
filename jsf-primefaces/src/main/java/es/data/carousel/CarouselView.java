package es.data.carousel;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import es.data.Car;
import es.service.CarService;

@ManagedBean
@ViewScoped
public class CarouselView implements Serializable {
    
    private List<Car> cars;
     
    private Car selectedCar;

    @ManagedProperty("#{carService}")
    private CarService service;
     
    @PostConstruct
    public void init() {
        cars = service.createCars(9);
    }
 
    public List<Car> getCars() {
    	FacesContext context = FacesContext.getCurrentInstance();
    	System.out.println("phaseId List<Car> getCars(): " + context.getCurrentPhaseId());
        return cars;
    }
 
    public void setService(CarService service) {
    	System.out.println("set service...");
        this.service = service;
    }
 
    public Car getSelectedCar() {
    	System.out.println("get selected car: " + selectedCar);
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
    	System.out.println("set selected car: " + selectedCar.getId());
        this.selectedCar = selectedCar;
    }
}

