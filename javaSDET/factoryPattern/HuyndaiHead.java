package factoryPattern;

public class HuyndaiHead extends CarFactory{
    @Override
    public void viewCar() {
        System.out.println("View HuynDai Car");
    }

    @Override
    public void bookCar() {
        System.out.println("Book HuynDai Car");
    }

    @Override
    public void driverCar() {
        System.out.println("Driver HuynDai Car");
    }

}
