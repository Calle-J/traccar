package org.traccar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;

import java.util.AbstractMap;
import java.util.Map;
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

    @Test
    public void testAddIgnoresNullObject() {
        ExtendedModel extendedModel = new ExtendedModel();
        Map<String, Object> attributes = extendedModel.getAttributes();
        extendedModel.add(null);

        assertEquals(attributes, extendedModel.getAttributes());
    }

    @Test
    public void testAddIgnoresNullValue() {
        Map.Entry<String, Object> entry = new AbstractMap.SimpleEntry<>(testKey, null);
        ExtendedModel extendedModel = new ExtendedModel();
        Map<String, Object> attributes = extendedModel.getAttributes();
        extendedModel.add(entry);

        assertEquals(attributes, extendedModel.getAttributes());
    }
}
