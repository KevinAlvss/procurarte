package pi.procurarteapi.infra.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("musicians")
public class Musician {
    @Id
    private String id;

    private String email;
    private String password;
    private String name;
    private String phoneNumber;
    private String instagramProfile;
    private Address address;
    private Portfolio portfolio;

    private Musician(Builder builder) {
        this.id = builder.id;
        this.email = builder.email;
        this.password = builder.password;
        this.name = builder.name;
        this.phoneNumber = builder.phoneNumber;
        this.instagramProfile = builder.instagramProfile;
        this.address = builder.address;
        this.portfolio = builder.portfolio;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id;
        private String email;
        private String password;
        private String name;
        private String phoneNumber;
        private String instagramProfile;
        private Address address;
        private Portfolio portfolio;

        private Builder() {}

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder instagramProfile(String instagramProfile) {
            this.instagramProfile = instagramProfile;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder portfolio(Portfolio portfolio) {
            this.portfolio = portfolio;
            return this;
        }

        public Musician build() {
            return new Musician(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInstagramProfile() {
        return instagramProfile;
    }

    public void setInstagramProfile(String instagramProfile) {
        this.instagramProfile = instagramProfile;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public static class Address {
        private String street;
        private String state;
        private String postalCode;
        private String number;
        private String complement;

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getComplement() {
            return complement;
        }

        public void setComplement(String complement) {
            this.complement = complement;
        }
    }

    public static class Portfolio {
        private String musicianDescription;
        private String profilePhoto;
        private String thumbnail;
        private List<String> media;

        public String getMusicianDescription() {
            return musicianDescription;
        }

        public void setMusicianDescription(String musicianDescription) {
            this.musicianDescription = musicianDescription;
        }

        public String getProfilePhoto() {
            return profilePhoto;
        }

        public void setProfilePhoto(String profilePhoto) {
            this.profilePhoto = profilePhoto;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public List<String> getMedia() {
            return media;
        }

        public void setMedia(List<String> media) {
            this.media = media;
        }

    }
}