/**
 * Root abstract class for the Gym Management System.
 * This class contains common attributes and methods for all gym members.
 * Extended by RegularMember and PremiumMember classes.
 * 
 * @author Shulav Shakya
 * @version 1.0
 */
public abstract class GymMember {
    // Attributes of a gym member
    protected int id;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected int attendance;
    protected double loyaltyPoints;
    protected boolean activeStatus;

    /**
     * Constructor to initialize a GymMember with common attributes.
     * 
     * @param id                  ID of the gym member.
     * @param name                Name of the gym member.
     * @param location            Location of the gym member.
     * @param phone               Phone number of the gym member.
     * @param email               Email of the gym member.
     * @param gender              Gender of the gym member.
     * @param DOB                 Date of birth of the gym member.
     * @param membershipStartDate Membership start date of the gym member.
     */
    public GymMember(int id, String name, String location, String phone, String email, String gender, String DOB,
                     String membershipStartDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.membershipStartDate = membershipStartDate;
        this.attendance = 0;
        this.loyaltyPoints = 0;
        this.activeStatus = false;
    }

    /**
     * Gets the ID of the gym member.
     * 
     * @return Member ID.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Gets the name of the gym member.
     * 
     * @return Member name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the location of the gym member.
     * 
     * @return Member location.
     */
    public String getLocation() {
        return this.location;
    }

    /**
     * Gets the phone number of the gym member.
     * 
     * @return Member phone number.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Gets the email of the gym member.
     * 
     * @return Member email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Gets the gender of the gym member.
     * 
     * @return Member gender.
     */
    public String getGender() {
        return this.gender;
    }

    /**
     * Gets the date of birth of the gym member.
     * 
     * @return Member date of birth.
     */
    public String getDOB() {
        return this.DOB;
    }

    /**
     * Gets the membership start date of the gym member.
     * 
     * @return Membership start date.
     */
    public String getMembershipStartDate() {
        return this.membershipStartDate;
    }

    /**
     * Gets the current attendance count of the gym member.
     * 
     * @return Attendance count.
     */
    public int getAttendance() {
        return this.attendance;
    }

    /**
     * Gets the loyalty points earned by the gym member.
     * 
     * @return Loyalty points.
     */
    public double getLoyaltyPoints() {
        return this.loyaltyPoints;
    }

    /**
     * Checks if the member's membership is active.
     * 
     * @return true if active, false otherwise.
     */
    public boolean isActiveStatus() {
        return this.activeStatus;
    }

    /**
     * Abstract method to be implemented by child classes.
     * Marks attendance for the member.
     */
    public abstract void markAttendance();

    /**
     * Activates the gym membership.
     */
    public void activateMembership() {
        activeStatus = true;
    }

    /**
     * Deactivates the gym membership if currently active.
     */
    public void deactivateMembership() {
        if (activeStatus) {
            activeStatus = false;
        }
    }

    /**
     * Resets the member's status, attendance, and loyalty points.
     */
    public void resetMember() {
        activeStatus = false;
        attendance = 0;
        loyaltyPoints = 0;
    }

    /**
     * Displays the details of the gym member.
     */
    public void display() {
        System.out.println("Id: " + this.getId());
        System.out.println("Name: " + this.getName());
        System.out.println("Location: " + this.getLocation());
        System.out.println("Phone: " + this.getPhone());
        System.out.println("Email: " + this.getEmail());
        System.out.println("Gender: " + this.getGender());
        System.out.println("DOB: " + this.getDOB());
        System.out.println("Membership Start Date: " + this.getMembershipStartDate());
        System.out.println("Attendance: " + this.getAttendance());
        System.out.println("Loyalty Points: " + this.getLoyaltyPoints());
        System.out.println("Active Status: " + this.isActiveStatus());
    }
}
