
// 'Product' 클래스는 상점에서 판매되는 하나의 상품을 나타냅니다.
public class Product {
    // key 는 상품의 고유 키 입니다.
    private String key;
    // 'name'은 상품의 이름을 나타내는 문자열입니다.
    private String name;
    // 'price'는 상품의 가격을 나타내는 double 타입의 값입니다.
    private double price;

    // 생성자 함수는 객체가 생성될 때 호출되며, 상품의 이름과 가격을 초기화합니다.
    public Product(String key, String name, double price) {
        this.key = key;
        this.name = name; // 'this' 키워드는 인스턴스 변수를 지칭합니다. 여기서는 파라미터로 받은 'name'으로 인스턴스 변수를 초기화합니다.
        this.price = price; // 마찬가지로 파라미터로 받은 'price'로 인스턴스 변수를 초기화합니다.
    }

    public String getKey() {
        return key;
    }

    // 'getName' 메서드는 상품의 이름을 반환하는 getter 메서드입니다.
    public String getName() {
        return name; // 인스턴스 변수 'name'의 값을 반환합니다.
    }

    // 'getPrice' 메서드는 상품의 가격을 반환하는 getter 메서드입니다.
    public double getPrice() {
        return price; // 인스턴스 변수 'price'의 값을 반환합니다.
    }

    // 'equals' 메서드는 두 'Product' 객체가 같은지 비교하는 메서드입니다.
    @Override // '@Override' 어노테이션은 이 메서드가 부모 클래스의 메서드를 오버라이드한다는 것을 나타냅니다.
    public boolean equals(Object o) {
        if (this == o) // 'this'가 'o'와 동일한 객체를 참조하고 있으면, 즉 동일한 메모리 주소를 가지고 있으면 참(true)을 반환합니다.
            return true;
        if (!(o instanceof Product)) // 'o'가 'Product' 클래스의 인스턴스가 아니면 거짓(false)을 반환합니다.
            return false;
        Product product = (Product) o; // 'o'를 'Product' 타입으로 캐스팅합니다.
        return key.equals(product.key); // 'name' 필드가 동일한지 비교하여 결과를 반환합니다.
    }

    // 'hashCode' 메서드는 객체의 해시 코드를 반환합니다.
    @Override // 이 메서드 역시 부모 클래스의 메서드를 오버라이드합니다.
    public int hashCode() {
        return key.hashCode(); // 상품의 이름('name')의 해시 코드를 반환합니다. 'equals' 메서드에서 사용된 같은 필드를 기준으로 해시코드를 생성해야 합니다.
    }
}
