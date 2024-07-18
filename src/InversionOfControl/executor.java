package InversionOfControl;

import InversionOfControl.IOContainer.IocContainer;
import InversionOfControl.amazon.DepitCard;
import InversionOfControl.amazon.Icredit;
import InversionOfControl.amazon.Shopper;

public class executor {

    public static void main(String[] args) throws Exception {


        IocContainer container = new IocContainer();

        container.register(Icredit.class , DepitCard.class);
        container.register(Shopper.class , Shopper.class);

        Shopper res =  container.resolve(Shopper.class);

         res.Charge();


    }
}
