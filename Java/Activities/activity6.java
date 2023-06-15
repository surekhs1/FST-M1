package activities;

public class activity6 {
    public static void main(String[] args) throws InterruptedException {
         plane Plane = new plane(10);
        Plane.onboard("John");
        Plane.onboard("Steve");
        Plane.onboard("Anna");
        System.out.println("Plane took off at: " + Plane.takeOff());
        System.out.println("People on the plane: " + Plane.getPassengers());
        Thread.sleep(5000);
        Plane.land();
        System.out.println("Plane landed at: " + Plane.getLastTimeLanded());
        System.out.println("People on the plane after landing: " + Plane.getPassengers());
    }
}
