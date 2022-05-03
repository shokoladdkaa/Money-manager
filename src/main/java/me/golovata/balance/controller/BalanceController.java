package me.golovata.balance.controller;

import lombok.AllArgsConstructor;
import me.golovata.balance.model.Balance;
import me.golovata.balance.service.BalanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping("/balance")
    private List<Balance> getBalance(@RequestHeader(name = "X-Token") String token) throws IOException, InterruptedException {
        return balanceService.getBalance(token);
    }
}
