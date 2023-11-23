package pi.procurarteapi.app.musician.dtos.UpdateImagesPortifolio;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ImagesRequestDto {
    private List<String> Images;
}
