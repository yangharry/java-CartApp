import java.util.*;
import java.io.*;

public class CartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Product> productSet = new HashSet<>();

        String csvFile = "src/products.csv";

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(csvFile), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                if (values.length == 2) {
                    String name = values[0].trim();
                    double price = Double.parseDouble(values[1].trim());
                    productSet.add(new Product(UUID.randomUUID().toString(), name, price));

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Cart cart = new Cart(productSet);

        while (true) {
            System.out.println("1: 상품 목록보기");
            System.out.println("2: 장바구니 목록보기");
            System.out.println("3: 장바구니 추가");
            System.out.println("4: 장바구니 제거");
            System.out.println("5: 종료");

            System.out.print("메뉴를 선택하세요: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.println("----------------------------------------------");
            switch (choice) {
                case 1:

                    productSet.forEach(
                            item -> System.out.println(item.getName() + " - 가격: " + item.getPrice()));
                    break;
                case 2:

                    cart.showItems();
                    break;
                case 3:
                    System.out.print("장바구니에 추가할 상품 이름을 입력하세요: ");
                    String productName = scanner.nextLine();
                    System.out.print("장바구니에 추가할 수량을 입력하세요: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    cart.addProduct(productName, quantity);
                    break;
                case 4:
                    System.out.print("장바구니에서 제거할 상품 이름을 입력하세요: ");
                    String productName2 = scanner.nextLine();
                    System.out.print("장바구니에서 제거할 수량을 입력하세요: ");
                    int quantity2 = scanner.nextInt();
                    scanner.nextLine();
                    cart.removeProduct(productName2, quantity2);
                    break;
                default:
                    System.out.println("앱을 종료합니다.");
                    scanner.close();
                    return;
            }
            System.out.println("----------------------------------------------");

        }
    }
}