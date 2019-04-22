package com.lft.java8.future;

/**
 * 折扣
 * @author Ryze
 * @date 2019-04-19 15:44
 */
public class Discount {
    /**
     * 折扣
     */
    public enum code {
        NONE(0), FIVE(5), TEN(10), FIFTEEN(15), TWENTY(20);
        private int percentage;

        code(int percentage) {
            this.percentage = percentage;
        }

        public int getPercentage() {
            return percentage;
        }
    }

    public static String applyDiscount(Quote quote) {
        return quote.getName() + " price is " + Discount.apply(quote.getPrice(), quote.getDisCode());
    }

    private static Double apply(Double price, code disCode) {
        deplay();
        return price * (100 - disCode.getPercentage()) / 100;
    }

    private static void deplay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
