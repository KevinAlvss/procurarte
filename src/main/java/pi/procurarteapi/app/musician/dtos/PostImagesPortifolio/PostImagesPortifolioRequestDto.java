package pi.procurarteapi.app.musician.dtos.PostImagesPortifolio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostImagesPortifolioRequestDto {
    private String id;
    private ImagesRequestDto Images;
}
