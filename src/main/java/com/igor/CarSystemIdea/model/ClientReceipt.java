package com.igor.CarSystemIdea.model;

import com.igor.CarSystemIdea.enums.CarColor;
import com.igor.CarSystemIdea.enums.CarType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Document(collection = "clientReceipt")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ClientReceipt {

    private static long id = 1;

    public static long incrementId() {
        return id++;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//	@Field("receiptID")
    private long receiptId = id;

    //	@Field("clientID")
    private int clientId;

    //	@Field("clientName")
    private String clientName;

    //	@Field("clientPhoneNumber")
    private String clientPhoneNumber;

    //	@Field("clientEmail")
    private String clientEmail;

    //	@Field("clientBalance")
    private double clientBalance;

    //	@Field("receiptDate")
    private String receiptDate;

    //	@Field("carID")
    private int carId;

    //	@Field("carNumber")
    private String carNumber;

    //	@Field("carColor")
    @Enumerated(EnumType.STRING)
    private CarColor carColor;

    //	@Field("carType")
    @Enumerated(EnumType.STRING)
    private CarType carType;

    //	@Field("carPrice")
    private double carPrice;
}
