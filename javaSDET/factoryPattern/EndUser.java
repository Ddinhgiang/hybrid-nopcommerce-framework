package factoryPattern;

import commons.CarList;

public class EndUser {
    public static CarFactory carFactory;
    public static void main (String []args) {
        //End User muon xem va lai xe honda
        carFactory = getCar("Honda");
        carFactory.viewCar();
        carFactory.bookCar();
        carFactory.driverCar();


    }
    public static CarFactory getCar(String carName) {
        CarFactory carFactory = null;
        CarList carList = CarList.valueOf(carName.toUpperCase());
        switch (carList) {
            case HONDA:
                carFactory = new HondaHead();
                break;
            case HUYNDAI:
                carFactory = new HuyndaiHead();
            case FORD:
                carFactory = new FordHead();
            default:
                throw new RuntimeException("Carname is not valid");
        }
        return carFactory;
    }

}
