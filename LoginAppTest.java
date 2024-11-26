public class LoginAppTest {

    public static void main(String[] args) {
        testValidCredentials();
        testInvalidEmail();
        testInvalidPassword();
        testInvalidCredentials();
        testSqlInjectionAttempt();
    }

    public static void testValidCredentials() {
        LoginApp app = new LoginApp();
        String result = app.authenticateUser("johndoe@example.com", "password123");
        assert result != null : "Test Failed: Expected a valid user";
        assert result.equals("Valid User") : "Test Failed: Expected 'Valid User', but got " + result;
        System.out.println("Test Passed: Valid credentials");
    }

    public static void testInvalidEmail() {
        LoginApp app = new LoginApp();
        String result = app.authenticateUser("johndough@example.com", "password123");
        assert result == null : "Test Failed: Expected null, but got " + result;
        System.out.println("Test Passed: Invalid email");
    }

    public static void testInvalidPassword() {
        LoginApp app = new LoginApp();
        String result = app.authenticateUser("johndoe@example.com", "password1234");
        assert result == null : "Test Failed: Expected null, but got " + result;
        System.out.println("Test Passed: Invalid password");
    }

    public static void testInvalidCredentials() {
        LoginApp app = new LoginApp();
        String result = app.authenticateUser("safwan@example.com", "invalidpassword");
        assert result == null : "Test Failed: Expected null, but got " + result;
        System.out.println("Test Passed: Invalid credentials");
    }

    public static void testSqlInjectionAttempt() {
        LoginApp app = new LoginApp();
        String result = app.authenticateUser("' OR 1=1--", "noresult");
        assert result == null : "Test Failed: Expected null, but got " + result;
        System.out.println("Test Passed: SQL injection attempt");
    }
}
