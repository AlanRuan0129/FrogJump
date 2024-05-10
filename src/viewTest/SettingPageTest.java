package view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SettingPageTest {
    private SettingPage settingPage;

    @BeforeEach
    void setUp() {
        settingPage = new SettingPage();
    }

    @AfterEach
    void tearDown() {
        settingPage.dispose();
    }

    @Test
    void main() {
        assertDoesNotThrow(() -> SettingPage.main(new String[]{}));
        System.out.println("main - Test passed.");
    }
}