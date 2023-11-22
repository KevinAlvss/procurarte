package pi.procurarteapi.MocyFactory.musician.MusicianMockTypes;

import pi.procurarteapi.MocyFactory.musician.IMusianMock;
import pi.procurarteapi.infra.entities.Musician;
import pi.procurarteapi.infra.entities.Musician.Address;

public class MusicianOk implements IMusianMock{

    @Override
    public  Musician generate() {
        Address address = new Address("rua", "sp", "00000-000", "09", "null");
		Musician musicianMock = new Musician("idMock", "email@mock", "123", "Mock", "11999999999", "@moock", address, null, null, null);
    
        return musicianMock;
    }

}