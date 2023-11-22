package pi.procurarteapi.MocyFactory.musician;

import pi.procurarteapi.MocyFactory.musician.MusicianMockTypes.MusicianFail;
import pi.procurarteapi.MocyFactory.musician.MusicianMockTypes.MusicianOk;

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
