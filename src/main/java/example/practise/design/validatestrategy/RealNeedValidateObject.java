package example.practise.design.validatestrategy;

public class RealNeedValidateObject extends ValidateObject {

    private String applicationType;

    private String dateOfBirth;


    public String getApplicationType() {
        System.out.println("Application Type Has Been Validate");
        return applicationType;
    }

    public String getDateOfBirth() {
        System.out.println("Date Of Birth Has Been Validate");
        return dateOfBirth;
    }
}
