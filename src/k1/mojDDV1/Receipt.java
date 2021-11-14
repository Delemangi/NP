package k1.mojDDV1;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final String ID;
    private final List<Article> list;

    public Receipt(String ID, List<Article> list) {
        this.ID = ID;
        this.list = list;
    }

    public static Receipt create(String str) {
        String[] split = str.split("\\s+");
        String ID = split[0];
        List<Article> list = new ArrayList<>();

        for (int i = 1; i < split.length; i += 2) {
            list.add(new Article(Integer.parseInt(split[i]), split[i + 1]));
        }

        Receipt r = new Receipt(ID, list);

        try {
            if (r.totalAmount() > 30000) {
                throw new AmountNotAllowedException(r.totalAmount());
            } else {
                return r;
            }
        } catch (AmountNotAllowedException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int totalAmount() {
        return list.stream().mapToInt(Article::getAmount).sum();
    }

    public double totalTaxReturn() {
        return list.stream().mapToDouble(Article::getTax).sum();
    }

    @Override
    public String toString() {
        return String.format("%s %d %.2f", ID, totalAmount(), totalTaxReturn() * 0.15);
    }
}