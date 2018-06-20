package cs271.lab.list;

import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestList {

  private List<Integer> list;

  @Before
  public void setUp() throws Exception {
    list = new ArrayList<Integer>();
    // list = new LinkedList<>(); No difference
    //DONE
  }

  @After
  public void tearDown() throws Exception {
    list = null;
  }

  @Test
  public void testSizeEmpty() {
    assertTrue(list.isEmpty());
    assertEquals(0, list.size());
    try {
      list.get(0);
      fail("there should not be any items in the list");
    } catch (Exception ex) {
    }
  }

  @Test
  public void testSizeNonEmpty() {
    //DONE
    list.add(77);
    assertEquals(false, list.isEmpty());
    assertEquals(1, list.size()); //after 77 1 element added
    assertEquals(77, list.get(0).intValue()); // 0 is first element, being 77
  }

  @Test
  public void testContains() {
    //list.contains(77);
    assertFalse(list.contains(77));
    list.add(77);
    assertTrue(list.contains(77));//Shows that the list does 77
    // DONE
    // list.contains(77)
    // that hold before and after adding 77 to the list
  }

  @Test
  public void testAddMultiple() {
    list.add(77);
    list.add(77);
    list.add(77);
    // TODO fix the expected values in the assertions below
    assertEquals(3, list.size());
    assertEquals(0, list.indexOf(77));
    assertEquals(77, list.get(1).intValue());
    assertEquals(2, list.lastIndexOf(77));
  }

  @Test
  public void testAddMultiple2() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // DONE
    assertEquals(7, list.size());
    assertEquals(1, list.indexOf(77));
    assertEquals(5, list.lastIndexOf(77));
    assertEquals(44, list.get(2).intValue());
    assertEquals(77, list.get(3).intValue());
    assertEquals(Arrays.asList(33, 77, 44, 77, 55, 77, 66), list);
  }

  @Test //DONE
  public void testRemoveObject() {
    list.add(3);
    list.add(77);
    list.add(4);
    list.add(77);
    list.add(5);
    list.add(77);
    list.add(6);
    list.remove(5); // what does this method do? Removes the 6th element, 77
    // TODO fix the expected values in the assertions below
    assertEquals(6, list.size());
    assertEquals(1, list.indexOf(77));
    assertEquals(3, list.lastIndexOf(77));
    assertEquals(4, list.get(2).intValue());
    assertEquals(77, list.get(3).intValue());
    list.remove(Integer.valueOf(5)); // what does this one do? It is removing the number 5
    assertEquals(5, list.size());
    assertEquals(1, list.indexOf(77));
    assertEquals(3, list.lastIndexOf(77));
    assertEquals(4, list.get(2).intValue());
    assertEquals(77, list.get(3).intValue());
  }

  @Test
  public void testContainsAll() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    assertTrue(list.containsAll(Arrays.asList(33,77,44,55,66)));
    assertFalse(list.containsAll(Arrays.asList(11,22,33)));
    // DONE
    // 1) assert that list contains all five different numbers added
    // 2) assert that list does not contain all of 11, 22, and 33
  }

  @Test
  public void testAddAll() {
    // DONE
    // add items to the list to make the following assertions pass
    // (without touching the assertions themselves)
    list.addAll(Arrays.asList(33,77,44,77,55,77,66));
    assertEquals(7, list.size());
    assertEquals(33, list.get(0).intValue());
    assertEquals(77, list.get(1).intValue());
    assertEquals(44, list.get(2).intValue());
    assertEquals(77, list.get(3).intValue());
    assertEquals(55, list.get(4).intValue());
    assertEquals(77, list.get(5).intValue());
    assertEquals(66, list.get(6).intValue());
  }

  @Test
  public void testRemoveAll() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // DONE
    // remove items from the list to make the following assertions pass
    // (without touching the assertions themselves)
    list.removeAll(Arrays.asList(33,44,55,66));
    assertEquals(3, list.size());
    assertEquals(Arrays.asList(77, 77, 77), list);
  }

  @Test
  public void testRetainAll() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // DONE
    // remove items from the list to make the following assertions pass
    // (without touching the assertions themselves)
    list.retainAll(Collections.singletonList(77));
    assertEquals(3, list.size());
    assertEquals(Arrays.asList(77, 77, 77), list);
  }

  @Test
  public void testSet() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // TODO use the set method to change specific elements in the list
    // such that the following assertions pass
    // (without touching the assertions themselves)
    list.set(1, 99);
    list.set(3, 99);
    list.set(5, 99);
    assertEquals(7, list.size());
    assertEquals(33, list.get(0).intValue());
    assertEquals(99, list.get(1).intValue()); //changed
    assertEquals(44, list.get(2).intValue());
    assertEquals(99, list.get(3).intValue()); //changed
    assertEquals(55, list.get(4).intValue());
    assertEquals(99, list.get(5).intValue()); //changed
    assertEquals(66, list.get(6).intValue());
  }

  @Test //DONE
  public void testSubList() {
    list.add(33);
    list.add(77);
    list.add(44);
    list.add(77);
    list.add(55);
    list.add(77);
    list.add(66);
    // TODO fix the arguments in the subList method so that the assertion
    // passes
    assertEquals(Arrays.asList(44, 77, 55), list.subList(2, 5));
  }
}
