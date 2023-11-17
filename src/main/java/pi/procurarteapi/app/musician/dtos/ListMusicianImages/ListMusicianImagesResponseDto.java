package pi.procurarteapi.app.musician.dtos.ListMusicianImages;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ListMusicianImagesResponseDto {
    private List<String> images;
    private String thumbnail;
    private String musicianId;
}
