package com.chandu.wsr.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import lombok.*;

@Entity
@Table(name = "WorkShopRegistration")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkshopRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(min = 3, max = 50, message = "First name should be between 3 and 50 characters")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 3, max = 50, message = "Last name should be between 3 and 50 characters")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Company name is required")
    @Size(min = 3, max = 100, message = "Company name should be between 3 and 100 characters")
    @Column(name = "company", nullable = false)
    private String companyInstitution;

    @NotBlank(message = "Address is required")
    @Size(max = 255, message = "Address can be max of 255 characters")
    @Column(name = "address", nullable = false)
    private String address;

    @NotBlank(message = "City is required")
    @Column(name = "city", nullable = false)
    private String city;

    @NotBlank(message = "State is required")
    @Column(name = "state", nullable = false)
    private String state;

    @NotBlank(message = "Country is required")
    @Column(name = "country", nullable = false)
    private String country;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone Number Format Is Not Valid")
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @NotBlank(message = "Meal preference is required")
    @Column(name = "meal_preference", nullable = false)
    private String mealPreference;

    @NotBlank(message = "Payment mode is required")
    @Column(name = "payment_mode", nullable = false)
    private String paymentMode;

    @Column(name = "cheque_number", nullable = false)
    private String chequeNumber;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "payable_at", nullable = false)
    private String payableAt;
}
