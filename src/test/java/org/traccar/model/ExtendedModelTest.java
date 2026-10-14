package org.traccar.model;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class ExtendedModelTest {

    private final String testKey = "test";

    @Test
    public void testByteSetterIgnoresNull() {
        ExtendedModel extendedModel = new ExtendedModel();
        extendedModel.set(testKey, (Byte) null);

        assertFalse(extendedModel.hasAttribute(testKey));
    }

    @Test
    public void testShortSetterIgnoresNull() {
        ExtendedModel extendedModel = new ExtendedModel();
        extendedModel.set(testKey, (Short) null);

        assertFalse(extendedModel.hasAttribute(testKey));
    }

    @Test
    public void testFloatSetterIgnoresNull() {
        ExtendedModel extendedModel = new ExtendedModel();
        extendedModel.set(testKey, (Float) null);

        assertFalse(extendedModel.hasAttribute(testKey));
    }
}
