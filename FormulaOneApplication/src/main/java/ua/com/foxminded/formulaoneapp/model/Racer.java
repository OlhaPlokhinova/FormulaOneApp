package main.java.ua.com.foxminded.formulaoneapp.model;

import java.util.Objects;

public class Racer {

   private String abbreviation;
   private String name;
   private String team;

   public Racer(String abbreviation, String name, String team) {
      this.abbreviation = abbreviation;
      this.name = name;
      this.team = team;
   }

   public String getAbbreviation() {
      return abbreviation;
   }

   public void setAbbreviation(String abbreviation) {
      this.abbreviation = abbreviation;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getTeam() {
      return team;
   }

   public void setTeam(String team) {
      this.team = team;
   }

   @Override
   public int hashCode() {
      return Objects.hash(abbreviation, name, team);
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      Racer other = (Racer) obj;
      return Objects.equals(abbreviation, other.abbreviation) && Objects.equals(name, other.name)
            && Objects.equals(team, other.team);
   }

   @Override
   public String toString() {
      return "Racer [abbreviation=" + abbreviation + ", name=" + name + ", team=" + team + "]";
   }

}


