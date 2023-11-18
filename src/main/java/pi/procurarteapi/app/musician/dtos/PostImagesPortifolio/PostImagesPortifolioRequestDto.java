package pi.procurarteapi.app.musician.dtos.PostImagesPortifolio;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostImagesPortifolioRequestDto {
    private List<String> Images;
}
