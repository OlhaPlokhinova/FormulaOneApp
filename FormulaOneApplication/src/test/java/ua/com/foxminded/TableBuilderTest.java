package test.java.ua.com.foxminded;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.List;
import main.java.ua.com.foxminded.formulaoneapp.model.RacerLap;
import main.java.ua.com.foxminded.formulaoneapp.table.TableBuilder;
import main.java.ua.com.foxminded.formulaoneapp.utils.ReadingFileUtils;

class TableBuilderTest {

   String abbreviationsFileName = "abbreviations.txt";
   String startFileName = "start.log";
   String endFileName = "end.log";

   @Test
   void ModelUtils_shouldReturnCompletedLines() throws IOException {

      String expected =

              "01. Sebastian Vettel  | FERRARI                       | 01:04.415"
           +"\n02. Daniel Ricciardo  | RED BULL RACING TAG HEUER     | 01:12.013"
           +"\n03. Valtteri Bottas   | MERCEDES                      | 01:12.434"
           +"\n04. Lewis Hamilton    | MERCEDES                      | 01:12.460"
           +"\n05. Stoffel Vandoorne | MCLAREN RENAULT               | 01:12.463"
           +"\n06. Kimi Raikkonen    | FERRARI                       | 01:12.639"
           +"\n07. Fernando Alonso   | MCLAREN RENAULT               | 01:12.657"
           +"\n08. Sergey Sirotkin   | WILLIAMS MERCEDES             | 01:12.706"
           +"\n09. Charles Leclerc   | SAUBER FERRARI                | 01:12.829"
           +"\n10. Sergio Perez      | FORCE INDIA MERCEDES          | 01:12.848"
           +"\n11. Romain Grosjean   | HAAS FERRARI                  | 01:12.930"
           +"\n12. Pierre Gasly      | SCUDERIA TORO ROSSO HONDA     | 01:12.941"
           +"\n13. Carlos Sainz      | RENAULT                       | 01:12.950"
           +"\n14. Esteban Ocon      | FORCE INDIA MERCEDES          | 01:13.028"
           +"\n15. Nico Hulkenberg   | RENAULT                       | 01:13.065"
           +"\n-----------------------------------------------------------------"
           +"\n16. Brendon Hartley   | SCUDERIA TORO ROSSO HONDA     | 01:13.179"
           +"\n17. Marcus Ericsson   | SAUBER FERRARI                | 01:13.265"
           +"\n18. Lance Stroll      | WILLIAMS MERCEDES             | 01:13.323"
           +"\n19. Kevin Magnussen   | HAAS FERRARI                  | 01:13.393";
      
      
      List<RacerLap> racerLapInformation = ReadingFileUtils.buildStageBoard(startFileName, endFileName,
            abbreviationsFileName);

      String actual = TableBuilder.tableBuilder(racerLapInformation);

      assertEquals(expected, actual);
   }

}
