package com.undangan.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.undangan.model.ResponseData;
import com.undangan.model.entities.Customer;
import com.undangan.services.CustomerService;

@SpringBootApplication
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @CrossOrigin(origins = "http://localhost:3000")
    
    @GetMapping("/api/client/customer")
    public ResponseEntity<ResponseData<List<Customer>>> findAllClient() {

        ResponseData<List<Customer>> responseCustomer = new ResponseData<>();
        responseCustomer.setCode(200);
        responseCustomer.setStatus("OK");
        responseCustomer.setData(customerService.findAll());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseCustomer);
    }

    @GetMapping("/api/client/customer/mypath") /*Komunikasi API dengan jenis POST*/
    public ResponseEntity<ResponseData<Customer>> findByPathClient (@RequestParam String path) /*Mengambil Request data dari Body dan melakukan Proses Validasi*/
    {
        ResponseData<Customer> responseCustomer = new ResponseData<>();
        responseCustomer.setCode(200);
        responseCustomer.setStatus("OK");
        responseCustomer.setData(customerService.findByPath(path));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseCustomer);
    }

    @GetMapping("/api/customer")
    public ResponseEntity<ResponseData<List<Customer>>> findAll() {

        ResponseData<List<Customer>> responseCustomer = new ResponseData<>();
        responseCustomer.setCode(200);
        responseCustomer.setStatus("OK");
        responseCustomer.setData(customerService.findAll());

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseCustomer);
    }

    // public List<Customer> findAll(){
    //     ResponseCustomer responseCustomer = new ResponseCustomer();
    //     responseCustomer.setCode(200);
    //     responseCustomer.setStatus("OK");
    //     responseCustomer.setData(customerService.findAll());
        
    //     return customerService.findAll();
    // }

    @GetMapping("/api/customer/{id}") /*Komunikasi API dengan jenis POST*/
    public ResponseEntity<ResponseData<Customer>> findById (@PathVariable("id") Long id) /*Mengambil Request data dari Body dan melakukan Proses Validasi*/
    {
        ResponseData<Customer> responseCustomer = new ResponseData<>();
        responseCustomer.setCode(200);
        responseCustomer.setStatus("OK");
        responseCustomer.setData(customerService.findById(id));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseCustomer);
    }

    @GetMapping("/api/customer/mypath") /*Komunikasi API dengan jenis POST*/
    public ResponseEntity<ResponseData<Customer>> findByPath (@RequestParam String path) /*Mengambil Request data dari Body dan melakukan Proses Validasi*/
    {
        ResponseData<Customer> responseCustomer = new ResponseData<>();
        responseCustomer.setCode(200);
        responseCustomer.setStatus("OK");
        responseCustomer.setData(customerService.findByPath(path));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseCustomer);
    }

    @PostMapping("/api/customer") /*Komunikasi API dengan jenis POST*/
    public ResponseEntity<ResponseData<Customer>> create (@RequestBody @Validated Customer customer) /*Mengambil Request data dari Body dan melakukan Proses Validasi*/
    {
        ResponseData<Customer> responseCustomer = new ResponseData<>();
        responseCustomer.setCode(200);
        responseCustomer.setStatus("OK");
        responseCustomer.setData(customerService.create(customer));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseCustomer);
    }

    @PutMapping("/api/customer/{id}") /*Komunikasi API dengan jenis POST*/
    public ResponseEntity<ResponseData<Customer>> update (@PathVariable("id") Long id, @RequestBody @Validated Customer customer) /*Mengambil Request data dari Body dan melakukan Proses Validasi*/
    {
        ResponseData<Customer> responseCustomer = new ResponseData<>();
        responseCustomer.setCode(200);
        responseCustomer.setStatus("OK");
        responseCustomer.setData(customerService.update(id, customer));

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseCustomer);

        // return id;
    }

    @DeleteMapping("/api/customer/{id}") /*Komunikasi API dengan jenis POST*/
    public ResponseEntity<ResponseData<Customer>> deleteById (@PathVariable("id") Long id) /*Mengambil Request data dari Body dan melakukan Proses Validasi*/
    {
        ResponseData<Customer> responseCustomer = new ResponseData<>();
        responseCustomer.setCode(200);
        responseCustomer.setStatus("OK");

        customerService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(responseCustomer);
    }
}
