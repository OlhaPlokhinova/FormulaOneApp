package test.java.ua.com.foxminded;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

import main.java.ua.com.foxminded.formulaoneapp.utils.FileReader;

class FileReaderTest {

   FileReader reader = new FileReader();

   @Test
   void FileReader_shouldReturnFileNotEx_ifFileIsNotFind() {
      assertThrows(FileNotFoundException.class, () -> {
         reader.readLines("fakeFile");
      });

   }

   @Test
   void FileReader_shouldReturnIlligalE_ifFileIsEmpty() throws IOException {
      assertThrows(IllegalArgumentException.class, () -> {
         reader.readLines("emptyTestFile");

      });
   }

   @Test
   void shouldReturnNonEmptyLine() throws IOException {
      List<String> list = reader.readLines("end.log");

      String actual = list.get(1);
      String expected = "RGH2018-05-24_12:06:27.441";
      assertEquals(actual.length(), expected.length());
   }

}




