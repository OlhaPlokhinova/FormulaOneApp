package main.java.ua.com.foxminded.formulaoneapp.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class RacerLap {

   private LocalDateTime startDateTime;
   private LocalDateTime endDateTime;
   private Duration duration;
   private Racer racer;

   public RacerLap(LocalDateTime startDateTime, LocalDateTime endDateTime, Duration duration, Racer racer) {
      this.startDateTime = startDateTime;
      this.endDateTime = endDateTime;
      this.duration = duration;
      this.racer = racer;
   }

   public LocalDateTime getStartDateTime() {
      return startDateTime;
   }

   public void setStartDateTime(LocalDateTime startDateTime) {
      this.startDateTime = startDateTime;
   }

   public LocalDateTime getEndDateTime() {
      return endDateTime;
   }

   public void setEndDateTime(LocalDateTime endDateTime) {
      this.endDateTime = endDateTime;
   }

   public Duration getDuration() {
      return duration;
   }

   public void setDuration(Duration duration) {
      this.duration = duration;
   }

   public Racer getRacer() {
      return racer;
   }

   public void setRacer(Racer racer) {
      this.racer = racer;
   }

   @Override
   public String toString() {
      return "RacerLap [startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", duration=" + duration
            + ", racer=" + racer + "]";
   }

   @Override
   public int hashCode() {
      return Objects.hash(duration, endDateTime, racer, startDateTime);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      RacerLap other = (RacerLap) obj;
      return Objects.equals(duration, other.duration) && Objects.equals(endDateTime, other.endDateTime)
            && Objects.equals(racer, other.racer) && Objects.equals(startDateTime, other.startDateTime);
   }
   

}




