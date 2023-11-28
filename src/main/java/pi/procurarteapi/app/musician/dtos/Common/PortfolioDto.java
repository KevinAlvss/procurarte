package pi.procurarteapi.app.musician.dtos.Common;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PortfolioDto {
    private String musicianDescription;
    private String instagramProfile;
    private String profilePhoto;
    private String thumbnail;
    private List<String> media;
}
