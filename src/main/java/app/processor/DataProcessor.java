package app.processor;

import app.database.DatabaseConnection;
import app.services.AuthenticationService;

public class DataProcessor {
    private DatabaseConnection databaseConnection;
    private AuthenticationService authenticationService;

    public DataProcessor(DatabaseConnection databaseConnection, AuthenticationService authenticationService) {
        this.databaseConnection = databaseConnection;
        this.authenticationService = authenticationService;
    }

    public void processData(String username, String password) {
        // Lógica de processamento de dados

        // Conecta ao banco de dados
        boolean isConnected = databaseConnection.connect();
        if (isConnected) {
            // Autentica o usuário
            boolean isAuthenticated = authenticationService.authenticateUser(username, password);
            if (isAuthenticated) {
                // Processa os dados
                System.out.println("Processando dados...");
            } else {
                System.out.println("Falha na autenticação do usuário.");
            }
        } else {
            System.out.println("Falha na conexão com o banco de dados.");
        }
    }
}
