package me.golovata.balance.integration.mono;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientInfo {
    private String clientId;
    private String name;
    private String webHookUrl;
    private String permissions;
    private List<Account> accounts;
}
