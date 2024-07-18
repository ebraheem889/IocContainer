package InversionOfControl.amazon;

public class MasterCard implements Icredit{
    @Override
    public   void Charge() {
            System.out.println("Charged via Master Card =============> ");
    }
}
