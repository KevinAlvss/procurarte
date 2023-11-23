package pi.procurarteapi.app.musician.dtos.UpdateImagesPortifolio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateImagesPortifolioRequestDto {
    private String id;
    private ImagesRequestDto Images;
}
