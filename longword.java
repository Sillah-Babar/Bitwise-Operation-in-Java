import java.util.Scanner;

public class longword implements ILongword{
    private bit [] bits;
    private int ArrayLength;

    //constructor to initialize the array of a specific size
    public longword(int len)
    {
        while(len<0)
        {
            System.out.println("You have entered a negative value for Array Length. Enter Again");
            Scanner obj=new Scanner(System.in);
            len=obj.nextInt();

        }
        ArrayLength=len;
        bits=new bit[ArrayLength];
        //to clear the array and set everything to false
        for(int i=0 ;i<ArrayLength ;i++)
        {
            bits[i]=new bit();
            bits[i].clear();
        }

    }
    @Override
    public bit getBit(int i) {
        //looping over the array
        for(int j=0 ; j<ArrayLength;j++)
        {
            if(j==i)
                return bits[j];
        }
        return null;
    }

    @Override
    public void setBit(int i, bit value) {
        //looping over the array
        for(int j=0 ; j<ArrayLength ;j++)
        {
            //set the bit at index j to this value
            if(j==i)
               bits[j]=value;
        }
    }

    @Override
    public longword and(longword other) {
        longword result= new longword(ArrayLength);
        //set everything to false
        for(int i=0 ; i<result.ArrayLength ;i++)
        {
            result.bits[i]=new bit();
            result.bits[i].clear();
        }
        if(this.ArrayLength== other.ArrayLength)
        {
           for(int i=0 ; i<other.ArrayLength ;i++)
           {
               //set the bit at index i by performing and with the other longword
               result.setBit(i,this.bits[i].and(other.getBit(i)));

           }
           return result;
        }
        else
        {
            System.out.println("And operation cannot be performed as the two longwords are of different sizes");
            return null;
        }
    }

    @Override
    public longword or(longword other) {
        longword result= new longword(ArrayLength);
        //set everything to zero
        for(int i=0 ; i<result.ArrayLength ;i++)
        {
            result.bits[i]=new bit();
            result.bits[i].clear();
        }
        if(this.ArrayLength== other.ArrayLength)
        {
            for(int i=0 ; i<other.ArrayLength ;i++)
            {
                //set the bit at index i by performing or with the other longword
                result.setBit(i,this.bits[i].or(other.getBit(i)));

            }
            return result;
        }
        else
        {
            System.out.println("OR operation cannot be performed as the two longwords are of different sizes");
            return null;
        }
    }

    @Override
    public longword xor(longword other) {
        longword result= new longword(ArrayLength);
        for(int i=0 ; i<result.ArrayLength ;i++)
        {
            //set everything to zero
            result.bits[i]=new bit();
            result.bits[i].clear();
        }
        if(this.ArrayLength== other.ArrayLength)
        {
            for(int i=0 ; i<other.ArrayLength ;i++)
            {
                //set the bit at index i by performing xor with the other longword
                result.setBit(i,this.bits[i].xor(other.getBit(i)));

            }
            return result;
        }
        else
        {
            System.out.println("XOR operation cannot be performed as the two longwords are of different sizes");
            return null;
        }
    }

    @Override
    public longword not() {
        longword result=new longword(this.ArrayLength);
        result.ArrayLength=this.ArrayLength;
        for(int i=0 ; i<result.ArrayLength ;i++)
        {
            //set everything to zero
            result.bits[i]=new bit();
            result.bits[i].clear();
        }

        for(int i=0 ; i<result.ArrayLength ;i++)
        {
            //if value is false set the resultant to true
            if(this.bits[i].getValue()==false) {
                bit obj=new bit();
                obj.set(true);
                result.setBit(i, obj);
            }
            else
            {
                //if value is true set the resultant to false
                bit obj=new bit();
                obj.set(false);
                result.setBit(i, obj);
            }
        }


        return result;
    }

    @Override
    public longword rightShift(int amount) {
        longword result=new longword(this.ArrayLength);
        result.ArrayLength=this.ArrayLength;
        //set everything to zero
        for(int i=0 ; i<result.ArrayLength ;i++)
        {
            result.bits[i]=new bit();
            result.bits[i].clear();
        }

        longword new_result=new longword(this.ArrayLength);
        new_result.ArrayLength=this.ArrayLength;
        for(int i=0 ; i<result.ArrayLength ;i++)
        {
            //set everything to zero
            new_result.bits[i]=new bit();
            new_result.bits[i].clear();
        }
        if(amount>0)
        {
            int count=amount;
            //initially shifting the bits by one to the right
            for (int i = this.ArrayLength - 1; i > 0; i--) {
                result.bits[i] = this.bits[i - 1];
            }
            //setting the least significant bit to zero
            result.bits[0].clear();
            count--;

            //remaining amounts shifted
            while (count!=0) {
                for (int i = this.ArrayLength - 1; i > 0; i--) {
                    result.bits[i] =   result.bits[i - 1];
                }
                result.bits[0].clear();
                count--;
            }
            //flipping the resultant longword
            int k=0;
            for(int i=ArrayLength-1 ; i>=0 ;i--)
            {
                new_result.bits[k]=result.bits[i];
                        k++;
            }
            return new_result;
        }
        else
        {
            System.out.println("The number of bits you want to shift are nagative hence cannot be shifted");
        }
        return null;
    }

