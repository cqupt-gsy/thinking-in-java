package example.practise.design.validatestrategy.validateobjects;

public class RealNeedValidateObject {

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
