package repository;

import domain.Product;
import exception.NotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {

    Product first = new Product(11234, "first", 1000);
    Product second = new Product(14533, "second", 2000);
    Product third = new Product(15444, "third", 3000);

    @Test
    public void shouldRemoveByIdNotFound() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);
        assertThrows(NotFoundException.class, () -> {
            repo.removeById(11111);
        });

    }

    @Test
    public void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeById(15444);
    }

}