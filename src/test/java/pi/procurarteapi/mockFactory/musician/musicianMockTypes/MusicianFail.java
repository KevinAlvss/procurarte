package pi.procurarteapi.mockFactory.musician.musicianMockTypes;

import pi.procurarteapi.app.musician.dtos.Common.AddressDto;
import pi.procurarteapi.app.musician.dtos.Common.MusicianDto;
import pi.procurarteapi.mockFactory.musician.IMusianMock;

public class MusicianFail implements IMusianMock{

    @Override
    public MusicianDto generate() {
        AddressDto address = new AddressDto("rua", "sp", "00000-000", "09", "null");
		
        MusicianDto musicianMock = new MusicianDto();
        musicianMock.setEmail("failedmock");
        musicianMock.setCpf("failedmock");
        musicianMock.setName("failedName");
        musicianMock.setAddress(address);
    
        return musicianMock;
    }
    
}
