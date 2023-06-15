package activities;

public class activity1 {

    public static void main(String[] args) {
        car hyundai = new car();
        hyundai.make = 2020;
        hyundai.color = "Red";
        hyundai.transmission = "Manual";


        hyundai.displayCharacteristics();
        hyundai.accelerate();
        hyundai.brake();
    }

}