package com.myapp;
import com.myapp.domain.Item;
import com.myapp.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = InventoryManaApplication.class)
public class InventoryManaApplicationTests {
 @Autowired
 ItemRepository itemRepository;
 
 @Before
 
 public void setUp() throws Exception {
  itemRepository.deleteAll();
  Item pandemic = new Item("Pandemic", "Co-op game for wannabe disease control specailists");
  Item werewolf = new Item("Werewolf", "You must find out who's secretly the werewolf, before it's too late");
  Item camelUp = new Item("Camel Up", "A high stakes game of gambling and camel racing");
  itemRepository.save(pandemic);
  itemRepository.save(werewolf);
  itemRepository.save(camelUp);
 }
 @Test
 public void testLoadItem() {
     List<Item> items = (ArrayList<Item>) itemRepository.findAll();
     assertEquals("Did not get all items", 3, items.size());
 }
 @Test
 public void testFindItem() throws Exception {
  List<Item> camelUpList = itemRepository.findByName("Camel Up");
  assertEquals("Found wrong number of Camel Ups", 1, camelUpList.size());
  assertEquals("Found wrong name", "Camel Up", camelUpList.get(0).getName());
 }
 @Test
 public void testCRUD() throws Exception {
  // Create a new game
  Item munchkin = new Item("Munchkin", "A wild game for wild people.");
  itemRepository.save(munchkin);
  // Assert it was created
  List<Item> foundGame = itemRepository.findByName(munchkin.getName());
  assertEquals("Did not find Munchkin", munchkin.getName(), foundGame.get(0).getName());
  // Edit it's description
  String newDescription = "If you love rules that change, you'll love Munchkin!";
  foundGame.get(0).setDescription(newDescription);
  // Save to the database (note that we can save not just single Entities, but collections of them as well)
  itemRepository.save(foundGame);
  // Assert it updated
  List<Item> updatedGame = itemRepository.findByName(munchkin.getName());
  assertEquals("Did not update description", newDescription, updatedGame.get(0).getDescription());
  // Delete game
  itemRepository.delete(updatedGame);
  // Assert not found
  List<Item> emptyGame = itemRepository.findByName(munchkin.getName());
  assertEquals("Should have returned no games", 0, emptyGame.size());
 }
}