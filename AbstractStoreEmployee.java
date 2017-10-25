/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

/**
 * This is the AbstractStoreEmployee abstract class file implements Employee and
 * Sore.
 *
 * @author Goteti Santosh Ravi Teja
 */
public abstract class AbstractStoreEmployee implements Employee, Store {

    private double basePay;
    String employeeName;
    private double hourlyRate;
    private double numberOfHoursWorked;
    private String storeDetails;

    /**
     * This is an argument constructor which initializes all the instance
     * variables
     *
     * @param numberOfHoursWorked - The parameter Number of hours worked is
     * passed.
     * @param hourlyRate - The parameter Hourly rate of the Employee in dollars
     * is passed.
     * @param storeDetails - The parameter Details of the Store is passed.
     * @param basePay - The parameter Base pay of the Employee in dollars is
     * passed.
     * @param employeeName - The parameter Full name of the Employee is passed.
     */
    public AbstractStoreEmployee(double numberOfHoursWorked, double hourlyRate, String storeDetails,
            double basePay, String employeeName) {
        this.numberOfHoursWorked = numberOfHoursWorked;
        this.hourlyRate = hourlyRate;
        this.storeDetails = storeDetails;
        this.basePay = basePay;
        this.employeeName = employeeName;
    }

    /**
     * Calculates the total commission of the employee.
     *
     * @return- This method returns the total commission
     */
    @Override
    public double calculateCommission() {
        return 0;
    }

    /**
     * Calculates pay
     *
     * @return- This method returns calculatePay.
     */
    @Override
    public abstract double calculatePay();

    /**
     * Calculates the store revenue and returns the store revenue
     *
     * @param storeSales- The Parameter storeSales is passed.
     * @return- This method returns Store revenue
     */
    @Override
    public double calculateRemainingStoreRevenue(double storeSales) {
        double employeePay = calculatePay();
        double storeRevenue = 0;

        storeRevenue = storeSales * (1 - TAX) - employeePay;

        if (storeSales > 255000) {
            storeRevenue = (1 - 0.05) * storeRevenue;
        } else if (storeSales > 155000 && storeSales <= 255000) {
            storeRevenue = (1 - 0.03) * storeRevenue;
        } else {
            storeRevenue = (1 - 0.01) * storeRevenue;
        }
        return storeRevenue;
    }

    /**
     * Checks if the employee should be awarded with promotion
     *
     * @return - This method returns the eligibility status for promotion for an
     * employee.
     */
    @Override
    public abstract boolean checkPromotionEligibility();

    /**
     * Returns the base pay of the employee
     *
     * @return This method returns Base pay amount.
     */
    public double getBasePay() {
        return basePay;
    }

    /**
     * Sets the Base pay
     *
     * @param basePay - The Parameter Base pay value is passed.
     */
    public void setBasePay(double basePay) {
        this.basePay = basePay;
    }

    /**
     * Returns the Name of the Employee
     *
     * @return- This method returns String Employee name.
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * Sets the Employee name
     *
     * @param employeeName Name of the Employee
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * Returns hourly rate for the employee
     *
     * @return - This method returns Hourly rate.
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Sets the hourly rate
     *
     * @param hourlyRate - The parameter Hourly rate is passed.
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
     * Returns number of hours worked hours
     *
     * @return- This method returns number of hours worked
     */
    public double getNumberOfHoursWorked() {
        return numberOfHoursWorked;
    }

    /**
     * Sets the number of hours worked
     *
     * @param numberOfHoursWorked - The parameter number of hours worked is
     * passed.
     */
    public void setNumberOfHoursWorked(double numberOfHoursWorked) {
        this.numberOfHoursWorked = numberOfHoursWorked;
    }

    /**
     * Sets the Store Details
     *
     * @param storeDetails- The parameter Details of the Store is passed.
     */
    public void setStoreDetails(String storeDetails) {
        this.storeDetails = storeDetails;
    }

    /**
     * Returns private variable are separated by one space.
     *
     * @return- This returns string representation of Employee and Store
     * details.
     */
    @Override
    public String toString() {
        return "Store Details: " + storeDetails + "\nEmployee Name: " + employeeName
                + "\nBase Pay: $" + basePay + "\nNumber of Hours worked: " + numberOfHoursWorked + "hrs"
                + "\nPayment Rate per hour: $" + hourlyRate + "/hr\n";
    }

}
