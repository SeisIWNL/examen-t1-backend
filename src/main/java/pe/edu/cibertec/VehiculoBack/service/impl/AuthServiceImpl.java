package pe.edu.cibertec.VehiculoBack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.VehiculoBack.dto.VehicleRequest;
import pe.edu.cibertec.VehiculoBack.service.AuthService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarPlaca(VehicleRequest vehicleRequest) throws IOException {
        String[] vehicle = null;
        Resource resource = resourceLoader.getResource("classpath:vehiculos.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split(";");
                if (vehicleRequest.placa().equals(data[1])) {
                    vehicle = new String[7];
                    vehicle[0] = data[0];
                    vehicle[1] = data[1];
                    vehicle[2] = data[2];
                    vehicle[3] = data[3];
                    vehicle[4] = data[4];
                    vehicle[5] = data[5];
                    vehicle[6] = data[6];
                }
            }

        } catch (IOException e) {
            throw new IOException(e);
        }

        return vehicle;
    }
}
