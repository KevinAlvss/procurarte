package pi.procurarteapi.mockFactory.musician.musicianMockTypes;

import java.util.ArrayList;
import java.util.List;

import pi.procurarteapi.app.musician.dtos.Common.AddressDto;
import pi.procurarteapi.app.musician.dtos.Common.MusicianDto;
import pi.procurarteapi.app.musician.dtos.Common.PortfolioDto;
import pi.procurarteapi.mockFactory.musician.IMusianMock;

public class MusicianOk implements IMusianMock{

    @Override
    public  MusicianDto generate() {
        AddressDto address = new AddressDto("rua", "sp", "00000-000", "09", "null");
        List<String> media = new ArrayList<>();
        media.add("media1");
        PortfolioDto portfolio = new PortfolioDto("description", "@something", "profilephoto", "thumbnail", media);
		MusicianDto musicianMock = new MusicianDto("email@mock.com", "123", "Mock", "11999999999", "41315600030", address, portfolio, null, null);
    
        return musicianMock;
    }

}