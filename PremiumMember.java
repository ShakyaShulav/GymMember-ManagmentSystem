/**
 * Child class extended from root class GymMember class for the Gym Management
 * System.
 * This class contains the common attributes and methods for all premium gym
 * members.
 * 
 * @author Shulav Shakya
 * @version 1.0
 */
public class PremiumMember extends GymMember {
    private final double premiumCharge = 50000;
    private String personalTrainer;
    private boolean isFullPayment;
    private double paidAmount;
    private double discountAmount;

    /**
     * Constructor to initialize a PremiumMember object with given attributes.
     * 
     * @param id                  includes the ID of the gym member.
     * @param name                includes the name of the gym member.
     * @param location            includes the location of the gym member.
     * @param phone               includes the phone number of the gym member.
     * @param email               includes the email of the gym member.
     * @param gender              includes the gender of the gym member.
     * @param DOB                 includes the date of birth of the gym member.
     * @param membershipStartDate includes the membership start date of the gym member.
     * @param personalTrainer     includes the name of the personal trainer assigned to the premium gym member.
     */
    public PremiumMember(int id, String name, String location, String phone, String email, String gender, String DOB,
                         String membershipStartDate, String personalTrainer) {
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        this.isFullPayment = false;
        this.paidAmount = 0;
        this.discountAmount = 0;
        this.personalTrainer = personalTrainer;
    }

    /**
     * Gets the name of the personal trainer assigned to the premium member.
     * 
     * @return the name of the personal trainer.
     */
    public String getPersonalTrainer() {
        return this.personalTrainer;
    }

    /**
     * Checks if the full payment has been completed.
     * 
     * @return true if the payment is complete, false otherwise.
     */
    public boolean isFullPayment() {
        return this.isFullPayment;
    }

    /**
     * Gets the total amount paid by the premium member.
     * 
     * @return the amount paid.
     */
    public double getPaidAmount() {
        return this.paidAmount;
    }

    /**
     * Gets the discount amount applied after full payment.
     * 
     * @return the discount amount.
     */
    public double getDiscountAmount() {
        return this.discountAmount;
    }

    /**
     * Gets the fixed premium membership charge.
     * 
     * @return the premium membership charge.
     */
    public double getPremiumCharge() {
        return this.premiumCharge;
    }

    /**
     * Marks the attendance for the premium member.
     * Increases attendance count and adds loyalty points.
     */
    @Override
    public void markAttendance() {
        attendance++;
        loyaltyPoints += 10;
    }

    /**
     * Processes the payment for the premium membership.
     * Updates the paid amount, checks for overpayment, and updates payment status.
     * 
     * @param amount the amount being paid.
     * @return message indicating the payment status.
     */
    public String payDueAmount(double amount) {
        if (isFullPayment) {
            return "The payment has been received";
        }
        double prevPaidAmount = paidAmount;
        paidAmount += amount;
        if (paidAmount > premiumCharge) {
            paidAmount = prevPaidAmount;
            return "Provided payment is excess than the required amount";
        }
        if (paidAmount == premiumCharge) {
            isFullPayment = true;
        }
        double remainingAmount = premiumCharge - paidAmount;
        return "Payment Successful. Remaining amount is: " + remainingAmount;
    }

    /**
     * Calculates and applies a discount if full payment has been completed.
     * Displays the discounted amount.
     */
    public void calculateDiscount() {
        if (isFullPayment) {
            discountAmount = 0.1 * premiumCharge;
            System.out.println("Discounted Amount: " + discountAmount);
        }
    }

    /**
     * Resets the premium member's details to initial state.
     * Resets payment details, discount, and personal trainer info.
     */
    public void revertPremiumMethod() {
        super.resetMember();
        personalTrainer = "";
        isFullPayment = false;
        paidAmount = 0;
        discountAmount = 0;
    }

    /**
     * Displays the premium member's details including payment and discount info.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Personal Trainer: " + personalTrainer);
        System.out.println("Paid Amount: " + paidAmount);
        if (isFullPayment) {
            System.out.println("Full Payment Received.");
        } else {
            double remainingAmount = premiumCharge - paidAmount;
            System.out.println("Remaining amount to pay: " + remainingAmount);
        }
        if (isFullPayment) {
            System.out.println("Discounted Amount: " + discountAmount);
        }
    }
}
