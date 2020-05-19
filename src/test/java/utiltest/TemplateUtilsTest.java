package utiltest;

import org.junit.Test;
import utils.TemplateUtils;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TemplateUtilsTest {


    @Test
    public void testGetTemplates() {
        assertArrayEquals(new String[]{"000", "001", "010", "011", "100", "101", "110", "111"},
                TemplateUtils.getTemplates(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTemplatesIllegalArgumentLower() {
        TemplateUtils.getTemplates(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetTemplatesIllegalArgumentHigher() {
        TemplateUtils.getTemplates(16);
    }


    @Test
    public void testCountOverlapping() {
        assertEquals(2, TemplateUtils.countOverlapping("01010001111", "00"));
        assertEquals(11, TemplateUtils.countOverlapping("111111111111", "11"));
    }

    @Test
    public void testCountNonOverlapping() {
        assertEquals(1, TemplateUtils.countNonOverlapping("01010001111", "00"));
        assertEquals(6, TemplateUtils.countNonOverlapping("111111111111", "11"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCountOverlappingIllegalArgument() {
        TemplateUtils.countNonOverlapping("01010011", "001010011");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCountNonOverlappingIllegalArgument() {
        TemplateUtils.countNonOverlapping("", "");
    }


}