    @Override
    public longword leftShift(int amount) {
        longword result=new longword(this.ArrayLength);
        result.ArrayLength=this.ArrayLength;
        //set everything to zero
        for(int i=0 ; i<result.ArrayLength ;i++)
        {
            result.bits[i]=new bit();
            result.bits[i].clear();
        }

        longword new_result=new longword(this.ArrayLength);
        new_result.ArrayLength=this.ArrayLength;

        //set everything to zero
        for(int i=0 ; i<result.ArrayLength ;i++)
        {
            new_result.bits[i]=new bit();
            new_result.bits[i].clear();
        }
        if(amount>0)
        {
            int count=amount;
            //initially shifting the bits by one to left
            for (int i = 0; i < result.ArrayLength-1; i++) {
                result.bits[i] = this.bits[i + 1];
            }
            result.bits[result.ArrayLength-1].clear();
            count--;

            //remaining amounts shifted
            while (count!=0) {
                for (int i = 0; i < result.ArrayLength-1; i++) {
                    result.bits[i] =   result.bits[i + 1];
                }
                //setting the most significant bit to zero
                result.bits[result.ArrayLength-1].clear();
                count--;
            }
            int k=0;
            //flipping the resulant long word
            for(int i=ArrayLength-1 ; i>=0 ;i--)
            {
                new_result.bits[k]=result.bits[i];
                k++;
            }
            return new_result;
        }
        else
        {
            System.out.println("The number of bits you want to shift are nagative hence cannot be shifted");
        }

        return null;
    }

    @Override
    public long getUnsigned() {
        long factor=1;
        long sum=0;
        for(int i=0 ; i<this.ArrayLength ;i++)
        {
            long product=0;

            //if the bit is true then multipky it with factor and store the value in sum
            if(this.bits[i].getValue()==true)
            {
                int val=1;
                product=val*factor;

                sum+=product;
                factor=factor*2;


            }
            else
            {
                //if the bit is false then multiply it with factor and store the value in sum
                int val=0;
                product=val*factor;
                sum+=product;
                factor=factor*2;
            }

        }

        return sum;
    }

    @Override
    public int getSigned() {
        long factor=1;
        int sum=0;
        for(int i=0 ; i<ArrayLength-1 ;i++)
        {
            if(this.bits[i].getValue()==true)
            {
                //if the bit is true then multipky it with factor and store the value in sum
                int val=1;
                long product=val*factor;
                sum+=product;
                factor=factor*2;


            }
            else
            {
                //if the bit is false then multiply it with factor and store the value in sum
                int val=0;
                long product=val*factor;
                sum+=product;
                factor=factor*2;
            }
        }
        //see the sign of most significant bit and if its true , set the sum to negative

        if(this.bits[ArrayLength-1].getValue()==true)
        {
            sum=-(sum);
        }
        return sum;
    }

    @Override
    public void copy(longword other) {
        if(this.ArrayLength==other.ArrayLength) {
            //copying the other longword bit by bit
            for (int i = 0; i < other.ArrayLength; i++)
            {
                this.setBit(i,other.getBit(i));
            }
        }
        else
        {
            System.out.println("This longword cannot be copied as the size of bits array is small");
        }
    }

    @Override
    public void set(int value) {
     int size=ArrayLength;
     size=size-1;
     int factor=1;
     //calculating the maximum factor by counting the number of bits and respectively mutiplying by 2
     while(size!=0)
     {
        factor=factor*2;
         size-=1;
     }

     for(int i=ArrayLength-1;i>=0 ;i--)
        {
            int product=0;
                //calculating the value at each bit position by mutiplying it by factor
                int val=1;
                product=val*factor;
                //if the value-product is less than zero then we turn off that bit
            if(value-product<0) {
                bit obj=new bit();
                obj.set(false);
                this.setBit(i,obj);

            }
            else {
                //if the value-product is greater than zero then we turn on that bit and subtract it from the sum
                bit obj=new bit();
                obj.set(true);
                this.setBit(i,obj);
                value=value-product;
            }
            factor=factor/2;

        }

    }
    @Override
    public String toString() // returns a comma separated string of “t” and “f” (provided by bit.toString())
    {
        String result = "";
        for(int i=ArrayLength-1 ; i>=0 ;i--)
        {
            if(this.bits[i].getValue()==true)
            {
                result+="t";
            }
            else
            {
                result+="f";
            }
            if(i!=0)
            result+=",";
        }
        return result;
    }
}
