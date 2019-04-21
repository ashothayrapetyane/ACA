package com.aca.test;

public class PrivateOverride {
   private void f() {
       System.out.println("private f() \n");
   }
   public static void main(String[] args) {
       PrivateOverride po = new PrivateOverride();
       po.f();
   }
}

class Derived extends PrivateOverride {
   public void f() {
       System.out.println("public f()");
   }
}
