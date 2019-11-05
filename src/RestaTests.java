import org.junit.Test;

import static org.junit.Assert.assertEquals;

public
class RestaTests{

    @Test

    public void test01Restar() {

        Suma suma = new Suma();

        assertEquals(suma.resta(4,2), 2);
    }


}
