package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository;


    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) {
        repository.save(product);
    }


    public Product[] getAll() {
        return repository.findAll();
    }


    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                int length = result.length + 1;
                Product[] tmp = new Product[length];
                // копируем поэлементно все элементы из Product[]
                System.arraycopy(result, 0, tmp, 0, result.length);
                //добавляем найденный элемент в result
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

    public boolean matches(Product product, String search) {
        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().contains(search)) {
                return true;
            }
            if (book.getAuthor().contains(search)) {
                return true;
            }
        }
        if (product instanceof Smartphone) {
            Smartphone smartphone = (Smartphone) product;
            if (smartphone.getName().contains(search)) {
                return true;
            }
            if (smartphone.getProducer().contains(search)) {
                return true;
            }
        }
        return false;
    }
}

