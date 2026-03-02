package nonFactoryPattern;

public class EndUser {
    public static void main (String []args) {
        //Toi hang honda de dat xe lai thu
        HondaHead honda = new HondaHead();
        //Xem
        honda.viewCar();
        //Dat
        honda.bookCar();
        //Lai thu
        honda.driverCar();
        //Toi hang ford de dat xe lai thu
        FordHead ford = new FordHead();
        ford.viewCar();
        ford.bookCar();
        ford.driverCar();


        HuyndaiHead huyndai = new HuyndaiHead();
        huyndai.viewCar();
        huyndai.bookCar();
        huyndai.driverCar();
    }

}
