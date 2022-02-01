package lab11.task1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TestMultiMapValue {
    private MultiMapValue<String, String> map;

    @BeforeEach
    public void setup() {
        map = new MultiMapValue<>();
    }

    @AfterEach
    public void clean() {
        map = null;
    }

    @Test
    public void testAddElementWithOneValue() {
        map.add("key", "value");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(1, map.size());
        Assertions.assertEquals(1, map.getValues("key").size());
    }

    @Test
    public void testAddElementWithMoreValues() {
        map.add("key", "value1");
        map.add("key", "value2");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(1, map.size());
        Assertions.assertEquals(2, map.getValues("key").size());
    }

    @Test
    public void testAddTwoElements() {
        map.add("key1", "value1");
        map.add("key2", "value2");
        map.add("key2", "value3");
        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(2, map.size());
        Assertions.assertEquals(1, map.getValues("key1").size());
        Assertions.assertEquals(2, map.getValues("key2").size());

        Assertions.assertEquals("value1", map.getValues("key1").get(0));
        Assertions.assertEquals("value2", map.getValues("key2").get(0));
        Assertions.assertEquals("value3", map.getValues("key2").get(1));
    }

    @Test
    public void testGetFirst() {
        map.add("key", "value1");
        map.add("key", "value2");
        map.add("key", "value3");

        Assertions.assertFalse(map.isEmpty());
        Assertions.assertEquals(1, map.size());

        Assertions.assertEquals("value1", map.getFirst("key"));
    }

    @Test
    public void testContainsKey() {
        map.add("key1", "value1");
        map.add("key2", "value2");
        map.add("key3", "value3");

        Assertions.assertTrue(map.containsKey("key1"));
        Assertions.assertTrue(map.containsKey("key2"));
        Assertions.assertTrue(map.containsKey("key3"));

        Assertions.assertFalse(map.containsKey("key4"));

    }

    @Test
    public void testSize() {
        map.add("key1", "value1");
        map.add("key2", "value2");
        map.add("key3", "value3");
        map.add("key3", "value4");

        Assertions.assertEquals(3, map.size());
    }

    @Test
    public void testRemoveKey() {
        map.add("key1", "value1");
        map.add("key2", "value2");
        map.add("key2", "value3");
        map.add("key3", "value4");

        Assertions.assertEquals(3, map.size());
        Assertions.assertEquals("value3", (map.remove("key2")).get(1));
        Assertions.assertEquals(2, map.size());

        Assertions.assertTrue(map.containsKey("key1"));
        Assertions.assertFalse(map.containsKey("key2"));
        Assertions.assertTrue(map.containsKey("key3"));
    }

    @Test
    public void testAddAllWithList() {
        map.add("key1", "value1");
        map.add("key2", "value2");
        map.add("key3", "value3");

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("value4");
        arrayList.add("value5");
        arrayList.add("value6");

        Assertions.assertEquals(3, map.size());
        map.addAll("key4", arrayList);
        Assertions.assertEquals(4, map.size());
        Assertions.assertTrue(map.containsKey("key4"));
        Assertions.assertEquals("value5", map.getValues("key4").get(1));

        Assertions.assertEquals(4, map.size());
        map.addAll("key1", arrayList);
        Assertions.assertEquals(4, map.size());
        Assertions.assertEquals("value1", map.getValues("key1").get(0));
        Assertions.assertEquals("value4", map.getValues("key1").get(1));
        Assertions.assertEquals("value5", map.getValues("key1").get(2));
        Assertions.assertEquals("value6", map.getValues("key1").get(3));
    }

    @Test
    public void testAddAllWithMultiMapValue() {
        map.add("key1", "value1");
        map.add("key2", "value2");
        map.add("key3", "value3");
        MultiMapValue<String, String> map2 = new MultiMapValue<>();
        map2.add("key1", "value11");
        map2.add("key2", "value22");
        map2.add("key3", "value33");
        map2.add("key4", "value4");

        map.addAll(map2);

        Assertions.assertEquals(4, map.size());
        Assertions.assertEquals("value1", map.getValues("key1").get(0));
        Assertions.assertEquals("value11", map.getValues("key1").get(1));
        Assertions.assertEquals("value2", map.getValues("key2").get(0));
        Assertions.assertEquals("value22", map.getValues("key2").get(1));
        Assertions.assertEquals("value3", map.getValues("key3").get(0));
        Assertions.assertEquals("value33", map.getValues("key3").get(1));

        Assertions.assertTrue(map.containsKey("key4"));
        Assertions.assertEquals("value4", map.getValues("key4").get(0));
    }
}
