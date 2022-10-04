
package accessmodifiers.differentpackage;

import accessmodifiers.basepackage.BaseClass;

public class InheritedClassInDifferentPackage extends BaseClass{
    void check()
    {
         
        privateMethod();
        packageMethod();
        protectedMethod();
        publicMethod();
    }
    public static void main(String[] args) {
        BaseClass x = new BaseClass();
//        x.privateMethod();
//        x.packageMethod();
//        x.protectedMethod();
//        x.publicMethod();
    }
}
