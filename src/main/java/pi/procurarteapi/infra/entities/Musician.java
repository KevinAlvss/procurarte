package pi.procurarteapi.infra.entities;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

    @DBRef
    private List<Instrument> instruments;

    @DBRef
    private List<MusicStyle> musicStyles;

    public Musician(String id, String email, String password, String name, String phoneNumber,
            String instagramProfile, Address address, Portfolio portfolio, List<Instrument> instruments, List<MusicStyle> musicStyles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.instagramProfile = instagramProfile;
        this.address = address;
        this.portfolio = portfolio;
        this.instruments = instruments;
        this.musicStyles = musicStyles;
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

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }

    public List<MusicStyle> getMusicStyles() {
        return musicStyles;
    }

    public void setMusicStyles(List<MusicStyle> musicStyles) {
        this.musicStyles = musicStyles;
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

        private Portfolio() {
        }

        public String getMusicianDescription() {
            return musicianDescription;
        }

        public String getProfilePhoto() {
            return profilePhoto;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public List<String> getMedia() {
            return media;
        }

        public static class Builder {
            private final Portfolio portfolio;
    
            public Builder() {
                portfolio = new Portfolio();
            }
    
            public Builder musicianDescription(String musicianDescription) {
                portfolio.musicianDescription = musicianDescription;
                return this;
            }
    
            public Builder profilePhoto(String profilePhoto) {
                portfolio.profilePhoto = profilePhoto;
                return this;
            }
    
            public Builder thumbnail(String thumbnail) {
                portfolio.thumbnail = thumbnail;
                return this;
            }
    
            public Builder media(List<String> media) {
                portfolio.media = media;
                return this;
            }
    
            public Portfolio build() {
                return portfolio;
            }
        }

    }
}