package accessmodifiers.basepackage;

public class BaseClass {

    public void publicMethod() {
        System.out.println("public method in base class");
    }

    private void privateMethod() {
        System.out.println("method is private");
    }

    protected void protectedMethod() {
        System.out.println("method  is protected");
    }

    void packageMethod() {
        System.out.println("method  is package");
    }

    public static void main(String[] args) {
        BaseClass x = new BaseClass();
        x.privateMethod();
        x.packageMethod();
        x.protectedMethod();
        x.publicMethod();
    }
}
