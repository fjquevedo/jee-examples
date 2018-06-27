package es.data.datatable;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import es.data.Car;
import es.service.CarService;


 
@ManagedBean(name="ctfTeamBean")
@ViewScoped
public class SelectionCarBean implements Serializable {
     
    private List<Car> cars1;
    private List<Car> cars2;
    private List<Car> cars3;
    private List<Car> cars4;
    private List<Car> cars5;
    private List<Car> cars6;
    private Car selectedCar;
    private List<Car> selectedCars;
    
    private DataTable myTable = new DataTable();
    
    private List<Car> invitedTeams;
    private List<Car> selectedTeams;
    
    @ManagedProperty("#{carService}")
    private CarService service;
     
    /**
	 * @return the myTable
	 */
	public DataTable getMyTable() {
		return myTable;
	}

	/**
	 * @param myTable the myTable to set
	 */
	public void setMyTable(DataTable myTable) {
		this.myTable = myTable;
	}



	@PostConstruct
    public void init() {
        cars1 = service.createCars(10);
        cars2 = service.createCars(10);
        cars3 = service.createCars(10);
        cars4 = service.createCars(10);
        cars5 = service.createCars(10);
        cars6 = service.createCars(10);
    }
    
    
 
    public List<Car> getCars1() {
        return cars1;
    }
 
    public List<Car> getCars2() {
        return cars2;
    }
 
    public List<Car> getCars3() {
        return cars3;
    }
 
    public List<Car> getCars4() {
        return cars4;
    }
 
    public List<Car> getCars5() {
        return cars5;
    }
 
    public List<Car> getCars6() {
        return cars6;
    }
     
    public void setService(CarService service) {
        this.service = service;
    }
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
 
    public List<Car> getSelectedCars() {
        return selectedCars;
    }
 
    public void setSelectedCars(List<Car> selectedCars) {
        this.selectedCars = selectedCars;
    }
     
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onRowUnselect(UnselectEvent event) {
        FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    /**
	 * @return the invitedTeams
	 */
	public List<Car> getInvitedTeams() {
		return invitedTeams;
	}

	/**
	 * @param invitedTeams the invitedTeams to set
	 */
	public void setInvitedTeams(List<Car> invitedTeams) {
		this.invitedTeams = invitedTeams;
	}

	/**
	 * @return the selectedTeams
	 */
	public List<Car> getSelectedTeams() {
		return selectedTeams;
	}

	/**
	 * @param selectedTeams the selectedTeams to set
	 */
	public void setSelectedTeams(List<Car> selectedTeams) {
		this.selectedTeams = selectedTeams;
		
	}

	/**
     * Move records from one list to another.
     * The invitedTeams list will be used to invite other teams.
     */
    public void inviteTeams() {
    	invitedTeams = selectedTeams;
    	
    	System.out.println(myTable.getFirst());
    	System.out.println(myTable.getPage());
    	System.out.println(myTable.getRows());
    	myTable.reset();
    	
    	//myTable.setFirst(0);
    	System.out.println(myTable.getTabindex());    	
    }
}