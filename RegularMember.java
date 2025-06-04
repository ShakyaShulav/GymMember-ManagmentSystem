/**
 * Child class extended from root class GymMember class for the Gym Management
 * System.
 * This class contains the common attributes and methods for all regular gym
 * members.
 * 
 * @author Shulav Shakya
 * @version 1.0
 */
class RegularMember extends GymMember {
    private final int attendanceLimit;
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;

    /**
     * Constructor to initialize a RegularMember object with given attributes.
     * 
     * @param id                  ID of the gym member.
     * @param name                Name of the gym member.
     * @param location            Location of the gym member.
     * @param phone               Phone number of the gym member.
     * @param email               Email of the gym member.
     * @param gender              Gender of the gym member.
     * @param DOB                 Date of birth of the gym member.
     * @param membershipStartDate Membership start date of the gym member.
     * @param referralSource      Referral source of the regular member.
     */
    public RegularMember(int id, String name, String location, String phone, String email, String gender, String DOB,
            String membershipStartDate, String referralSource) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.attendanceLimit = 30;
        this.referralSource = referralSource;
        this.isEligibleForUpgrade = false;
        this.removalReason = "";
        this.plan = "basic";
        this.price = 6500;
    }

    /**
     * Gets the attendance limit for the regular member.
     * 
     * @return Attendance limit.
     */
    public int getAttendanceLimit() {
        return this.attendanceLimit;
    }

    /**
     * Gets the removal reason for the member.
     * 
     * @return Removal reason.
     */
    public String getRemovalReason() {
        return this.removalReason;
    }

    /**
     * Gets the referral source of the regular member.
     * 
     * @return Referral source.
     */
    public String getReferralSource() {
        return this.referralSource;
    }

    /**
     * Gets the current membership plan of the member.
     * 
     * @return Current plan.
     */
    public String getPlan() {
        return this.plan;
    }

    /**
     * Gets the current price of the member's plan.
     * 
     * @return Plan price.
     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Gets the current attendance count of the member.
     * 
     * @return Attendance count.
     */
    public int getAttendance() {
        return this.attendance;
    }

    /**
     * Marks attendance for the regular member.
     * Increases attendance and loyalty points.
     * Sets eligibility for upgrade if attendance limit is reached.
     */
    @Override
    public void markAttendance() {
        attendance++;
        loyaltyPoints += 5;
        if (getAttendance() >= attendanceLimit) {
            System.out.println("Attendance limit reached. Eligible for upgrade.");
            isEligibleForUpgrade = true;
        }
    }

    /**
     * Gets the price for a given membership plan.
     * 
     * @param plan Name of the plan.
     * @return Price of the specified plan, or -1 if invalid plan.
     */
    public double getPlanPrice(String plan) {
        switch (plan.toLowerCase()) {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                return -1;
        }
    }

    /**
     * Upgrades the membership plan if eligible.
     * 
     * @param newPlan The new plan to upgrade to.
     * @return Message indicating the result of the upgrade attempt.
     */
    public String upgradePlan(String newPlan) {
        if (!isEligibleForUpgrade) {
            return "Upgrade not available. Attendance requirement not met.";
        }

        double newPrice = getPlanPrice(newPlan);
        if (newPrice == -1) {
            return "Invalid plan selected. Please choose a valid plan.";
        }

        if (newPlan.equalsIgnoreCase(plan)) {
            return "You are already subscribed to this plan.";
        }

        this.plan = newPlan;
        this.price = newPrice;
        return "Plan upgraded successfully to " + newPlan + " for " + newPrice;
    }

    /**
     * Reverts the regular member to initial state.
     * Resets membership details, eligibility for upgrade, plan, and price.
     * 
     * @param removalReason The reason for reverting the member.
     */
    public void revertRegularMethod(String removalReason) {
        super.resetMember();
        this.isEligibleForUpgrade = false;
        this.plan = "basic";
        this.price = 6500;
    }

    /**
     * Displays the details of the regular member including plan, price, referral
     * source, and removal reason if available.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Plan: " + plan);
        System.out.println("Price: " + price);
        System.out.println("Referral: " + referralSource);
        if (!removalReason.isEmpty()) {
            System.out.println("Removal Reason: " + removalReason);
        }
    }
}
