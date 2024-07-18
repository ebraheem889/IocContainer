package InversionOfControl.amazon;

public class Shopper {


    private Icredit icredit;


    public Shopper(Icredit icredit){
        this.icredit = icredit;
    }


    public void Charge(){
        icredit.Charge();
    }

}
