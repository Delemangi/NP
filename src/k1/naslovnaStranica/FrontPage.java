package k1.naslovnaStranica;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FrontPage {
    private final List<NewsItem> list;
    private final Category[] categories;

    public FrontPage(Category[] categories) {
        this.list = new ArrayList<NewsItem>();
        this.categories = Arrays.copyOf(categories, categories.length);
    }

    public void addNewsItem(NewsItem ni) {
        list.add(ni);
    }

    public List<NewsItem> listByCategory(Category c) {
        return list.stream().filter(i -> i.getCategory().equals(c)).collect(Collectors.toList());
    }

    public List<NewsItem> listByCategoryName(String category) throws CategoryNotFoundException {
        for (Category c : categories) {
            if (c.getCategory().equals(category)) {
                return list.stream().filter(i -> i.getCategory().getCategory().equals(category)).collect(Collectors.toList());
            }
        }

        throw new CategoryNotFoundException(String.format("Category %s was not found", category));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        list.forEach(sb::append);

        return sb.toString();
    }
}