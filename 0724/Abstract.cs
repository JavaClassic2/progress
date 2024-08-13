using System;

public class A {
    public virtual void m() {
        Console.WriteLine("a");
    }
}

public class B : A{
    public override void m() {
        Console.WriteLine("b");
    }
}

public class Test2 {
    public static void Main(string[] args) {
        B b = new B();
        A a = B;

        Console.WriteLine(b.m());
        Console.WriteLine(a.m());
    }
}