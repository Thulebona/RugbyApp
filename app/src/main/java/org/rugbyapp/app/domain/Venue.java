package org.rugbyapp.app.domain;

import java.io.Serializable;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class Venue implements Serializable {

    private String location;
    private String venueName;
    private int number_of_seat =0;

    private Venue() {
    }

    public Venue(Builder builder) {
       // this.Id = builder.Id;
        this.location = builder.location;
        this.venueName = builder.venueName;
        this.number_of_seat = builder.number_of_seat;

    }

    /*public Long getId() {
        return Id;
    }*/

    public String getLocation() {
        return location;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getNumber_of_seat() {
        return number_of_seat;
    }

    public static class Builder{
       // private Long Id;
        private String location;
        private String venueName;
        private int number_of_seat= 0;

        public Builder(String val){
            this.venueName = val;
        }
        public Builder location(String val){
            this.location = val;
            return this;
        }
     /*   public Builder id(Long val){
            this.Id = val;
            return this;
        }*/
        public Builder number_of_seat(int val){
            this.number_of_seat = val;
            return this;
        }
        public Venue build(){
            return new Venue(this);
        }
        public Builder copy(Venue val){
          //  this.Id = val.Id;
            this.location = val.location;
            this.venueName = val.venueName;
            this.number_of_seat = val.number_of_seat;
            return this;
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venue venue = (Venue) o;

        return !(venueName != null ? !venueName.equals(venue.venueName) : venue.venueName != null);

    }

    @Override
    public int hashCode() {
        return venueName != null ? venueName.hashCode() : 0;
    }
}
