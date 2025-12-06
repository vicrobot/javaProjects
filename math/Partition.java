class Partition{
    
    public static class Partitioner{
    
         public long f(int n, int k){
            
            
            if( (n==0) || (n==1) ){return 1;}
            if (n<k){ return this.f(n,n);}
            
            assert (n >=k) & (k >= 1);
            System.out.println("n and k are: "+n+", "+k);
            int a = (int)n/k;
            int b = n%k;
            
            long result = this.p(b);
            
            for(int j=0;j<=a-1;j++){
                
                for(int i = 1;i <= k-1; i++){
                    int temp = n-(j*k)-i;
                    System.out.println("Calling f("+temp+", "+i+")");
                    long temp_res = this.f(temp,i);
                    System.out.println("Result: "+temp_res);
                    result += temp_res;
                
                }
                
            }
            
            return result;
         
         }
         
         public long p(int n){
            assert n>=1;
            if(n==1){return 1;}
            
            int result = 1;
            for(int i=1; i <= (n-1);i++){
                System.out.println("Looping for f("+(n-i)+", "+i+")");
                long loop_res = this.f(n-i,i);
                System.out.println("Loop Result: "+ loop_res);
                result += loop_res;
            }
            return result;
         
         }
         
         public long partitionRecursively(int n){
            
            /*
                Theory:
                    f(n,k) = keep k const, split n  ------------------(0)
                    f(1,k) = 1 = f(0,k)  = f(n,1)            ---------------(1)

                    p(n) = f(n,n)                   -----------(3)
                    
                    f(n,n) = 1 + sum(i=1 to n-1) (f(n-i,i))
                    
                    If n < k: f(n,k) = f(n,n) = p(n)
                    If n >=k:
                        n = ak + b
                        f(n,k) = p(b) + sum(j=0 to a-1)( sum(i=1 to k-1) ( f(n-j*k -i,i) ) )
            
            */
            
            assert n >= 1;
            if(n==1){return 1;}
            
            long nPartitions = 0;
            
            for ( int counter = n-1; n >= 1; n-- ){
                nPartitions += this.partitionRecursively(counter);
            }
            
            return nPartitions;
         
         }
    
    }
    
    public static void main(String args[]){
        //System.out.println(args[0]); // this is space for command line args
        // dwar and space for saaman of atithi.
        // preshak bheshaj udwetak like words are coming in mind
        int arg = Integer.parseInt(args[0],10);
        Partitioner partitioner = new Partitioner();
        long nPartitions = partitioner.p(arg);
        System.out.println("Total "+ nPartitions + " partitions are there for " + arg);
        //TODO - Try to get the result and print later.
    
    }

}

/*
Q0. Can we declare non-Filename class only?
Ans
Try 1. Tried to declare public class PartitionTr in Partition.java-

    Partition.java:1: error: class PartitionTr is public, should be declared in a file named PartitionTr.java
    public class PartitionTr{
           ^
    1 error

Try 2. Tried changing access modifier to private-
    Partition.java:1: error: modifier private not allowed here
    private class PartitionTr{
            ^
    1 error

Try 3. Tried skipping access modifier - and it succeeds.
From java docs- If a class has no modifier (the default, also known as package-private), it is visible only within its own package (packages are named groups of related classes — you will learn about them in a later lesson.)

Thus Ans is 'Yes' but access modifier should be skipped.

The intention of error is now making little sense in public case - make class predictable by other users.
The intention of error for private - 
    From JLS-
    The access modifiers protected and private pertain only to member classes within a directly enclosing class declaration
    So intention makes little sense as - whatever code we write - its outermost shell is supposed to exist.
    Either that exist for community or you. So either it is public or default.

Q1. Can we write outside of class Filename ? IF yes - what what can we write?
Other class, and if tried making class less functions then we get error as mentioned in below ques.

Q2. How will scope work on file level?
Case - multi class
    I've seen multi-classes 'compile and generate' their specific '.class' files.
    So - in theory - their access shouldn't be a problem.
    Let me make 2 classes - one mukha, and one is udar.
    Ok - experiment worked - 2 class files were their - udar was giving error as no main was there, mukh worked.
Case - single class seen
Case - External method with and without class
    Method.java:12: error: unnamed classes are a preview feature and are disabled by default.
    public static void method(String args[]){
                  ^
      (use --enable-preview to enable unnamed classes)
    1 error


Creating a classess function therefore not possible.
But yes calling a function classlessly is sort of possible- using static imports - 

Static import is a feature introduced in the Java programming language that allows members (fields and methods) which have been scoped within their container class as public static, to be used in Java code without specifying the class in which the field has been defined. This feature was introduced into the language in version 5.0. 

Example- If we do-
import static java.lang.Math.*;

class .. {

    ..
        double pi= PI;
    ..

}


Q3. Can we declare any other signatured main function for entry of interpreter? Like non-static, non-void, private etc? If not - why not?
Ans: 
Tried skipping static-
    Compile success
    Runtime error-
    Error: Main method is not static in class Partition, please define the main method as:
       public static void main(String[] args)
I have already executed/seen example of class with no main method not being static
which tells us - main method is judged differently.

After few tries of renaming the method for default class (as public is strictier so it'll surely not allow)-
    main function can be skipped fully - but then don't try to run the program as main program.
    This therefore is ideology - if running a program as main program - declare its main method.




*/























