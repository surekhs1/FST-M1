package activities;


   public class activity8 {
    public static void main(String[] a){
        try {
            activity8.exceptionTest("Will print to console");
            activity8.exceptionTest(null);
            activity8.exceptionTest("Won't execute");
        } catch(CustomException day) {
            System.out.println("Inside catch block: " + day.getMessage());
        }
    }

    static void exceptionTest(String str) throws CustomException {
        if(str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
    }
}