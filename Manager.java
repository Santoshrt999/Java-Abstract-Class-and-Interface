/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

/**
 * This is the Manager class file extends AbstractStoreEmployee.
 *
 * @author Goteti Santosh Ravi Teja
 */
public class Manager extends AbstractStoreEmployee {

    private double bonusRate;
    private double salesDone;
    private double totalStoreSales;

    /**
     * This is an Argument constructor which Initializes all the Instance
     * Variables. bonusRate is initialized with 0. Also Calls a Super class
     * Constructor to initialize numberOfHoursWorked, hourlyRate, storeDetails,
     * basePay, name variables.
     *
     * @param totalStoreSales - The parameter Total Sales in the Store is
     * passed.
     * @param salesDone - The parameterTotal Sales taken place in the store is
     * passed.
     * @param numberOfHoursWorked - The parameter Number of Hours worked by the
     * Manager is passed.
     * @param hourlyRate - The parameter Hourly rate for the Manager is passed.
     * @param storeDetails - The parameterDetails of the Store is passed.
     * @param basePay - The parameter Base Pay Rate is passed.
     * @param name - The parameter Name of the Manager is passed.
     */
    public Manager(double totalStoreSales, double salesDone, double numberOfHoursWorked,
            double hourlyRate, String storeDetails, double basePay, String name) {
        super(numberOfHoursWorked, hourlyRate, storeDetails, basePay, name);
        this.bonusRate = bonusRate;
        this.salesDone = salesDone;
        this.totalStoreSales = totalStoreSales;
        this.bonusRate = 0;
    }

    /**
     * Returns the total Pay for a Manager.
     *
     * @return- This method returns total pay for a manager.
     */
    @Override
    public double calculatePay() {

        if (salesDone > 25000) {
            bonusRate = 15.00;
        } else if (salesDone > 5000 && salesDone <= 25000) {
            bonusRate = 10.00;
        } else {
            bonusRate = 1;
        }

        return (super.getNumberOfHoursWorked() * super.getHourlyRate()
                + super.getBasePay()) * (1 + bonusRate / 100);

    }

    /**
     * Checks if the employee should be awarded with a promotion.
     *
     * @return - This method returns the eligibility status for promotion for an
     * employee.
     */
    @Override
    public boolean checkPromotionEligibility() {

        if (calculatePay() > 50000.0) {

            return true;
        } else {

            return false;
        }
    }

    /**
     * Returns the bonus rate for a manager in percentage.
     *
     * @return - This method returns double Bonus Rate in percentage
     */
    public double getBonusRate() {
        return bonusRate / 100;
    }

    /**
     * Returns total sales performed by the manager in dollars.
     *
     * @return- This method returns Sales done by the manager
     */
    public double getSalesDone() {
        return salesDone;
    }

    /**
     * Returns the total store sales in dollars
     *
     * @return- This method returns Total sales in the store
     */
    public double getTotalStoreSales() {
        return totalStoreSales;
    }

    /**
     * Returns the sales percentage of the manager.
     *
     * @return - This method returns Sales Percentage for the Manager
     */
    public double salesPercentByManager() {
        return (salesDone / totalStoreSales) * 100;
    }

    /**
     * Returns the bonus rate for a manager in percentage.
     *
     * @param bonusRate- The parameter Bonus Rate in percentage is passed.
     */
    public void setBonusRate(double bonusRate) {
        this.bonusRate = bonusRate;
    }

    /**
     * Sets total sales.
     *
     * @param salesDone - The parameter Sales Done is passed.
     */
    public void setSalesDone(double salesDone) {
        this.salesDone = salesDone;
    }

    /**
     * Returns the total store sales in dollars
     *
     * @param totalStoreSales - The parameter Total sales in the store is
     * passed.
     */
    public void setTotalStoreSales(double totalStoreSales) {
        this.totalStoreSales = totalStoreSales;
    }

    /**
     * Returns the String representation of stores sales made by manager and
     * total sales in store.
     *
     * @return - This method returns a String representation of total store
     * sales and sales done.
     */
    @Override
    public String toString() {
        return super.toString() + "Total Sales in store: $" + totalStoreSales
                + "\nSales done: $" + salesDone;
    }

}
