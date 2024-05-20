package com.example.Conexaopet.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateAddressDTO {
    private Optional<String> id = Optional.empty();
    private Optional<String> cep = Optional.empty();
    private Optional<String> state = Optional.empty();
    private Optional<String> city = Optional.empty();
    private Optional<String> public_place = Optional.empty();
    private Optional<String> neighborhood = Optional.empty();
    private Optional<String> number = Optional.empty();
}
