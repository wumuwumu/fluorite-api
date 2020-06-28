package cn.sciento.fluorite.response.account;

public class AccountInfoResponse {
    private String accountId;

    private String accountName;

    private String appKey;

    private String accountStatus;

    private AccountPolicy policy;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public AccountPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(AccountPolicy policy) {
        this.policy = policy;
    }
}
