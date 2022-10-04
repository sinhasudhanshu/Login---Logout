package accessmodifiers.differentpackage;

import accessmodifiers.basepackage.BaseClass;

public class ClassInDifferentPackage {

    public static void main(String[] args) {
        BaseClass x = new BaseClass();
//        x.privateMethod();
//        x.packageMethod();
//        x.protectedMethod();
        x.publicMethod();
    }
}
