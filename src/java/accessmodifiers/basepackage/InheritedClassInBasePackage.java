
package accessmodifiers.basepackage;

public class InheritedClassInBasePackage extends BaseClass{
    public static void main(String[] args) {
        BaseClass x = new BaseClass();
        //x.privateMethod();
        x.packageMethod();
        x.protectedMethod();
        x.publicMethod();
    }
}
