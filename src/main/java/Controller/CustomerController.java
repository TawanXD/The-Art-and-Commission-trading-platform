package Controller;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import Entity.Customer;
import org.springframework.stereotype.Controller;
import CustomerService;
import Util.LabMapper;

@Controller
@CrossOrigin(maxAge = 3600)
@RequiredArgsConstructor
public class CustomerController {
    final CustomerService customerService;

    //specific customer
    @GetMapping("customers")
    public ResponseEntity<?> getCustomerLists(@RequestParam(value = "_limit", required = false) Integer perPage
            ,@RequestParam(value = "_page",required = false)Integer page) {
        Page<Customer> pageOutput = customerService.getCustomers(perPage, page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count",
                String.valueOf(pageOutput.getTotalElements()));
//        return new ResponseEntity<>(pageOutput.getContent(),responseHeader,HttpStatus.OK);
        return new ResponseEntity<>(LabMapper.INSTANCE.getCustomerDto(pageOutput.getContent()),responseHeader, HttpStatus.OK);
    }

    @GetMapping("customers/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable("id") Long id) {
        Customer output = customerService.getCustomer(id);
        if (output != null){
            return ResponseEntity.ok(output);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The Given id is not found");
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<?> addUser(@RequestBody Customer customer){
        Customer output = userService.save(customer);
        return ResponseEntity.ok(output);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer updatedCustomer) {
        Customer old = customerService.getCustomer(id);
        if(old == null){
            //Exception
        }
        if (updatedCustomer.getName() != null){
            old.setName(updatedCustomer.getName());
        }
        if (updatedCustomer.getStudentID() != null){
            old.setStudentID(updatedCustomer.getStudentID());
        }
        if (updatedCustomer.getSurname() != null){
            old.setSurname(updatedCustomer.getSurname());
        }
        if (updatedCustomer.getImage() != null){
            old.setImage(updatedCustomer.getImage());
        }
        if (updatedCustomer.getAdvisorName() != null){
            old.setAdvisorName(updatedCustomer.getAdvisorName());
        }
        if (updatedCustomer.getAdvisorSurname() != null){
            old.setAdvisorSurname(updatedCustomer.getAdvisorSurname());
        }
        if (updatedCustomer.getAdvisorImage() != null){
            old.setAdvisorImage(updatedCustomer.getAdvisorImage());
        }
        if (updatedCustomer.getPosition() != null){
            old.setPosition(updatedUCustomer.getPosition());
        }
        if (updatedCustomer.getReply() != null){
            old.setReply(updatedUCustomer.getReply());
        }
        if (updatedCustomer.getComment() != null){
            old.setComment(updatedCustomer.getComment());
        }

        Customer output = customerService.save(updatedCustomer);
        return ResponseEntity.ok(output);
    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
//        User userToDelete = userService.getUser(id);
//        userService.deleteUser(userToDelete);
//        return userToDelete;
//    }
}