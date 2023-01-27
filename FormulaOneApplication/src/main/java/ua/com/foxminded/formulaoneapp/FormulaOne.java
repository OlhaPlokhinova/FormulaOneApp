package main.java.ua.com.foxminded.formulaoneapp;

import java.io.IOException;
import java.util.List;
import main.java.ua.com.foxminded.formulaoneapp.model.RacerLap;
import main.java.ua.com.foxminded.formulaoneapp.table.TableBuilder;
import main.java.ua.com.foxminded.formulaoneapp.utils.ReadingFileUtils;

public class FormulaOne {

   public static void main(String[] args) throws IOException {

      String abbreviationsFileName = "abbreviations.txt";
      String startFileName = "start.log";
      String endFileName = "end.log";

      List<RacerLap> racerLapInformation = ReadingFileUtils.buildStageBoard(startFileName, endFileName,
            abbreviationsFileName);

      String build = TableBuilder.tableBuilder(racerLapInformation);

      System.out.println(build);

   }
}
