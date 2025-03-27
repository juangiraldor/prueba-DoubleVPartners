package com.Test;

import com.Base.BaseTest;
import com.Pages.LogInPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest(){
        LogInPage.loginUser();
    }
}
