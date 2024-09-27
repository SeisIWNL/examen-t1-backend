package pe.edu.cibertec.VehiculoBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.VehiculoBack.dto.VehicleRequest;
import pe.edu.cibertec.VehiculoBack.dto.VehicleResponse;
import pe.edu.cibertec.VehiculoBack.service.AuthService;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class VehicleController {

    @Autowired
    AuthService authService;

    @PostMapping("/consultar")
    public VehicleResponse consultar(@RequestBody VehicleRequest vehicleRequest) {
        try {
            String[] vehiculo = authService.validarPlaca(vehicleRequest);
            if (vehiculo == null) {
                return new VehicleResponse("000","ERROR",null,null,null,null,null);
            }
            return new VehicleResponse(vehiculo[0],vehiculo[1],vehiculo[2],vehiculo[3],vehiculo[4],vehiculo[5],vehiculo[6]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
