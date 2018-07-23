package es.data.datatable;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

import es.data.Car;
import es.data.Children;
import es.data.Parent;
import es.service.CarService;

@ManagedBean(name = "dtSelectionView")
@ViewScoped
public class SelectionView implements Serializable {

	private List<Car> cars1;
	private List<Car> cars2;
	private List<Car> cars3;
	private List<Car> cars4;
	private List<Car> cars5;
	private List<Car> cars6;
	private Car selectedCar;
	private List<Car> selectedCars;

	private List<Parent> parents;
	private Parent selectedParent;
	private Children selectedChildren;

	@ManagedProperty("#{carService}")
	private CarService service;

	@PostConstruct
	public void init() {
		cars1 = service.createCars(10);
		cars2 = service.createCars(10);
		cars3 = service.createCars(10);
		cars4 = service.createCars(10);
		cars5 = service.createCars(10);
		cars6 = service.createCars(10);

		parents = service.createParents(5, 3);
		selectedParent = parents.get(0);
		selectedChildren = parents.get(0).getChildren().get(0);
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

	public List<Parent> getParents() {
		return parents;
	}

	public void setService(CarService service) {
		this.service = service;
	}

	public Car getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(Car selectedCar) {
		System.out.println("selected Car" + selectedCar);
		this.selectedCar = selectedCar;
	}

	public List<Car> getSelectedCars() {
		return selectedCars;
	}

	public void setSelectedCars(List<Car> selectedCars) {
		this.selectedCars = selectedCars;
	}

	public Parent getSelectedParent() {
		return selectedParent;
	}

	public void setSelectedParent(Parent selectedParent) {
		if (selectedParent != null) {
			System.out.println("select Parent: " + selectedParent.getId());
			this.selectedParent = selectedParent;
			this.selectedChildren = this.selectedParent.getChildren().get(0);
		} else {
			System.out.println("Parent null");
		}
	}

	public Children getSelectedChildren() {
		return selectedChildren;
	}

	public void setSelectedChildren(Children selectedChildren) {
		if (selectedChildren != null) {
			System.out.println(
					"select Children: " + selectedChildren.getId() + ", parentID: " + selectedChildren.getParentID());
			this.selectedChildren = selectedChildren;
			for (Parent p : parents) {
				if (p.getId().equals(selectedChildren.getParentID())) {
					this.selectedParent = p;
					break;
				}
			}
		} else {
			System.out.println(FacesContext.getCurrentInstance().getCurrentPhaseId() + " Children null");
		}
	}

	public void onRowSelect(SelectEvent event) {
		FacesMessage msg = new FacesMessage("Car Selected", ((Car) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowUnselect(UnselectEvent event) {
		FacesMessage msg = new FacesMessage("Car Unselected", ((Car) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowSelectParent(SelectEvent event) {
		selectedParent = (Parent) event.getObject();
		this.selectedChildren = this.selectedParent.getChildren().get(0);
		FacesMessage msg = new FacesMessage("Parent Selected", selectedParent.getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowSelectChildren(SelectEvent event) {
		selectedChildren = (Children) event.getObject();
		
		for (Parent p : parents) {
			if (p.getId().equals(selectedChildren.getParentID())) {
				this.selectedParent = p;
				break;
			}
		}
		
		FacesMessage msg = new FacesMessage("Children Selected", selectedChildren.getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}