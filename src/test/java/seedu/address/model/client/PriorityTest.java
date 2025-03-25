package seedu.address.model.client;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PriorityTest {

    @Test
    public void fromIntTest_validInt_successful(){
        assertEquals(Priority.fromInt(1), Priority.STANDARD);
        assertEquals(Priority.fromInt(2), Priority.PREMIUM);
        assertEquals(Priority.fromInt(3), Priority.VIP);
    }

    @Test
    public void fromIntTest_invalidInt_throwsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, () -> Priority.fromInt(0));
        assertThrows(IllegalArgumentException.class, () -> Priority.fromInt(4));
    }

    @Test
    public void toStringTest(){
        assertEquals(Priority.STANDARD.toString(), "STANDARD");
        assertEquals(Priority.PREMIUM.toString(), "PREMIUM");
        assertEquals(Priority.VIP.toString(), "VIP");
    }
}
