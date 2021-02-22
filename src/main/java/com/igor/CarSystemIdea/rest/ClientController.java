package com.igor.CarSystemIdea.rest;

import com.igor.CarSystemIdea.service.ClientServiceImpl;
import com.igor.CarSystemIdea.task.ClientSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private Map<String, ClientSession> tokensMap;

    private ClientSession isActive(String token) {
        return tokensMap.get(token);
    }

    @Autowired
    private ClientServiceImpl clientServiceImpl;


    // Add Car
    @PostMapping("/addCar/{token}/{id}")
    public ResponseEntity<?> getCar(@PathVariable("token") String token, @PathVariable("id") int id) {
        ClientSession clientSession = isActive(token);
        if (clientSession != null) {
            clientSession.setLastAccessed(System.currentTimeMillis());
            try {
                return new ResponseEntity<>(clientServiceImpl.getCar(id), HttpStatus.OK);
            } catch (Exception e) {
                e.getMessage();
                return new ResponseEntity<>("You have no money on your account! Failed to get Car. Car id: " + id,
                        HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Unauthorized. Session Timeout", HttpStatus.UNAUTHORIZED);
        }
    }

    // View Cars
    @GetMapping("/viewCars/{token}")
    public ResponseEntity<?> getCars(@PathVariable("token") String token) {
        ClientSession clientSession = isActive(token);
        if (clientSession != null) {
            clientSession.setLastAccessed(System.currentTimeMillis());
            try {
                return new ResponseEntity<>(clientServiceImpl.getCars(), HttpStatus.OK);
            } catch (Exception e) {
                e.getMessage();
                return new ResponseEntity<>("Failed to view cars by client", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Unauthorized. Session Timeout", HttpStatus.UNAUTHORIZED);
        }
    }

    // View My Cars
    @GetMapping("/viewMyCars/{token}")
    public ResponseEntity<?> getMyCars(@PathVariable("token") String token) {
        ClientSession clientSession = isActive(token);
        if (clientSession != null) {
            clientSession.setLastAccessed(System.currentTimeMillis());
            try {
                return new ResponseEntity<>(clientServiceImpl.getMyCars(), HttpStatus.OK);
            } catch (Exception e) {
                e.getMessage();
                return new ResponseEntity<>("Failed to view my cars", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Unauthorized. Session Timeout", HttpStatus.UNAUTHORIZED);
        }
    }

    // Return Car
    @DeleteMapping("/returnCar/{token}/{id}")
    public ResponseEntity<?> returnCar(@PathVariable("token") String token, @PathVariable("id") int id) {
        ClientSession clientSession = isActive(token);
        if (clientSession != null) {
            clientSession.setLastAccessed(System.currentTimeMillis());
            try {
                return new ResponseEntity<>(clientServiceImpl.returnCar(id), HttpStatus.OK);
            } catch (Exception e) {
                e.getMessage();
                return new ResponseEntity<>("Failed to return car", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Unauthorized. Session Timeout", HttpStatus.UNAUTHORIZED);
        }
    }

    // View Receipts By Client
    @GetMapping("/viewMyReceipts/{token}")
    public ResponseEntity<?> getReceiptsByClient(@PathVariable("token") String token) {
        ClientSession clientSession = isActive(token);
        if (clientSession != null) {
            clientSession.setLastAccessed(System.currentTimeMillis());
            try {
                return new ResponseEntity<>(clientServiceImpl.getReceiptsByClient(), HttpStatus.OK);
            } catch (Exception e) {
                e.getMessage();
                return new ResponseEntity<>("Failed to view Receipts By Client. ", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Unauthorized. Session Timeout", HttpStatus.UNAUTHORIZED);
        }
    }

    // View Balance
    @GetMapping("/viewBalance/{token}")
    public ResponseEntity<?> getBalance(@PathVariable("token") String token) {
        ClientSession clientSession = isActive(token);
        if (clientSession != null) {
            clientSession.setLastAccessed(System.currentTimeMillis());
            try {
                return new ResponseEntity<>(clientServiceImpl.getBalance(), HttpStatus.OK);
            } catch (Exception e) {
                e.getMessage();
                return new ResponseEntity<>("Failed to view balance", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Unauthorized. Session Timeout", HttpStatus.UNAUTHORIZED);
        }
    }

    // Delete Account
    @DeleteMapping("/deleteAccount/{token}")
    public ResponseEntity<?> deleteAccount(@PathVariable("token") String token) {
        ClientSession clientSession = isActive(token);
        if (clientSession != null) {
            clientSession.setLastAccessed(System.currentTimeMillis());
            try {
                return new ResponseEntity<>(clientServiceImpl.deleteAccount(), HttpStatus.OK);
            } catch (Exception e) {
                e.getMessage();
                return new ResponseEntity<>("Failed remove account.", HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("Unauthorized. Session Timeout", HttpStatus.UNAUTHORIZED);
        }
    }

}
