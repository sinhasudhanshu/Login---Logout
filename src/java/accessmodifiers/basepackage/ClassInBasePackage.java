
package accessmodifiers.basepackage;

public class ClassInBasePackage {
    public static void main(String[] args) {
        BaseClass x = new BaseClass();
        //x.privateMethod();
        x.packageMethod();
        x.protectedMethod();
        x.publicMethod();
    }
}
