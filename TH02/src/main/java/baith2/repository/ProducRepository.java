package baith2.repository;

import baith2.Product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProducRepository extends JpaRepository<Product,String> {
    Product findByCode(String code);
    void deleteByCode(String code);
}
