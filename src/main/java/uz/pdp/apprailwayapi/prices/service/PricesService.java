package uz.pdp.apprailwayapi.prices.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.apprailwayapi.prices.entity.PricesEntity;
import uz.pdp.apprailwayapi.prices.repository.PricesRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PricesService {
    private final PricesRepository pricesRepository;

    public List<PricesEntity> getAllPrices() {
        return pricesRepository.findAll();
    }
}

