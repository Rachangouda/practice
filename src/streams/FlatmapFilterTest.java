package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FlatmapFilterTest {


    public static void main(String[] args) {
        List<Optional<Customer>> customers = Arrays.asList(
                Optional.of(new Customer("John P.", 15)),
                Optional.of(new Customer("Sarah M.", 78)),
                Optional.empty(),
                Optional.of(new Customer("Mary T.", 20)),
                Optional.empty(),
                Optional.of(new Customer("Florian G.", 89)),
                Optional.empty()
        );

        long numberOf65PlusCustomers = customers
                .stream()
                .flatMap(c -> c
                        .map(Stream::of)
                        .orElseGet(Stream::empty))
                .mapToInt(Customer::getAge)
                .filter(c -> c > 65)
                .count();
    }

    private static class Customer {
        String name;
        int age;

        public int getAge() {
            return age;
        }

        public Customer(String name, int age) {
            this.name=name;
            this.age=age;
        }


    }
}
