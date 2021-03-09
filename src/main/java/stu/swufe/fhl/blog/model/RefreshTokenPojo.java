package stu.swufe.fhl.blog.model;

import java.util.Date;

public class RefreshTokenPojo {
    private String id;

    private String tokenKey;

    private Boolean dirt;

    private String userId;

    private Date createDate;

    private Date updateDate;

    private String refreshToken;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTokenKey() {
        return tokenKey;
    }

    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey == null ? null : tokenKey.trim();
    }

    public Boolean getDirt() {
        return dirt;
    }

    public void setDirt(Boolean dirt) {
        this.dirt = dirt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken == null ? null : refreshToken.trim();
    }
}