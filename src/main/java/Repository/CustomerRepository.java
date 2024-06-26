package Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import Entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAll();

 //หาชื่อ
    //   Page<Customer> findByNameContainingIgnoreCaseOrStudentID(String name ,String studentID, Pageable PageRequest);
}
