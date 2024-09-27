package pe.edu.cibertec.VehiculoBack.service;

import pe.edu.cibertec.VehiculoBack.dto.VehicleRequest;

import java.io.IOException;

public interface AuthService {
    String[] validarPlaca(VehicleRequest vehicleRequest) throws IOException;
}
