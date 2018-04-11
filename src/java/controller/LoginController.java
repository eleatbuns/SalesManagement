package controller;

import com.jfinal.core.Controller;

public class LoginController extends Controller {
    public void index(){
        render("/login.html");
    }

    // 验证码 由JFinal自动实现
    private static final String FORM_ITEM_CODE = "code";

    /**
     * 返回验证码
     */
    public void code() {
        renderCaptcha();
    }

}
