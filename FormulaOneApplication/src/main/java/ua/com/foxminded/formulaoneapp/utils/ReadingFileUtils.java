package main.java.ua.com.foxminded.formulaoneapp.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import main.java.ua.com.foxminded.formulaoneapp.model.Racer;
import main.java.ua.com.foxminded.formulaoneapp.model.RacerLap;
import main.java.ua.com.foxminded.formulaoneapp.table.constants.ExceptionConstants;
import main.java.ua.com.foxminded.formulaoneapp.table.constants.FormatConstants;
import main.java.ua.com.foxminded.formulaoneapp.table.constants.ValidationPatternConstants;

public class ReadingFileUtils {

   private ReadingFileUtils() {
   }

   public static List<RacerLap> buildStageBoard(String startLogFileName, String endLogFileName, String abbrFileName)
         throws FileNotFoundException {

      try {

         FileReader reader = new FileReader();

         List<String> startList = reader.readLines(startLogFileName);
         List<String> endList = reader.readLines(endLogFileName);
         List<String> abbreviationsList = reader.readLines(abbrFileName);

         return generateLapsInfo(startList, endList, abbreviationsList).collect(Collectors.toList());
      } catch (IOException e) {
         throw new FileNotFoundException(e.getMessage());
      }
   }

   private static Stream<RacerLap> generateLapsInfo(List<String> startList, List<String> endList,
         List<String> abbreviationsList) {

      return racersToString(abbreviationsList).stream().map(racer -> {

         LocalDateTime startTime = parseLapInfo(startList, racer);
         LocalDateTime endTime = parseLapInfo(endList, racer);

         Duration lapDuration = Duration.between(startTime, endTime);

         return new RacerLap(startTime, endTime, lapDuration, racer);
      });
   }

   private static LocalDateTime parseLapInfo(List<String> list, Racer racer) {
      ReadingFileUtils parser = new ReadingFileUtils();

      return parser.parseTimeDateFromString(list.stream().filter(line -> line.startsWith(racer.getAbbreviation()))
            .findAny().orElseThrow(() -> new NoSuchElementException("No element in start.log")).substring(3));
   }

   private static LocalDateTime parseTimeDateFromString(String dateTime) {

      if (dateTime == null || dateTime.isEmpty()) {
         throw new IllegalArgumentException(ExceptionConstants.EMPTY_ARGUMENT);
      }
      if (!dateTime.matches(ValidationPatternConstants.DATE_TIME)) {
         throw new IllegalArgumentException(ExceptionConstants.ARGUMENT_FORMAT);
      }

      return LocalDateTime.parse(dateTime, FormatConstants.DATE_FORMAT_PATTERN);
   }

   public static List<Racer> racersToString(List<String> abbreviations) {
      ReadingFileUtils creat = new ReadingFileUtils();
      return abbreviations.stream().map(creat::creatRacerToString).collect(Collectors.toList());
   }

   private Racer creatRacerToString(String abbrFileName) {
      String[] params = abbrFileName.split("_");
      return new Racer(params[0], params[1], params[2]);
   }

}









