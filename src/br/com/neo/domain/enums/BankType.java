package br.com.neo.domain.enums;

public enum BankType {
    BRADESCO("Bradesco"),
    CAIXA("Caixa Econômica Federal"),
    ITAU("Itaú Unibanco");

    private final String displayName;

    BankType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
