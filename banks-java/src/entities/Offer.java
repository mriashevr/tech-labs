package entities;

public class Offer {
    private int number = 0;
    private int percentage;
    private int offerNumber;

    public Offer(int percent) {
        offerNumber = ++number;
        percentage = percent;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getOfferNumber() {
        return offerNumber;
    }

    public void setOfferNumber(int offerNumber) {
        this.offerNumber = offerNumber;
    }
}
