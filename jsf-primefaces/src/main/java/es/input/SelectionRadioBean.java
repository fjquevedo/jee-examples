package es.input;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import es.data.Car;
import es.service.CarService;

@ManagedBean(name="selectionRadioBean")
@ViewScoped
public class SelectionRadioBean {
	
    @ManagedProperty("#{carService}")
    private CarService service;
    
    private List<Car> cars1;
    
    
    private Car car;

	@PostConstruct
    public void init() {
        cars1 = service.createCars(10);
    }
	
    public void setService(CarService service) {
        this.service = service;
    }
    
    public List<Car> getCars1() {
        return cars1;
    }

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
    
    
    

}
