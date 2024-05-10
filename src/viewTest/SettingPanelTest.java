package view.custom;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SettingPanelTest {
    private SettingPanel settingPanel;

    @BeforeEach
    void setUp() {
        settingPanel = new SettingPanel();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setLeftActionListener() {
        try {
            settingPanel.setLeftActionListener();
            assertTrue(true);
            System.out.println("setLeftActionListener - Test passed.");
        } catch (Exception e) {
            fail("setLeftActionListener should not throw an exception.");
        }
    }
}