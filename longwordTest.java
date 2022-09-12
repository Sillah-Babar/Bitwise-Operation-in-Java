import static org.junit.Assert.*;

public class longwordTest {
    longword word=new longword(5);
    longword word2=new longword(5);
    bit obj;
    bit obj2;
    @org.junit.Before
    public void createVariables()
    {

        obj=new bit();
        obj.set(true);
        obj2=new bit();
        obj2.set(false);
        word.setBit(0,obj2);
        word.setBit(1,obj);
        word.setBit(2,obj2);
        word.setBit(3,obj);
        word.setBit(4,obj2);

        word2.setBit(0,obj2);
        word2.setBit(1,obj);
        word2.setBit(2,obj2);
        word2.setBit(3,obj);
        word2.setBit(4,obj);

    }

    @org.junit.Test
    public void getBit() {

        assertEquals(word.getBit(0).getValue(),false);
        assertEquals(true,word.getBit(1).getValue());
        assertEquals(false,word.getBit(2).getValue());
        assertEquals(true,word.getBit(3).getValue());
        assertEquals(false,word.getBit(4).getValue());
    }

    @org.junit.Test
    public void setBit() {
        word.setBit(4,obj);
        assertEquals(true,word.getBit(4).getValue());
        word.setBit(4,obj2);
        assertEquals(false,word.getBit(4).getValue());
    }

    @org.junit.Test
    public void and() {
        longword wr=word.and(word2);
        assertEquals(wr.getBit(0).getValue(),false);
        assertEquals(wr.getBit(1).getValue(),true);
        assertEquals(wr.getBit(2).getValue(),false);
        assertEquals(wr.getBit(3).getValue(),true);
        assertEquals(wr.getBit(4).getValue(),false);
    }

    @org.junit.Test
    public void or() {
        longword wr=word.or(word2);
        assertEquals(wr.getBit(0).getValue(),false);
        assertEquals(wr.getBit(1).getValue(),true);
        assertEquals(wr.getBit(2).getValue(),false);
        assertEquals(wr.getBit(3).getValue(),true);
        assertEquals(wr.getBit(4).getValue(),true);
    }

    @org.junit.Test
    public void xor() {
        longword wr=word.xor(word2);
        assertEquals(wr.getBit(0).getValue(),false);
        assertEquals(wr.getBit(1).getValue(),false);
        assertEquals(wr.getBit(2).getValue(),false);
        assertEquals(wr.getBit(3).getValue(),false);
        assertEquals(wr.getBit(4).getValue(),true);
    }

    @org.junit.Test
    public void not() {
        longword result =word.not();

        assertEquals(result.getBit(0).getValue(),true);
        assertEquals(result.getBit(1).getValue(),false);
        assertEquals(result.getBit(2).getValue(),true);
        assertEquals(result.getBit(3).getValue(),false);
        assertEquals(result.getBit(4).getValue(),true);

    }

    @org.junit.Test
    public void rightShift() {
        longword new_word=word.rightShift(2);
        assertEquals(new_word.getBit(0).getValue(),false);
        assertEquals(new_word.getBit(1).getValue(),true);
        assertEquals(new_word.getBit(2).getValue(),false);
        assertEquals(new_word.getBit(3).getValue(),false);
        assertEquals(new_word.getBit(4).getValue(),false);

    }

    @org.junit.Test
    public void leftShift() {
        longword new_word=word.rightShift(3);
        assertEquals(new_word.getBit(0).getValue(),true);
        assertEquals(new_word.getBit(1).getValue(),false);
        assertEquals(new_word.getBit(2).getValue(),false);
        assertEquals(new_word.getBit(3).getValue(),false);
        assertEquals(new_word.getBit(4).getValue(),false);
    }

    @org.junit.Test
    public void getUnsigned() {
        long val=word.getUnsigned();
        assertEquals(10,val);
        long val2=word2.getUnsigned();
        assertEquals(26,val2);
    }

    @org.junit.Test
    public void getSigned() {
        long val=word.getSigned();
        assertEquals(10,val);
        long val2=word2.getSigned();
        assertEquals(-10,val2);
    }

    @org.junit.Test
    public void copy() {
         word.copy(word2);

        assertEquals(word2.getBit(0).getValue(),word.getBit(0).getValue());
        assertEquals(word2.getBit(1).getValue(),word.getBit(1).getValue());
        assertEquals(word2.getBit(2).getValue(),word.getBit(2).getValue());
        assertEquals(word2.getBit(3).getValue(),word.getBit(3).getValue());
        assertEquals(word2.getBit(4).getValue(),word.getBit(4).getValue());
    }

    @org.junit.Test
    public void set() {
        word.set(8);
        assertEquals(word.getBit(0).getValue(),false);
        assertEquals(false,word.getBit(1).getValue());
        assertEquals(false,word.getBit(2).getValue());
        assertEquals(true,word.getBit(3).getValue());
        assertEquals(false,word.getBit(4).getValue());
    }

    @org.junit.Test
    public void testToString() {
        String str=word.toString();
        String real="f,t,f,t,f";
        assertEquals(real,str);

    }
    @org.junit.Test
    public void main()
    {

    }
}