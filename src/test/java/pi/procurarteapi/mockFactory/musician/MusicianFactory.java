package pi.procurarteapi.mockFactory.musician;

import pi.procurarteapi.mockFactory.musician.musicianMockTypes.MusicianFail;
import pi.procurarteapi.mockFactory.musician.musicianMockTypes.MusicianOk;

public class MusicianFactory {
   
    public static IMusianMock MusicianGenerator(String type){

      if(type.equalsIgnoreCase("OK")){
         return new MusicianOk();
      }if(type.equalsIgnoreCase("FAIL")){
         return new MusicianFail();
      }else{
        throw new IllegalArgumentException("Tipo inválido de forma: " + type);
    }

   }
}
