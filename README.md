# Bitwise-Operations-in-Java
The following functions are written in java which perform basic bitwise functions such as and,or,xor . It helps understand how the computer deals with bytes as by simply calling functions you can grasp an understanding of bitwise operations.
The following functions are written in java which perform basic bitwise functions such as and,or,xor . It helps understand how the computer deals with bytes as by simply calling functions you can grasp an understanding of bitwise operations.
# Functions Implemented

*        bit getBit(int i); // Get bit i
*         void setBit(int i, bit value); // set bit i's value
*         longword and(longword other); // and two longwords, returning a third
*         longword or(longword other); // or two longwords, returning a third
*         longword xor(longword other);// xor two longwords, returning a third
*         longword not(); // negate this longword, creating another
*         longword rightShift(int amount); // rightshift this longword by amount bits, creating a new longword
*         longword leftShift(int amount);// leftshift this longword by amount bits, creating a new longword
*         @Override
*         String toString(); // returns a comma separated string of “t” and “f” (provided by bit.toString())
*         long getUnsigned(); // returns the value of this longword as a long
*         int getSigned(); // returns the value of this longword as an int
*         void copy(longword other); // copies the values of the bits from another longword into this one
*         void set(int value); // set the value of the bits of this longword (used for tests)
