package InversionOfControl.IOContainer;

import java.util.*;

public class IocContainer {



    Map<Class<?> , Class<?>> Dic = new HashMap<>();


    public <TFrom , TTo> void register(TFrom key , TTo value){


        Dic.put((Class<?>) key,(Class<?>) value);


    }


    public <TFrom ,TTo >  TTo resolve(TFrom key) throws Exception {

        if(!Dic.containsKey(key)) throw new Exception("Can't Be Resolved, Make Sure U Register "+ key.getClass());

        var typeTo = Dic.get(key);
            // get the key from dictionary
       var cinfo =   Arrays.stream(typeTo.getConstructors()).findFirst().get();



            // check if the constructor does not have any parameters so that we can make early return
        if(cinfo.getParameterCount() == 0 ){

                return (TTo) cinfo.newInstance();
        }
        List<Object> paramObj =new ArrayList<>();
        // in case the constructor have parameters of specific type

        Arrays.stream(cinfo.getParameters()).forEach((param)->{
            try {

                paramObj.add(resolve(param.getType()));
            } catch (Exception e) {
                System.out.println("============> Wrong !" + e.getMessage());
            }
        });


        return (TTo) cinfo.newInstance(paramObj.toArray());
    }


}
