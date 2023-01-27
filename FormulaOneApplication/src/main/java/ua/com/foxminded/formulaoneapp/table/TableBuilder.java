package main.java.ua.com.foxminded.formulaoneapp.table;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import main.java.ua.com.foxminded.formulaoneapp.model.RacerLap;
import main.java.ua.com.foxminded.formulaoneapp.table.constants.FormatConstants;

public class TableBuilder {

   public static String tableBuilder(List<RacerLap> info) throws IOException {
      int maxRacerNameLength = info.stream().mapToInt(it -> it.getRacer().getName().length()).max().orElse(20);
      int maxRacerTeamLength = info.stream().mapToInt(it -> it.getRacer().getTeam().length()).max().orElse(20);

      String formatTemplate = "%02d. %-" + maxRacerNameLength + "s | %-" + maxRacerTeamLength + "s | %s";

      final AtomicInteger index = new AtomicInteger();

      return info.stream()
         .sorted(Comparator.comparing(RacerLap::getDuration))
         .map(item -> generateBoard(item, formatTemplate, index.incrementAndGet()))
         .map(row -> {
            if (index.get() == 15) {
               return new StringBuilder()
                  .append(row)
                  .append("\n")
                  .append(repeatChar(row.length(), '-'));
            } else {
               return row;
            }
         })
         .collect(Collectors.joining("\n"));

   }

   private static String generateBoard(RacerLap info, String formatTemplate, int index) {

      LocalTime time = LocalTime.ofNanoOfDay(info.getDuration().toNanos());
      String timeOutput = time.format(FormatConstants.BOARD_TIME_FORMAT_PATTERN);

      return String.format(formatTemplate, index, info.getRacer().getName(),
         info.getRacer().getTeam(), timeOutput);
   }

   private static String repeatChar(int length, char ch) {
      StringBuilder builder = new StringBuilder();

      for (int i = 0; i < length; i++) {
         builder.append(ch);
      }

      return builder.toString();
   }
}






