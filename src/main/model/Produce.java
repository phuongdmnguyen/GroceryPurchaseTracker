package model;

public class Produce extends Item {

    public Produce(String n, double c, int q, int e, boolean s) {
        super(n, c, q, e, s);
    }

    @Override
    public void itemExpired() {
        expiryStatus = daysTillExpiry == 0;
        System.out.println(getItemName() + "has expired!");
        System.out.println("Dispose of produce");
    }
}
