package ui.com.ztna.login.models;

import com.google.gson.annotations.SerializedName;
import indexed.pojo.model.IndexedPojo;

public class LoginParameters extends IndexedPojo {

    public static final String EMAIL_KEY = "email";
    @SerializedName(EMAIL_KEY)
    public String email = "";

    public static final String PASSWORD_KEY = "password";
    @SerializedName(PASSWORD_KEY)
    public String password = "";
}
