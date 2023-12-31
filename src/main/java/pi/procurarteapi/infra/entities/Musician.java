package pi.procurarteapi.infra.entities;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;

@Document("musicians")
public class Musician  implements UserDetails{
    @Id
    private String id;

    private String email;
    private String password;
    private String name;
    private String phoneNumber;
    private String cpf;

    private Address address;
    private Portfolio portfolio;

    @DBRef
    private List<Instrument> instruments;

    @DBRef
    private List<MusicStyle> musicStyles;

    public Musician(String email, String password, String name, String phoneNumber, String cpf, Address address, Portfolio portfolio) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.portfolio = portfolio;
        this.cpf = cpf;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    @AllArgsConstructor
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
        private String instagramProfile;
        private String profilePhoto;
        private String thumbnail;
        private List<String> media;
        
        private Portfolio() {
        }
        
        public String getInstagramProfile() {
            return instagramProfile;
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
        
        public void setMedia(List<String> media) {
            this.media = media;
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

            public Builder instagramProfile(String instagramProfile) {
                portfolio.instagramProfile = instagramProfile;
                return this;
            }
    
            public Portfolio build() {
                return portfolio;
            }
        }

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;        
    }


}