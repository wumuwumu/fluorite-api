package cn.sciento.fluorite.response.account;

import java.util.List;

public class AccountPolicy {
    private List<AccountStatement> Statement;


    public List<AccountStatement> getStatement() {
        return Statement;
    }

    public void setStatement(List<AccountStatement> statement) {
        Statement = statement;
    }
}
