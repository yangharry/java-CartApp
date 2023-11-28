import java.util.*;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();
    private Set<Product> productsSet;

    public Cart(Set<Product> productsSet) {
        this.productsSet = productsSet;
    }

    public void addProduct(String productName, int quantity) {
        Product product = productsSet.stream().filter(p -> p.getName().equals(productName)).findFirst().orElse(null);
        if (product != null) {
            items.merge(product, quantity, Integer::sum);
            System.out.println(product.getName() + " " + quantity + "개를 장바구니에 추가했습니다.");
        } else {
            System.out.println("해당 제품은 목록에 없습니다.");
        }
    }

    public void removeProduct(String productName, int quantity) {
        Product product = items.keySet().stream().filter(p -> p.getName().equalsIgnoreCase(productName)).findFirst()
                .orElse(null);

        if (product != null) {
            int CurrentQuantity = items.getOrDefault(product, 0);
            if (CurrentQuantity > quantity) {
                items.put(product, CurrentQuantity - quantity);
                System.out.println(product.getName() + " " + quantity + "개를 장바구니에서 뺐습니다.");
            } else {
                items.remove(product);
                System.out.println(product.getName() + " 제품을 장바구니에서 제거했습니다.");
            }
        } else {
            System.out.println("해당 제품은 장바구니에 없습니다.");

        }

    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            System.out.println("장바구니 내 상품 목록:");
            items.forEach((product, quantity) -> {
                System.out.println(product.getName() + " - 가격: " + product.getPrice() + ", 수량: " + quantity);
            });
        }
    }
}