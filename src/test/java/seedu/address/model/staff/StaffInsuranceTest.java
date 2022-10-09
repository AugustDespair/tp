package seedu.address.model.staff;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import seedu.address.model.staff.StaffInsurance;

public class StaffInsuranceTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new StaffInsurance(null));
    }

    @Test
    public void constructor_invalidStaffInsurance_throwsIllegalArgumentException() {
        String invalidStaffInsurance = "";
        assertThrows(IllegalArgumentException.class, () -> new StaffInsurance(invalidStaffInsurance));
    }

    @Test
    public void isValidStaffInsurance() {
        // null name
        assertThrows(NullPointerException.class, () -> StaffInsurance.isValidStaffInsurance(null));

        // invalid staff name
        assertFalse(StaffInsurance.isValidStaffInsurance("")); // empty string
        assertFalse(StaffInsurance.isValidStaffInsurance(" ")); // spaces only
        assertFalse(StaffInsurance.isValidStaffInsurance("^")); // only non-alphanumeric characters
        assertFalse(StaffInsurance.isValidStaffInsurance("peter*")); // contains non-alphanumeric characters

        // valid staff name
        assertTrue(StaffInsurance.isValidStaffInsurance("peter jack")); // alphabets only
        assertTrue(StaffInsurance.isValidStaffInsurance("12345")); // numbers only
        assertTrue(StaffInsurance.isValidStaffInsurance("peter the 2nd")); // alphanumeric characters
        assertTrue(StaffInsurance.isValidStaffInsurance("Capital Tan")); // with capital letters
        assertTrue(StaffInsurance.isValidStaffInsurance("David Roger Jackson Ray Jr 2nd")); // long names
    }
}



