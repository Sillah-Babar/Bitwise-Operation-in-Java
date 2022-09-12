public class bit {
    private boolean value;

    //initializes the bit
    //sets the value of the bit
   public void set(boolean value)
    {
    if(value == true)
        this.value = value;
    else if (value == false)
        this.value = value;
    else
        throw new IllegalArgumentException("ERROR: bit must must be true or false");
    }

    //changes value from true or false
    void toggle(){
    if (value == false)
        value = true;
    else value = false;
    }

    //sets the bit to true
    void set()
    {
    value = true;
    }

    //sets the bit to false
    void clear()
    {
    value = false;
    }

    //returns the current value
    boolean getValue()
    {
    return value;
    }

    //performs and on two bits and returns a new bit to set the output
public bit and(bit other) {

    bit output = new bit();// new bit that stores the output
    if (value == true && other.getValue()==true) // if value is false then output must be false
        output.set();
    else {
        output.clear();
    }
    return output;

}

//performs or on two bits and returns a new bit to set the output
public bit or(bit other){
bit output = new bit();
if(value == true)
    output.set();
else
{
    if(other.getValue()==true)
        output.set();
    else
        output.clear();
}
return output;
}

//performs xor on two bits and returns a new bit to set the output
public bit xor(bit other) {
    bit output = new bit();
    if (value == true) {
        if (other.getValue() == false)
            output.set();
        else
            output.clear();
    } else
    {
        if(other.getValue()== true)
            output.set();
        else
            output.clear();
}
return output;
}


//performs not on the existing bit, returning the output as a new bit
public bit not() {
    if(value == false)
        this.set();
    else
        this.clear();

    return this;
}


    }


