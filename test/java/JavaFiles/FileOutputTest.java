package JavaFiles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileOutputTest {

  FileOutput testOutput;

  @BeforeEach
  void setUp() {
    testOutput = new FileOutput(
        "/Users/yang/Desktop/CS5004_sp23/Team_repo_Yangyang_Yizhou_Zheng/hw08/src/main/java/OutputFiles",
        "test");
  }

  @Test
  void writeFile() {
    List<String> test = new ArrayList<>();
    test.add("good morning");
    assertThrows(IOException.class, () -> testOutput.writeFile(test));
  }

  @Test
  void testEquals() {
    assertTrue(testOutput.equals(testOutput));

    assertFalse(testOutput.equals(null));
    assertFalse(testOutput.equals("null"));

    assertFalse(testOutput.equals(
        new FileOutput("/Users/yang/Desktop/CS5004_sp23/Team_repo_Yangyang_Yizhou_Zheng/hw08/src",
            "test")));
    assertFalse(testOutput.equals(new FileOutput(
        "/Users/yang/Desktop/CS5004_sp23/Team_repo_Yangyang_Yizhou_Zheng/hw08/src/main/java/OutputFiles",
        "test1")));
    assertFalse(testOutput.equals(new FileOutput(
        "/Users/yang/Desktop/CS5004_sp23/Team_repo_Yangyang_Yizhou_Zheng/hw08/src/main", "test1")));
  }

  @Test
  void testHashCode() {
    assertNotEquals(0, testOutput.hashCode());
  }

  @Test
  void testToString() {
    assertNotNull(testOutput.toString());
  }
}