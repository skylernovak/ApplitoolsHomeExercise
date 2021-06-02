/*
Programmer: Skyler Nelson-Novak MacAdam
Date: 4/27/2021
Description: Take home assignment for Applitools, Software Engineer Support (US West Coast) application
*/

import java.lang.Math;

public class Solution {

    private static final int NUM_OF_TESTS = 20; // the number of test samples that will be conducted on the calculators

    private static class CalcRunner extends Thread {

        double successRate; // the success rate of the calculator run on the current thread

        // @Override
        CalcRunner(String name) {
            Thread.currentThread().setName(name);
        }

        // @Override
        public void run() {

            // initialize the calculator
            Calculator calc = new Calculator(Thread.currentThread().getName());

            // Calculate the success rates of the calculator & print results to console
            setSuccessRate(runCalculations(calc)); // calculator success rate

        }

        private void setSuccessRate(double successRate) {
            this.successRate = successRate;
        }

        public double getSuccessRate() {
            return this.successRate;
        }
    }

    public static void main(String[] args) {

        // Create the two threads
        CalcRunner t1 = new CalcRunner("Crystal 1"); // String argument is the name of the thread
        CalcRunner t2 = new CalcRunner("Crystal 2");

        // run calculator threads
        t1.start();
        t2.start();

        try {
            // wait for threads to complete before printing success rates
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // print two calculators success rates
        System.out.println("Crystal 1 Success rate: " + t1.getSuccessRate());
        System.out.println("Crystal 2 Success rate: " + t2.getSuccessRate());

        // Run tests and compare success rates
        if (t1.getSuccessRate() > t2.getSuccessRate()) { // Calc1 has a higher success rate
            System.out.println("Crystal 1 is better");
        } else if (t1.getSuccessRate() == t2.getSuccessRate()) { // Both calculators have the same success rate
            System.out.println("Both crystals have the same success rate");
        } else { // Calc2 has a higher success rate
            System.out.println("Crystal 2 is better");
        }

    } // main()

    /**
     * Runs NUM_OF_TESTS calculations with calculator, and returns success rate
     * 
     * @param calc calculator object
     * @return (# of successful calculations) / NUM_OF_TESTS
     */
    private static double runCalculations(Calculator calc) {

        // Success rate of current calculator
        double successRate = 0.0;

        // print to console what calculator is being tested
        System.out.println("Calculator " + calc.getName());

        // run the number of tests specified
        for (int i = 0; i < NUM_OF_TESTS; i++) {

            // Generate two random numbers to be submitted to the calc for evaluation
            double num1 = Math.random() * 10;
            double num2 = Math.random() * 10;
            String errorString = "WARNING  --  NO ERROR STRING VALUE";

            // calculate the correct solution, and the calculators solution.
            double solution = num1 + num2;
            double calculation = calc.add(num1, num2);

            // calculate the error. 1.0 means no error in calculator
            double err = (calculation / solution);

            // Print error results, tally success rate as appropriate
            if (err == 1.0) {
                errorString = "(correct)";
                successRate++;
            } else {
                errorString = "(error)";
            }

            // print to console calculation results
            System.out.printf("%.15f + %.15f = %18.15f\t%-9s%15s%n", num1, num2, calculation, errorString,
                    Thread.currentThread().getName());

        } // for loop

        System.out.println(""); // formatting

        // return this calculators success rate
        return successRate / (double) NUM_OF_TESTS;

    } // runCalculations()

} // Solution{}
