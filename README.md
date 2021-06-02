# ApplitoolsHomeExercise
Take Home assignment for Applitools SWE Support role

## Background Story:
This implementation of the calculator is built to showcase an advanced futuristic technology 
based on Quantum calculations, which in some cases skews the result due to a small quantum
error.
The accuracy of the calculations is derived from the type of crystal that is used to store the
Qbits.

## Assignment:
Build a testing project, to test which one of the two crystals is better to be used (has a higher
accuracy rate).
Within your implementation, generate two instances of calculators with the following calculator
names:
1) Crystal 1
2) Crystal 2

In order to test the accuracy of each calculator, 20 pairs of random numbers should be
generated. An accurate result should be considered a “Successful Calculation” and a skewed
result should be considered an “Error”.

At the end of the 20 samples, each calculator test should produce a “Success Rate” calculated
as ((Number of Successful calculations) / 20)

The output of the program should print the calculations, whether they are correct or an error, the
success rates of the calculators and which Crystal is better to be used (the one with the higher
success rate) to the console.

## The implementation should:
1) Be written in Java.
2) Follow Object-Oriented concepts and written as modular as possible.
3) Include a separate thread running for each calculator (parallel runs).

# My Reflection on Assignment
I completed the assignment in a timely manner and thought I had reached the solution. 
I was not selected to move onto next steps, and when I inquired why, it was explained to me
that I did not follow the 3rd requirement, "Include a separate thread running for each calculator (parallel runs)".
I realised I had misunderstood the requirement, partly due to a gap in my knowledge of Threads in Java.

I had used threads in C++ during a couple of assignments for my Operating Systems course at CSUEB, but that was all.
I continued to complete the assignment in my free time and believe I have now successfully completed the assignment 
to the specified requirements.
